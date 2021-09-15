package granguil.data.request;

import java.util.UUID;

public class PatchModuleRequest {
	public UUID id;
	public String title;
	public String text;
	public UUID scene;

	public PatchModuleRequest() {
		
	}

	public PatchModuleRequest(String title,String text,UUID scene) {
		this.title=title;
		this.text=text;
		this.scene=scene;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UUID getScene() {
		return scene;
	}

	public void setScene(UUID scene) {
		this.scene = scene;
	}

}
