@echo off
chcp 65001
title zhilian-publics
echo.
echo [信息] 打包publics公共服务工程。
echo.
call  mvn  package -DskipTests=true
echo.
echo [信息] 启动publics公共服务工程。
echo.
java -Dfile.encoding=utf-8 -Xmx128m -jar target/zhilian-publics.jar