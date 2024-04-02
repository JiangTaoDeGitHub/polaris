package com.polaris.service.impl;

import com.polaris.mapper.RoleMapper;
import com.polaris.model.SysRole;
import com.polaris.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<SysRole> listRolesByUserId(String userid) {

        return roleMapper.listRolesByUserId(userid);

    }
}
