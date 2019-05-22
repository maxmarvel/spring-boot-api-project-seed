package com.company.project.module.sys.service;
import com.company.project.module.sys.model.SysRole;
import com.company.project.core.Service;
import com.company.project.module.sys.model.dto.SysRoleMenuDto;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysRoleService extends Service<SysRole> {

    List<SysRole> findAllRole(SysRole role);

    SysRoleMenuDto findRoleWithMenus(String id);

    SysRole findByName(String roleName);
}
