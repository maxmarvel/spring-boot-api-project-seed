package com.company.project.module.sys.service.impl;

import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.dao.SysUserMapper;
import com.company.project.module.sys.model.SysUser;
import com.company.project.module.sys.service.SysUserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUserWithDept(SysUser user, QueryRequest request) {
        return null;
    }

    @Override
    public void registUser(SysUser user) {

    }
}
