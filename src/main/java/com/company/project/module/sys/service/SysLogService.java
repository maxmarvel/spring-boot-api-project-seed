package com.company.project.module.sys.service;
import com.company.project.module.sys.model.SysLog;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by chen on 2019/05/21.
 */
public interface SysLogService extends Service<SysLog> {

    List<SysLog> findAllLogs(SysLog log);

    void deleteLogs(String ids);
}
