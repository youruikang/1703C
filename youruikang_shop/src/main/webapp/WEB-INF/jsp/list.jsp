<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function qx(){
		var a = $("[name='a']").prop("checked");
		$("[name='rid']").prop("checked",a);
	}
</script>
<body>
	
	<form action="list.do" method="post">
		销售商品 :<c:forEach items="${slist}" var="s">
					<input type = "checkbox" name="sid" value="${s.sid}">${s.sname}
				</c:forEach>
		<br>店铺名称 :<input type="text" name="sname"><input type="submit" value="查询">
	</form>
	
	<table>
		<tr>
			<td>
				<input type="checkbox" name="a" onclick="qx()">
			</td>
			<td>编号</td>
			<td>店铺名称</td>
			<td>创建日期</td>
			<td>销售商品</td>
			<td>操作</td>
		</tr>	
		<c:forEach items="${rlist}" var="r">
		<tr>
			<td>
				<input type="checkbox" name="rid">
			</td>
			<td>${r.rid}</td>
			<td>${r.rname}</td>
			<td>${r.rdate}</td>
			<td>${r.sname}</td>
			<td>
				<input type = "button" value = "详情" onclick="findById(${r.rid})">
			</td>
		</tr>	
		</c:forEach>
		<tr>
			<td colspan="16">
				<a href = "list.do?pageNum=1">首页</a>
				<a href = "list.do?pageNum=${page.prePage==0?1:page.prePage}">上一页</a>
				<a href = "list.do?pageNum=${page.nextPage==0?page.lastPage:page.nextPage}">下一页</a>
				<a href = "list.do?pageNum=${page.lastPage}">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>