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
	 * Classe qui permet de g�n�rer l'affichage graphique d'un membre
	 * 
	 * */
	
	private JButton boutonConnexion = new JButton("Se connecter");
	private JButton creerCompte = new JButton("Cr�er un compte");
	private JButton actualiser = new JButton("Actualiser liste membre");
	private JButton bannirMembre = new JButton("Bannir un membre");
	private JTextField pseudoChamp = new JTextField("");
	private JTextField passwordChamp = new JTextField("");
	private JTextField typeMembre = new JTextField("");
	private JList<String> jl;
	private DefaultListModel<String> model = new DefaultListModel<>();
	
	private Serveur s;
	
	public FenetreServeur(Serveur s){
		this.s = s;
		
		this.setTitle("Fenétre de connexion");
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
	    JLabel membreLabel = new JLabel("Rôle membre (0, 1 ou 2)");
	    
	    pseudoLabel.setLabelFor(pseudoChamp);
	    passwordLabel.setLabelFor(passwordChamp);
	    membreLabel.setLabelFor(typeMembre);
	    
	    pseudoChamp.setPreferredSize(new Dimension(100,24));
	    passwordChamp.setPreferredSize(new Dimension(100,24));
	    typeMembre.setPreferredSize(new Dimension(100,24));
	    
	    zoneCentre.add(pseudoLabel);
	    zoneCentre.add(pseudoChamp);
	    zoneCentre.add(passwordLabel);
	    zoneCentre.add(passwordChamp);
	    zoneCentre.add(membreLabel);
	    zoneCentre.add(typeMembre);
	    
	    
	    /*
	     * On ajoute la liste des pseudos des membres inscrits
	     * 
	     * TODO
	     * 
	     * **/
	    
	    jl = new JList(model);
	    zoneCentre.add(jl);
	    
	    
	    /**
	     * On cr�e une zone sud qui va contenir le bouton pour se connecter ou pour cr�er un compte
	     * */
	    JPanel zoneSud = new JPanel();
	    zoneSud.add(boutonConnexion);
	    zoneSud.add(creerCompte);
	    zoneSud.add(actualiser);
	    zoneSud.add(bannirMembre);
	    
	    this.getContentPane().add(zoneCentre, BorderLayout.CENTER);
	    this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
	    this.setVisible(true);
	    boutonConnexion.addActionListener(this);
	    creerCompte.addActionListener(this);
	    actualiser.addActionListener(this);
	    bannirMembre.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println(this.s.getListeInscrit());
		
		//Si on a appuy� sur le bouton de connexion.
		if(e.getSource() == boutonConnexion){
			
			//On appelle la m�thode seConnecter du membre
			if(this.s.seConnecter(pseudoChamp.getText(), passwordChamp.getText()) != null){
				Membre m = this.s.seConnecter(pseudoChamp.getText(), passwordChamp.getText()); //On r�cup�re le membre (on s'est assur� avant d'un r�sultat non null on peut donc manipuler sans crainte)
				FenetreMembreConnecte fmc = new FenetreMembreConnecte(m); //On ouvre une fen�tre pour le membre qui se co
				m.setFenetreMembre(fmc);
				s.connecterUnMembre(m); //On inscrit le membre � la liste des connect�s
			
			}
			
			else{
				//Message d'erreur si la connexion n'est pas valide
				JOptionPane.showMessageDialog(this, 
				         "Identifiant ou mot de passe incorrect",
				         "Erreur saisi",
				         JOptionPane.ERROR_MESSAGE);
				
			}
			actualiserListeMembre();
		}
		
		
		if(e.getSource() == creerCompte){
			
			FabriqueMembre fm = FabriqueMembre.getInstance();
			
			//Si valeur à 1 le membre est un certifié
			//Si valeur à 2 le membres est admin
			//Sinon on crée un membre
			if(typeMembre.getText().equals("1")) {
				fm.getMembre("1", pseudoChamp.getText(), passwordChamp.getText(), s);
			}
			else if(typeMembre.getText().equals("2")) {
				fm.getMembre("2", pseudoChamp.getText(), passwordChamp.getText(), s);
			}
			else{
				fm.getMembre("Administrateur", pseudoChamp.getText(), passwordChamp.getText(), s);
			}
			
			actualiserListeMembre();
		}
		
		if(e.getSource() == actualiser){
			actualiserListeMembre();
		}
		
		if(e.getSource() == bannirMembre){
			//Récupérer avec le pseudo un membre
			//Membre m = this.s.seConnecter(pseudoChamp.getText(), passwordChamp.getText());
			for(int i=0; i<s.getListeInscrit().size(); i++){
				if(s.getListeInscrit().get(i).getPseudo().equals(pseudoChamp.getText())){
					Membre m = s.getListeInscrit().get(i);
					s.bannirUnMembre(m);
				}  
			}
			actualiserListeMembre();
		}
	}
	
	
	private void actualiserListeMembre() {
		model.removeAllElements();
		for(int i=0;i<s.getListeInscrit().size();i++){
	    	model.add(i, s.getListeInscrit().get(i).getPseudo() + "(" +s.getListeInscrit().get(i).getClass().getSimpleName() + ")");
	    }
	}

}
