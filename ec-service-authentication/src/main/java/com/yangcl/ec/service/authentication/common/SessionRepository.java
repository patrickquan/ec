package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.TokenSession;

import java.util.List;

public interface SessionRepository {
    public void addSession(TokenSession session);
    public void updateSession(TokenSession session);
    public void updateSession(TokenSession session,String token);
    public TokenSession getSession(String sessionId,String sysName);
    public TokenSession getSession(String sessionId,String sysName,String token);
    public List<TokenSession> getSessions();
}
