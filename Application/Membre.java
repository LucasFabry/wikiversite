package Application;

import java.util.ArrayList;

import interfaceGraphique.FenetreMembreConnecte;
import interfaceGraphique.FenetreServeur;

public class Membre {
	private String pseudo;
	private String password;
	private int niveauReputation;
	private FenetreMembreConnecte fenetreMembre;
	private ArrayList<Cours> listeCoursFav = new ArrayList<Cours>();
	private Serveur serveur;
	
	/**
	 * 
	 * Pour cr�er des membres ici on utilisera le patron de conception fabrique
	 * 
	 * */
	public Membre(String pseudo, String password, Serveur serveur) {
		//Penser à mettre la v�rification de l'unicit� du pseudo
		this.pseudo = pseudo;
		//On peut mettre une validation de password (ex : plus de 4 caract�res, une majuscule, etc.) 
		this.password = password;
		//On commence avec une r�putation nulle;
		this.niveauReputation = 0;
		
		this.serveur = serveur;
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
		//On vérifie que le cours n'est pas déjà dans les favoris
		if(!(listeCoursFav.contains(c))) {
			this.listeCoursFav.add(c);
		}
		
	}
	
	public ArrayList<Cours> getListeFavoris(){
		return this.listeCoursFav;
	}
	
	/**
	 * M�thode pour se connecter renvoie true si le membre arrive � se connecter, False sinon.
	 * */
	public boolean seConnecter(String pseudo, String password){
		System.out.println("Pseudo : " + this.pseudo + " pseudo saisi = " + pseudo);
		System.out.println("Pseudo : " + this.password + " pseudo saisi = " + password);
		if(this.pseudo.equals(pseudo) && this.password.equals(password)){
			return true;
		}
		return false;
	}
	
	public void setFenetreMembre(FenetreMembreConnecte fmc) {
		this.fenetreMembre = fmc;
	}
	public void notifier() {
		fenetreMembre.majListeCours();
	}
	
	
}
