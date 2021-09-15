package granguil.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import granguil.data.Enum.CurrentState;
import granguil.data.Enum.ReadState;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Entity implementation class for Entity: Scene
 *
 */
@Entity
@Table(name="scene_chapter")
public class Scene implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	private int numero;
	
	@Type(type="text")
	private String info;
	
	@ManyToOne
	@JoinColumn(name="chapter_id")
	@JsonBackReference
	private Chapter chapterAssociated;
	
	@OneToMany(mappedBy="sceneAssociated", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonInclude(Include.NON_EMPTY)
	private List<Block> blocks;

	@Transient
	private ReadState status=ReadState.NotRead;
		
	private String title;
	
	@OneToMany(mappedBy="scene")
	@JsonBackReference
	private List<BookMark> bookMark;
	
	@OneToMany(mappedBy="scene")
	@JsonBackReference
	private List<ReadUser> readUser;
	
	private CurrentState currentState=CurrentState.DRAFT;
	
	public CurrentState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}

	public Chapter getChapterAssociated() {
		return chapterAssociated;
	}

	public void setChapterAssociated(Chapter chapterAssociated) {
		this.chapterAssociated = chapterAssociated;
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
	
	public Scene(String title,int numero, String info, Chapter chapter_associated, List<Block> blocks) {
		super();
		this.title=title;
		this.numero = numero;
		this.info = info;
		this.chapterAssociated = chapter_associated;
		this.blocks = blocks;	
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


	public Chapter getChapter_associated() {
		return chapterAssociated;
	}


	public void setChapter_associated(Chapter chapter_associated) {
		this.chapterAssociated = chapter_associated;
	}


	public List<Block> getBlocks() {
		return blocks;
	}


	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}


	public ReadState getStatus() {
		return status;
	}


	public void setStatus(ReadState status) {
		this.status = status;
	}


	public Scene() {
		super();
	}
   
}
