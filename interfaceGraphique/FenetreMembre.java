package interfaceGraphique;

import java.awt.BorderLayout;
import Application.Membre;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FenetreMembre extends JFrame implements ActionListener {
	
	/**
	 * 
	 * Classe qui permet de générer l'affichage graphique d'un membre
	 * 
	 * */
	
	public FenetreMembre(Membre m){
		this.setTitle("Fenêtre de : " + m.getPseudo());
	    this.setSize(700, 500);
	    this.setLocationRelativeTo(null);  
	    this.setLayout(new BorderLayout());
		// TODO Auto-generated constructor stub
	    
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
