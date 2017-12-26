package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import java.util.List;

/**
 * 权限实体类
 */
public class Permission extends BaseEntity {
    private Long sysno;
    private String permissionNo;
    private String permissionName;
    private Integer permissionType;
    private String menuPath;
    private String menuIcon;
    private String resource;
    private Long parentSysno;
    private Integer level;
    private Integer sortNum;

    public Long getSysno() {
        return sysno;
    }

    public void setSysno(Long sysno) {
        this.sysno = sysno;
    }

    public String getPermissionNo() {
        return permissionNo;
    }

    public void setPermissionNo(String permissionNo) {
        this.permissionNo = permissionNo;
    }


    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Long getParentSysno() {
        return parentSysno;
    }

    public void setParentSysno(Long parentSysno) {
        this.parentSysno = parentSysno;
    }
}
