package com.polaris.mapper;

import com.polaris.model.SysPermission;
import com.polaris.model.SysRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    List<SysPermission> listPermissionsByRoles(List<String> roleIds);

}
