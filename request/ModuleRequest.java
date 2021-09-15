package granguil.data.request;

import java.util.ArrayList;
import java.util.List;

public class ModuleRequest {
public List<String[]> Titre=new ArrayList<String[]>();
	
	public List<ModuleExplorerRequest> Element=new ArrayList<ModuleExplorerRequest>();
	
	public List<PatchModuleRequest> Bloc=new ArrayList<PatchModuleRequest>();
	
	public ModuleRequest() {
	}
	
	public ModuleRequest(List<ModuleExplorerRequest> element,List<PatchModuleRequest> bloc) {
		this.Element=element;
		this.Bloc=bloc;
	}

	public List<String[]> getTitre() {
		return Titre;
	}

	public void setTitre(List<String[]> titre) {
		Titre = titre;
	}

	public List<ModuleExplorerRequest> getElement() {
		return Element;
	}

	public void setElement(List<ModuleExplorerRequest> element) {
		Element = element;
	}

	public List<PatchModuleRequest> getBloc() {
		return Bloc;
	}

	public void setBloc(List<PatchModuleRequest> bloc) {
		Bloc = bloc;
	}

}
