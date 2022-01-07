package Application;

import java.util.ArrayList;


/*
 * 
 * Classe qui gère les connexions, les listes de connectés, etc...
 * Singleton
 * **/

public final class Serveur {
	private static Serveur instance;
	private ArrayList membresCo = new ArrayList<Membre>();
	
	public Serveur(){
		if (instance == null) {
            instance = new Serveur();
        }
	}
	
	public static Serveur getInstance() {
        if (instance == null) {
            instance = new Serveur();
        }
        return instance;
    }
	
	public void connecterUnMembre(Membre m){
		this.membresCo.add(m);
	}
	
	//Bannir un membre
	
	
	//Membres certifiés
	
	

}
