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
		<div data-options="region:'north'" style="height: 100px; background-color: Aquamarine;padding:10px; background-image: none"></div>
		<div data-options="region:'south',split:true" style="height:50px;padding:10px; background-color: #00FF40"></div>
		<div data-options="region:'east',split:true" title="East" style="width:180px;padding:10px; background-color: #FFFF00">
			<ul class="easyui-tree" data-options="url:'tree_data1.json',animate:true,dnd:true"></ul>
		</div>
		<div data-options="region:'west',split:true" title="West" style="width:100px;padding:10px; background-color: Cornsilk">
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="Title1" style="padding:10px;">
					content1
				</div>
				<div title="Title2" data-options="selected:true" style="padding:10px;">
					content2
				</div>
				<div title="Title3" style="padding:10px">
					content3
				</div>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'" style="background-color: WhiteSmoke">
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
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
</html>