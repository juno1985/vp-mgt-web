$(document).ready(function(){
	
	pc_list();
	
	$(".panel-heading").click(function(e) {
		console.log(e);
		/* 切换折叠指示图标 */
		$(this).find("span").toggleClass("glyphicon-chevron-down");
		$(this).find("span").toggleClass("glyphicon-chevron-up");
	});
});
function pc_list(){
	$('#pcTable').children().remove();
	$.ajax({
		url: "/mgt/computer/list",
		type: "GET",
		dataType: "json",
		success:function(data){
			var content = "<thead><tr><th>商品id</th><th>商品名称</th><th>商品价格</th><th>更新</th><th>删除</th></tr></thead>";
			// v-value, i-index
			data.forEach(function(v,i){
				/*
				 * console.log(v.cid + ' ' + v.tradeMark + ' ' + v.price + ' ' +
				 * v.pic);
				 */
				content += "<tr><td>"+v.id+'</td><td><a id="pc" href="javascript:void(0);" onClick="pcClick(this)" value="'+ v.id +'">'+v.trademark+"</a></td><td>"+v.price+"元</td>"+
							'<td><a href="/mgt/computer/update/'+v.id+'">更新</a></td>'+
							'<td><a href="/mgt/computer/delete/'+v.id+'">删除</a></td>'+
							"</tr>";
			}); 
			$('#pcTable').append("<tbody>"+content+"</tbody>");
		}
	});	
}
function pc_add(obj){
	var page_link = obj.getAttribute("value");
	$.get(page_link, function(data){
		$('#pcTable').children().remove();
		$('#pcTable').html(data);
	});
}