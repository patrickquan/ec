package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.TokenSession;

import java.util.ArrayList;
import java.util.List;

public class MemorySessionRepositoryImpl implements SessionRepository {

    private static List<TokenSession> SESSIONS=new ArrayList<TokenSession>();

    private TokenSession copySession(TokenSession session){
        TokenSession sess=new TokenSession();
        sess.setRefreshToken(session.getRefreshToken());
        sess.setSystem(session.getSystem());
        sess.setSessionId(session.getSessionId());
        sess.setToken(session.getToken());
        sess.setSessionStatus(session.getSessionStatus());
        sess.setSessionName(session.getSessionName());
        sess.setSessionUser(session.getSessionUser());
        sess.setExpirationTime(session.getExpirationTime());
        sess.setCreatedTime(session.getCreatedTime());
        return sess;
    }

    public void addSession(TokenSession session) {
        SESSIONS.add(this.copySession(session));
    }

    public void updateSession(TokenSession session) {
        for(int i=0;i<SESSIONS.size();i++){
            if(SESSIONS.get(i).getSessionId().equals(session.getSessionId()) &&
                    SESSIONS.get(i).getSystem().equals(session.getSystem())){
                SESSIONS.set(i,this.copySession(session));
            }
        }
    }

    public void updateSession(TokenSession session,String token) {
        for(int i=0;i<SESSIONS.size();i++){
            if(SESSIONS.get(i).getSessionId().equals(session.getSessionId()) &&
                    SESSIONS.get(i).getSystem().equals(session.getSystem()) &&
                    SESSIONS.get(i).getToken().equals(token)){
                SESSIONS.set(i,this.copySession(session));
            }
        }
    }
    public TokenSession getSession(String sessionId, String system) {
        for(TokenSession ts:SESSIONS){
            if(ts.getSessionId().equals(sessionId) &&
                    ts.getSystem().equals(system)){
                return this.copySession(ts);
            }
        }
        return null;
    }
    public TokenSession getSession(String sessionId, String system,String token) {
        List<TokenSession> sessions=SESSIONS;
        for(TokenSession ts:sessions){
            if(ts.getSessionId().equals(sessionId) &&
                    ts.getSystem().equals(system) &&
                    ts.getToken().equals(token) &&
                    ts.getExpirationTime().getTime()>System.currentTimeMillis()){
                return this.copySession(ts);
            }
        }
        return null;
    }

    public List<TokenSession> getSessions(){
        return SESSIONS;
    }
}
