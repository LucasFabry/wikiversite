package Application;

import interfaceGraphique.FenetreServeur;

import java.util.ArrayList;
import java.util.HashMap;


/*
 * 
 * Classe qui g�re les connexions, les listes de connect�s, etc...
 * Singleton
 * **/

public final class Serveur {
	private static Serveur instance;
	private ArrayList<Membre> membresCo = new ArrayList<Membre>();
	private ArrayList<Membre> listeMembres = new ArrayList<Membre>();
	private ArrayList<Membre> listeMembresBannis = new ArrayList<Membre>();
	private ArrayList<MembreCertifie> listeMembreCertifie = new ArrayList<MembreCertifie>();
	private ArrayList<Cours> listeCoursDispo = new ArrayList<Cours>();
	
	private Serveur(){}
	
	public static Serveur getInstance() {
        if (instance == null) {
            instance = new Serveur();
            new FenetreServeur(instance);
        }
    
        return instance;
    }
	
	public void genererFenetre() {
		new FenetreServeur(instance);
	}
	
	public void inscrireUnMembre(Membre m){
		this.listeMembres.add(m);
	}
	

	/**
	 * 
	 * M�thode qui permet de savoir si un membre avec le bon pseudo et le bon password existe dans la liste des membres.
	 * Retourne : le membre s'il existe, null sinon
	 * */
	public Membre seConnecter(String pseudo, String password){
		for(int i=0; i<listeMembres.size(); i++){
			if((listeMembres.get(i)).getPassword().equals(password) && listeMembres.get(i).getPseudo().equals(pseudo)){
				return listeMembres.get(i);
			}
		}
		return null;
	}
	
	public void connecterUnMembre(Membre m){
		this.membresCo.add(m);
	}
	
	
	//Retourne la liste des connect�s
	public ArrayList<Membre> getListeCo(){
		return this.membresCo;
	}
	
	//Retourne la liste des inscrits
	public ArrayList<Membre> getListeInscrit(){
		return this.listeMembres;
	}
	
	//Retourne la liste des bannis
	public ArrayList<Membre> getListeBannis(){
		return this.listeMembres;
	}
	//Bannir un membre
	public void bannirUnMembre(Membre m){
		this.listeMembresBannis.add(m);
		this.listeMembres.remove(m);
	}
	
	/*
	 * Cette méthode permet d'ajouter un cours
	 * **/
	public void ajouterCours(Cours c) {
		this.listeCoursDispo.add(c);
	}
	
	/**
	 * 
	 * Getter de la liste des cours
	 * */
	
	public ArrayList<Cours> getListeCours(){
		return this.listeCoursDispo;
	}
	
	public void supprimerCours(Cours c) {
		this.listeCoursDispo.remove(c);
	}
	
	//Récupérer un cours par le nom
	public Cours getCoursByName(String nomCours) {
		for(int i=0; i<this.listeCoursDispo.size(); i++) {
			if(nomCours.equals(listeCoursDispo.get(i).getNomCours())){
				return listeCoursDispo.get(i);
			}
		}
		return null;
	}
	
	//Retourne faux si le nom est pris
		//Retourne vrai si le nom est disponible
		public boolean nomDispo(String nomCours) {
			for(int i = 0; i<Serveur.getInstance().getListeCours().size(); i++) {
				if(nomCours.equals(Serveur.getInstance().getListeCours().get(i).getNomCours())) { //Si le nom du cours existe déjà
					return false;
				}
			}
			return true;
		}
	
	//Membre Certifié
	

	
	
}

