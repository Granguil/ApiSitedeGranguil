package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: Document
 *
 */
@Entity
@Table(name="document")
public class Document implements Serializable {

	
	@NotSend
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="code")
	@JsonBackReference
	@NotSend
	private AssociatedCode code;

	public Document() {
		super();
	}
   
}
