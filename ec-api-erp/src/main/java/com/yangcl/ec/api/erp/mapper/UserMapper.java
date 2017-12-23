package com.yangcl.ec.api.erp.mapper;
import com.yangcl.ec.common.entity.erp.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getByKey(long sysno);
}
