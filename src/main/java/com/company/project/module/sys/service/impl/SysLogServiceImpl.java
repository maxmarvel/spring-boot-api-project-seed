package com.company.project.module.sys.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.module.sys.dao.SysLogMapper;
import com.company.project.module.sys.model.SysLog;
import com.company.project.module.sys.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAllLogs(SysLog log) {
        try {
            Example example = new Example(SysLog.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(log.getUserName())) {
                criteria.andCondition("user_name=", log.getUserName().toLowerCase());
            }
            if (StringUtils.isNotBlank(log.getOperation())) {
                criteria.andCondition("operation like", "%" + log.getOperation() + "%");
            }
            if (StringUtils.isNotBlank(log.getTimeField())) {
                String[] timeArr = log.getTimeField().split("~");
                criteria.andCondition("date_format(create_time,'%Y-%m-%d') >=", timeArr[0]);
                criteria.andCondition("date_format(create_time,'%Y-%m-%d') <=", timeArr[1]);
            }
            example.setOrderByClause("create_time desc");
            return this.findByExample(example);
        } catch (Exception e) {
            logger.error("获取系统日志失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void deleteLogs(String logIds) {
        List<String> list = Arrays.asList(logIds.split(","));
        this.batchDelete(list, "id", SysLog.class);
    }
}
