package interfazApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAdministrador extends JPanel{
	
	
	private JButton regMedico;
	
	private JButton regUsuario;
	
	private JButton regRecp;
	
	private JButton regGerente;
	
	private JButton deshabServicios;
	
	private JButton rehabServicios;
	
	public PanelAdministrador()
	{
		setLayout (new GridBagLayout());
		
		regMedico = new JButton("registrar médico");
		regMedico.setPreferredSize(new Dimension(200,200));
		
		regUsuario = new JButton("Registrar usuario");
		regUsuario.setPreferredSize(new Dimension(200,200));
		
		regRecp = new JButton("Registrar recepcionista");
		regRecp.setPreferredSize(new Dimension(200,200));
		
		regGerente = new JButton("Registrar gerente");
		regGerente.setPreferredSize(new Dimension(200,200));
		
		deshabServicios = new JButton("Deshabilitar servicios");
		deshabServicios.setPreferredSize(new Dimension(200,200));
		
		rehabServicios = new JButton("Rehabilitar servicios");
		rehabServicios.setPreferredSize(new Dimension(200,200));
		
		GridBagConstraints cts = new GridBagConstraints();
		setBackground(Color.white);
		
		cts.weighty = 1.0;
		cts.weightx = 1.0; 
		
		cts.gridx = 0;
		cts.gridy = 0;
		add(deshabServicios, cts);
		
		cts.gridx = 1;
		cts.gridy = 0;
		add(regMedico, cts);
		
		cts.gridx = 2;
		cts.gridy = 0;
		add(regUsuario, cts);
		
		cts.gridx = 0;
		cts.gridy = 1;
		add(rehabServicios,cts);
		
		cts.gridx = 1;
		cts.gridy = 1;
		add(regRecp, cts);
		
		cts.gridx = 2;
		cts.gridy = 1;
		add(regGerente, cts);
		

	}

}
