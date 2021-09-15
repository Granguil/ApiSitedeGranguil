package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enum
 *
 */
@Entity
@Table(name="enum_list")
public class EnumList implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID code;

	public EnumList() {
		super();
	}
   
}
