package granguil.data.response;

import java.util.UUID;

import granguil.data.Enum.CurrentState;

public class UniverseResponse {
	private UUID id;
	
	private String info;
	
	private String title;
	
	private CurrentState currentState;

	public UniverseResponse(UUID id, String info, String title, CurrentState currentState) {
		super();
		this.id = id;
		this.info = info;
		this.title = title;
		this.currentState = currentState;
	}
	
	public UniverseResponse() {
		
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
