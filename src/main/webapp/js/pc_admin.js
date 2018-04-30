$(document).ready(function(){
	//start from page 1, rows - 5
	pc_list(1,5);
	$(".panel-heading").click(function(e) {
		console.log(e);
		/* 切换折叠指示图标 */
		$(this).find("span").toggleClass("glyphicon-chevron-down");
		$(this).find("span").toggleClass("glyphicon-chevron-up");
	});
	$('#mgt_content').on('click','.pcFormSubmit',pc_add_submit);
	
	$('#mgt_content').on('click','.pcUpdateSubmit',pc_update_submit);
});
function pc_list(pageNum,rows){
	$('#mgt_content').children().remove();
	
	$.ajax({
		url: "/mgt/admin/pc/list",
		type: "GET",
		data: {"pageNum":pageNum, "rows":rows},
		dataType: "json",
		success:function(obj){
			var data = obj.data;
			var totalPage;
			var totalRows = obj.totalRows;
			//总共分几页
		    if(totalRows/rows > parseInt(totalRows/rows)){
		        totalPage=parseInt(totalRows/rows)+1;
		    }else{
		        totalPage=parseInt(totalRows/rows);
		    }
			var content = "<table id="+'"pcTable"'+" class="+'"table table-condensed"'+"><tbody>";
			content += "<thead><tr><th>商品id</th><th>商品名称</th><th>商品价格</th><th>更新</th><th>删除</th></tr></thead>";
			// v-value, i-index
			data.forEach(function(v,i){
				/*
				 * console.log(v.cid + ' ' + v.tradeMark + ' ' + v.price + ' ' +
				 * v.pic);
				 */
				content += "<tr><td>"+v.id+'</td><td><a id="pc" href="javascript:void(0);" onClick="pcClick(this)" value="'+ v.id +'">'+v.trademark+"</a></td><td>"+v.price+"元</td>"+
							'<td><a href="javascript:void(0);" onClick="pcUpldate(this)" value="'+v.id+'">更新</a></td>'+
							'<td><a href="/mgt/admin/pc/delete/'+v.id+'">删除</a></td>'+
							"</tr>";
			}); 
			content += "</table></tbody>";
			var pagerHtml = goPage(pageNum, rows, totalPage)
			content += pagerHtml;
			$('#mgt_content').append(content);
		}
	});	
}
function pc_add(obj){
	var page_link = obj.getAttribute("value");
	$.get(page_link, function(data){
		$('#mgt_content').children().remove();
		$('#mgt_content').html(data);
	});
}
function pc_add_submit(){
	if(!pc_form_validate($('#pcForm'))){
		return false;
	}
	var pc_form_fields = $('#pcForm').serializeArray();
	$('#pcForm').ajaxSubmit({
		url:"/mgt/admin/pc/add",
		type:'post',
		complete:function(data){
			if(data.status == 200)
				alert("添加电脑成功!");
			else if(data.status == 400)
				alert("请填入完整信息!");
		}
	});
}
function pcUpldate(obj){
	//get id
	var id = obj.getAttribute("value");
	var page_link = "/mgt/page/pc_update.html";
	$.get(page_link, function(data){
		$('#mgt_content').children().remove();
		$('#mgt_content').html(data);
		
	});
	//先查出来,然后显示到更新页面
	$.ajax({
		url: "/mgt/admin/pc/query/" + id,
		type: "GET",
		dataType: "json",
		success: function(data){
			console.log(data.id + ' ' + data.trademark + ' ' + data.pic);
			$("#mgt_content .cid").val(data.id);
			$("#mgt_content .tradeMark").val(data.trademark);
			$("#mgt_content .price").val(data.price);
		}
	});
}
function pc_update_submit(){
	$('#pcUpdateForm').ajaxSubmit({
		url:"/mgt/admin/pc/update",
		type:'post',
		complete:function(data){
			if(data.status == 200)
				alert("添加电脑成功!");
			else if(data.status == 400)
				alert("请填入完整信息!");
		}
	});
}
function goPage(pageNum, rows, totalPage){
	var tempStr = "<span>共"+totalPage+"页</span>";
	  if(pageNum>1){
	        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"pc_list("+(1)+","+rows+")\">首页</span>";
	        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"pc_list("+(pageNum-1)+","+rows+")\">上一页</span>"
	    }else{
	        tempStr += "<span class='btn btn-default'>首页</span>";
	        tempStr += "<span class='btn btn-default'>上一页</span>";
	    }
	  for(var pageIndex= 1;pageIndex<totalPage+1;pageIndex++){
	        tempStr += "<a onclick=\"pc_list("+pageIndex+","+rows+")\"><span class=\"btn btn-default\">"+ pageIndex +"</span></a>";
	    }
	  if(pageNum<totalPage){
	        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"pc_list("+(pageNum+1)+","+rows+")\">下一页</span>";
	        tempStr += "<span class='btn btn-default' href=\"#\" onClick=\"pc_list("+(totalPage)+","+rows+")\">尾页</span>";
	    }else{
	        tempStr += "<span class='btn btn-default'>下一页</span>";
	        tempStr += "<span class='btn btn-default'>尾页</span>";
	    }
	 return tempStr;
}
function pc_form_validate(obj){
	var result=true;
	var arrayInput = $(obj).find(":text");
	arrayInput.each(function(index, element){
		var in_value = $(element).val();
		if(in_value==""||in_value.length==0||in_value==null){
			$(element).css('border','1px solid red');
			//注意JS里return会停止本次循环并不会跳出函数
			result = false;
			return false;
		}
	});
	return result;
}
