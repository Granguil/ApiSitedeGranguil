package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: KeyWord
 *
 */
@Entity
@Table(name="key_word")
public class KeyWord implements Serializable {

	@NotSend
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="code")
	@JsonBackReference
	@NotSend
	private AssociatedCode code;
	
	@Column(name="key_word")
	private String keyWord;
	
	public KeyWord() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public AssociatedCode getCode() {
		return code;
	}

	public void setCode(AssociatedCode code) {
		this.code = code;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
   
}
