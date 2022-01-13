package Application;

import java.util.ArrayList;

public class Cours {
	private String nomCours; //Le nom du cours est unique.
	private ArrayList<Chapitre> listeChap = new ArrayList<>();
	
	public Cours(String nomCours) {
		this.nomCours = nomCours;
	}

	public ArrayList<Chapitre> getListeChap() {
		return listeChap;
	}

	public void setListeChap(Chapitre chapitre) {
		this.listeChap.add(chapitre);
	}
	
	public void majListeChap() {
		Serveur.getInstance().getCoursByName(nomCours);
	}
	
	public String getNomCours() {
		return nomCours;
	}

	
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}	
	
	public Chapitre getChapByName(String titre) {
		for(int i=0;i<listeChap.size();i++) {
			if(listeChap.get(i).getTitreChapitre().equals(titre)) {
				return listeChap.get(i);
			}
		}
		return null;
	}
	
	public String getAllCours() {
		String contenu = "";
		for(int i=0;i<listeChap.size();i++) {
			contenu += "\r\n" + listeChap.get(i).getTitreChapitre()  + "\n\r" + listeChap.get(i).getContenuChapitre();
		}
		return contenu;
	}
	
}
