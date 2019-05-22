package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.annotation.Log;
import com.company.project.core.controller.BaseController;
import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.model.SysDict;
import com.company.project.module.sys.model.SysRole;
import com.company.project.module.sys.model.dto.SysRoleMenuDto;
import com.company.project.module.sys.service.SysRoleService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2019/05/21.
 */
@RestController
@RequestMapping("/module/sys/role")
@Api(description = "角色管理")
public class SysRoleController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysRoleService sysRoleService;

    @Log("获取角色信息")
    @PostMapping("/")
    @RequiresPermissions("role:list")
    @ApiOperation(value = "访问路径", notes = "角色管理请求地址")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("module/sys/dict/list");
        return mv;
    }

    @PostMapping("/list")
    @RequiresPermissions("role:list")
    @ApiOperation(value = "列表", notes = "角色列表")
    public Result list(QueryRequest request, SysRole role) {
        Map<String, Object> listData = super.selectByPageNumSize(request, () -> this.sysRoleService.findAllRole(role));
        return ResultGenerator.genSuccessResult(listData);
    }

    @Log("新增角色")
    @RequiresPermissions("role:add")
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "角色新增")
    public Result add(SysRole sysRole) {
        try {
            sysRoleService.save(sysRole);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("新增角色失败", e);
            return ResultGenerator.genFailResult("新增角色失败，请联系网站管理员！");
        }
    }

    @Log("删除角色")
    @RequiresPermissions("role:delete")
    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "角色删除")
    public Result delete(@RequestParam String id) {
        try {
            sysRoleService.deleteById(id);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return ResultGenerator.genFailResult("删除角色失败，请联系网站管理员！");
        }

    }

    @Log("修改角色")
    @RequiresPermissions("role:update")
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "角色修改")
    public Result update(SysRole sysRole) {
        try {
            sysRoleService.update(sysRole);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("修改角色失败", e);
            return ResultGenerator.genFailResult("修改角色失败，请联系网站管理员！");
        }

    }

    @PostMapping("/detail")
    @ApiOperation(value = "明细", notes = "角色详细数据")
    public Result detail(@RequestParam String id) {
        try {
            SysRoleMenuDto dto = this.sysRoleService.findRoleWithMenus(id);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("获取角色信息失败", e);
            return ResultGenerator.genFailResult("获取角色信息失败，请联系网站管理员！");
        }
    }

    @PostMapping("/checkRoleName")
    @ApiOperation(value = "检查名称", notes = "角色名称检查")
    public boolean checkRoleName(String roleName, String oldRoleName) {
        if (StringUtils.isNotBlank(oldRoleName) && roleName.equalsIgnoreCase(oldRoleName)) {
            return true;
        }
        SysRole result = sysRoleService.findByName(roleName);
        return result == null;
    }

}
