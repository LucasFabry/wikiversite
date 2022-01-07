package Application;

import interfaceGraphique.FenetreMembre;

public class Administrateur extends Membre {
	private ArrayList listeMembres = new ArrayList<Membre>();
	private ArrayList listeMembresBannis = new ArrayList<Membre>();
	private ArrayList listeMembreCertifie = new ArrayList<MembreCertifie>();

	public Administrateur(String pseudo, String password) {
		super(pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	//Récupérer la liste des membres
	public ArrayList getMembres(){
		return this.listeMembres;
	}
	
	/**
	 * 
	 * Méthode pour bannir un membre
	 * Idée : penser à créer un concierge (comme l'an dernier) qui gère la liste des membres
	 * cette méthode retire simplement un membre de la liste
	 * 
	 * */
	public void bannirMembre(Membre m){
		this.listeMembresBannis.add(m);
		this.listeMembres.remove(m);	
	}
	/**
	 * 
	 * Méthode pour bannir un membre
	 * Idée : penser à créer un concierge (comme l'an dernier) qui gère la liste des membres
	 * cette méthode permet de certifier un membre
	 * 
	 * */
	public void certifierMembre(Membre m){
		//TODO
		MembreCertifie mc = new MembreCertifie(m.getPseudo(), m.getPassword());
		this.listeMembreCertifie.add(m);
		m=null;
	}
	
	public void bannirIP(String ipAdress){
		//TODO
	}

}
