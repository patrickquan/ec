package com.yangcl.ec.common.entity.common;

/**
 * 系统枚举类
 */
public class AppEnum {
    /**
     * Auth帐户统一认证服务返回码枚举
     */
    public static enum AuthResultCode{
        LoginSuccess("200","登录成功"),//登录成功
        ValidateSuccess("200","登录验证成功"),//登录验证成功
        InputNull("400","输入校验为空"),//输入校验为空
        TokenError("402","Token验证失败"),//Token验证失败
        AccountNull("403","帐户不在线");//帐户不在线，查找不到

        private final String code;
        private final String message;
        private AuthResultCode(final String code,final String message){
            this.code=code;
            this.message=message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString(){
            return "{\"code\":\""+code+"\",\"message\":"+message+"\"}";
        }
    }
}
