import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:5220/Home'


// axios 配置
axios.defaults.timeout = 5000;
axios.defaults.baseURL = 'https://api.github.com';

// http request 拦截器
axios.interceptors.request.use(
    config => {
        config.headers.Authorization = '12312312312313';
        return config;
    },
    err => {
        return Promise.reject(err);
    });


//get请求
function get(url) {
    return body => axios.get(url, { params: body })
  }
//post请求
function post(url) {
return body => axios.post(url, body)
}

//导出使用 
export const login = post('/About')