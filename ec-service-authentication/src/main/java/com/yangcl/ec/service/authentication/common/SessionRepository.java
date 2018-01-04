package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.TokenSession;

public interface SessionRepository {
    public TokenSession getSession(String sessionId,String sysName);
    public void addSession(TokenSession session);
    public void updateSession(TokenSession session);
}
