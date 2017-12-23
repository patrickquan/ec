package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import java.util.List;

/**
 * 权限实体类
 */
public class Permission extends BaseEntity {
    private long sysno;
    private String permissionNo;
    private String permissionNamme;
    private int permissionType;
    private String menuPath;
    private String menuIcon;
    private String resource;
    private long parentSyno;
    private int level;
    private int sortNum;

    public long getSysno() {
        return sysno;
    }

    public void setSysno(long sysno) {
        this.sysno = sysno;
    }

    public String getPermissionNo() {
        return permissionNo;
    }

    public void setPermissionNo(String permissionNo) {
        this.permissionNo = permissionNo;
    }

    public String getPermissionNamme() {
        return permissionNamme;
    }

    public void setPermissionNamme(String permissionNamme) {
        this.permissionNamme = permissionNamme;
    }

    public int getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(int permissionType) {
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

    public long getParentSyno() {
        return parentSyno;
    }

    public void setParentSyno(long parentSyno) {
        this.parentSyno = parentSyno;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }
}
