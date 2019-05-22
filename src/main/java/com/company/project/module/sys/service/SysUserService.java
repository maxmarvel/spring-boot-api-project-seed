package com.company.project.module.sys.service;
import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.model.SysUser;
import com.company.project.core.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysUserService extends Service<SysUser> {
    List<SysUser> findUserWithDept(SysUser user, QueryRequest request);

    void registUser(SysUser user);

    SysUser findByName(String username);

    void addUser(SysUser user, String[] roles);

    void updateTheme(String theme, String userName);

    void deleteUsers(String ids);

    void updateUser(SysUser user, String[] rolesSelect);
}
