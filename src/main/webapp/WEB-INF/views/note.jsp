<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>aboz</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-theme.min.css">
		<script src="<%=request.getContextPath() %>/js/jquery-1.11.0.min.js"></script>
		<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/dust-full.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/js/dust-helpers.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/tpl/tpl.dust.js"></script>
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
		<style type="text/css">
			.jumbotron {margin-bottom: 10px; padding: 10px; }
		</style>
		<script type="text/javascript">
			$(function(){
				dust.render("tpl1.dust", {title:"aboz",content:"stand by, there is it."}, function(err, out) {
					$('#gadget1').html(out);
				});
				dust.render("tpl2.dust", {image:"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk91QZdIrSHp5ubIcn9HHeDLnnU8ckbxarse2TcVamwgIgnWwtW6AFmJg/0",description:"Spring"}, function(err, out) {
					$('#gadget2').html(out);
				});
				dust.render("tpl3.dust", {image:"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9GSRKhBicYj8Ds3xOwUmnT2BiapbQiadKoTQn1JFVQy4aJfGic00r6cibibmQ/0",description:"Summer",comment:"Really?"}, function(err, out) {
					$('#gadget3').html(out);
				});
				dust.render("tpl2.dust", {image:"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9BVRIxfpXB7tibJUxL63ibHre2hgia6TqEn5kR62cPOroQHsnZfZb6JSYg/0",description:"Autumn"}, function(err, out) {
					$('#gadget4').html(out);
				});
				dust.render("tpl3.dust", {image:"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9ic2ILzmSOWX3jqDEPLgQNnhJ7ibD3yNCLl0FBDOdfq3ymzX6PxIvjEfg/0",description:"Winter",comment:"Absolutely!"}, function(err, out) {
					$('#gadget5').html(out);
				});
			});
		</script>
	</head>
	<body>
		<div class="well well-sm">
			<div id="gadget1" class="panel panel-default"></div>
			<div id="gadget2" class="panel panel-default"></div>
			<div id="gadget3" class="panel panel-default"></div>
			<div id="gadget4" class="panel panel-default"></div>
			<div id="gadget5" class="panel panel-default"></div>
		</div>
	</body>
</html>