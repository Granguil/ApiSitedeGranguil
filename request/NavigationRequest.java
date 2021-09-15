package granguil.data.request;

import java.util.UUID;

public class NavigationRequest {
	
	public UUID role;
	
	public String site;

	public UUID getRole() {
		return role;
	}

	public void setRole(UUID role) {
		this.role = role;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	
	
	
}
