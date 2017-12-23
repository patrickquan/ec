package com.yangcl.ec.api.erp.mapper;
import com.yangcl.ec.common.entity.erp.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity getByKey(long sysno);
}
