<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">

	.s{
		cursor: pointer;
	}

</style>
</head>
<script type="text/javascript">

	function qx(){
		var c = $("#qx").prop("checked");
		$("[name='mid']").attr("checked", c);
	}
	
	function fx(){
		$("[name='mid']").each(function(){
			this.checked = !this.checked;
		})
	}
	
	function remove(){
		var ids = "";
		$("[name='mid']:checked").each(function(){
			ids += ","+this.value;
		})
		if(ids.length > 0){
			$.ajax({
				url:"delete.do",
				type:"post",
				data:"ids="+ids.substring(1),
				dataType:"json",
				success:function(data){
					if(eval(data) > 0){
						alert("删除成功");
					}else{
						alert("删除失败");
					}
					location.href="list.do";
				},error:function(){
					location.href="list.do";
				}
			})
		}else{
			alert("您未选择要删除的数据");
		}
	}
	
	function page(page){
		$("#p").val(page);
		$("#f").submit();
	}
	
	function search(){
		$("#f").css("display", "inline-block");
	}
	
	function s1(){
		$("#yorder").val("");
		$("#horder").val("");
		var c = $("#dorder").val();
		if(c.length > 0){
			if(c == 'asc'){
				$("#dorder").val("desc");
			}else{
				$("#dorder").val("asc");
			}
			$("#f").submit();
		}else{
			$("#dorder").val("asc");
			$("#f").submit();
		}
	}
	
	function s3(){
		$("#dorder").val("");
		$("#horder").val("");
		var c = $("#yorder").val();
		if(c.length > 0){
			if(c == 'asc'){
				$("#yorder").val("desc");
			}else{
				$("#yorder").val("asc");
			}
			$("#f").submit();
		}else{
			$("#yorder").val("asc");
			$("#f").submit();
		}
	}
	
	function s2(){
		$("#yorder").val("");
		$("#dorder").val("");
		var c = $("#horder").val();
		if(c.length > 0){
			if(c == 'asc'){
				$("#horder").val("desc");
			}else{
				$("#horder").val("asc");
			}
			$("#f").submit();
		}else{
			$("#horder").val("asc");
			$("#f").submit();
		}
	}
</script>
<body>
	<input type="button" value="查询影片" onclick="search()">
	<input type="button" value="添加影片" onclick="add()">
	<input type="button" value="删除影片" onclick="remove()"><br><br>
	<form action="list.do" method="post" id="f" style="display: none;">
		<input type="hidden" name="page" id="p">
		<input type="hidden" name="dorder" id="dorder" value="${map.dorder }">
		<input type="hidden" name="yorder" id="yorder" value="${map.yorder }">
		<input type="hidden" name="horder" id="horder" value="${map.horder }">
		影片名称:<input type="text" name="mname" value="${map.mname }"><br><br>
		导演:<input type="text" name="dname" value="${map.dname }"><br><br>
		电影年代:<input type="text" name="year" placeholder="请选择年代" value="${map.year }"><br><br>
		上映时间:<input type="text" name="dlow" value="${map.dlow }" placeholder="开始日期" onclick="WdatePicker()">——<input type="text" placeholder="结束日期" name="dhigh" value="${map.dhigh }" onclick="WdatePicker()"><br><br>
		价格:<input type="text" name="plow" value="${map.plow }" placeholder="最低价">——<input type="text" name="phigh" value="${map.phigh }" placeholder="最高价"><br><br>
		电影时长:<input type="text" name="hlow" value="${map.hlow }" placeholder="最短时间">——<input type="text" name="hhigh" value="${map.hhigh }" placeholder="最长时间"><br><br>
		<input type="submit" value="查询影片">
		<input type="reset" >
	</form>
	<table>
		<tr>
			<th><input type="checkbox" id="qx" onclick="qx()">
				<input type="button" value="反选" onclick="fx()">
			</th>
			<th>影片名</th>
			<th>导演</th>
			<th>票价</th>
			<th>上映时间<span onclick="s1()" class="s">〓</span></th>
			<th>时长<span onclick="s2()" class="s">〓</span></th>
			<th>类型</th>
			<th>年代<span onclick="s3()" class="s">〓</span></th>
			<th>区域</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="m">
			<tr>
				<td><input type="checkbox" name="mid" value="${m.mid }"></td>
				<td>${m.mname }</td>
				<td>${m.dname }</td>
				<td>${m.price }</td>
				<td>${m.datea }</td>
				<td>${m.hours }</td>
				<td>${m.type }</td>
				<td>${m.year }</td>
				<td>${m.area }</td>
				<td><c:if test="${m.status == 0 }">已被下架</c:if>
					<c:if test="${m.status == 1 }">即将上映</c:if>
					<c:if test="${m.status == 2 }">正在热映</c:if>
				</td>
				<td>
					<a href="#">详细</a>
					<a href="#">编辑</a>
					<c:if test="${m.status == 2 }"><a href="updateStatus.do?status=0&mid=${m.mid }">下架</a></c:if>
					<c:if test="${m.status == 0 }"><a href="updateStatus.do?status=1&mid=${m.mid }">上架</a></c:if>
					<c:if test="${m.status == 1 }"><a href="updateStatus.do?status=2&mid=${m.mid }">热映</a></c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="15">
				<input type="button" value="首页" onclick="page('1')">
				<input type="button" value="上一页" onclick="page('${pageInfo.pageNum == 1?1:pageInfo.prePage}')">
				当前数:${pageInfo.pageNum }|总页数:${pageInfo.lastPage }——总条数:${pageInfo.total }
				<input type="button" value="下一页" onclick="page('${pageInfo.pageNum == pageInfo.lastPage?pageInfo.lastPage:pageInfo.nextPage}')">
				<input type="button" value="尾页" onclick="page('${pageInfo.lastPage}')">
			</td>
		</tr>
	</table>
</body>
</html>