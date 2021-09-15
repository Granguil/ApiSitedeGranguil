package granguil.data.response;

import java.util.UUID;

import granguil.data.Enum.CurrentState;

public class SceneResponse {
	public UUID id;
	
	public String info;
	
	public String title;
	
	public CurrentState currentState;
	
	public String parent;

	public int numero;
	public SceneResponse(UUID id, String parent,String info, String title, CurrentState currentState,int numero) {
		super();
		this.parent=parent;
		this.id = id;
		this.info = info;
		this.title = title;
		this.currentState = currentState;
		this.numero=numero;
	}
	
	public SceneResponse() {
		
	}
	
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CurrentState getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(CurrentState currentState) {
		this.currentState = currentState;
	}
}
