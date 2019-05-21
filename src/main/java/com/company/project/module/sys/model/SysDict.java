package com.company.project.module.sys.model;

import javax.persistence.*;

@Table(name = "tb_sys_dict")
public class SysDict {
    /**
     * id唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 文本
     */
    private String name;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 值
     */
    private Integer value;

    /**
     * 父ID
     */
    private String pid;

    /**
     * 键
     */
    private String key;

    /**
     * 是否启用
     */
    private Integer status;

    /**
     * 字段名称
     */
    @Column(name = "field_name")
    private String fieldName;

    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 获取id唯一标识
     *
     * @return id - id唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id唯一标识
     *
     * @param id id唯一标识
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取文本
     *
     * @return name - 文本
     */
    public String getName() {
        return name;
    }

    /**
     * 设置文本
     *
     * @param name 文本
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return seq - 排序
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * 设置排序
     *
     * @param seq 排序
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 获取父ID
     *
     * @return pid - 父ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置父ID
     *
     * @param pid 父ID
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取键
     *
     * @return key - 键
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置键
     *
     * @param key 键
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取是否启用
     *
     * @return status - 是否启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否启用
     *
     * @param status 是否启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取字段名称
     *
     * @return field_name - 字段名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名称
     *
     * @param fieldName 字段名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 获取表名
     *
     * @return table_name - 表名
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置表名
     *
     * @param tableName 表名
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}