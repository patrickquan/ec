package com.yangcl.ec.common.entity.common;
import java.util.List;

public class JsonRowsResult<T> {
    //返回码
    private String code;
    //返回消息
    private String message;
    //返回token
    private String token;
    //返回总行数
    private Long total;
    //返回集合对象
    private List<T> rows;


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
