package granguil.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
 * Entity implementation class for Entity: Book
 *
 */
@Entity

public class Book implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	private int numero;
	
	@Type(type="text")
	private String info;
	
	@ManyToOne
	@JoinColumn(name="universe_id")
	@JsonBackReference
	private Universe universeAssociated;
	
	@OneToMany(mappedBy="bookAssociated", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Chapter> chapters=new ArrayList<Chapter>();
	
	@Transient
	private ReadState status=ReadState.NotRead;
	
	private String title;
	
	@OneToMany(mappedBy="book")
	@JsonBackReference
	private List<BookMark> bookMark;
	
	@OneToMany(mappedBy="book")
	@JsonBackReference
	private List<ReadUser> readUser;
	
	private CurrentState currentState=CurrentState.DRAFT;
	
	public CurrentState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}

	public Universe getUniverseAssociated() {
		return universeAssociated;
	}

	public void setUniverseAssociated(Universe universeAssociated) {
		this.universeAssociated = universeAssociated;
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
	
	public Book(String title,int numero, String info, Universe universe_associated, List<Chapter> chapters) {
		super();
		this.title=title;
		this.numero = numero;
		this.info = info;
		this.universeAssociated = universe_associated;
		if(chapters==null) {
			this.chapters=new ArrayList<Chapter>();
		}else {
		this.chapters = chapters;
		}
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


	public List<Chapter> getChapters() {
		return chapters;
	}


	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}


	public ReadState getStatus() {
		return status;
	}


	public void setStatus(ReadState status) {
		this.status = status;
	}


	public Book() {
		super();
	}
   
}
