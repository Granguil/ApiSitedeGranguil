package granguil.data.response;

import java.util.UUID;

import granguil.data.entity.Module.ModuleStatus;

public class ModuleExplorerResponse {
	public UUID id;
    public String Type;
    public String Titre;
    public String Detail;
    public UUID Parent;
    public ModuleStatus Status;
    
    public ModuleExplorerResponse() {
    	
    }
    
    public ModuleExplorerResponse(UUID id,String type,String titre,String detail,UUID parent,ModuleStatus status) {
    	this.id=id;
    	this.Type=type;
    	this.Titre=titre;
    	this.Detail=detail;
    	this.Parent=parent;
    	this.Status=status;
    }

    
    
	public ModuleStatus getStatus() {
		return Status;
	}

	public void setStatus(ModuleStatus status) {
		Status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public UUID getParent() {
		return Parent;
	}

	public void setParent(UUID parent) {
		Parent = parent;
	}
    
    
    
}
