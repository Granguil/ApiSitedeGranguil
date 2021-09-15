package granguil.data.request;

import java.util.UUID;

public class ModuleExplorerRequest {
	public UUID id;
    public String Type;
    public String Titre;
    public String Detail;
    public UUID Parent;
    
    public ModuleExplorerRequest() {
    	
    }
    
    public ModuleExplorerRequest(UUID id,String type,String titre,String detail,UUID parent) {
    	this.id=id;
    	this.Type=type;
    	this.Titre=titre;
    	this.Detail=detail;
    	this.Parent=parent;
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
