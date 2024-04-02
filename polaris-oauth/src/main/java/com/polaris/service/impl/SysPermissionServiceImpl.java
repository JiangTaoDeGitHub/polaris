package com.polaris.service.impl;

import com.polaris.mapper.PermissionMapper;
import com.polaris.model.SysPermission;
import com.polaris.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysPermissionServiceImpl implements SysPermissionService {


    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<SysPermission> listPermissionsByRoles(List<String> roleIds) {
        return permissionMapper.listPermissionsByRoles(roleIds);
    }
}
