package granguil.data.entity;

import java.io.Serializable;
import javax.persistence.*;

import granguil.data.utils.ResourceKey;

/**
 * Entity implementation class for Entity: Resource
 *
 */
@Entity
@IdClass(ResourceKey.class)
@Table(name="resource_language")
public class Resource implements Serializable {

	@Id
	private String language;
	
	@Id
	private String name;
	
	@Id
	private String siteName="General";
	
	@Id
	private String group="none";
	
	private String value;
	
	private static final long serialVersionUID = 1L;
	
	public Resource(String lang, String name, String sitename,String value,String group) {
		this.language=lang;
		this.name=name;
		this.value=value;
		this.siteName=sitename;
		this.group=group;
	}
	
	
	
	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public String getSiteName() {
		return siteName;
	}



	public void setSiteName(String siteName) {
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



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public Resource() {
		super();
	}
   
}
