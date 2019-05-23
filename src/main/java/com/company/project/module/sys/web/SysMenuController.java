package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.annotation.Log;
import com.company.project.core.controller.BaseController;
import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.model.SysMenu;
import com.company.project.module.sys.model.SysRole;
import com.company.project.module.sys.service.SysMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
* Created by chen on 2019/05/21.
*/
@RestController
@RequestMapping("/module/sys/menu")
@Api(description = "菜单管理")
public class SysMenuController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysMenuService sysMenuService;
    @Log("获取菜单信息")
    @GetMapping("/")
    @RequiresPermissions("menu:list")
    @ApiOperation(value = "访问路径", notes = "菜单管理请求地址")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("module/sys/menu/list");
        return mv;
    }
    @PostMapping("/list")
    @RequiresPermissions("menu:list")
    @ApiOperation(value = "列表", notes = "菜单列表")
    public Result list(QueryRequest request, SysMenu menu) {
        try {
            Map<String, Object> listData = super.selectByPageNumSize(request, () -> sysMenuService.findAllMenus(menu));
            return ResultGenerator.genSuccessResult(listData);
        } catch (Exception e) {
            log.error("获取菜单集合失败", e);
            return ResultGenerator.genFailResult("获取菜单信息失败，请联系网站管理员！");
        }
    }
    @PostMapping("/detail")
    @ApiOperation(value = "明细", notes = "菜单/按钮详细数据")
    public Result detail(@RequestParam String id) {
        try {
            SysMenu sysMenu = sysMenuService.findById(id);
            return ResultGenerator.genSuccessResult(sysMenu);
        } catch (Exception e) {
            log.error("获取菜单信息失败", e);
            return ResultGenerator.genFailResult("获取菜单/按钮信息失败，请联系网站管理员！");
        }

    }
    @Log("新增菜单/按钮")
    @RequiresPermissions("menu:add")
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "菜单/按钮新增")
    public Result add(SysMenu menu) {
        String name;
        if (SysMenu.TYPE_MENU.equals(menu.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }
        try {
            sysMenuService.addMenu(menu);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("新增{}失败", name, e);
            return ResultGenerator.genFailResult("新增" + name + "失败，请联系网站管理员！");
        }
    }

    @PostMapping("/delete")
    @Log("删除菜单")
    @RequiresPermissions("menu:delete")
    @ApiOperation(value = "删除", notes = "菜单/按钮删除")
    public Result delete(@RequestParam String ids) {
        try {
            sysMenuService.deleteMeuns(ids);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("删除菜单失败", e);
            return ResultGenerator.genFailResult("删除失败，请联系网站管理员！");
        }
    }
    @Log("修改菜单/按钮")
    @RequiresPermissions("menu:update")
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "菜单/按钮修改")
    public Result update(SysMenu menu) {
        String name;
        if (SysMenu.TYPE_MENU.equals(menu.getType())) {
            name = "菜单";
        } else {
            name = "按钮";
        }
        try {
            sysMenuService.updateMenu(menu);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("新增{}失败", name, e);
            return ResultGenerator.genFailResult("新增" + name + "失败，请联系网站管理员！");
        }
    }


    @PostMapping("/checkMenuName")
    @ApiOperation(value = "检查名称", notes = "菜单名称检查")
    public boolean checkMenuName(String menuName, String type, String oldMenuName) {
        if (StringUtils.isNotBlank(oldMenuName) && menuName.equalsIgnoreCase(oldMenuName)) {
            return true;
        }
        SysMenu result = sysMenuService.findByNameAndType(menuName, type);
        return result == null;
    }


}
