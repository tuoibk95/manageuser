<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
     <%@ include file="../css/style.css"%>
</style>
<script type="text/javascript" src="../js/user.js"></script>
<title>ユーザ管理</title>
</head>
<body>
<div>			
	<!-- Begin vung header -->	
		<div>			
			<div>
			<table>
			<tr>
			<td width = "80%"><img src="${pageContext.request.contextPath}/images/logo-manager-user.gif" alt="Luvina" /></td>
			<td align="left"><a href = "Logout">ログアウト</a> &nbsp; <a href = "ListUser.do">トップ</a></td>
			</tr>
			</table>
			</div>
		</div>
</div>
</body>
</html>