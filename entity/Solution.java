package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import granguil.data.annotation.NotSend;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Solution
 *
 */
@Entity
@Table(name="solution")
public class Solution implements Serializable {

	@NotSend
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="code")
	@JsonBackReference
	@NotSend
	private Code code;
	
	public Solution() {
		super();
	}
   
}
