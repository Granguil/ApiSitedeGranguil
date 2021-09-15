package granguil.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import granguil.data.Enum.CurrentState;

/**
 * Entity implementation class for Entity: Block
 *
 */
@Entity
@Table(name="block_scene")
public class Block implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	
	@Type(type="text")
	private String contentBlock;
	
	private int order;
	
	@ManyToOne
	@JoinColumn(name="scene_id")
	@JsonBackReference
	private Scene sceneAssociated;
	
	public Block() {
		super();
	}


	
	public Scene getSceneAssociated() {
		return sceneAssociated;
	}



	public void setSceneAssociated(Scene sceneAssociated) {
		this.sceneAssociated = sceneAssociated;
	}

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getContentBlock() {
		return contentBlock;
	}


	public void setContentBlock(String contentBlock) {
		this.contentBlock = contentBlock;
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public Scene getScene_associated() {
		return sceneAssociated;
	}


	public void setScene_associated(Scene scene_associated) {
		this.sceneAssociated = scene_associated;
	}


	public Block(String contentBlock, int order, Scene scene_associated) {
		super();
		this.contentBlock = contentBlock;
		this.order = order;
		this.sceneAssociated = scene_associated;
	}
   
	
}
