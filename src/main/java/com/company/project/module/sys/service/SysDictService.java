package com.company.project.module.sys.service;

import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.model.SysDict;
import com.company.project.core.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysDictService extends Service<SysDict> {
    List<SysDict> findAllDicts(SysDict sysDict, QueryRequest request);


}
