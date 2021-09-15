package granguil.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import granguil.data.annotation.NotSend;

/**
 * Entity implementation class for Entity: AssociatedCode
 *
 */
@Entity
@Table(name="Association_Element")
@JsonInclude(Include.NON_NULL)
public class AssociatedCode implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	@OneToOne
	@JoinColumn(name="code")
	@JsonBackReference
	@NotSend
	private Code code;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Discuss discuss;
	
	@OneToOne(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	private WorkFlow workFlow;
	
	@OneToMany(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Document> documents;
	
	@OneToMany(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Comment> comments;
	
	@OneToMany(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<File> files;
	
	@OneToMany(mappedBy="code", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<KeyWord> keyWords;
	
	
	
	public List<KeyWord> getKeyWords() {
		return keyWords;
	}



	public void setKeyWords(List<KeyWord> keyWords) {
		this.keyWords = keyWords;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public WorkFlow getWorkFlow() {
		return workFlow;
	}



	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}



	public List<Document> getDocuments() {
		return documents;
	}



	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<File> getFiles() {
		return files;
	}



	public void setFiles(List<File> files) {
		this.files = files;
	}



	public Code getCode() {
		return code;
	}



	public void setCode(Code code) {
		this.code = code;
	}



	public Discuss getDiscuss() {
		return discuss;
	}



	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}



	public AssociatedCode() {
		super();
	}
   
}
