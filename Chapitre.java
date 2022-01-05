
public class Chapitre {
	private Cours cours;
	private String titreChapitre;
	private String contenuChapitre;
	
	/**
	 * 
	 * On crée un chapite avec un cours, un titre et un contenu (peut être vide au début)
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
