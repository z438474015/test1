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
<c:forEach items="${l }" var="map">
	<form action="<%=basePath%>act/check.do" method="post">
	<input type="hidden" name="name" value="${map['taskId'] }">
		请假人：${map['userId'] }<br/>
		请假原因：${map['why'] }<br/>
		请假时长：${map['time'] }<br/>
		开始时间：${map['startTime'] }<br/>
		<c:choose>
			<c:when test="${map['report1']!=null }">审批意见1：${map['report1'] }<br/></c:when>
			<c:otherwise>
				审批意见1：<textarea rows="4" cols="15" name="idea1"></textarea><br/>
				<input type="submit" value="提交">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${map['report2']!=null }">审批意见2：${map['report2'] }<br/></c:when>
			<c:when test="${map['report1']!=null && map['report2']==null }">
			审批意见2：<textarea rows="4" cols="15" name="idea2"></textarea><br/>
			<input type="submit" value="提交">
			</c:when>
		</c:choose>		
	</form>
</c:forEach>
<c:if test="${l==null }">
*没有您需要审核的流程
</c:if>
</body>
</html>