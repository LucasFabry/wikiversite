package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import Application.Cours;
import Application.Membre;
import Application.Serveur;

public class FenetreCours extends JFrame implements ActionListener {
	
	
	private JButton editerCours = new JButton("Éditer le cours");
	private JButton ajouterChapitre = new JButton("Ajouter un chapitre");
	private JButton validerEdit = new JButton("Valider édition");
	private JButton afficherChapitre = new JButton("Afficher le chapitre");
	JTextArea jTextArea1 = new JTextArea( 500,400);
	private DefaultListModel<String> listeChapitre = new DefaultListModel<>();
	private JList<String> JlisteChapitre2;
	Cours c;
	Membre m;
	
	public FenetreCours(Membre m, Cours c){
		this.c = c;
		this.m = m;
		
		JPanel zoneEst = new JPanel();
		JlisteChapitre2 = new JList(listeChapitre);
		zoneEst.add(JlisteChapitre2);

		/*
		 * 
		 * Liste des cours disponibles, un simple membre ne peut que consulter la liste des cours et en ouvrir un.
		 * 
		 * **/
		for(int i =0; i<c.getListeChap().size(); i++) {
			listeChapitre.add(i, c.getListeChap().get(i).getTitreChapitre());
		}
	
		jTextArea1.setEditable(false);
		JScrollPane jsp = new JScrollPane(jTextArea1,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		jsp.setVerticalScrollBarPolicy(jsp.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setPreferredSize(new Dimension(400,400));
		this.setTitle("Cours : " + c.getNomCours());
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);  
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		//TODO rendre la fenêtre un peu mieux
		
		
		//Afficher une liste des chapitres
		//Bouton afficher chapitre qui fait apparaître éditer si on a les droits
		
		JPanel zoneSud= new JPanel();
		
		zoneSud.add(editerCours); //Ne doit pas apparaître que si le membre est de type Admin ou certifié pour ce cours
		zoneSud.add(validerEdit); 
		editerCours.setVisible(false);
		validerEdit.setVisible(false);
		zoneSud.add(afficherChapitre);
		
		if(m.getClass().getSimpleName() == "MembreCertifie" || m.getClass().getSimpleName().equals("Administrateur")) {
			editerCours.setVisible(true);
		}
		this.getContentPane().add(jsp,null);
		this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
		this.getContentPane().add(zoneEst, BorderLayout.EAST);
	      
		editerCours.addActionListener(this);
		validerEdit.addActionListener(this);
		afficherChapitre.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == editerCours) {
			jTextArea1.setEditable(true);
			validerEdit.setVisible(true);
		}
		
		if(arg0.getSource() == validerEdit){
			//Doit juster récupérer le chapitre sélectionné et enregistrer la nouvelle valeur
			if(JlisteChapitre2.getSelectedValue() != null) {
				if(c.getChapByName(JlisteChapitre2.getSelectedValue()) != null) {
					c.getChapByName(JlisteChapitre2.getSelectedValue()).setContenuChapitre(jTextArea1.getText());
				}
			}
		}
		
		if(arg0.getSource() == afficherChapitre) {
			if(JlisteChapitre2.getSelectedValue() != null) {
				if(c.getChapByName(JlisteChapitre2.getSelectedValue()) != null) {
					jTextArea1.setText(c.getChapByName(JlisteChapitre2.getSelectedValue()).getContenuChapitre());
				}
			}
			System.out.println(m.getClass().getSimpleName());
			if(m.getClass().getSimpleName() == "MembreCertifie" || m.getClass().getSimpleName() == "Administrateur") {
				editerCours.setVisible(true);
			}
		}
	}
}
