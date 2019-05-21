package com.company.project.module.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_dept")
public class SysDept {
    /**
     * 部门ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 上级部门ID
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 部门层级
     */
    @Column(name = "dept_level")
    private String deptLevel;

    /**
     * 部门在当前层级下的顺序，由小到大
     */
    private Integer seq;

    /**
     * 备注
     */
    private String remark;

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
     * 获取部门ID
     *
     * @return id - 部门ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置部门ID
     *
     * @param id 部门ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取上级部门ID
     *
     * @return parent_id - 上级部门ID
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置上级部门ID
     *
     * @param parentId 上级部门ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取部门层级
     *
     * @return dept_level - 部门层级
     */
    public String getDeptLevel() {
        return deptLevel;
    }

    /**
     * 设置部门层级
     *
     * @param deptLevel 部门层级
     */
    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    /**
     * 获取部门在当前层级下的顺序，由小到大
     *
     * @return seq - 部门在当前层级下的顺序，由小到大
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置部门在当前层级下的顺序，由小到大
     *
     * @param seq 部门在当前层级下的顺序，由小到大
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
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
}