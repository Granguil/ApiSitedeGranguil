package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Display
 *
 */
@Entity
@Table(name="display")
public class Display implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID code;
	
	public Display() {
		super();
	}
   
}
