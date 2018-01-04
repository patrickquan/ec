package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.TokenSession;

import java.util.ArrayList;
import java.util.List;

public class MemorySessionRepositoryImpl implements SessionRepository {

    private static List<TokenSession> SESSIONS=new ArrayList<TokenSession>();

    public TokenSession getSession(String sessionId, String system) {
        for(TokenSession ts:SESSIONS){
            if(ts.getSessionId().equals(sessionId) &&
                    ts.getSystem().equals(system)){
                return ts;
            }
        }
        return null;
    }

    public void addSession(TokenSession session) {
        SESSIONS.add(session);
    }

    public void updateSession(TokenSession session) {
        for(int i=0;i<SESSIONS.size();i++){
            if(SESSIONS.get(i).getSessionId().equals(session.getSessionId()) &&
                    SESSIONS.get(i).getSystem().equals(session.getSystem())){
                SESSIONS.set(i,session);
            }
        }
    }
}
