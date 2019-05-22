package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.annotation.Log;
import com.company.project.core.controller.BaseController;
import com.company.project.core.model.QueryRequest;
import com.company.project.module.sys.model.SysDict;
import com.company.project.module.sys.model.SysUser;
import com.company.project.module.sys.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2019/05/21.
 */
@RestController
@RequestMapping("/module/sys/user")
@Api(description = "用户管理")
public class SysUserController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysUserService sysUserService;

    private static final String ON = "on";

    @Log("获取用户信息")
    @PostMapping("/")
    @RequiresPermissions("user:list")
    @ApiOperation(value = "访问路径", notes = "用户管理请求地址")
    public ModelAndView index(Model model) {
        SysUser user = super.getCurrentUser();
        model.addAttribute("user", user);
        ModelAndView mv = new ModelAndView("module/sys/user/list");
        return mv;
    }

    @PostMapping("/list")
    @RequiresPermissions("user:list")
    @ApiOperation(value = "列表", notes = "部门列表")
    public Result list(QueryRequest request, SysUser user) {
        Map<String, Object> listData = super.selectByPageNumSize(request, () -> sysUserService.findUserWithDept(user, request));
        return ResultGenerator.genSuccessResult(listData);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "明细", notes = "用户详细数据")
    public Result detail(@RequestParam String id) {
        try {
            SysUser sysUser = sysUserService.findById(id);
            return ResultGenerator.genSuccessResult(sysUser);
        } catch (Exception e) {
            log.error("获取用户失败", e);
            return ResultGenerator.genFailResult("获取用户失败，请联系网站管理员！");
        }
    }

    @Log("新增用户")
    @RequiresPermissions("user:add")
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "用户新增")
    public Result add(SysUser user, String[] roles) {
        try {
            if (ON.equalsIgnoreCase(user.getStatus().toString())) {
                user.setStatus(SysUser.STATUS_VALID);
            } else {
                user.setStatus(SysUser.STATUS_LOCK);
            }
            sysUserService.addUser(user, roles);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("新增用户失败", e);
            return ResultGenerator.genFailResult("新增用户失败，请联系网站管理员！");
        }
    }

    @Log("删除用户")
    @RequiresPermissions("user:delete")
    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "用户删除")
    public Result delete(@RequestParam String ids) {
        try {
            sysUserService.deleteUsers(ids);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("删除用户失败", e);
            return ResultGenerator.genFailResult("删除用户失败，请联系网站管理员！");
        }
    }

    @Log("修改用户")
    @PostMapping("/update")
    @RequiresPermissions("user:update")
    @ApiOperation(value = "修改", notes = "用户修改")
    public Result update(SysUser user, String[] rolesSelect) {
        try {
            if (ON.equalsIgnoreCase(user.getStatus().toString())) {
                user.setStatus(SysUser.STATUS_VALID);
            } else {
                user.setStatus(SysUser.STATUS_LOCK);
            }
            sysUserService.updateUser(user, rolesSelect);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("修改用户失败", e);
            return ResultGenerator.genFailResult("修改用户失败，请联系网站管理员！");
        }
    }


    @PostMapping("/checkUserName")
    @ApiOperation(value = "检查名称", notes = "用户名称检查")
    public boolean checkUserName(String username, String oldusername) {
        if (StringUtils.isNotBlank(oldusername) && username.equalsIgnoreCase(oldusername)) {
            return true;
        }
        SysUser result = sysUserService.findByName(username);
        return result == null;
    }

    @PostMapping("/regist")
    @ApiOperation(value = "注册", notes = "用户注册")
    public Result regist(SysUser user) {
        try {
            SysUser result = sysUserService.findByName(user.getUserName());
            if (result != null) {
                return ResultGenerator.genFailResult("该用户名已被使用！");
            }
            sysUserService.registUser(user);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("注册失败", e);
            return ResultGenerator.genFailResult("注册失败，请联系网站管理员！");
        }
    }

    @Log("更换主题")
    @PostMapping("/theme")
    @ApiOperation(value = "主题更换", notes = "用户主题更换")
    public Result updateTheme(SysUser user) {
        try {
            this.sysUserService.updateTheme(user.getTheme(), user.getUserName());
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("修改主题失败", e);
            return ResultGenerator.genFailResult("修改主题失败");
        }
    }

}
