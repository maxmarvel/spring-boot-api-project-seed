package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysMenuMapper;
import com.company.project.module.sys.model.SysMenu;
import com.company.project.module.sys.service.SysMenuService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}
