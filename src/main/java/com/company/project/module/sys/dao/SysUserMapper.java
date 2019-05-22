package com.company.project.module.sys.dao;

import com.company.project.core.Mapper;
import com.company.project.module.sys.model.SysUser;
import com.company.project.module.sys.model.dto.SysUserRoleDto;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {
    List<SysUser> findUserWithDept(SysUser user);

    List<SysUserRoleDto> findUserWithRole(String id);

    SysUser findUserProfile(SysUser user);
}