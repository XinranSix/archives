## 设置代理

## http || https 协议

```shell
//设置全局代理
//http
git config --global https.proxy http://127.0.0.1:1080
//https
git config --global https.proxy https://127.0.0.1:1080
//使用socks5代理的 例如ss，ssr 1080是windows下ss的默认代理端口,mac下不同，或者有自定义的，根据自己的改
git config --global http.proxy socks5://127.0.0.1:1080
git config --global https.proxy socks5://127.0.0.1:1080

//只对github.com使用代理，其他仓库不走代理
git config --global http.https://github.com.proxy socks5://127.0.0.1:1080
git config --global https.https://github.com.proxy socks5://127.0.0.1:1080
//取消github代理
git config --global --unset http.https://github.com.proxy
git config --global --unset https.https://github.com.proxy

//取消全局代理
git config --global --unset http.proxy
git config --global --unset https.proxy
```

### SSH 协议

```shell
//对于使用git@协议的，可以配置socks5代理
//在~/.ssh/config 文件后面添加几行，没有可以新建一个
//socks5
Host github.com
User git
ProxyCommand connect -S 127.0.0.1:1080 %h %p

//http || https
Host github.com
User git
ProxyCommand connect -H 127.0.0.1:1080 %h %p
```
