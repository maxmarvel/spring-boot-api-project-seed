package com.company.project.module.sys.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.module.sys.model.SysDept;
import com.company.project.module.sys.service.SysDeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 2019/05/21.
 */
@RestController
@RequestMapping("/module/sys/dept")
@Api(description = "部门管理")
public class SysDeptController {
    @Resource
    private SysDeptService sysDeptService;

    @PostMapping("/add")
    public Result add(SysDept sysDept) {
        sysDeptService.save(sysDept);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysDeptService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysDept sysDept) {
        sysDeptService.update(sysDept);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysDept sysDept = sysDeptService.findById(id);
        return ResultGenerator.genSuccessResult(sysDept);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysDept> list = sysDeptService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 获取部门树
     *
     * @return
     */
    @PostMapping("/tree")
    @ApiOperation(value = "部门树", notes = "部门异步请求树")
    public List tree(@RequestParam(name = "parentId", defaultValue = "0") String parentId) {
        // List<EasyUITreeNode> result = sysDeptService.tree(parentId);
        return null;
    }
}