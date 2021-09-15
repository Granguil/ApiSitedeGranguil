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

import granguil.data.Enum.CurrentState;
import granguil.data.Enum.ReadState;

/**
 * Entity implementation class for Entity: Universe
 *
 */
@Entity

public class Universe implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	private int numero;
	
	@Type(type="text")
	private String info;
	
	
	@OneToMany(mappedBy="universeAssociated", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Book> books;
	
	@Transient
	private ReadState status=ReadState.NotRead;
	
	@Column(unique = true)
	private String title;
	
	@OneToMany(mappedBy="universe")
	@JsonBackReference
	private List<BookMark> bookMark;
	
	@OneToMany(mappedBy="universe")
	@JsonBackReference
	private List<ReadUser> readUser;
	
	private CurrentState currentState=CurrentState.DRAFT;
	
	public CurrentState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}

	public List<BookMark> getBookMark() {
		return bookMark;
	}

	public void setBookMark(List<BookMark> bookMark) {
		this.bookMark = bookMark;
	}

	public List<ReadUser> getReadUser() {
		return readUser;
	}

	public void setReadUser(List<ReadUser> readUser) {
		this.readUser = readUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Universe() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public ReadState getStatus() {
		return status;
	}

	public void setStatus(ReadState status) {
		this.status = status;
	}

	public Universe(String title,int numero, String info, List<Book> books) {
		super();
		this.title=title;
		this.numero = numero;
		this.info = info;
		this.books = books;
	}
   
}
