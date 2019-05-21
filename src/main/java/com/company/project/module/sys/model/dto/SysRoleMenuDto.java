package com.company.project.module.sys.model.dto;

import com.company.project.module.sys.model.SysRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class SysRoleMenuDto extends SysRole {
    private String menuId;

    private List<String> menuIds;
}