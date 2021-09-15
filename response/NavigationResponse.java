package granguil.data.response;

public class NavigationResponse {
	public String groupe;
	
	public String nom;
	
	public String adresse;

	public NavigationResponse() {
		
	}
	
	public NavigationResponse(String groupe,String nom,String adresse) {
		this.groupe=groupe;
		this.nom=nom;
		this.adresse=adresse;
	}
	
	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
