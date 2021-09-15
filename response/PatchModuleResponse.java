package granguil.data.response;

import java.util.UUID;

import granguil.data.entity.Module.ModuleStatus;

public class PatchModuleResponse {
public UUID id;
public String title;
public String text;
public UUID scene;
public ModuleStatus status;

public PatchModuleResponse() {
	
}

public PatchModuleResponse(UUID id,String title,String text,UUID scene,ModuleStatus status) {
	this.title=title;
	this.text=text;
	this.scene=scene;
	this.id=id;
	this.status=status;
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
