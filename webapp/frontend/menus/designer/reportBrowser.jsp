<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
String basePath = serverPath + path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>frontend/">
	<link href="<%=basePath %>frontend/css/press.css" rel="stylesheet" />
	<link href="<%=basePath %>frontend/javascript/jquery-plugin/jpages/jPages.css" rel="stylesheet"/>
	<script src="<%=basePath %>comm_script/jquery-1.7.2.min.js" type="application/javascript"></script>
	<script src="<%=basePath %>frontend/javascript/jquery-plugin/imgLiquid/imgLiquid.js" type="application/javascript"></script>
	<script src="<%=basePath %>frontend/javascript/jquery-plugin/jpages/jPages.js" type="application/javascript"></script>
  </head>
  
  <body  oncontextmenu="return false" onselectstart="return false">
  	<div id="main">
  		 <div id="contents">
            <div class="ulwrapper" class="defaults">
			    <ul id="itemContainer">
			    	<s:iterator value="reportvolist" var="reportvo">
	                	<li>
	                		<div class="item">
	                			<s:if test="#reportvo.thumbnail != null">
	                				<div class="imgLiquidFill imgLuid pic">
					                	<img src="<%=basePath %><s:property value='#reportvo.thumbnail'/>" alt="<s:property value='#reportvo.thumbnail'/>"/>
					                </div>
	                			</s:if>
				            	<div class="preview">
				                	<p class="pretitle"><a href="<%=basePath %>designer/report/<s:property value='#reportvo.id'/>.html"><s:property value='#reportvo.title'/></a></p>
				                	<p class="precontent">
				                		<s:set name="preview" value="#reportvo.preview"/>
				                		<s:if test="%{#preview.length()>180}">
				                			<s:property value="#preview.substring(0,180)+'...'"/>
				                		</s:if>
				                		<s:else>
				                			<s:property value="#preview"/>
				                		</s:else>
				                	</p>
				                </div>
				            </div>
	                	</li>
	                </s:iterator>
               </ul>      
		      <!-- navigation holder -->
     			<div class="holder"></div>
			</div>
	    </div>
  	</div>
  	<script type="application/javascript">
		$(document).ready(function(){
			$(".imgLiquidFill").imgLiquid({
				fill:true,
				horizontalAlign:"center",
				verticalAlign:"top"  
					  
			});

			/* initiate plugin */
    		$("div.holder").jPages({
      			containerID : "itemContainer",
				perPage:8
    		});

    		/* when button is clicked */
    		$("button").click(function(){
     			 /* get given page */
     			 var page = parseInt( $("input").val() );

	     		 /* jump to that page */
	     		 $("div.holder").jPages( page );

   	 		});
		});
	</script>
  </body>
</html>
