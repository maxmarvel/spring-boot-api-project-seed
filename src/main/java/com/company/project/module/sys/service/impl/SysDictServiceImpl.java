package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysDictMapper;
import com.company.project.module.sys.model.SysDict;
import com.company.project.module.sys.service.SysDictService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysDictServiceImpl extends AbstractService<SysDict> implements SysDictService {
    @Resource
    private SysDictMapper sysDictMapper;

}
