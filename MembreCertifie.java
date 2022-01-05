import java.util.ArrayList;


public class MembreCertifie extends Membre {
	private ArrayList listeCoursCertifie = new ArrayList<Cours>(); //Liste des cours où l'utilisateur est certifié
	
	public MembreCertifie(String pseudo, String password) {
		super(pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	//Récupérer la liste des cours certifié
	public ArrayList getListeCoursCertifie(){
		return this.listeCoursCertifie;
	}
	
	/**
	 * 
	 * Permet d'ajouter un cours à la liste des cours certifié du membre
	 * 
	 * */
	public void setListeCoursCertifie(Cours c){
		this.listeCoursCertifie.add(c);
	}
	
	/**
	 * 
	 * Permet d'ajouter une liste de cours à la liste de cours
	 * 
	 * */
	public void setListeCoursCertifie(ArrayList<Cours> listeCours){
		this.listeCoursCertifie.addAll(listeCours);
	}
	
	/**
	 * 
	 * le membre certifié peut créer le chapitre, qui est associé à un cours;
	 * 
	 * */
	public Chapitre creerUnChapitre(Cours c, String nomChapitre){
		return new Chapitre(c, nomChapitre, "");
	}
	

}
