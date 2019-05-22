package com.company.project.module.sys.service;
import com.company.project.core.model.Tree;
import com.company.project.module.sys.model.SysDept;
import com.company.project.core.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysDeptService extends Service<SysDept> {

    List<SysDept> findAllDepts(SysDept dept);

    SysDept findByName(String deptName);

    void addDept(SysDept dept);

    void deleteDepts(String ids);

    Tree<SysDept> getDeptTree();
}
