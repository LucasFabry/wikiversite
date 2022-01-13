package interfaceGraphique;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Application.Administrateur;
import Application.Cours;
import Application.Membre;
import Application.MembreCertifie;
import Application.ObservateurConcret;
import Application.Serveur;

public class FenetreMembreConnecte extends JFrame implements ActionListener {

	private DefaultListModel<String> listeCours = new DefaultListModel<>();
	private DefaultListModel<String> listeCoursFav = new DefaultListModel<>();
	private JButton boutonOuvrirCo = new JButton("Ouvrir un cours");
	private JButton boutonCreerCo = new JButton("Créer un cours");
	private JButton boutonAjouterFav = new JButton("Ajouter en favori");
	private JTextField coursChamp = new JTextField("");
	private JList<String> JlisteCours;
	private Membre m;
	
	public FenetreMembreConnecte(Membre m){
		this.m = m;
		this.setTitle("Fenetre de : " + m.getPseudo());
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);  
		this.setLayout(new BorderLayout());
		this.setVisible(true);

		JPanel zoneEst = new JPanel();
		JlisteCours = new JList(listeCours);
		zoneEst.add(JlisteCours);

		/*
		 * 
		 * Liste des cours disponibles, un simple membre ne peut que consulter la liste des cours et en ouvrir un.
		 * 
		 * **/
		for(int i =0; i<Serveur.getInstance().getListeCours().size(); i++) {
			listeCours.add(i, Serveur.getInstance().getListeCours().get(i).getNomCours());
		}
		//Boutons de commandes
		JPanel zoneSud = new JPanel();
		zoneSud.add(boutonOuvrirCo);
		/*
		 * Zone qui ne s'afficher que pour l'admin
		 * **/
		
		if(m.getClass().getSimpleName().equals("Administrateur")) {
			JPanel zoneCentre = new JPanel();
			JLabel coursLabel = new JLabel("Choisir nom du cours : ");
			coursChamp.setPreferredSize(new Dimension(200,24));
			coursLabel.setLabelFor(coursChamp);
			zoneCentre.add(coursLabel);
			zoneCentre.add(coursChamp);
			zoneSud.add(boutonCreerCo);
			this.getContentPane().add(zoneCentre, BorderLayout.CENTER);
		}
		
	
		
		//Zone ouest pour les cours favoris
		JPanel zoneOuest = new JPanel();
		zoneOuest.add(new JList(listeCoursFav));
		for(int i = 0; i<m.getListeFavoris().size();i++) {
			listeCoursFav.add(i, m.getListeFavoris().get(i).getNomCours());
		}
		
		zoneOuest.add(boutonAjouterFav);

		this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
		this.getContentPane().add(zoneEst, BorderLayout.EAST);
		this.getContentPane().add(zoneOuest, BorderLayout.WEST);
		
		boutonOuvrirCo.addActionListener(this);
		boutonCreerCo.addActionListener(this);
		boutonAjouterFav.addActionListener(this);
	    
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		//
		if(e.getSource() == boutonOuvrirCo){
			//On ouvre la fenetre d'un cours
			if(JlisteCours.getSelectedValue() != null) {
				if(Serveur.getInstance().getCoursByName(JlisteCours.getSelectedValue()) != null) {
					new FenetreCours(this.m, Serveur.getInstance().getCoursByName(JlisteCours.getSelectedValue()));
				}
			}
			
		}
		
		if(e.getSource() == boutonCreerCo) {
			listeCours.removeAllElements();
			if(Serveur.getInstance().nomDispo(coursChamp.getText())) { //On vérifie la disponibilité du nom
				Serveur.getInstance().ajouterCours(new Cours(coursChamp.getText())); //On crée le cours et on l'ajoute au serveur.
			}
			for(int i =0; i<Serveur.getInstance().getListeCours().size(); i++) {
				listeCours.add(i, Serveur.getInstance().getListeCours().get(i).getNomCours());
			}
			Serveur.getInstance().getOb().actualiser();
			
		}
		
		if(e.getSource() == boutonAjouterFav) {
			if(JlisteCours.getSelectedValue() != null) {
				if(Serveur.getInstance().getCoursByName(JlisteCours.getSelectedValue()) != null) {
					this.m.ajouterFavori(Serveur.getInstance().getCoursByName(JlisteCours.getSelectedValue()));
				}
			}
			//Mise à jour des favoris
			listeCoursFav.clear();
			for(int i = 0; i<m.getListeFavoris().size();i++) {
				listeCoursFav.add(i, m.getListeFavoris().get(i).getNomCours());
			}
		}
		
	}
	
	public void majListeCours() {
		listeCours.removeAllElements();
		for(int i =0; i<Serveur.getInstance().getListeCours().size(); i++) {
			listeCours.add(i, Serveur.getInstance().getListeCours().get(i).getNomCours());
		}
	}

}
