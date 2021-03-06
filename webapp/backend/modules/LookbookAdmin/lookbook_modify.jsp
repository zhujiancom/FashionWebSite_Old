<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	String basePath = serverPath + path + "/";
%>
<%@taglib uri="/struts-tags"  prefix="s"%> 
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>backend/">

		<title>lookbook modify page</title>

		<link href="<%=basePath %>comm_style/base.css" rel="stylesheet" type="text/css" />
	    <link href="<%=basePath %>comm_script/fileuploader/css/custom_uploader.css" rel="stylesheet">
		<link href="<%=basePath %>comm_script/bootstrap/css/bootstrap.css" rel="stylesheet">
    	<link href="<%=basePath %>comm_script/bootstrap/css/bootstrap-formhelpers.css" rel="stylesheet">
    	
	    <script type="text/javascript" 
	    		src="<%=basePath %>comm_script/jquery-1.7.2.min.js">
	    </script>
	    <script src="<%=basePath %>comm_script/bootstrap/js/bootstrap-formhelpers-datepicker.en_US.js"></script>
	    <script src="<%=basePath %>comm_script/bootstrap/js/bootstrap-formhelpers-datepicker.js"></script>
	    <script type="text/javascript" 
	    		src="<%=basePath%>comm_script/jquery-plugin/jquery-ui-1.8.16.custom.min.js">
	    </script>
	    <script type="text/javascript" 
	    		src="<%=basePath %>comm_script/base.js">
	    </script>
	    <script type="text/javascript"
			src="<%=basePath%>comm_script/dialog/lhgdialog.min.js">
		</script>
	    
	    <style type="text/css">
	    	.delete_icon{
	    						width:16px;
	    						height:16px;
                                background-image: url(../comm_images/remove.png) ;
                                margin:0;
                                padding:0;
                                display:none;
                                cursor:pointer;
                                float:right;
                                top:-110px;
                                position:relative;
                        }
                        
               .rowElem{
               	padding-left:10px;
               }
	    </style>
	</head>

	<body>
		<div id="wrapper">
			<form id="fmt" action="lookbook_update.action" method="post" target="main"  enctype="multipart/form-data">
				<input type="hidden" name="lookbook.lookbookid" value="<s:property value='lookbookvo.id'/>" />
				<input type="hidden" name="lookbook.imgs" value="<s:property value='lookbookvo.lookbook.imgs'/>">
				<div class="rowElem">
					<label>
						<h4>Lookbook Name(EN):</h4>
					</label>
					<input type="text" name="lookbook.lookbookEname" value="<s:property value='lookbookvo.lookbook.lookbookEname'/>"  />
				</div>
				<div class="rowElem">
					<label>
						<h4>Lookbook Name(ZH):</h4>
					</label>
					<input type="text" name="lookbook.lookbookCname" value="<s:property value='lookbookvo.lookbook.lookbookCname'/>" />
				</div>
				<div id="uploadbox">
				<div id="title">
		        	<p>Lookbook Images:</p>
		            <hr />
		        </div>
		        <div id="container">
			        <div id="imagecontainer">
			        	<ul>
			                <s:iterator value="lookbookvo.thumbnailUrls" var="thumbnail">
			                	<li class="list_common">
				                	<div class="imgLiquidFill imgLuid pic">
				                    	<img src="<%=basePath %><s:property value='#thumbnail'/>"  width="100" height="100"/>
				                    </div>
				                    <span class="delete_icon"></span>
				                </li>
			                </s:iterator>
			        	</ul>
			        </div>
			        </div>
			        <div id="uploader">
						<input type="file" name="imageFiles" multiple="multiple" />
			        </div>
		     	</div>
				<div class="rowElem">
					<label><h4>Lookbook Date:</h4></label>
						<div class="bfh-datepicker" data-format="y-m-d" data-date="<s:date name='lookbookvo.lookbook.lookbookdate' format='yyyy-MM-dd'/>">
		              <div class="input-prepend bfh-datepicker-toggle" data-toggle="bfh-datepicker">
		                <span class="add-on"><i class="icon-calendar"></i></span>
		                <input type="text" class="input-medium" name="lookbook.lookbookdate" readonly>
		              </div>
		              <div class="bfh-datepicker-calendar">
		                <table class="calendar table table-bordered">
		                  <thead>
		                    <tr class="months-header">
		                      <th class="month" colspan="4">
		                        <a class="previous" href="#"><i class="icon-chevron-left"></i></a>
		                        <span></span>
		                        <a class="next" href="#"><i class="icon-chevron-right"></i></a>
		                      </th>
		                      <th class="year" colspan="3">
		                        <a class="previous" href="#"><i class="icon-chevron-left"></i></a>
		                        <span></span>
		                        <a class="next" href="#"><i class="icon-chevron-right"></i></a>
		                      </th>
		                    </tr>
		                    <tr class="days-header">
		                    </tr>
		                  </thead>
		                  <tbody>
		                  </tbody>
		                </table>
		              </div>
		            </div>
				</div>
				
				<div class="rowElem">
					<div class="ui-widget">
						<label for="brandName">Brand Name(EN): </label>
						<input id="brandName" type="text" name="brand.brandEname" value="<s:property value='lookbookvo.lookbook.brand.brandEname'/>"/>
					</div>
				</div>
				<br />
			<br />
			<div class="rowElem"
				style="float: right; position: relative; right: 20px;">
				<input type="submit" class="big_submitButton_class" value="Submit" />
			</div>
			</form>
		</div>
		<script type="text/javascript">
    		$(function(){
    			$( "#brandName" ).autocomplete({
					source: "brand_fuzzySearch.action"
				});
    			
    			 $(".delete_icon").each(function(){
                     var _this = $(this);
                     _this.click(function(){
                             var src = $(this).siblings("div").children("img").attr("src");
                             $.ajax({
                            	 type:"POST",
                            	 dataType:"json",
                            	 data:{imgSrc:src},
                            	 url:"<%=basePath%>backend/asynDelImg_deleteImg.action",
                            	 success:function(result){
                            		 if(result.type == "true"){
                            			 feedbackInfo(result.msg);
                            			 _this.parents("li").remove();
                            		 }else{
                            			 feedbackInfo(result.msg,"ERROR");
                            		 }
                            	 }
                             });
                     });
             });
             $("#imagecontainer li").each(function(){
                     $(this).mouseover(function(){
                            $("span",this).show();
                     });
                     $(this).mouseout(function(){
                            $("span",this).hide();
                     });
             });
    		});
    	</script>
	</body>
</html>
