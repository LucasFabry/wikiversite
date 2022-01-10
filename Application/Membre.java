package Application;

import java.util.ArrayList;

import interfaceGraphique.FenetreServeur;

public class Membre {
	private String pseudo;
	private String password;
	private int niveauReputation;
	private FenetreServeur fenetreMembre;
	private ArrayList listeCoursFav = new ArrayList<Cours>();
	private Serveur serveur;
	
	/**
	 * 
	 * Pour créer des membres ici on utilisera le patron de conception fabrique
	 * 
	 * */
	public Membre(String pseudo, String password, Serveur serveur) {
		//Penser à mettre la vérification de l'unicité du pseudo
		this.pseudo = pseudo;
		//On peut mettre une validation de password (ex : plus de 4 caractères, une majuscule, etc.) 
		this.password = password;
		//On commence avec une réputation nulle;
		this.niveauReputation = 0;
		
		this.serveur = serveur;
	}
	
	/**
	 * 
	 * Méthode pour modifier le contenu d'un cours
	 * 
	 * */
	public void modifierContenuChapitre(Chapitre chapitre, String texteModifie){
		//Penser à créer un pattern Logger pour savoir qui modifie quoi etc...
		chapitre.setContenuChapitre(texteModifie);
	}
	
	/**
	 * 
	 * Méthode pour changer la réputation d'un membre
	 * Idée : On note de 1 à 10 un utilisateur, sa réputation sera la moyenne de toutes les notes qu'il aura reçues
	 * 
	 * */
	public void changerReputation(Membre m){
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
	
	
	/**
	 * Méthode pour se connecter renvoie true si le membre arrive à se connecter, False sinon.
	 * */
	public boolean seConnecter(String pseudo, String password){
		System.out.println("Pseudo : " + this.pseudo + " pseudo saisi = " + pseudo);
		System.out.println("Pseudo : " + this.password + " pseudo saisi = " + password);
		if(this.pseudo.equals(pseudo) && this.password.equals(password)){
			return true;
		}
		return false;
	}
	
	
	
	
}
