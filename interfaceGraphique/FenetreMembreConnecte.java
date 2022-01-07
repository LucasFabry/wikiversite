package interfaceGraphique;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Application.Membre;

public class FenetreMembreConnecte extends JFrame implements ActionListener {

	
	public FenetreMembreConnecte(Membre m){
		// TODO Auto-generated constructor stub
		this.setTitle("Fenêtre de : " + m.getPseudo());
	    this.setSize(700, 500);
	    this.setLocationRelativeTo(null);  
	    this.setLayout(new BorderLayout());
	    
	    this.setVisible(true);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
