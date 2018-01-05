package com.yangcl.ec.common.entity.common;

import java.util.Date;

/**
 * Token会话
 */
public class TokenSession {
    private String sessionId;
    private String sessionName;
    private String sessionUser;
    private String system;
    private String token;
    private String refreshToken;
    private Date createdTime;
    private Date expirationTime;
    private String sessionStatus;

    public TokenSession(){}
    public TokenSession(String sessionId,String sessionUser,String system){
        this.sessionId=sessionId;
        this.sessionUser=sessionUser;
        this.system=system;
    }


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(String sessionUser) {
        this.sessionUser = sessionUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
