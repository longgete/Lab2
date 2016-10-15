<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新加入作者信息输入</title>
</head>
<body>
<s:form action="addauthor" method="post">
     <s:textfield name="Age" label="作者年龄"></s:textfield>
     <s:textfield name="Country" label="国家"></s:textfield>
     <s:submit value="添加"></s:submit>
</s:form>
</body>
</html>