package com.company.project.module.sys.service.impl;

import com.company.project.module.sys.dao.SysMenuMapper;
import com.company.project.module.sys.model.SysMenu;
import com.company.project.module.sys.service.SysMenuService;
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
import java.util.Date;
import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public SysMenu findByNameAndType(String menuName, String type) {
        return null;
    }

    @Override
    public List<SysMenu> findAllMenus(SysMenu menu) {
        try {
            Example example = new Example(SysMenu.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(menu.getName())) {
                criteria.andCondition("name=", menu.getName());
            }
            if (StringUtils.isNotBlank(menu.getType().toString())) {
                criteria.andCondition("type=", menu.getType().toString());
            }
            example.setOrderByClause("id");
            return this.findByExample(example);
        } catch (NumberFormatException e) {
            log.error("error", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void addMenu(SysMenu menu) {
        menu.setOperateTime(new Date());
        if (menu.getParentId() == null) {
            menu.setParentId(0 + "");
        }
        if (SysMenu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        this.save(menu);
    }

    @Override
    @Transactional
    public void deleteMeuns(String ids) {
        this.batchDelete(ids, "id", SysMenu.class);
        //sysRoleMenuService.deleteRoleMenusByMenuId(ids);
        List<String> list = Arrays.asList(ids.split(","));
        sysMenuMapper.changeToTop(list);
    }

    @Override
    @Transactional
    public void updateMenu(SysMenu menu) {
        menu.setOperateTime(new Date());
        if (menu.getParentId() == null) {
            menu.setParentId(0 + "");
        }
        if (SysMenu.TYPE_BUTTON.equals(menu.getType())) {
            menu.setUrl(null);
            menu.setIcon(null);
        }
        this.updateNotNull(menu);
    }
}
