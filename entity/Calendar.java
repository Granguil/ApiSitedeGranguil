package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: Calendar
 *
 */
@Entity
@Table(name="calendar")
public class Calendar implements Serializable {

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
	
	public Calendar() {
		super();
	}
   
}
