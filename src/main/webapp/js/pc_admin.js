$(document).ready(function(){
	pc_list();
	$(".panel-heading").click(function(e) {
		console.log(e);
		/* 切换折叠指示图标 */
		$(this).find("span").toggleClass("glyphicon-chevron-down");
		$(this).find("span").toggleClass("glyphicon-chevron-up");
	});
	$('#mgt_content').on('click','.pcFormSubmit',pc_add_submit);
	
	$('#mgt_content').on('click','.pcUpdateSubmit',pc_update_submit);
});
function pc_list(){
	$('#mgt_content').children().remove();
	$.ajax({
		url: "/mgt/admin/pc/list",
		type: "GET",
		dataType: "json",
		success:function(data){
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
