package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: BookMark
 *
 */
@Entity

public class BookMark implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
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
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonManagedReference
	private User user;
	
	private String name;
	
	public BookMark() {
		super();
	}

	public BookMark(Universe universe, Book book, Chapter chapter, Scene scene, User user,String name) {
		super();
		this.universe = universe;
		this.book = book;
		this.chapter = chapter;
		this.scene = scene;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
