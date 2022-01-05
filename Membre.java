
public abstract class Membre {
	private String pseudo;
	private String password;
	private int niveauReputation;
	
	/**
	 * 
	 * Pour créer des membres ici on utilisera le patron de conception fabrique
	 * 
	 * */
	
	public Membre(String pseudo, String password) {
		//Penser à mettre la vérification de l'unicité du pseudo
		this.pseudo = pseudo;
		//On peut mettre une validation de password (ex : plus de 4 caractères, une majuscule, etc.) 
		this.password = password;
		//On commence avec une réputation nulle;
		this.niveauReputation = 0;
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
	public void chagerReputation(Membre m){
		//TODO
	}
	
	
	
}
