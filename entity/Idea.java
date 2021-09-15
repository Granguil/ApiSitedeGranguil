package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: Idea
 *
 */
@Entity
@Table(name="idea")
public class Idea implements Serializable {

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
	
	private String nom;
	
	
	
	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public Code getCode() {
		return code;
	}



	public void setCode(Code code) {
		this.code = code;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Idea() {
		super();
	}
   
}
