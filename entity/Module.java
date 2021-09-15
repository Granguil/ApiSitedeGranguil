package granguil.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Module
 *
 */
@Entity
@Table(name="module_list")
public class Module implements Serializable {
public enum ModuleStatus{
	ACTIVE(1),
	ARCHIVED(0),
	USED(2);
	private final int value;
	private ModuleStatus(int value) {
		this.value=value;
	}
	public int getValue() {
		return this.value;
	}
}

	
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="uuid-char")
	@GeneratedValue
	private UUID id;
	
	@Transient
	private String type_mod="Module";
	
	@Column(unique = true)
	private String name;
	
	@Type(type="text")
	private String description;

	private ModuleStatus status;
	
	@OneToMany(mappedBy="module",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Version> versions=new ArrayList<Version>();
	
	@ManyToOne
	@JoinColumn(name="module_type")
	@JsonBackReference
	private ModuleType type;
	
	public Module() {
		super();
	}

	public Module(String description,String name,List<Version> versions,ModuleStatus status) {
	this.name=name;
	this.description=description;
	this.versions=versions;
	this.status=status;
	}
	
	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}

	public String getType_mod() {
		return type_mod;
	}

	public void setType_mod(String type_mod) {
		this.type_mod = type_mod;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Version> getVersions() {
		return versions;
	}



	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public ModuleType getType() {
		return type;
	}

	public void setType(ModuleType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModuleStatus getStatus() {
		return status;
	}

	public void setStatus(ModuleStatus status) {
		this.status = status;
	}
   
	
}
