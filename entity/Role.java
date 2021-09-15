package granguil.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import granguil.data.Enum.TypeRole;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="role_managed")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Type(type="uuid-char")
	private UUID code=GenerateUUID();
	
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	@Column(unique = true)
	private String name;
	
	@Column(name="type_role")
	private TypeRole typeRole;
	
	public static UUID GenerateUUID() {
		UUID code = UUID.randomUUID();
		return code;
	}
	
	
	public TypeRole getTypeRole() {
		return typeRole;
	}



	public void setTypeRole(TypeRole typeRole) {
		this.typeRole = typeRole;
	}



	public UUID getCode() {
		return code;
	}



	public void setCode(UUID code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Role() {
		super();
	}
   
}
