package Application;


public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serveur s = Serveur.getInstance();
		FabriqueMembre fm = FabriqueMembre.getInstance();
		s.inscrireUnMembre(fm.getMembre("Membre", "A", "password", s));
		System.out.println(s.getListeInscrit());
		s.inscrireUnMembre(fm.getMembre("Administrateur", "A", "password", s));
		
		
	}

}
