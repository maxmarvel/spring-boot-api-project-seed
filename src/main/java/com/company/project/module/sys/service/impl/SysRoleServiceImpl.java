package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysRoleMapper;
import com.company.project.module.sys.model.SysRole;
import com.company.project.module.sys.model.dto.SysRoleMenuDto;
import com.company.project.module.sys.service.SysRoleService;
import com.company.project.core.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findAllRole(SysRole role) {
        try {
            Example example = new Example(SysRole.class);
            if (StringUtils.isNotBlank(role.getName())) {
                example.createCriteria().andCondition("name=", role.getName());
            }
            example.setOrderByClause("create_time");
            return this.findByExample(example);
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    public SysRoleMenuDto findRoleWithMenus(String id) {
        List<SysRoleMenuDto> list = this.sysRoleMapper.findDtoById(id);
        List<String> menuList = list.stream().map(SysRoleMenuDto::getMenuId).collect(Collectors.toList());
        if (list.isEmpty()) {
            return null;
        }
        SysRoleMenuDto roleWithMenu = list.get(0);
        roleWithMenu.setMenuIds(menuList);
        return roleWithMenu;
    }

    @Override
    public SysRole findByName(String roleName) {
        Example example = new Example(SysRole.class);
        example.createCriteria().andCondition("lower(name)=", roleName.toLowerCase());
        List<SysRole> list = this.findByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }


}
