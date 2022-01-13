package Application;

import java.util.Random;

public class FabriqueMembre {
	private static FabriqueMembre instance;
	private FabriqueMembre() {}
	    
	 public static FabriqueMembre getInstance() {
		 	if (instance == null) {
	            instance = new FabriqueMembre();
	        }
	       return instance;
	 }

	 public Membre getMembre(String typeMembre, String pseudo, String password, Serveur s) {
		 /*
		  * Boucle pour s'assurer de l'unicit� du pseudo
		  * **/
		 for(int i = 0; i<s.getListeInscrit().size(); i++){
			 if(s.getListeInscrit().get(i).getPseudo().equals(pseudo)){
				 pseudo = pseudo + this.genererChaineAleatoire(); //Si le pseudo existe on génère un pseudo al�atoire
				 
			 }
		 }
		 
		 /**
		  * Cr�ation du membre
		  * */
		 
		 Membre m;
	     if (typeMembre.equals("1")) {
	    	 m = new MembreCertifie(pseudo, password, s);
	     	 s.inscrireUnMembre(m);
	         return m;
	     }
	    	 
	     else if (typeMembre.equals("2")) {
	    	 m = new Administrateur(pseudo, password, s);
	     	 s.inscrireUnMembre(m);
	         return m;
	     }
	     m = new Membre(pseudo, password, s);
     	 s.inscrireUnMembre(m);
         return m;
	   }
	 
	 private String genererChaineAleatoire(){
		 Random rand = new Random();
		 String str="";
		 for(int i = 0 ; i < 5 ; i++){
		   char c = (char)(rand.nextInt(26) + 97);
		   str += c;
		 }
		 return str;
	 }
}
