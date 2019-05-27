package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.annotation.Log;
import com.company.project.core.controller.BaseController;
import com.company.project.core.model.QueryRequest;
import com.company.project.core.util.FileUtil;
import com.company.project.module.sys.model.SysDict;
import com.company.project.module.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2019/05/21.
 */
@RestController
@RequestMapping("/module/sys/dict")
@Api(description = "数据字典管理")
public class SysDictController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SysDictService sysDictService;

    @Log("获取字典信息")
    @PostMapping("/")
    @RequiresPermissions("dict:list")
    @ApiOperation(value = "访问路径", notes = "数据字典管理请求地址")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("module/sys/dict/list");
        return mv;
    }

    @PostMapping("/list")
    @RequiresPermissions("dict:list")
    @ApiOperation(value = "列表", notes = "数据字典列表")
    public Result list(QueryRequest request, SysDict sysDict) {
        Map<String, Object> listData = super.selectByPageNumSize(request, () -> this.sysDictService.findAllDicts(sysDict, request));
        return ResultGenerator.genSuccessResult(listData);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "明细", notes = "数据字典详细数据")
    public Result detail(@RequestParam String id) {
        try {
            SysDict sysDict = sysDictService.findById(id);
            return ResultGenerator.genSuccessResult(sysDict);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return ResultGenerator.genFailResult("获取字典信息失败，请联系网站管理员！");
        }
    }

    @Log("新增字典 ")
    @RequiresPermissions("dict:add")
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "数据字典新增")
    public Result add(SysDict sysDict) {
        try {
            sysDictService.save(sysDict);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("新增字典失败", e);
            return ResultGenerator.genFailResult("新增字典失败，请联系网站管理员！");
        }

    }

    @Log("删除字典")
    @RequiresPermissions("dict:delete")
    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "数据字典删除")
    public Result delete(@RequestParam String ids) {
        try {
            sysDictService.batchDelete(ids, "id", SysDict.class);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("删除字典失败", e);
            return ResultGenerator.genFailResult("删除字典失败，请联系网站管理员！");
        }
    }

    @Log("修改字典 ")
    @ApiOperation(value = "修改", notes = "数据字典修改")
    @RequiresPermissions("dict:update")
    @PostMapping("/update")
    public Result update(SysDict sysDict) {
        try {
            sysDictService.update(sysDict);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            log.error("修改字典失败", e);
            return ResultGenerator.genFailResult("修改字典失败，请联系网站管理员！");
        }
    }


    @PostMapping("/excel")
    @ApiOperation(value = "excel导出", notes = "数据字典excel导出")
    public Result dictExcel(SysDict dict) {
        try {
            List<SysDict> list = this.sysDictService.findAllDicts(dict, null);
            return FileUtil.createExcelByPOIKit("字典表", list, SysDict.class);
        } catch (Exception e) {
            log.error("导出字典信息Excel失败", e);
            return ResultGenerator.genFailResult("导出Excel失败，请联系网站管理员！");
        }
    }

    @PostMapping("/csv")
    @ApiOperation(value = "csv导出", notes = "数据字典csv导出")
    public Result dictCsv(SysDict sysDict) {
        try {
            List<SysDict> list = this.sysDictService.findAllDicts(sysDict, null);
            return FileUtil.createCsv("字典表", list, SysDict.class);
        } catch (Exception e) {
            log.error("导出字典信息Csv失败", e);
            return ResultGenerator.genFailResult("导出Csv失败，请联系网站管理员！");
        }
    }
}
