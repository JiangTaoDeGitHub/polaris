package com.polaris.service;

import com.polaris.model.SysPermission;

import java.util.List;

public interface SysPermissionService {

    List<SysPermission> listPermissionsByRoles(List<String> roleIds);
}
