package granguil.data.utils;

import java.io.Serializable;

public class ResourceKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String language;
	
	private String name;
	
	private String siteName;
	
	private String group;
	
	public ResourceKey() {
		
	}
	
	public ResourceKey(String language, String name,String siteName,String group) {
		this.language=language;
		this.name=name;
		this.siteName=siteName;
		this.group=group;
	}
	
	
	
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSitename() {
		return siteName;
	}

	public void setSitename(String siteName) {
		this.siteName = siteName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
