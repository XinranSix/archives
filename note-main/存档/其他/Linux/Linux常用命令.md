## Linux常用命令

## 常用工具安装

```shell
# ifconfig 命令
yum install -y net-tools
# vim
yum install -y vim
```

## 防火墙相关命令

```shell
# 1. 查看防火墙状态
systemctl status firewalld
service iptables status
# 2. 暂时关闭防火墙 
systemctl stop firewalld
service iptables stop
# 3. 永久关闭防火墙
systemctl disable firewalld
chkconfig iptables off
# 4 开启防火墙
systemctl enable firewalld
service iptables restart
# 5 查看某个端口是否放行
firewall-cmd --query-port=端口号/tcp
# 6 放行指定端口
firewall-cmd --zone=public --add-port=端口号/tcp --permanent 
# 6.1 重启防火墙
systemctl restart firewalld.service
# 6.2 重新载入配置
firewall-cmd --reload
```
