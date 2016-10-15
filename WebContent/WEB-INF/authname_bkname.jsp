<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  %>
<!-- <%@taglib prefix="s" uri="/struts-tags" %>  -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>该作者的作品如下</title>
</head>

<table>

<s:iterator  value="Reportlist">
<tr>
<td>
<a href=<s:url action="select">
<s:param name="ISBN" value="ISBN"></s:param>
</s:url>
><s:property value="Title"/></a>

<a href=<s:url action="delete">
<s:param name="key" value="ISBN"></s:param>
<s:param name="AuthorID" value="AuthorID"></s:param>
</s:url>>删除这本书</a>
</td>
</tr>
 </s:iterator> 
</table>
</html>