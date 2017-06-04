<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员注册页面</title>
</head>
<body>
    <s:form action="addNew" method="post">
        <h4><s:text name="添加新闻"></s:text></h4>
        <s:property value="exception.message"/>
        <s:textfield name="news.newTitle" label="新闻标题" tooltip="添加新闻标题!" required="true"></s:textfield>
        <s:textfield name="news.newContent" label="新闻内容" tooltip="Enter your password!"></s:textfield>
        <s:textfield name="news.newImage" label="新闻图片"></s:textfield>
        <s:textfield name="news.newProvenance" label="新闻出处"></s:textfield>
        <s:submit value="提交"/>
    </s:form>
</body>
</html>