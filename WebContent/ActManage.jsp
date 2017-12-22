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
    
    <title>My JSP 'a.jsp' starting page</title>
    
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
   <a href="<%=basePath%>user/exit.do"><button>安全退出</button></a>
   <a href="<%=basePath%>addAct.jsp"><button>添加新流程</button></a>
   <a href="<%=basePath%>act/plan.do?name=${usr.nickName}"><button>查看我的历史流程申请</button></a>
   <c:if test="${usr.audit eq \"1\" }">
   <a href="<%=basePath%>act/look.do?name=${usr.nickName}"><button>查看我的审核</button></a>
   </c:if>
   <table border="1" width="400">
   	<tr>
   		<th>编号</th>
   		<th>流程名称</th>
   		<th>流程ID</th>
   		<th>功能</th>
   	</tr>
   
   <c:forEach items="${list }" var="p" varStatus="s">
   	<tr>
   		<td>${s.count }</td>
   		<td>${p.name }</td>
   		<td>${p.id }</td>
   		<td>
   			<a href="<%=basePath%>begin.jsp?flow=${p.key}"><button>使用</button></a>|
	   		<a href="<%=basePath%>act/delete.do?id=${p.deploymentId}"><button>删除</button></a>
   		</td>
   	</tr>
   </c:forEach>
   </table>
</body>
</html>