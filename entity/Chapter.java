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
 * Entity implementation class for Entity: Chapter
 *
 */
@Entity
@Table(name="Chapter_Book")
public class Chapter implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	private int numero;
	
	@Type(type="text")
	private String info;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	@JsonBackReference
	private Book bookAssociated;
	
	@OneToMany(mappedBy="chapterAssociated", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Scene> scenes;
	
	@Transient
	private ReadState status=ReadState.NotRead;
	
	private String title;
	
	@OneToMany(mappedBy="chapter")
	@JsonBackReference
	private List<ReadUser> readUser;
	
	@OneToMany(mappedBy="chapter")
	@JsonBackReference
	private List<BookMark> bookMark;
	
	private CurrentState currentState=CurrentState.DRAFT;
	
	public CurrentState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}

	public Book getBookAssociated() {
		return bookAssociated;
	}

	public void setBookAssociated(Book bookAssociated) {
		this.bookAssociated = bookAssociated;
	}

	public List<ReadUser> getReadUser() {
		return readUser;
	}

	public void setReadUser(List<ReadUser> readUser) {
		this.readUser = readUser;
	}

	public List<BookMark> getBookMark() {
		return bookMark;
	}

	public void setBookMark(List<BookMark> bookMark) {
		this.bookMark = bookMark;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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


	public Book getBook_associated() {
		return bookAssociated;
	}


	public void setBook_associated(Book book_associated) {
		this.bookAssociated = book_associated;
	}


	public List<Scene> getScenes() {
		return scenes;
	}


	public void setScenes(List<Scene> scenes) {
		this.scenes = scenes;
	}


	public ReadState getStatus() {
		return status;
	}


	public void setStatus(ReadState status) {
		this.status = status;
	}


	public Chapter(String title,int numero, String info, Book book_associated, List<Scene> scenes) {
		super();
		this.title=title;
		this.numero = numero;
		this.info = info;
		this.bookAssociated = book_associated;
		this.scenes = scenes;
	}


	public Chapter() {
		super();
	}
   
}
