package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: File
 *
 */
@Entity
@Table(name="file_upload")
public class File implements Serializable {

	@NotSend
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	
	private String location;
	
	@ManyToOne
	@JoinColumn(name="code")
	@JsonBackReference
	@NotSend
	private AssociatedCode code;

	public File() {
		super();
	}

	public File(String name,String location) {
		this.name=name;
		this.location=location;
	}
	
	public File(String name,String location,AssociatedCode code) {
		this(name,location);
		this.code=code;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AssociatedCode getCode() {
		return code;
	}

	public void setCode(AssociatedCode code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
   
	
}
