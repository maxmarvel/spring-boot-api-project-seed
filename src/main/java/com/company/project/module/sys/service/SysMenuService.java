package com.company.project.module.sys.service;
import com.company.project.module.sys.model.SysMenu;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysMenuService extends Service<SysMenu> {

    SysMenu findByNameAndType(String menuName, String type);

    List<SysMenu> findAllMenus(SysMenu menu);

    void addMenu(SysMenu menu);

    void deleteMeuns(String ids);

    void updateMenu(SysMenu menu);
}
