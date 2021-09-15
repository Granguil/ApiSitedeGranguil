package granguil.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: ModuleType
 *
 */
@Entity
@Table(name="module_type")
public class ModuleType implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="uuid-char")
	@GeneratedValue
	private UUID code;	
	
	@Transient
	private String type="Type";
	
	@Column(unique = true)
	private String name;
	
	@Type(type="text")
	private String description;
	
	@OneToMany(mappedBy="type",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Module> module;
	
	public ModuleType(String name,String description,List<Module> modules) {
		this.name=name;
		this.description=description;
		this.module=modules;
	}
	
	public ModuleType() {
		super();
	}

	public UUID getCode() {
		return code;
	}

	public void setCode(UUID code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}
   
	
}
