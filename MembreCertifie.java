import java.util.ArrayList;


public class MembreCertifie extends Membre {
	private ArrayList listeCoursCertifie = new ArrayList<Cours>(); //Liste des cours o� l'utilisateur est certifi�
	
	public MembreCertifie(String pseudo, String password) {
		super(pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	//R�cup�rer la liste des cours certifi�
	public ArrayList getListeCoursCertifie(){
		return this.listeCoursCertifie;
	}
	
	/**
	 * 
	 * Permet d'ajouter un cours � la liste des cours certifi� du membre
	 * 
	 * */
	public void setListeCoursCertifie(Cours c){
		this.listeCoursCertifie.add(c);
	}
	
	/**
	 * 
	 * Permet d'ajouter une liste de cours � la liste de cours
	 * 
	 * */
	public void setListeCoursCertifie(ArrayList<Cours> listeCours){
		this.listeCoursCertifie.addAll(listeCours);
	}
	
	/**
	 * 
	 * le membre certifi� peut cr�er le chapitre, qui est associ� � un cours;
	 * 
	 * */
	public Chapitre creerUnChapitre(Cours c, String nomChapitre){
		return new Chapitre(c, nomChapitre, "");
	}
	

}
