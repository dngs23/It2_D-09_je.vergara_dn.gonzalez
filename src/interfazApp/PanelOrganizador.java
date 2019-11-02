package interfazApp;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelOrganizador extends JPanel implements ActionListener{



	private PanelRegistrarCampaña panelRegistrarCamp;
	private EPSAndesInterfaz principal;
	
	

	public PanelOrganizador(EPSAndesInterfaz p)
	{
		principal = p;
		panelRegistrarCamp = new PanelRegistrarCampaña();	
		inicializarPanelCamps();
		setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(panelRegistrarCamp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 30, 300, 50);
		scrollPane.setPreferredSize(new Dimension(500,1200));
		add(scrollPane, BorderLayout.WEST);


	}


	public void inicializarPanelCamps(){

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		

	}

}
