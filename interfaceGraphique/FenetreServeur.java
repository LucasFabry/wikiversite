package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import Application.FabriqueMembre;
import Application.Membre;
import Application.Serveur;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FenetreServeur extends JFrame implements ActionListener {
	
	/**
	 * 
	 * Classe qui permet de générer l'affichage graphique d'un membre
	 * 
	 * */
	
	private JButton boutonConnexion = new JButton("Se connecter");
	private JButton creerCompte = new JButton("Créer un compte");
	private JButton listeMembre = new JButton("Actualiser liste membre");
	private JTextField pseudoChamp = new JTextField("");
	private JTextField passwordChamp = new JTextField("");
	private JList<String> pseudos;
	private DefaultListModel<String> model = new DefaultListModel<>();
	
	private Serveur s;
	
	public FenetreServeur(Serveur s){
		this.s = s;
		
		this.setTitle("Fenêtre de connexion");
	    this.setSize(700, 500);
	    this.setLocationRelativeTo(null);  
	    this.setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	    
	    /**
	     * Zone Centrale pour saisir identifiant + mot de passe
	     * */
	    
	    JPanel zoneCentre = new JPanel();
	    
	    JLabel pseudoLabel = new JLabel("Pseudo : ");
	    JLabel passwordLabel = new JLabel("Mot de passe :");
	    
	    pseudoLabel.setLabelFor(pseudoChamp);
	    passwordLabel.setLabelFor(passwordChamp);
	    
	    pseudoChamp.setPreferredSize(new Dimension(200,24));
	    passwordChamp.setPreferredSize(new Dimension(200,24));
	    
	    zoneCentre.add(pseudoLabel);
	    zoneCentre.add(pseudoChamp);
	    zoneCentre.add(passwordLabel);
	    zoneCentre.add(passwordChamp);
	    
	    
	    /*
	     * On ajoute la liste des pseudos des membres inscrits
	     * 
	     * TODO
	     * 
	     * **/
	    
	 
	    zoneCentre.add(new JList(model));
	    
	    
	    /**
	     * On crée une zone sud qui va contenir le bouton pour se connecter ou pour créer un compte
	     * */
	    JPanel zoneSud = new JPanel();
	    zoneSud.add(boutonConnexion);
	    zoneSud.add(creerCompte);
	    zoneSud.add(listeMembre);
	    
	    this.getContentPane().add(zoneCentre, BorderLayout.CENTER);
	    this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
	    this.setVisible(true);
	    boutonConnexion.addActionListener(this);
	    creerCompte.addActionListener(this);
	    listeMembre.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this.s.getListeInscrit());
		
		//Si on a appuyé sur le bouton de connexion.
		if(e.getSource() == boutonConnexion){
			model.removeAllElements();
			//On appelle la méthode seConnecter du membre
			if(this.s.seConnecter(pseudoChamp.getText(), passwordChamp.getText()) != null){
				Membre m = this.s.seConnecter(pseudoChamp.getText(), passwordChamp.getText()); //On récupère le membre (on s'est assuré avant d'un résultat non null on peut donc manipuler sans crainte)
				FenetreMembreConnecte fmc = new FenetreMembreConnecte(m); //On ouvre une fenêtre pour le membre qui se co
				s.connecterUnMembre(m); //On inscrit le membre à la liste des connectés
			}
			
			else{
				//Message d'erreur si la connexion n'est pas valide
				JOptionPane.showMessageDialog(this, 
				         "Identifiant ou mot de passe incorrect",
				         "Erreur saisi",
				         JOptionPane.ERROR_MESSAGE);
				
			}
			for(int i=0;i<s.getListeInscrit().size();i++){
		    	model.add(i, s.getListeInscrit().get(i).getPseudo());
		    }
		}
		
		
		if(e.getSource() == creerCompte){
			model.removeAllElements();
			FabriqueMembre fm = FabriqueMembre.getInstance();
			this.s.inscrireUnMembre(fm.getMembre("Administrateur", "A", "password", s));
			for(int i=0;i<s.getListeInscrit().size();i++){
		    	model.add(i, s.getListeInscrit().get(i).getPseudo());
		    }
		}
		
		if(e.getSource() == listeMembre){
			model.removeAllElements();
			for(int i=0;i<s.getListeInscrit().size();i++){
		    	model.add(i, s.getListeInscrit().get(i).getPseudo());
		    }
		}
	}

}
