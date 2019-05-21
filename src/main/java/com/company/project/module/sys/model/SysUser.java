package com.company.project.module.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_sys_user")
public class SysUser {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 账户
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机

     */
    private String telephone;

    /**
     * 姓名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 部门id
     */
    @Column(name = "dept_id")
    private String deptId;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 性别 0男 1女
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 页码数
     */
    @Column(name = "page_size")
    private Integer pageSize;

    /**
     * 状态，1：正常，0：冻结状态，2：删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近访问时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 最后一次更新时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 最后一次更新者的ip地址
     */
    @Column(name = "operate_ip")
    private String operateIp;

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
     * 获取账户
     *
     * @return user_name - 账户
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置账户
     *
     * @param userName 账户
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机

     *
     * @return telephone - 手机

     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置手机

     *
     * @param telephone 手机

     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取姓名
     *
     * @return true_name - 姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置姓名
     *
     * @param trueName 姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 获取部门id
     *
     * @return dept_id - 部门id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置部门id
     *
     * @param deptId 部门id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 获取性别 0男 1女
     *
     * @return sex - 性别 0男 1女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0男 1女
     *
     * @param sex 性别 0男 1女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取页码数
     *
     * @return page_size - 页码数
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置页码数
     *
     * @param pageSize 页码数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最近访问时间
     *
     * @return last_login_time - 最近访问时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最近访问时间
     *
     * @param lastLoginTime 最近访问时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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
     * 获取最后一次更新时间
     *
     * @return operate_time - 最后一次更新时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置最后一次更新时间
     *
     * @param operateTime 最后一次更新时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取最后一次更新者的ip地址
     *
     * @return operate_ip - 最后一次更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * 设置最后一次更新者的ip地址
     *
     * @param operateIp 最后一次更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * shiro-redis v3.1.0 必须要有getAuthCacheKey()或者getId()方法
     * # Principal id field name. The field which you can get unique id to identify this principal.
     * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
     * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
     * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
     * @return userId as Principal id field name
     */
    public String getAuthCacheKey() {
        return id;
    }
}