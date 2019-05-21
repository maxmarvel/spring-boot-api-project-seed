package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysLogMapper;
import com.company.project.module.sys.model.SysLog;
import com.company.project.module.sys.service.SysLogService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

}
