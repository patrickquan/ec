package com.yangcl.ec.common.entity.common;

import java.util.List;

public class JsonResult<T> {
    //返回码
    private String code;
    //返回消息
    private String message;
    //返回token
    private String token;
    //返回对象
    private T entity;
    //返回集合
    private List<T> rows;
    //返回总记录数
    private Long total;

    public JsonResult(){}
    public JsonResult(String code, String message){
        this.code=code;
        this.message=message;
        this.token="";
        this.entity=null;
    }
    public JsonResult(String code, String message, String token){
        this.code=code;
        this.message=message;
        this.token=token;
        this.entity=null;
    }
    public JsonResult(String code, String message, T data){
        this.code=code;
        this.message=message;
        this.token="";
        this.entity=data;
    }
    public JsonResult(String code, String message, String token, T data){
        this.code=code;
        this.message=message;
        this.token=token;
        this.entity=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T data) {
        this.entity = data;
    }


    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
