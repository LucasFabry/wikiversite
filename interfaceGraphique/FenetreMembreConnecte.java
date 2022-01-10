package interfaceGraphique;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import Application.Membre;

public class FenetreMembreConnecte extends JFrame implements ActionListener {

	private DefaultListModel<String> listeCours = new DefaultListModel<>();
	private JButton boutonOuvrirCo = new JButton("Ouvrir un cours");
	
	public FenetreMembreConnecte(Membre m){
		// TODO Auto-generated constructor stub
		this.setTitle("Fenêtre de : " + m.getPseudo());
	    this.setSize(700, 500);
	    this.setLocationRelativeTo(null);  
	    this.setLayout(new BorderLayout());
	    this.setVisible(true);
	    
	    JPanel zoneEst = new JPanel();
	    zoneEst.add(new JList(listeCours));
	    
	    /*
	     * 
	     * Liste des cours disponibles, un simple membre ne peut que consulter la liste des cours et en ouvrir un.
	     * 
	     * **/
	    listeCours.add(0, "coursTropBien");
	    
	    
	    JPanel zoneSud = new JPanel();
	    zoneSud.add(boutonOuvrirCo);
	    
	    this.getContentPane().add(zoneSud, BorderLayout.SOUTH);
	    this.getContentPane().add(zoneEst, BorderLayout.EAST);
	    
	    boutonOuvrirCo.addActionListener(this);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == "boutonOuvrirCo"){
			
		}

	}

}
