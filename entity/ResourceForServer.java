package granguil.data.entity;

import java.io.Serializable;
import javax.persistence.*;

import granguil.data.utils.ResourceServerKey;

/**
 * Entity implementation class for Entity: ResourceForServer
 *
 */
@Entity
@Table(name="resources_server")
@IdClass(ResourceServerKey.class)
public class ResourceForServer implements Serializable {

	
	@Id
	private String language;
	
	@Id
	private String name;
	
	private String value;
	
	private static final long serialVersionUID = 1L;
	
	public ResourceForServer(String lang, String name, String value) {
		this.language=lang;
		this.name=name;
		this.value=value;
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



	public ResourceForServer() {
		super();
	}
   
}
