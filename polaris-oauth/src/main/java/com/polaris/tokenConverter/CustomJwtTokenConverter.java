package com.polaris.tokenConverter;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;
/**
 * JwtAccessTokenConverter
 * TokenEnhancer的子类，帮助程序在JWT编码的令牌值和OAuth身份验证信息之间进行转换。
 * 继承JwtAccessTokenConverter 后，重写enhance方法后，就可以
 */
public class CustomJwtTokenConverter extends JwtAccessTokenConverter{

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication authentication) {
        //Object principal = authentication.getUserAuthentication().getPrincipal();
        final Map<String,Object> additionalInformation = new HashMap<>(4);
        additionalInformation.put("author","jiangtao");
        additionalInformation.put("project","polaris");
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInformation);
        return super.enhance(oAuth2AccessToken,authentication);
    }
}
