package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysRoleMapper;
import com.company.project.module.sys.model.SysRole;
import com.company.project.module.sys.service.SysRoleService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
