package com.company.project.module.sys.service.impl;

import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.dao.SysDictMapper;
import com.company.project.module.sys.model.SysDict;
import com.company.project.module.sys.service.SysDictService;
import com.company.project.core.AbstractService;
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
public class SysDictServiceImpl extends AbstractService<SysDict> implements SysDictService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findAllDicts(SysDict dict, QueryRequest request) {
        try {
            Example example = new Example(SysDict.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(dict.getKey())) {
                criteria.andCondition("key=", Long.valueOf(dict.getKey()));
            }
            if (StringUtils.isNotBlank(dict.getValue())) {
                criteria.andCondition("value=", dict.getValue());
            }
            if (StringUtils.isNotBlank(dict.getTableName())) {
                criteria.andCondition("table_name=", dict.getTableName());
            }
            if (StringUtils.isNotBlank(dict.getFieldName())) {
                criteria.andCondition("field_name=", dict.getFieldName());
            }
            example.setOrderByClause("id");
            return this.findByExample(example);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return new ArrayList<>();
        }
    }




}
