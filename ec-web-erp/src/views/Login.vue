<!--登录页-->
<template>
    <el-form :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left" label-width="0px" class="login-container">
        <h3 class="title text-center">Vue ElementUI Admin</h3>
        <el-alert style="margin-bottom:10px;" title="帐号admin或guest，密码123456，帐号权限不同!" type="success"></el-alert>
        <el-form-item prop="loginuser">
            <el-input type="text" v-model="loginForm.loginuser" auto-complete="off" placeholder="账号" @keyup.enter.native="loginIn" :autofocus="true"></el-input>
        </el-form-item>
        <el-form-item prop="loginpwd">
            <el-input type="password" v-model="loginForm.loginpwd" auto-complete="off" placeholder="密码" @keyup.enter.native="loginIn"></el-input>
        </el-form-item>
        <el-checkbox v-model="checked" class="remember">记住密码</el-checkbox>
        <el-form-item style="width:100%;margin-top:10px;">
            <el-button type="primary" style="width:100%;" @click.native.prevent="loginIn" :loading="logining">登录</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import {requestLogin,login} from '../service/api';
export default {
    name:'Login',
    data() {
        return {
            logining: false,
            loginForm: {
                loginuser: '',
                loginpwd: ''
            },
            loginRules: {
                loginuser: [
                    { required: true, message: '请输入账号', trigger: 'blur' },
                ],
                loginpwd: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                ]
            },
            checked: false
        };
    },
    methods: {
        resetForm() {
            this.$refs.loginForm.resetFields();
        },
        menuchilren(data,pid){
            var result=[],temp;
            for(var i in data){
                if(data[i].parent==pid){
                    data[i]=data[i];
                    result.push(data[i]);
                    temp=this.menuchilren(data,data[i].id);
                    if(temp.length>0){
                        data[i].children=temp;
                    }
                }
            }
        },
        loginIn(ev) {
            this.$refs.loginForm.validate((valid) => {
                if(valid){
                    this.logining=true;
                    var loginParams={loginName:this.loginForm.loginuser,loginPwd:this.loginForm.loginpwd};
                    requestLogin(loginParams).then(data=>{
                        this.logining=false;
                        let {message,code,entity}=data;
                        console.log(message);
                        if(code!=200){
                            this.$message({
                                message:message,
                                type:'error'
                            });
                        }else{
                            let pers=[];
                            entity.roles.forEach(function (r) {
                                r.permissions.forEach(function (p) {
                                    if(pers.length==0){
                                        pers.push(p);
                                    }else{
                                        let isCheck=true;
                                        pers.forEach(function (pr) {
                                            if(pr.sysno===p.sysno){
                                              isCheck=false;
                                            }
                                        });
                                        if(isCheck){
                                            pers.push(p);
                                        }
                                    }
                                });
                            });
                            let menus=[];
                            pers.forEach(function (p) {
                                menus.push({
                                    id:p.sysno,
                                    name:p.menupath,
                                    path:p.menupath,
                                    icon:p.menuicon,
                                    title:p.permissionName,
                                    parent:p.parentSysno,
                                    children:[]
                                });
                            });



                            entity.menus=this.menuchilren(menus,0);
                            console.log(entity.menus.length);
                            sessionStorage.setItem('user',JSON.stringify(data.data));
                            this.$router.push({path:'/'});
                        }
                    });
                }else{
                    return false;
                }
            });
        },
        test(){
            login({account:'admin'}).then(data=>{

            });
            console.log(res);
        }
    }
}
</script>

<style>
  .login-container {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    .title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
    .remember {
      margin: 0px 0px 35px 0px;
    }
  }
  .text-center {
    text-align: center;
  }
</style>
