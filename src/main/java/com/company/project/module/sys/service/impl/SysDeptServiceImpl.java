package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysDeptMapper;
import com.company.project.module.sys.model.SysDept;
import com.company.project.module.sys.service.SysDeptService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysDeptServiceImpl extends AbstractService<SysDept> implements SysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

}
