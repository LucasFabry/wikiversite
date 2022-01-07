package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;

import Application.Membre;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreMembre extends JFrame implements ActionListener {
	
	/**
	 * 
	 * Classe qui permet de générer l'affichage graphique d'un membre
	 * 
	 * */
	
	private JButton boutonConnexion = new JButton("Se connecter");
	private JButton creerCompte = new JButton("Créer un compte");
	private JTextField pseudoChamp = new JTextField("");
	private JTextField passwordChamp = new JTextField("");
	
	private Membre m;
	
	public FenetreMembre(Membre m){
		this.m = m;
		this.setTitle("Fenêtre de : " + m.getPseudo());
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
	    
	    /**
	     * On crée une zone sud qui va contenir le bouton pour se connecter ou pour créer un compte
	     * */
	    JPanel zoneSud = new JPanel();
	    zoneSud.add(boutonConnexion);
	    zoneSud.add(creerCompte);
	    
	    this.getContentPane().add(zoneCentre, BorderLayout.CENTER);
	    this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
	    this.setVisible(true);
	    boutonConnexion.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//Si on a appuyé sur le bouton de connexion.
		if(e.getSource() == boutonConnexion){
			
			//On appelle la méthode seConnecter du membre
			if(this.m.seConnecter(pseudoChamp.getText(), passwordChamp.getText())){
				FenetreMembreConnecte fmc = new FenetreMembreConnecte(this.m);
			}
			
			else{
				//Message d'erreur si la connexion n'est pas valide
				JOptionPane.showMessageDialog(this, 
				         "Identifiant ou mot de passe incorrect",
				         "Erreur saisi",
				         JOptionPane.ERROR_MESSAGE);
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
		}
	}

}
