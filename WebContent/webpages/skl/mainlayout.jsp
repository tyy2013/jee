<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainlayout</title>
<%@include file="/webpages/easyui.jsp"%>
</head>
<body class="easyui-layout">
		<div data-options="region:'north'" style="height: 100px; background-color: Aquamarine;padding:10px;">
			<img src="../../resources/images/sklbanner.gif"/>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;padding:10px; background-color: #00FF40"></div>
		<div data-options="region:'west',split:true" title="West" style="width:180px;padding:10px; background-color: #FFFF00">
<!-- 			<ul class="easyui-tree" data-options="url:'tree_data1.json',animate:true,dnd:true"></ul> -->
<ul class="easyui-tree">
		<li>
			<span>My Documents</span>
			<ul>
				<li data-options="state:'closed'">
					<span>Photos</span>
					<ul>
						<li>
							<a title="t1" href="javascript:void(0)" onclick="add(this)" ><span>Friend</span></a>
						</li>
						<li>
							<span>Wife</span>
						</li>
						<li>
							<span>Company</span>
						</li>
					</ul>
				</li>
				<li>
					<span>Program Files</span>
					<ul>
						<li>Intel</li>
						<li>Java</li>

					</ul>
				</li>

				<li>about.html</li>

			</ul>
		</li>
	</ul>
		</div>
		<div data-options="region:'east',split:true" title="East" style="width:100px;padding:10px; background-color: Cornsilk">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="Title1" style="padding:10px;" data-options="selected:true">
					<a title="t1" href="javascript:void(0)" class="easyui-linkbutton" 
						onclick="add(this)" >t1</a>	
				</div>
				<div title="Title2" style="padding:10px;">
					content2
				</div>
				<div title="Title3" style="padding:10px">
					content3
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'" style="background-color: WhiteSmoke">
			<div id="content" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="About" data-options="href:'basic.jsp'" style="padding:10px"></div>
				<div title="DataGrid" style="padding:5px">
					<table class="easyui-datagrid"
							data-options="url:'datagrid_data1.json',singleSelect:true,fit:true,fitColumns:true">
						<thead>
							<tr>
								<th data-options="field:'itemid'" width="80">Item ID</th>
								<th data-options="field:'productid'" width="100">Product ID</th>
								<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
								<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
								<th data-options="field:'attr1'" width="150">Attribute</th>
								<th data-options="field:'status',align:'center'" width="50">Status</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>

</body>
<script type="text/javascript">
var index = 0;
function add(obj){
var value = obj.title;
	//index++;
	$('#content').tabs('add',{
		title: 'Tab'+value,
		content: '<div style="padding:10px">Content'+value+'</div>',
		closable: true
	});
}
function remove(){
	var tab = $('#content').tabs('getSelected');
	if (tab){
		var index = $('#content').tabs('getTabIndex', tab);
		$('#content').tabs('close', index);
	}
}
$('#content').tabs({
	tools:[{
		iconCls:'icon-add',
		handler:function(){
			add();
		}
	},{
		iconCls:'icon-remove',
		handler:function(){
			remove();
		}
	}]
});

</script>
</html>