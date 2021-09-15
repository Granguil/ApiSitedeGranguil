package granguil.data.request;

import java.util.UUID;

import granguil.data.entity.Module.ModuleStatus;

public class ModuleSaveRequest {
	public enum TypeModule{
		PATCH(0),
		MINOR(1),
		MAJOR(2),
		MODULE(3);
		
		private final int value;
		private TypeModule(int value) {
			this.value=value;
		}
		public int getValue() {
			return this.value;
		}
	}
public UUID id;
public String title;
public String description;
public int numero;
public UUID parent;
public TypeModule type;
public ModuleStatus status;


public ModuleStatus getStatus() {
	return status;
}

public void setStatus(ModuleStatus status) {
	this.status = status;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public UUID getParent() {
	return parent;
}
public void setParent(UUID parent) {
	this.parent = parent;
}
public TypeModule getType() {
	return type;
}
public void setType(TypeModule type) {
	this.type = type;
}


}
