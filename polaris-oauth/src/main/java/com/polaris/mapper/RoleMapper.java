package com.polaris.mapper;

import com.polaris.model.SysRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    List<SysRole> listRolesByUserId(String userid);
}
