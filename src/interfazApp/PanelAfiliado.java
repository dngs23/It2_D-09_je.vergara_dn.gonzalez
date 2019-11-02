package interfazApp;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAfiliado extends JPanel{
	
	private JComboBox menucito;

	public PanelAfiliado()
	{
		setBackground(Color.white);
		
		String[] servs = {"Consulta", "Examen"};
		menucito = new JComboBox(servs);
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		
		JLabel titulo = new JLabel("Registrar nueva cita");
		titulo.setSize(50,300);
		
		add(titulo);
		
		add(new JLabel("Tipo:"));
		add(menucito);
		
		
		add(new JLabel("Nombre:"));
		add(new JTextField());
		
		
	}

}
