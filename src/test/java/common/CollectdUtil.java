package common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import util.JSONHelper;

public class CollectdUtil {
	
	//test param
	private String[] vmnames={"tangvm","test"};
	private String[] servernames={"localhost","data"};
	
	//result
	private List tabRecipes = new ArrayList();
	private Map chartRecipes = new HashMap();
	
	public String createRecipeJson(String[] vmnames, String[] servernames){
		for(String vmname : vmnames){
			String vmcpukey = vmname+"vcpu";
			String vmnetkey = null;//vmname+"vnet";
			ArrayList tabKeyList = new ArrayList();
			if(vmcpukey!=null){
				tabKeyList.add(vmcpukey);
				chartRecipes.put(vmcpukey, createChartRecipe(vmname,ChartRecipeType.vmcpu));
			}
			if(vmnetkey!=null){
				tabKeyList.add(vmnetkey);
				chartRecipes.put(vmnetkey, createChartRecipe(vmname,ChartRecipeType.vmnet));
			}
			ArrayList tab = new ArrayList();;
			tab.add(vmname);
			tab.add(tabKeyList);
			tabRecipes.add(tab);	
		}
		for(String servername : servernames){

			ArrayList tabKeyList = new ArrayList();
			String cpukey = servername+"cpu";
			if(cpukey!=null){
				tabKeyList.add(cpukey);
				chartRecipes.put(cpukey, createChartRecipe(servername,ChartRecipeType.cpu));
			}
			String memkey = servername+"memory";
			if(memkey!=null){
				tabKeyList.add(memkey);
				chartRecipes.put(memkey, createChartRecipe(servername,ChartRecipeType.memory));
			}
			String loadkey = servername+"load";
			if(loadkey!=null){
				tabKeyList.add(loadkey);
				chartRecipes.put(loadkey, createChartRecipe(servername,ChartRecipeType.load));
			}
			String netkey = servername+"net";
			if(netkey!=null){
				tabKeyList.add(netkey);
				chartRecipes.put(netkey, createChartRecipe(servername,ChartRecipeType.net));
			}
			
			ArrayList tab = new ArrayList();;
			tab.add(servername);
			tab.add(tabKeyList);
			tabRecipes.add(tab);
			
				
		}
		JSONObject result = new JSONObject();
		result.put("TAB_RECIPES_STANDARD", JSONHelper.collection2json(tabRecipes));
		result.put("CHART_RECIPES_COLLECTD", JSONHelper.map2json(chartRecipes));
		return result.toString();
	}
	
	@Test
	public void testCreateJSON() {
		// TODO Auto-generated method stub
		String a = this.createRecipeJson(vmnames, servernames);
		System.out.println(a);
	}
	
	public ChartRecipe createChartRecipe(String path, ChartRecipeType type){
		ChartRecipe chart = new ChartRecipe();
		chart.setTitle(path+"_"+type.toString());
		ArrayList data = new ArrayList();
		//create vm net data 需要知道虚拟机对应的虚拟网卡
		if(type==ChartRecipeType.vmnet){
			data.add("['"+path+"/libvirt/if_octets-vnet0.rrd', 'tx', 'veth0 Transmit', 'B']");
			data.add("['"+path+"/libvirt/if_octets-vnet0.rrd', 'rx', 'veth0 Receive', 'B']");
		}
		//create vm cpu data 需要知道虚拟机分配的虚拟CPU数量
		if(type==ChartRecipeType.vmcpu){
			data.add("['"+path+"/libvirt/virt_vcpu-0.rrd', 0, 'CPU-0', '']");
			data.add("['"+path+"/libvirt/virt_cpu_total.rrd', 0, 'CPU-TOTAL', '']");
		}
		if(type==ChartRecipeType.cpu){
			data.add("['"+path+"/cpu-0/cpu-wait.rrd', 0, 'CPU-0 Wait', '%']");
			data.add("['"+path+"/cpu-0/cpu-system.rrd', 0, 'CPU-0 System', '%']");
			data.add("['"+path+"/cpu-0/cpu-user.rrd', 0, 'CPU-0 User', '%']");
			//根据cpu数量增加
			data.add("['"+path+"/cpu-1/cpu-wait.rrd', 0, 'CPU-1 Wait', '%']");
			data.add("['"+path+"/cpu-1/cpu-system.rrd', 0, 'CPU-1 System', '%']");
			data.add("['"+path+"/cpu-1/cpu-user.rrd', 0, 'CPU-1 User', '%']");
		}
		if(type==ChartRecipeType.memory){
			data.add("['"+path+"/memory/memory-buffered.rrd', 0, 'Buffered', 'B']");
			data.add("['"+path+"/memory/memory-used.rrd', 0, 'Used', 'B']");
			data.add("['"+path+"/memory/memory-cached.rrd', 0, 'Cached', 'B']");
			data.add("['"+path+"/memory/memory-free.rrd', 0, 'Free', 'B']");
		}
		if(type==ChartRecipeType.load){
			data.add("['"+path+"/load/load.rrd', 'shortterm', 'Short Term', '']");
			data.add("['"+path+"/load/load.rrd', 'midterm', 'Medium Term', '']");
			data.add("['"+path+"/load/load.rrd', 'longterm', 'Long Term', '']");
		}
		if(type==ChartRecipeType.net){
			data.add("['"+path+"/interface/if_octets-eth0.rrd', 'tx', 'eth0 Transmit', 'bit/s', function (v) { return v*8; }]");
			data.add("['"+path+"/interface/if_octets-eth0.rrd', 'rx', 'eth0 Receive', 'bit/s', function (v) { return v*8; }]");
		}	
		chart.setData(data);
		return chart;
	}
	

//	//Map转换成json， 是用jsonObject
//	@Ignore
//	public void testMapToJSON(){
//	    Map map = new HashMap();  
//	    map.put( "name", "json" );  
//	    map.put( "bool", Boolean.TRUE );  
//	    map.put( "int", new Integer(1) );  
//	    map.put( "arr", new String[]{"a","b"} );  
//	    map.put( "func", "function(i){ return this.arr[i]; }" );  
//	      
//	    JSONObject jsonObject = JSONObject.fromObject( map );  
//	    System.out.println( jsonObject );  
//	}
//	
//	 //Collection对象转换成JSON
//	@Ignore
//    public void testListToJSON(){
//        List list = new ArrayList();  
//        list.add( "first" );  
//        list.add( "second" );  
//        JSONArray jsonArray = JSONArray.fromObject( list );  
//        System.out.println( jsonArray );  
//        // prints ["first","second"]  
//    }
        
	public class ChartRecipe{
		private String title;
		private List data;
		private String options;

		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

		public List getData() {
			return data;
		}
		public void setData(List data) {
			this.data = data;
		}
		public String getOptions() {
			return options;
		}
		public void setOptions(String options) {
			this.options = options;
		}
		
	}
	public enum ChartRecipeType {
		vmcpu,
		vmnet,		
		cpu,
		memory,
		load,
		net
	}
}


