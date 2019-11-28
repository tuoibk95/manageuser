<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function anhien() {
    let an1 = document.getElementById("an1");
    let an2 = document.getElementById("an2");
    let an3 = document.getElementById("an3");
    let an4 = document.getElementById("an4");

    if (an1.style.visibility === 'visible') {
        an1.style.visibility = 'hidden';
        an2.style.visibility = 'hidden';
        an3.style.visibility = 'hidden';
        an4.style.visibility = 'hidden';
    } else {
        an1.style.visibility = 'visible';
        an2.style.visibility = 'visible';
        an3.style.visibility = 'visible';
        an4.style.visibility = 'visible';
    };
}
</script>
<title>ユーザ管理</title>
</head>
<body>
	<!-- Begin vung header -->
	<%@ include file="Header.jsp"%>
	<!-- End vung header -->

	<!-- Begin vung input-->
	<form action="ADM004.html" method="post" name="inputform">
		<table class="tbl_input" border="0" width="75%" cellpadding="0"
			cellspacing="0">
			<tr>
				<th align="left">
					<div style="padding-left: 100px;">会員情報編集</div>
				</th>
			</tr>
			<tr>
				<td class="errMsg">
					<div style="padding-left: 120px">&nbsp;</div>
				</td>
			</tr>
			<tr>
				<td align="left">
					<div style="padding-left: 100px;">
						<table border="0" width="100%" class="tbl_input" cellpadding="4"
							cellspacing="0">
							<tr>
								<td class="lbl_left"><font color="red">*</font> アカウント名:</td>
								<td align="left"><input class="txBox" type="text" name="id"
									value="" size="15" onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> グループ:</td>
								<td align="left"><select name="group_id">
										<option value="0">選択してください</option>
										<c:forEach items="${listgroup}" var="group">
											<option value="${group.groupId}"
												${group.groupId == group_id ? 'selected="selected"' : ''}><c:out
													value="${group.groupName}" /></option>
										</c:forEach>
								</select> <span>&nbsp;&nbsp;&nbsp;</span></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="name" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left">カタカナ氏名:</td>
								<td align="left"><input class="txBox" type="text"
									name="name" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> 生年月日:</td>
								<td align="left">
								<select>
										<c:forEach items="${year}" var="year">
											<option value="${year}"><c:out value="${year}" /></option>
										</c:forEach>
								</select>年 <select>
										<c:forEach items="${month }" var="month">
											<option value="${month}"><c:out value="${month}" /></option>
										</c:forEach>
								</select>月 <select>
										<c:forEach items="${day }" var="day">
											<option value="${day}"><c:out value="${day}" /></option>
										</c:forEach>
								</select>日
								</td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> メールアドレス:</td>
								<td align="left"><input class="txBox" type="text"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font>電話番号:</td>
								<td align="left"><input class="txBox" type="text"
									name="tel" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left"><font color="red">*</font> パスワード:</td>
								<td align="left"><input class="txBox" type="password"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<td class="lbl_left">パスワード（確認）:</td>
								<td align="left"><input class="txBox" type="password"
									name="email" value="" size="30"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
							<tr>
								<th align="left" colspan="2"><a onclick= "anhien()" href="#">日本語能力</a></th>
							</tr>
							<tr id="an1">
								<td class="lbl_left">資格:</td>
								<td align="left"><select name="kyu_id">
										<option value="0">選択してください</option>
										<c:forEach items="${listjapan}" var="mstjapan">
											<option value="${mstjapan.codeLevel}"
												${mstjapan.codeLevel == code_level ? 'selected="selected"' : ''}><c:out
													value="${mstjapan.codeLevel}" /></option>
										</c:forEach>
								</select></td>
							</tr>
							<tr id="an2">
								<td class="lbl_left">資格交付日:</td>
								<td align="left">
								<select>
										<c:forEach items="${year}" var="year">
											<option value="${year}"><c:out value="${year}" /></option>
										</c:forEach>
								</select>年 <select>
										<c:forEach items="${month }" var="month">
											<option value="${month}"><c:out value="${month}" /></option>
										</c:forEach>
								</select>月 <select>
										<c:forEach items="${day }" var="day">
											<option value="${day}"><c:out value="${day}" /></option>
										</c:forEach>
								</select>日
								</td>
							</tr>
							<tr  id="an3">
								<td class="lbl_left">失効日:</td>
								<td align="left">
								<select>
										<c:forEach items="${year}" var="year">
											<option value="${year}"><c:out value="${year}" /></option>
										</c:forEach>
								</select>年 <select>
										<c:forEach items="${month }" var="month">
											<option value="${month}"><c:out value="${month}" /></option>
										</c:forEach>
								</select>月 <select>
										<c:forEach items="${day }" var="day">
											<option value="${day}"><c:out value="${day}" /></option>
										</c:forEach>
								</select>日
								</td>
							</tr>
							<tr  id="an4">
								<td class="lbl_left">点数:</td>
								<td align="left"><input class="txBox" type="text"
									name="total" value="" size="5"
									onfocus="this.style.borderColor='#0066ff';"
									onblur="this.style.borderColor='#aaaaaa';" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<div style="padding-left: 100px;">&nbsp;</div>
		<!-- Begin vung button -->
		<div style="padding-left: 45px;">
			<table border="0" cellpadding="4" cellspacing="0" width="300px">
				<tr>
					<th width="200px" align="center">&nbsp;</th>
					<td><input class="btn" type="submit" value="確認" /></td>
					<td><input class="btn" type="button" value="戻る"
						onclick="window.location.href='${pageContext.request.contextPath}/ListUser.do?type=BACK'" />
					</td>
				</tr>
			</table>
		</div>
			<!-- End vung button -->
	</form>
	<!-- End vung input -->

	<!-- Begin vung footer -->
	<div class="lbl_footer">
		<%@ include file="Footer.jsp"%>
	</div>
		<!-- End vung footer -->
</body>

</html>