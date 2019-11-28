<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style>
     <%@ include file="../css/style.css"%>
</style>
<title>ユーザ管理</title>
</head>
<body>
<!-- Begin vung header -->
<%@ include file="Header.jsp"%>
<!-- End vung header -->	

<!-- Begin vung dieu kien tim kiem -->	
<form action="ListUser.do" method="get" name="mainform">
	<input type="hidden" name="type" value="SEARCH"/>
	<table  class="tbl_input" border="0" width="90%"  cellpadding="0" cellspacing="0" >		
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				会員名称で会員を検索します。検索条件無しの場合は全て表示されます。 
			</td>
		</tr>
		<tr>
			<td width="100%">
				<table class="tbl_input" cellpadding="4" cellspacing="0" >
					<tr>
						<td class="lbl_left">氏名:</td>
						<td align="left">
						<input class="txBox" type="text" name="name" value="<c:out value="${name}"/>"
							size="20" onfocus="this.style.borderColor='#0066ff';"
							onblur="this.style.borderColor='#aaaaaa';" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td class="lbl_left">グループ:</td>
						<td align="left" width="80px">
							<select name="group_id">
								<option value="0">全て</option>						
								<c:forEach items="${listgroup}" var="group">
								<option value="${group.groupId}" ${group.groupId == group_id ? 'selected="selected"' : ''}><c:out value="${group.groupName}"/></option>	
								</c:forEach>
							</select>							
						</td>
						<td align="left">
							<input class="btn" type="submit" value="検索" />
							<input class="btn" type="button" value="新規追加"  onclick="window.location.href='${pageContext.request.contextPath}/AddUserInput.do'" />							
						</td>
					</tr>
				</table>
			</td>
		</tr>		
	</table>
	<!-- End vung dieu kien tim kiem -->
</form>
	<!-- Begin vung hien thi danh sach user -->
	<table class="tbl_list" border="1" cellpadding="4" cellspacing="0" width="80%">
		
		<tr class="tr2">
			<th align="center" width="20px">
				ID
			</th>
			<th align="left">
				氏名
				<c:url value = "ListUser.do?type=SORT&sortField=fullName&sort=${sortByFullName == 'ASC' ? 'DESC' : 'ASC'}" var="fullName">
					<c:param name="name" value="${name}" />
					<c:param name="group_id" value="${group_id}"/>
					<c:param name="currentPage" value="${currentPage}"></c:param>
				</c:url>
				<a href = "${fullName}">
				<c:choose>
				<c:when test="${sortByFullName == 'ASC'}">
					<c:out value="▲▽"/>
				</c:when>
				<c:otherwise>
					<c:out value="△▼"/>
				</c:otherwise>
				</c:choose>
				</a>
			</th>
			<th align="left">
				生年月日
			</th>
			<th align="left">
				グループ
			</th>
			<th align="left">
				メールアドレス
			</th>
			<th align="left" width="70px">
				電話番号
			</th>
			<th align="left">
				日本語能力  
				<c:url value = "ListUser.do?type=SORT&sortField=codeLevel&sort=${sortByCodeLevel == 'ASC' ? 'DESC' : 'ASC'}" var="codeLevel">
					<c:param name="name" value="${name}" />
					<c:param name="group_id" value="${group_id}"/>
					<c:param name="currentPage" value="${currentPage}"></c:param>
				</c:url>
				<a href = "${codeLevel}">
				<c:choose>
				<c:when test="${sortByCodeLevel == 'ASC'}">
					<c:out value="▲▽"/>
				</c:when>
				<c:otherwise>
					<c:out value="△▼"/>
				</c:otherwise>
				</c:choose>
				</a>
			</th>
			<th align="left">
				失効日 
				<c:url value = "ListUser.do?type=SORT&sortField=expireDate&sort=${sortByExpireDate == 'ASC' ? 'DESC' : 'ASC'}" var="expireDate">
					<c:param name="name" value="${name}" />
					<c:param name="group_id" value="${group_id}"/>
					<c:param name="currentPage" value="${currentPage}"></c:param>
				</c:url>
				<a href = "${expireDate}">
				<c:choose>
				<c:when test="${sortByExpireDate == 'ASC'}">
					<c:out value="▲▽"/>
				</c:when>
				<c:otherwise>
					<c:out value="△▼"/>
				</c:otherwise>
				</c:choose>
				</a>
			</th>
			<th align="left">
				点数
			</th>
		</tr>
		<c:forEach items="${userInfo}" var="user">
			<tr>
				<td align="right">
					<a href="JSP/ADM005.html"><c:out value="${user.userId}"/></a>
				</td>
				<td>
					<c:out value="${user.fullName}"/>
				</td>
				<td align="center">
					<c:out value="${user.birthDay}"/>
				</td>
				<td>
					<c:out value="${user.group}"/>
				</td>
				<td>
					<c:out value="${user.email}"/>
				</td>
				<td>
					<c:out value="${user.tel}"/>
				</td>
				<td>
					<c:out value="${user.japanLevel}"/>
				</td>
				<td align="center">
					<c:out value="${user.expireDate}"/>
				</td>
				<td align="right">
					<c:out value="${user.total}"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<span><c:out value="${error}"/></span>
	<!-- End vung hien thi danh sach user -->

	<!-- Begin vung paging -->
	<table>
		<tr>
			<td class = "lbl_paging">
				<c:if test = "${fn:length(listPaging) != 0 && listPaging[0] != 1}">
         			<a href = "ListUser.do?type=PAGING&name=${URLEncoder.encode(name,'UTF-8')}&group_id=${group_id}&sortField=${sortField}&sort=${sort}&currentPage=${listPaging[0] - 3}"><<</a>
      			</c:if>
      			<c:if test = "${allPaging > 1}">
				<c:forEach items="${listPaging}" var="page">
				<c:choose>
					<c:when test="${page == currentPage}">
						<c:out value="${page}"/>
					</c:when>
					<c:otherwise>
						<a href = "ListUser.do?type=PAGING&name=${URLEncoder.encode(name,'UTF-8')}&group_id=${group_id}&sortField=${sortField}&sort=${sort}&currentPage=${page}"><c:out value="${page}"/></a>	
					</c:otherwise>
				</c:choose>
				</c:forEach>
				</c:if>
				<c:if test = "${fn:length(listPaging) != 0 && listPaging[fn:length(listPaging) - 1] != allPaging}">
         			<a href = "ListUser.do?type=PAGING&name=${URLEncoder.encode(name,'UTF-8')}&group_id=${group_id}&sortField=${sortField}&sort=${sort}&currentPage=${listPaging[2] + 1}">>></a>
      			</c:if>
			</td>
		</tr>
	</table>
	<!-- End vung paging -->

	<!-- Begin vung footer -->
	<%@ include file="Footer.jsp"%>
	<!-- End vung footer -->
	
</body>

</html>