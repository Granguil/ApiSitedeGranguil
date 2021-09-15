package granguil.data.response;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import granguil.data.Enum.CurrentState;

public class BlockResponse {
	
	private String id;
	
	
	private String text;
	
	
	private int order;
	
	
	private UUID parent;
	
	public BlockResponse() {
		
	}
	
	public BlockResponse(String id,String text, int order, UUID parent) {
		super();
		this.id=id;
		this.text = text;
		this.order = order;
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public UUID getParent() {
		return parent;
	}

	public void setParent(UUID parent) {
		this.parent = parent;
	}

	
	
}
