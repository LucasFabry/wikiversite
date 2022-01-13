package Application;


public class Application {

	public static void main(String[] args) {
		
		Serveur s = Serveur.getInstance();
		FabriqueMembre fm = FabriqueMembre.getInstance();
		
		
		
		Cours c = new Cours("Mathématique");
		Chapitre ch1 = new Chapitre(c,"Géométrie", "La géométrie est à l'origine la branche des mathématiques étudiant les figures du plan et de l'espace (géométrie euclidienne). Depuis la fin du xviiie siècle, la géométrie étudie également les figures appartenant à d'autres types d'espaces (géométrie projective, géométrie non euclidienne, par exemple).\r\n"
				+ "\r\n"
				+ "Depuis le début du xxe siècle, certaines méthodes d'étude de figures de ces espaces se sont transformées en branches autonomes des mathématiques : topologie, géométrie différentielle et géométrie algébrique, par exemple."
				+ "\r\n"
				+ "Si l'on veut englober toutes ces acceptions, il est difficile de définir ce qu'est, aujourd'hui, la géométrie. "
				+ "\r\n" 
				+ "C'est que l'unité des diverses branches de la « géométrie contemporaine » réside plus dans des origines historiques que dans une communauté de méthodes ou d'objets");
		ch1.attribuerCours();
		Chapitre ch2 = new Chapitre(c, "Algorithmie", "L'algorithmique est l'étude et la production de règles et techniques qui sont impliquées dans la définition et la conception d'algorithmes, "
				+ "c'est-à-dire de processus systématiques de résolution d'un problème permettant de décrire "
				+ "précisément des étapes pour résoudre un problème algorithmique.");
		ch2.attribuerCours();
		s.ajouterCours(c);
		
	
	}

}
