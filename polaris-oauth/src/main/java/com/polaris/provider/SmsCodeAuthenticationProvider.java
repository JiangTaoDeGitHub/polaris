package com.polaris.provider;

import com.polaris.config.SpringContextHolder;
import com.polaris.model.SmsCodeAuthenticationToken;
import com.polaris.model.User;
import com.polaris.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * 短信登陆鉴权 Provider，要求实现 AuthenticationProvider 接口
 * @author jiangtao
 * @date 2023/9/21 21：00
 */
@Log4j2
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

    private IUserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        SmsCodeAuthenticationToken smsCodeAuthenticationToken = (SmsCodeAuthenticationToken) authentication;

        userService = SpringContextHolder.getBean(IUserService.class);
        String mobile = (String) smsCodeAuthenticationToken.getPrincipal();

        //校验手机号验证码
        checkSmsCode(mobile);

        User user = userService.getUserByMobile(mobile);
        if(null == user){
            throw new BadCredentialsException("Invalid mobile!");
        }

        //授权通过
        UserDetails userDetails = buildUserDetails(user);
        return new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities());
    }

    /**
     * 构建用户认证信息
     * @param user 用户对象
     * @return UserDetails
     */
    private UserDetails buildUserDetails(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ADMIN")) ;
    }

    /**
     * 校验手机号与验证码的绑定关系是否正确
     *  todo 需要根据业务逻辑自行处理
     * @author javadaily
     * @date 2020/7/23 17:31
     * @param mobile 手机号码
     */
    private void checkSmsCode(String mobile) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取验证码
        String smsCode = request.getParameter("smsCode");
        if(StringUtils.isEmpty(smsCode) || !"666666".equals(smsCode)){
            throw new BadCredentialsException("Incorrect sms code,please check !");
        }
        //todo  手机号与验证码是否匹配
    }

    /**
     * ProviderManager 选择具体Provider时根据此方法判断
     * 判断 authentication 是不是 SmsCodeAuthenticationToken 的子类或子接口
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
