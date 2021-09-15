package granguil.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.entity.Module.ModuleStatus;

/**
 * Entity implementation class for Entity: Version
 *
 */
@Entity
@Table(name="version_module")
public class Version implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="module")
	@JsonBackReference
	private Module module;
	
	private String version_level;
	
	private String tag;
	
	private int numero;
	
	@Type(type="text")
	private String description;
	
	private ModuleStatus status;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Version version_parent;
	
	@OneToMany(mappedBy="version_parent",cascade = CascadeType.ALL)
	private List<Version> versions;
	
	public Version(int num,String version,String tag,String description,List<Version> versions,ModuleStatus status) {
		this.numero=num;
		this.description=description;
		this.tag=tag;
		this.version_level=version;
		this.versions=versions;
		this.status=status;
	}
	
	public Version() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion_level() {
		return version_level;
	}

	public void setVersion_level(String version_level) {
		this.version_level = version_level;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Version getVersion_parent() {
		return version_parent;
	}

	public void setVersion_parent(Version version_parent) {
		this.version_parent = version_parent;
	}

	public List<Version> getVersions() {
		return versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public ModuleStatus getStatus() {
		return status;
	}

	public void setStatus(ModuleStatus status) {
		this.status = status;
	}
   
	
}
