<%--
  Created by IntelliJ IDEA.
  User: 28357
  Date: 2023/10/18
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath
}/statics/calendar/WdatePicker.js"></script>
</head>
<body>
<fm:form method="post" modelAttribute="sysUser">
    用户编码:<fm:input path="account"/><fm:errors path="account"/><br/>
    用户名称:<fm:input path="realName"/><fm:errors path="realName"/><br/>
    用户密码:<fm:password path="password"/><fm:errors path="password"/><br/>
    用户生日:<fm:input path="birthday" Class="Wdate"
                   readonly="readonly" onclick="WdatePicker();"
                   class="Wdate"/> <fm:errors path="birthday"/><br/>
    用户地址:<fm:input path="address"/><br/>
    联系电话:<fm:input path="phone"/><br/>
    用户角色:
    <fm:radiobutton path="roleId" value="1"/>系统管理员
    <fm:radiobutton path="roleId" value="2"/>店长
    <fm:radiobutton path="roleId" value="3" checked="checked"/>店员
    <br/>
    <input type="submit" value="保存"/>
</fm:form>
</body>
</html>
