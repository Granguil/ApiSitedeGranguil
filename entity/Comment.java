package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
@Table(name="comment_list")
public class Comment implements Serializable {

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

	public Comment() {
		super();
	}
   
}
