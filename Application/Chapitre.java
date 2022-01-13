package Application;

public class Chapitre {
	private Cours cours;
	private String titreChapitre;
	private String contenuChapitre;
	
	/**
	 * 
	 * On cr�e un chapite avec un cours, un titre et un contenu (peut �tre vide au d�but)
	 * 
	 * */
	public Chapitre(Cours cours, String titreChapitre, String contenuChapitre) {
		this.cours = cours;
		this.titreChapitre = titreChapitre;
		this.contenuChapitre = contenuChapitre;
	}


	public Cours getCours() {
		return cours;
	}

	public void attribuerCours() {
		this.cours.setListeChap(this);
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}


	public String getTitreChapitre() {
		return titreChapitre;
	}


	public void setTitreChapitre(String titreChapitre) {
		this.titreChapitre = titreChapitre;
	}


	public String getContenuChapitre() {
		return contenuChapitre;
	}


	public void setContenuChapitre(String contenuChapitre) {
		this.contenuChapitre = contenuChapitre;
	}
	
	
	
}
