package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 * Entity implementation class for Entity: Navigation
 *
 */
@Entity
@Table(name="navigation")
public class Navigation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String group;
	
	private String name;
	
	private String address;
	
	@Type(type="uuid-char")
	private UUID role;
	
	private String site;
	
	public Navigation(String group,String name,String address, UUID role, String site) {
		this.group=group;
		this.name=name;
		this.address=address;
		this.role=role;
		this.site=site;
	}
	
	
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



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getGroup() {
		return group;
	}



	public void setGroup(String group) {
		this.group = group;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Navigation() {
		super();
	}
   
}
