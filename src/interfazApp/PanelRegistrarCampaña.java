package interfazApp;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DateTimePicker;

public class PanelRegistrarCampaña extends JPanel implements ActionListener{
	
	private JButton agregar;
	private JTextField nombre;
	private JTextField empresa;
	private JTextField numE;
	private DateTimePicker inicio;
	private DateTimePicker fin;
	private GridLayout lt;
	private GridBagConstraints cts;
	
	public PanelRegistrarCampaña()
	{
		
		setBackground(Color.white);
		agregar = new JButton("+");
		agregar.setActionCommand("agregar");
		agregar.addActionListener(this);
		
		
		lt = new GridLayout(11,2);
		setLayout(lt);
		cts = new GridBagConstraints();

		nombre = new JTextField();
		empresa = new JTextField();
		numE = new JTextField();
		inicio = new DateTimePicker();
		fin = new DateTimePicker();
		String[] servs = {"Consulta", "Examen"};
		JComboBox menucito = new JComboBox(servs);

		cts.gridx = 0;
		cts.gridy = 0;
		add(new JLabel("    Registrar nueva campaña"), cts);
		cts.gridx = 1;
		cts.gridy = 0;
		add(new JLabel(), cts);
		cts.gridx = 0;
		cts.gridy = 1;
		add(new JLabel("    Nombre: "), cts);
		cts.gridx = 1;
		cts.gridy = 1;
		add(nombre, cts);
		cts.gridx = 0;
		cts.gridy = 2;
		add(new JLabel("    Empresa: "), cts);
		cts.gridx = 1;
		cts.gridy = 2;
		add(empresa, cts);
		cts.gridx = 0;
		cts.gridy = 3;
		add(new JLabel("    Número de participantes esperados: "), cts);
		cts.gridx = 1;
		cts.gridy = 3;
		add(numE, cts);
		cts.gridx = 0;
		cts.gridy = 4;
		add(new JLabel("    Fecha inicio: "), cts);
		cts.gridx = 1;
		cts.gridy = 4;
		add(inicio, cts);
		cts.gridx = 0;
		cts.gridy = 5;
		add(new JLabel("    Fecha fin: "), cts);
		cts.gridx = 1;
		cts.gridy = 5;
		add(fin, cts);

		cts.gridx = 0;
		cts.gridy = 6;
		add(new JLabel("    Servicios"), cts);
		cts.gridx = 1;
		cts.gridy = 6;
		add(new JLabel(), cts);
		cts.gridx = 0;
		cts.gridy = 7;
		add(new JLabel("                   Tipo: "), cts);
		cts.gridx = 1;
		cts.gridy = 7;
		add(menucito, cts);
		cts.gridx = 0;
		cts.gridy = 8;
		add(new JLabel("                   Nombre: "), cts);
		cts.gridx = 1;
		cts.gridy = 8;
		add(new JTextField(), cts);
		cts.gridx = 0;
		cts.gridy = 9;
		add(new JLabel("                   Cantidad: "), cts);
		cts.gridx = 1;
		cts.gridy = 9;
		add(new JTextField(), cts);
		cts.gridx = 0;
		cts.gridy = 10;
		add(new JLabel(), cts);
		cts.gridx = 1;
		cts.gridy = 10;
		add(agregar, cts);
	}
	
	public void agregarServicio()
	{
		String[] servs = {"Consulta", "Examen"};
		JComboBox menucito = new JComboBox(servs);
		lt.setRows(lt.getRows()+2);
		
		cts.gridx = 0;
		cts.gridy =lt.getRows()-3;
		add(new JLabel("                   Tipo: "), cts);
		cts.gridx = 1;
		cts.gridy = lt.getRows()-3;
		add(menucito, cts);
		cts.gridx = 0;
		cts.gridy = lt.getRows()-2;
		add(new JLabel("                   Nombre: "), cts);
		cts.gridx = 1;
		cts.gridy = lt.getRows()-2;
		add(new JTextField(), cts);
		cts.gridx = 0;
		cts.gridy = lt.getRows()-1;
		add(new JLabel(), cts);
		cts.gridx = 1;
		cts.gridy = lt.getRows()-1;
		add(agregar, cts);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String evento = arg0.getActionCommand();
		if(evento.equals("agregar"))
			agregarServicio();
		
	}

}
