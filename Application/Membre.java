package Application;

import java.util.ArrayList;

import interfaceGraphique.FenetreMembre;

public class Membre {
	private String pseudo;
	private String password;
	private int niveauReputation;
	private FenetreMembre fenetreMembre;
	private ArrayList listeCoursFav = new ArrayList<Cours>();
	
	/**
	 * 
	 * Pour cr�er des membres ici on utilisera le patron de conception fabrique
	 * 
	 * */
	public Membre(String pseudo, String password) {
		//Penser � mettre la v�rification de l'unicit� du pseudo
		this.pseudo = pseudo;
		//On peut mettre une validation de password (ex : plus de 4 caract�res, une majuscule, etc.) 
		this.password = password;
		//On commence avec une r�putation nulle;
		this.niveauReputation = 0;
		this.fenetreMembre = new FenetreMembre(this);
	}
	
	/**
	 * 
	 * M�thode pour modifier le contenu d'un cours
	 * 
	 * */
	public void modifierContenuChapitre(Chapitre chapitre, String texteModifie){
		//Penser � cr�er un pattern Logger pour savoir qui modifie quoi etc...
		chapitre.setContenuChapitre(texteModifie);
	}
	
	/**
	 * 
	 * M�thode pour changer la r�putation d'un membre
	 * Id�e : On note de 1 � 10 un utilisateur, sa r�putation sera la moyenne de toutes les notes qu'il aura re�ues
	 * 
	 * */
	public void chagerReputation(Membre m){
		//TODO
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNiveauReputation() {
		return niveauReputation;
	}

	public void setNiveauReputation(int niveauReputation) {
		this.niveauReputation = niveauReputation;
	}

	public void ajouterFavori(Cours c){
		this.listeCoursFav.add(c);
	}
	
	
	
	
	
	
}