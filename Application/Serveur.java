package Application;

import java.util.ArrayList;


/*
 * 
 * Classe qui g�re les connexions, les listes de connect�s, etc...
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
	
	
	//Membres certifi�s
	
	

}
