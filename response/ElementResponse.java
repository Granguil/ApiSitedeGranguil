package granguil.data.response;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class ElementResponse {
	
	private UUID id;
	
	private UUID parent;
	
	private String info;
	
	private String status;
	
	private String title;
	
	private int numero;

	public ElementResponse() {
		
	}
	public ElementResponse(UUID id,UUID parent, String info, String status, String title,int numero) {
		super();
		this.id=id;
		this.parent = parent;
		this.info = info;
		this.status = status;
		this.title = title;
		this.numero=numero;
	}

	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getParent() {
		return parent;
	}

	public void setParent(UUID parent) {
		this.parent = parent;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
