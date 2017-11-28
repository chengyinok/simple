package com.study.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;


/**
 * <p>
 * 用户账户表
 * </p>
 *
 * @author chengyin
 * @since 2017-11-28
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 账户名称
     */
    @TableField("account_name")
    private String accountName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 逻辑删除状态
     */
    @TableField("delete_status")
    private Integer deleteStatus;

    /**
     * 是否锁定
     */
    private Integer locked;

    /**
     * 用户描述
     */
    private String description;

    /**
     * 加密盐
     */
    @TableField("credentials_salt")
    private String credentialsSalt;

    /**
     * 创建者
     */
    @TableField("creator_id")
    private String creatorId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    @TableField("dept_id")
    private Integer deptId;

    private String img;

    private String email;

    private String remark;


    /**
     * 获取 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取 账户名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置 账户名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 获取 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取 逻辑删除状态
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 设置 逻辑删除状态
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 获取 是否锁定
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * 设置 是否锁定
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    /**
     * 获取 用户描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 用户描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取 加密盐
     */
    public String getCredentialsSalt() {
        return credentialsSalt;
    }

    /**
     * 设置 加密盐
     */
    public void setCredentialsSalt(String credentialsSalt) {
        this.credentialsSalt = credentialsSalt;
    }

    /**
     * 获取 创建者
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置 创建者
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("User [");
        sb.append("id=" + id + ", ");
        sb.append("realName=" + realName + ", ");
        sb.append("accountName=" + accountName + ", ");
        sb.append("password=" + password + ", ");
        sb.append("deleteStatus=" + deleteStatus + ", ");
        sb.append("locked=" + locked + ", ");
        sb.append("description=" + description + ", ");
        sb.append("credentialsSalt=" + credentialsSalt + ", ");
        sb.append("creatorId=" + creatorId + ", ");
        sb.append("createTime=" + createTime + ", ");
        sb.append("updateTime=" + updateTime + ", ");
        sb.append("deptId=" + deptId + ", ");
        sb.append("img=" + img + ", ");
        sb.append("email=" + email + ", ");
        sb.append("remark=" + remark);
        sb.append("]");
        return sb.toString();
    }
}
