package granguil.data.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Secret
 *
 */
@Entity
@Table(name="secret")
public class Secret implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String question;
	
	private String response;
	
	private static final long serialVersionUID = 1L;

	public Secret(String question,String response) {
		this.question=question;
		this.response=response;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}



	public void setQuestion(String question) {
		this.question = question;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	public Secret() {
		super();
	}
   
}
