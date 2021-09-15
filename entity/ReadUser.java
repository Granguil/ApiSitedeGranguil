package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import granguil.data.Enum.ReadState;

/**
 * Entity implementation class for Entity: ReadUser
 *
 */
@Entity
@Table(name="read_user")
public class ReadUser implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonManagedReference
	private User user;
	
	@ManyToOne
	@JoinColumn(name="universe_id")
	@JsonManagedReference
	private Universe universe;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	@JsonManagedReference
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="chapter_id")
	@JsonManagedReference
	private Chapter chapter;
	
	@ManyToOne
	@JoinColumn(name="scene_id")
	@JsonManagedReference
	private Scene scene;
	
	private ReadState readState;
	
	public ReadUser() {
		super();
	}

	public ReadUser(Universe universe,Book book, Chapter chapter, Scene scene, User user,ReadState readState) {
		this.universe=universe;
		this.book=book;
		this.chapter=chapter;
		this.scene=scene;
		this.readState=readState;
	}
	
	
	public ReadState getReadState() {
		return readState;
	}

	public void setReadState(ReadState readState) {
		this.readState = readState;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
   
}
