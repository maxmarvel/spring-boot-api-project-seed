package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.core.controller.BaseController;
import com.company.project.core.model.QueryRequest;
import com.company.project.core.util.FileUtil;
import com.company.project.module.sys.model.SysLog;
import com.company.project.module.sys.service.SysLogService;
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
@RequestMapping("/module/sys/log")
@Api(description = "日志管理")
public class SysLogController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysLogService sysLogService;

    @RequiresPermissions("log:list")
    @PostMapping("/")
    @ApiOperation(value = "访问路径", notes = "日志管理请求地址")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("module/sys/log/list");
        return mv;
    }

    @PostMapping("/list")
    @ApiOperation(value = "列表", notes = "日志列表")
    public Result list(QueryRequest request, SysLog log) {
        Map<String, Object> listData = super.selectByPageNumSize(request, () -> this.sysLogService.findAllLogs(log));
        return ResultGenerator.genSuccessResult(listData);
    }
    //@PostMapping("/add")
    //public Result add(SysLog sysLog) {
    //    sysLogService.save(sysLog);
    //    return ResultGenerator.genSuccessResult();
    //}

    @RequiresPermissions("log:delete")
    @PostMapping("/delete")
    @ApiOperation(value = "删除", notes = "日志单条删除")
    public Result delete(@RequestParam String id) {
        sysLogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequiresPermissions("log:delete")
    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除", notes = "日志批量删除")
    public Result batchDelete(@RequestParam String ids) {
        try {
            this.sysLogService.batchDelete(ids, "id", SysLog.class);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            logger.error("删除日志失败", e);
            return ResultGenerator.genFailResult("删除日志失败，请联系网站管理员！");
        }
    }


    //@PostMapping("/update")
    //public Result update(SysLog sysLog) {
    //    sysLogService.update(sysLog);
    //    return ResultGenerator.genSuccessResult();
    //}
    //
    //@PostMapping("/detail")
    //public Result detail(@RequestParam String id) {
    //    SysLog sysLog = sysLogService.findById(id);
    //    return ResultGenerator.genSuccessResult(sysLog);
    //}
    //
    //@PostMapping("/list")
    //public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
    //    PageHelper.startPage(page, size);
    //    List<SysLog> list = sysLogService.findAll();
    //    PageInfo pageInfo = new PageInfo(list);
    //    return ResultGenerator.genSuccessResult(pageInfo);
    //}

    @PostMapping("/excel")
    @ApiOperation(value = "excel导出", notes = "日志excel导出")
    public Result logExcel(SysLog log) {
        try {
            List<SysLog> list = this.sysLogService.findAllLogs(log);
            return FileUtil.createExcelByPOIKit("系统日志表", list, SysLog.class);
        } catch (Exception e) {
            logger.error("导出系统日志Excel失败", e);
            return ResultGenerator.genFailResult("导出Excel失败，请联系网站管理员！");
        }
    }

    @PostMapping("/csv")
    @ApiOperation(value = "csv导出", notes = "日志csv导出")
    public Result logCsv(SysLog log) {
        try {
            List<SysLog> list = this.sysLogService.findAllLogs(log);
            return FileUtil.createCsv("系统日志表", list, SysLog.class);
        } catch (Exception e) {
            logger.error("导出系统日志Csv失败", e);
            return ResultGenerator.genFailResult("导出Csv失败，请联系网站管理员！");
        }
    }


}
