package Application;

import java.util.ArrayList;

public class ObservateurConcret implements Observateur {

	private static ArrayList<Membre> listeInscrit = new ArrayList<Membre>();
	@Override
	public void actualiser() {
		for(int i=0;i<listeInscrit.size();i++) {
			listeInscrit.get(i).notifier();
		}

	}
	
	public void inscrireALecoute(Membre m){
		listeInscrit.add(m);
	}

}
