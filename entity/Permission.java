package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Permission
 *
 */
@Entity
@Table(name="permission")
public class Permission implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID code;
	
	public Permission() {
		super();
	}
   
}
