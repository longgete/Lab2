<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书管理</title>
</head>
<body>
<br>
 <s:form action="login" method="post">作者查询
     <s:textfield name="authorname" label="作者姓名"></s:textfield>
     <s:submit value="查询"></s:submit>
 </s:form>
<br>
 <s:form action="Addbook" method="post">图书添加
     <s:textfield name="Title" label="新增书名"></s:textfield>
     <s:textfield name="authorname" label="作者姓名"></s:textfield>
     <s:textfield name="ISBN" label="ISBN"></s:textfield>
     <s:textfield name="Publisher" label="出版社"></s:textfield>
     <s:textfield name="PublishDate" label="出版日期"></s:textfield>
     <s:textfield name="Price" label="价格"></s:textfield>
     <s:submit value="添加"></s:submit>
 </s:form>
 <br>
 <s:form action="refresh_" method="post">图书信息更新
     <s:textfield name="Title" label="更新书名"></s:textfield>
     <s:submit value="确定"></s:submit>
 </s:form> 
 
 
 
</body>
</html>