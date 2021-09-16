package granguil.data.utils;

import java.io.Serializable;

public class ResourceServerKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String language;
	
	private String name;
	
	public ResourceServerKey() {
		
	}
	
	public ResourceServerKey(String language, String name) {
		this.language=language;
		this.name=name;
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
