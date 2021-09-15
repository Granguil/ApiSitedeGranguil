package granguil.data.mapper;

import java.util.ArrayList;
import java.util.List;

import granguil.data.entity.Navigation;
import granguil.data.request.NavigationSaveRequest;
import granguil.data.response.NavigationResponse;

public class NavigationMapper {

	public static List<NavigationResponse> getNavigationList(List<Navigation> navigations){
		List<NavigationResponse> list=new ArrayList<NavigationResponse>();
		for(Navigation nav:navigations) {
			list.add(new NavigationResponse(nav.getGroup(),nav.getName(),nav.getAddress()));
		}
		return list;
	}
	
	public static Navigation saveNavigation(NavigationSaveRequest navigation) {
		Navigation nav=new Navigation();
		nav.setAddress(navigation.getAddress());
		nav.setGroup(navigation.getGroup());
		nav.setName(navigation.getName());
		nav.setRole(navigation.getRole());
		nav .setSite(navigation.getSite());
		return nav;
	}
}
