package com.yangcl.ec.common.entity.erp.dto;

import com.yangcl.ec.common.entity.erp.domain.Permission;
import com.yangcl.ec.common.entity.erp.domain.Role;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private String token;
    private String userId;
    private String userName;
    private String loginName;
    private List<MenuDto> menus;

    public UserDto(){}
    public UserDto(String token,String userId,String userName,String loginName,List<MenuDto> menus){
        this.token=token;
        this.userId=userId;
        this.userName=userName;
        this.loginName=loginName;
        this.menus=menus;
    }

    public void setMenus(List<Role> roles){
        this.menus=new ArrayList<MenuDto>();
        for(Role r:roles){
            for(Permission p:r.getPermissions()){
                Boolean isAdd=true;
                for(MenuDto m:this.menus){
                    if(m.getId().equals(p.getSysno().toString())){
                        isAdd=false;
                    }
                }
                if(isAdd && p.getPermissionType()==1){
                    MenuDto m=new MenuDto();
                    m.setId(p.getSysno().toString());
                    m.setIcon(p.getMenuIcon()==null?"":p.getMenuIcon());
                    m.setName(p.getPermissionName());
                    m.setParent(p.getParentSysno().toString());
                    m.setPath(p.getMenuPath()==null?"":p.getMenuPath());
                    m.setTitle(p.getPermissionName());
                    this.menus.add(m);
                }
            }
        }
    }

    public List<MenuDto> getMenus(){
        return this.menus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
