package com.yangcl.ec.common.utils;

public class JsonResult<T> {
    private String code;
    private String status;
    private String message;
    private T entity;

    public JsonResult(String code,String message){
        this.code=code;
        this.status="";
        this.message=message;
        this.entity=null;
    }
    public JsonResult(String code,String status,String message){
        this.code=code;
        this.status=status;
        this.message=message;
        this.entity=null;
    }
    public JsonResult(String code,String message,T data){
        this.code=code;
        this.status="";
        this.message=message;
        this.entity=data;
    }
    public JsonResult(String code,String status,String message,T data){
        this.code=code;
        this.status=status;
        this.message=message;
        this.entity=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T data) {
        this.entity = data;
    }
}
