package com.company.project.module.sys.service.impl;

import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.dao.SysUserMapper;
import com.company.project.module.sys.model.SysUser;
import com.company.project.module.sys.service.SysUserService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findUserWithDept(SysUser user, QueryRequest request) {
        return null;
    }

    @Override
    @Transactional
    public void registUser(SysUser user) {

    }

    @Override
    public SysUser findByName(String username) {
        return null;
    }

    @Override
    @Transactional
    public void addUser(SysUser user, String[] roles) {

    }

    @Override
    public void updateTheme(String theme, String userName) {

    }

    @Override
    @Transactional
    public void deleteUsers(String ids) {
        this.batchDelete(ids, "id", SysUser.class);

        //this.userRoleService.deleteUserRolesByUserId(ids);
    }

    @Override
    public void updateUser(SysUser user, String[] rolesSelect) {

    }
}
