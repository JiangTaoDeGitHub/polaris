package com.polaris.service;

import com.polaris.mapper.RoleMapper;
import com.polaris.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SysRoleService {


    List<SysRole> listRolesByUserId(String userid);
}
