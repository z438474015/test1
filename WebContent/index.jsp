<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'i.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <a href="<%=basePath%>/act/findAll.do"><button>流程管理</button></a>
   <a href="<%=basePath%>user/exit.do"><button>安全退出</button></a>
   <a href="<%=basePath%>aAu.jsp"><button>添加新用户</button></a>
   <hr>
   <c:if test="${list != null }">
	   <table border="1" width="500">
	   	<tr>
	   		<th>编号</th>
	   		<th>用户名</th>
	   		<th>用户密码</th>
	   		<th>昵称</th>
	   		<th>功能</th>
	   	</tr>
	   	<c:forEach items="${list }" var="u" varStatus="s">
	   		<tr align="center">
	   			<td>${s.count}</td>
	   			<td>${u.userName }</td>
	   			<td>${u.password }</td>
	   			<td>${u.nickName }</td>
	   			<td>
	   				<a href="<%=basePath%>user/findById.do?id=${u.id}"><button>修改</button></a>|
	   				<a href="<%=basePath%>user/delete.do?id=${u.id}"><button>删除</button></a>
	   			</td>
	   		</tr>
	   	</c:forEach>
	   </table>
   </c:if>
  </body>
</html>
