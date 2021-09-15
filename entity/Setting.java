package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Setting
 *
 */
@Entity
@Table(name="setting")
public class Setting implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID code;

	public Setting() {
		super();
	}
   
}
