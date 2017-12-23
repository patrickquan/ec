package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.User;

public interface UserService {
    User getByKey(long sysno);
}
