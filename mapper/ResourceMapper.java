package granguil.data.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import granguil.data.entity.Resource;

public class ResourceMapper {

	public static Map<String,Object> list=new HashMap<String,Object>();
	public static Map<String,Map<String,String>> mapObject=new HashMap<String,Map<String,String>>();
	
	public static Map<String,Object> resourcesToMap(List<Resource> listRes){
		
		for(Resource res:listRes) {
			if(res.getGroup().equals("none")) {
			list.put(res.getName(), res.getValue());
			}else {
				if(!mapObject.containsKey(res.getGroup())) {
					Map<String,String> newMap=new HashMap<String,String>();
					newMap.put(res.getName(), res.getValue());
					mapObject.put(res.getGroup(), newMap);
				}else {
					mapObject.get(res.getGroup()).put(res.getName(), res.getValue());
				}
			}
		}
		return list;
	}
	
	public static Map<String,Object> associate(List<Resource> resources,List<Resource> resourcesByDefault,boolean languageByDefault){
		list.clear();
		mapObject.clear();
		List<Resource> generalDefault=resourcesByDefault.stream().filter(x->x.getSiteName()=="General").collect(Collectors.toList());
		
		list.putAll(resourcesToMap(generalDefault));
		List<Resource> specificDefault=resourcesByDefault.stream().filter(x->x.getSiteName()!="General").collect(Collectors.toList());
		list.putAll(resourcesToMap(specificDefault));
		
		if(!languageByDefault) {
			
			List<Resource> general=resources.stream().filter(x->x.getSiteName()=="General" ).collect(Collectors.toList());
			list.putAll(resourcesToMap(general));
			
			List<Resource> specific=resources.stream().filter(x->x.getSiteName()!="General").collect(Collectors.toList());
			list.putAll(resourcesToMap(specific));
		}
		list.putAll(mapObject);
		return list;
	}
}
 