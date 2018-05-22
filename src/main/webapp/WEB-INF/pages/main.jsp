<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/springprictise/static/layui/css/layui.css">

<script src="/springprictise/static/layui/layui.js"></script>
<script src="/springprictise/static/jquery/jquery-3.3.1.js"></script>
</head>
<body>
	<h1>Welcofdsfdsme!</h1><br/>
	<!-- 
	<button type="button" class="layui-btn" id="test1">
		<i class="layui-icon">&#xe67c;</i>上传图片
	</button> -->
	<form id="userform" action="/springprictise/addUser" method="post">
		名称：<input type="text" name="userName"/><br/><br/>
		年龄：<input type="text" name="age"/><br/><br/>
		<input type="button" value="提交" id="submitBtn"/>
	</form>

	<script type="text/javascript">
		layui.use('upload', function() {
			var upload = layui.upload;
			//执行实例
			uploadInst = upload.render({
				elem : '#submitBtn' //绑定元素
				,
				url : '/springprictise/upload' //上传接口
				,
				accept:'file',
				method:'post',
				field:'userFile',
				done : function(res) {
					if(res.code==0){
						var formdata=$('#userform').serialize();
						if(formdata.indexOf('userId')==-1){
							formdata+='&userId='+res.id;
						}
						console.log(res.id);
						console.log(formdata);
						$.ajax({
							type:'post',
							data:formdata,
							url:'/springprictise/addUser',
							success:function(text){
								alert(text);
							}
						});
						//$('#userId').val(res.id);
						//$('#userform')[0].submit();
					}
				},
				error : function() {
					//alert('erro!');
				}
			});
		});
		$('#submitBtn').click(function(){
			//uploadInst.upload();
			
			return false;
		});
	</script>
</body>
</html>