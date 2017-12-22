<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<c:if test="${tlist!=null }">
	<table border="1" width="800">
		<tr>
			<th>发起人</th>
			<th>办理流程ID</th>
			<th>发起时间</th>
			<th>请假原因</th>
			<th>请假时长</th>
			<th>请假开始时间</th>
			<th>审核意见1</th>
			<th>审核意见2</th>
		</tr>
		<c:forEach items="${tlist}" var="t" varStatus="s">
			<tr>
				<td>${t.assignee }</td>
				<td>${t.processDefinitionId }</td>
				<td><fmt:formatDate value="${t.startTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${vlist[s.index]['why'] }</td>
				<td>${vlist[s.index]['time'] }</td>
				<td>${vlist[s.index]['startTime'] }</td>
				<td>${vlist[s.index]['report1']==null?"审核中":vlist[s.index]['report1'] }</td>
				<td>${vlist[s.index]['report2']==null?"审核中":vlist[s.index]['report2'] }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${tlist==null }"><h3>*您还没有申请过流程</h3></c:if>
</body>
</html>