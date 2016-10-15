<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  %>
<!-- <%@taglib prefix="s" uri="/struts-tags" %>  -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="refresh" method="post">
     <s:textfield name="authorname" label="作者"></s:textfield>
     <s:textfield name="Publisher" label="出版社"></s:textfield>
     <s:textfield name="PublishDate" label="出版日期"></s:textfield>
     <s:textfield name="Price" label="价格"></s:textfield>
     <s:submit value="更新"></s:submit>
 </s:form>
</body>
</html>