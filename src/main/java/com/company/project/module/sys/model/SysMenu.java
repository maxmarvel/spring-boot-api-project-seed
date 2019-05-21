package com.company.project.module.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_menu")
public class SysMenu {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 菜单类型，1：1级菜单:2:2级菜单，3:3级菜单,0:不是菜单
     */
    @Column(name = "menu_type")
    private Integer menuType;

    /**
     * 图标
     */
    private String icon;

    /**
     * 名称
     */
    private String name;

    /**
     * 1：展开，0：不展开
     */
    private Integer state;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 类型 1菜单  2按钮
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，1：正常，0：冻结状态，2：删除
     */
    private Integer status;

    /**
     * 顺序，由小到大
     */
    private Integer seq;

    /**
     * 菜单层级
     */
    @Column(name = "menu_level")
    private String menuLevel;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 最后一次更新操作者的ip地址
     */
    @Column(name = "operate_ip")
    private String operateIp;

    /**
     * 权限
     */
    private String permission;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取菜单类型，1：1级菜单:2:2级菜单，3:3级菜单,0:不是菜单
     *
     * @return menu_type - 菜单类型，1：1级菜单:2:2级菜单，3:3级菜单,0:不是菜单
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型，1：1级菜单:2:2级菜单，3:3级菜单,0:不是菜单
     *
     * @param menuType 菜单类型，1：1级菜单:2:2级菜单，3:3级菜单,0:不是菜单
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1：展开，0：不展开
     *
     * @return state - 1：展开，0：不展开
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1：展开，0：不展开
     *
     * @param state 1：展开，0：不展开
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取访问地址
     *
     * @return url - 访问地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问地址
     *
     * @param url 访问地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取类型 1菜单  2按钮
     *
     * @return type - 类型 1菜单  2按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 1菜单  2按钮
     *
     * @param type 类型 1菜单  2按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取状态，1：正常，0：冻结状态，2：删除
     *
     * @return status - 状态，1：正常，0：冻结状态，2：删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态，1：正常，0：冻结状态，2：删除
     *
     * @param status 状态，1：正常，0：冻结状态，2：删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取顺序，由小到大
     *
     * @return seq - 顺序，由小到大
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置顺序，由小到大
     *
     * @param seq 顺序，由小到大
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取菜单层级
     *
     * @return menu_level - 菜单层级
     */
    public String getMenuLevel() {
        return menuLevel;
    }

    /**
     * 设置菜单层级
     *
     * @param menuLevel 菜单层级
     */
    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 获取操作者
     *
     * @return operator - 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作者
     *
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取最后一次操作时间
     *
     * @return operate_time - 最后一次操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置最后一次操作时间
     *
     * @param operateTime 最后一次操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取最后一次更新操作者的ip地址
     *
     * @return operate_ip - 最后一次更新操作者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置最后一次更新操作者的ip地址
     *
     * @param operateIp 最后一次更新操作者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * 获取权限
     *
     * @return permission - 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }
}