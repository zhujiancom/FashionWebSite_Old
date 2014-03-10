<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>frontend/">
    
    <title>resetpasswrod</title>
    <link href="<%=basePath %>comm_script/bootstrap/css/bootstrap_custom_1.css" rel="stylesheet">
    <script src="<%=basePath %>comm_script/jquery-1.9.1.min.js" type="application/javascript"></script>
	<style type="text/css">
   		body {TEXT-ALIGN: center;}
    	#resetbox{
    		MARGIN-RIGHT: auto; MARGIN-LEFT: auto;
    		width:460px;
    		margin-top:20px;
    		padding:10px;
    	}
    	ol li{
    		list-style: none;
    	}
    </style>
  </head>
  
  <body>
  	<jsp:include page="header.jsp"></jsp:include>
  	<div id="resetbox">
  		<form action="../resetPassword" method="post" name="resetPswdForm">
  			<input type="hidden" name="referer" value="<%=request.getParameter("referer")%>"/>
  			<h1 style="font-size:18px;">Reset your Password</h1>
			<fieldset style="border:0;">
				<ol>
					<li>
						<label for="name">Account Name</label>
						<input id="name" name="account.accountname" placeholder="Name" required="true" type="text">
					</li>
					<li>
						<label for="newPasswd">New Password</label>
						<input id="newPasswd" name="account.pswd" placeholder="Password" title="six characters at least" pattern="\w{6,}" required="true" type="password">
					</li>
					<li>
						<label for="confirmpswd">Confirm Password</label>
						<input id="confirmpswd" name="confirmpswd" placeholder="Password" title="six characters at least" pattern="\w{6,}" required="true" type="password">
					</li>
					<li>
						<input type="submit" class="btn btn-small" value="<s:text name='submit'/>"/>
						<input type="reset" class="btn btn-small" value="<s:text name='reset'/>"/>
					</li>
				</ol>
			</fieldset>
  		</form>
  	</div>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="<%=basePath %>comm_script/base.js" type="application/javascript"></script>
    <script type="text/javascript">
    	$(function(){
    		var projectName = getProjectName();
    		$("#confirmpswd").blur(function(){
				var confirmvalue = $("#confirmpswd").val();
				var newvalue = $("#newPasswd").val();
				var _this = $(this);
				if(confirmvalue != "" && confirmvalue != newvalue && $(_this).next("span").length == 0){
					$(_this).after("<span style='color:red'><img src=/"+projectName+"/comm_images/error.png width=16px height=16px />&nbsp;&nbsp;password is not consistent!</span>");
					$("form[name=resetPswdForm]").submit(function(){return false;});
				}
				if(confirmvalue == newvalue && $(_this).next("span").length > 0){
					$(_this).next("span").remove();
				}
			});
    	});
    </script>
  </body>
</html>
