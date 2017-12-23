package com.yangcl.ec.api.erp.service.erp;

import com.yangcl.ec.common.entity.erp.UserEntity;

public interface UserService {
    UserEntity getByKey(long sysno);
}
