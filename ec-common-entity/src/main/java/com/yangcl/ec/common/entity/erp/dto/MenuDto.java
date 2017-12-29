package com.yangcl.ec.common.entity.erp.dto;

public class MenuDto {
    private String id;
    private String name;
    private String path;
    private String icon;
    private String title;
    private String parent;

    public MenuDto(){}
    public MenuDto(String id,String name,String path,String icon,String title,String parent){
        this.id=id;
        this.name=name;
        this.path=path;
        this.icon=icon;
        this.title=title;
        this.parent=parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
