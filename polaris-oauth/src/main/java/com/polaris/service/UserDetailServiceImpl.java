package com.polaris.service;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.polaris.mapper.UserMapper;
import com.polaris.model.AuthConstants;
import com.polaris.model.SysPermission;
import com.polaris.model.SysRole;
import com.polaris.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //获取本地用户
        User user = userMapper.selectByUserName(userName);
        if (user != null) {
            //返回oauth2的用户
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    user.getPassword(),
//                    AuthorityUtils.createAuthorityList(user.getRole())) ;
            //获取当前用户的所有角色
            List<SysRole> roleList = sysRoleService.listRolesByUserId(user.getId());
            user.setRoles(roleList.stream().map(SysRole::getRoleCode).collect(Collectors.toList()));
            List<String> roleIds = roleList.stream().map(SysRole::getId).collect(Collectors.toList());
            //获取所有角色的权限
            List<SysPermission> permissionList = sysPermissionService.listPermissionsByRoles(roleIds);
            user.setPermissions(permissionList.stream().map(SysPermission::getUrl).collect(Collectors.toList()));
            //构建oauth2的用户
            return buildUserDetails(user);
        } else {
            throw new UsernameNotFoundException("用户[" + userName + "]不存在");
        }
    }


    /**
     * 构建oAuth2用户，将角色和权限赋值给用户，角色使用ROLE_作为前缀
     *
     * @param sysUser 系统用户
     * @return UserDetails
     */
    private UserDetails buildUserDetails(User sysUser) {
        Set<String> authSet = new HashSet<>();
        List<String> roles = sysUser.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(item -> authSet.add(AuthConstants.ROLE_PREFIX + item));
            authSet.addAll(sysUser.getPermissions());
        }
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(authSet.toArray(new String[0]));
        return new org.springframework.security.core.userdetails.User(sysUser.getUsername(), sysUser.getPassword(),
                authorityList);
    }
}
