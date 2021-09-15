package granguil.data.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModuleResponse {
	
	public List<String[]> Titre=new ArrayList<String[]>();
	
	public List<ModuleExplorerResponse> Element=new ArrayList<ModuleExplorerResponse>();
	
	public List<PatchModuleResponse> Bloc=new ArrayList<PatchModuleResponse>();
	
	public ModuleResponse() {
		String[] titre1=new String[2];
		titre1[0]="Type de Modules";
		titre1[1]="Type de Modules";
		String[] titre2=new String[2];
		titre2[0]="Modules";
		titre2[1]="Détail des Types";
		String[] titre3=new String[2];
		titre3[0]="Version Majeure";
		titre3[1]="Détail Module";
		String[] titre4=new String[2];
		titre4[0]="Version Mineure";
		titre4[1]="Détail Version Majeure";
		this.Titre.add(titre1);
		this.Titre.add(titre2);
		this.Titre.add(titre3);
		this.Titre.add(titre4);
	}
	
	public ModuleResponse(List<ModuleExplorerResponse> element,List<PatchModuleResponse> bloc) {
		String[] titre1=new String[2];
		titre1[0]="Type de Modules";
		titre1[1]="Type de Modules";
		String[] titre2=new String[2];
		titre2[0]="Modules";
		titre2[1]="Détail des Types";
		String[] titre3=new String[2];
		titre3[0]="Version Majeure";
		titre3[1]="Détail Module";
		String[] titre4=new String[2];
		titre4[0]="Version Mineure";
		titre4[1]="Détail Version Majeure";
		this.Titre.add(titre1);
		this.Titre.add(titre2);
		this.Titre.add(titre3);
		this.Titre.add(titre4);
		this.Element=element;
		this.Bloc=bloc;
	}

	public List<String[]> getTitre() {
		return Titre;
	}

	public void setTitre(List<String[]> titre) {
		Titre = titre;
	}

	public List<ModuleExplorerResponse> getElement() {
		return Element;
	}

	public void setElement(List<ModuleExplorerResponse> element) {
		Element = element;
	}

	public List<PatchModuleResponse> getBloc() {
		return Bloc;
	}

	public void setBloc(List<PatchModuleResponse> bloc) {
		Bloc = bloc;
	}
	
	
}
