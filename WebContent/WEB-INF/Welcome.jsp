<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- <%@taglib prefix="s" uri="/struts-tags" %>  -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>WElcom</title>
</head>
<body>
<center>


<table  width="400px" border="1" cellpadding="1" cellspacing="1">
<caption>作者详细信息</caption>                             
<tr><th>AuthorID</th><th>Name</th><th>Age</th><th>Country</th></tr>
<tr><th><s:property value="#request.author.AuthorID"  default="a default value"/></th>
    <th><s:property value="#request.author.Name"  default="a default value"/></th>
    <th><s:property value="#request.author.Age"  default="a default value"/></th>
    <th><s:property value="#request.author.Country"  default="a default value"/></th>
</tr>
</table>
<table width="400px" border="1" cellpadding="1" cellspacing="1">
<caption>图书详细信息</caption>
<tr><td>ISBN</td><td>Title</td><td>AuthorID</td><td>Publisher</td><td>PublishDate</td><td>Price</td></tr>
<tr>
  <td><s:property value="#request.bd.ISBN"  default="a default value"/></td>
  <td><s:property value="#request.bd.Title"  default="a default value"/></td>
  <td><s:property value="#request.bd.AuthorID"  default="a default value"/></td>
  <td><s:property value="#request.bd.Publisher"  default="a default value"/></td>
  <td><s:property value="#request.bd.PublishDate"  default="a default value"/></td>
  <td><s:property value="#request.bd.Price"  default="a default value"/></td>
</table>
</center>
</body>
</html>