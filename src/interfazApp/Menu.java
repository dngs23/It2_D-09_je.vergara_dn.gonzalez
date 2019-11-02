package interfazApp;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Menu extends JMenuBar implements ActionListener, MenuListener{

	private JMenu afiliados;

	private JMenu campa�as;

	private JMenu personal;

	private EPSAndesInterfaz principal;
	
	private JDialog dialogo;

	public Menu(EPSAndesInterfaz interfaz)
	{
		principal = interfaz;

		afiliados = new JMenu("Afiliados");
		afiliados.addMenuListener(this);
		afiliados.setMnemonic('A');
		add(afiliados);


		campa�as = new JMenu("Campa�as");
		add(campa�as);

		personal = new JMenu("Personal");
		add(personal);

		/**
		 * Agrega los items al JMenu del personal de la eps
		 */
		JMenuItem medico = new JMenuItem("M�dico");
		medico.addActionListener(this);
		medico.setActionCommand("M�dico");

		JMenuItem recepcionista = new JMenuItem("Recepcionista");
		recepcionista.setActionCommand("Recepcionista");
		recepcionista.addActionListener(this);

		JMenuItem admin = new JMenuItem("Administrador de datos");
		admin.addActionListener(this);
		admin.setActionCommand("Administrador");

		JMenuItem gerente = new JMenuItem("Gerente");
		gerente.addActionListener(this);
		gerente.setActionCommand("Gerente");

		personal.add(medico);
		personal.add(recepcionista);
		personal.add(admin);
		personal.add(gerente);

		for(int i=0; i<personal.getItemCount();i++)
			personal.getItem(i).setBackground(Color.WHITE);

		/**
		 * Agrega los items al JMenu de las campa�as que trabajan con la eps
		 */
		JMenuItem org = new JMenuItem("Soy organizador");
		org.addActionListener(this);
		org.setActionCommand("Organizador Campa�a");

		JMenuItem afi = new JMenuItem("Soy afiliado");
		afi.setActionCommand("Afiliado");
		afi.addActionListener(this);

		campa�as.add(org);
		campa�as.add(afi);

		for(int i=0; i<campa�as.getItemCount();i++)
			campa�as.getItem(i).setBackground(Color.WHITE);

		applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(700,25));

	}

	/**
	 * 
	 */
	public void iniciarSesion(String rolUsuario)
	{
		JTextField correo = new JTextField();
		JTextField con = new JTextField();
		JButton registrar = new JButton("�a�n no te has registrado?");
		registrar.setBackground(Color.white);
		registrar.addActionListener(this);
		registrar.setActionCommand("registrar");
		registrar.setBorder(null);

		Object[] message = {
				"Correo: ", correo, "Contrase�a: ", con, null };
		if(rolUsuario.equals("Organizador Campa�a"))
		{
			message[4] = registrar;
		}

		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);
		UIManager.put("Button.background", Color.white);
		JOptionPane pane = new JOptionPane();
		pane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		pane.setMessage(message);
		pane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		dialogo = pane.createDialog(principal,"Iniciar sesi�n " + rolUsuario);
		dialogo.setVisible(true);

	}

	public void registrarUsuario()
	{
		dialogo.setVisible(false);
		JTextField nombre = new JTextField();
		JTextField correo = new JTextField();
		JTextField numI = new JTextField();
		JTextField tipoI = new JTextField();
		JTextField con = new JTextField();

		Object[] message = { "Nombre: ", nombre,"Tipo de Identificaci�n: ",tipoI ,"N�mero de Identificaci�n: ", numI, "Correo: ", correo, "Contrase�a: ", con};
		
		int option = JOptionPane.showConfirmDialog(principal,message, "Registrar cuenta", JOptionPane.OK_CANCEL_OPTION);
		if(option == JOptionPane.OK_OPTION)
		{
			//TODO registrar organizador
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() =="registrar") {
			registrarUsuario();
		}
		else
			iniciarSesion(arg0.getActionCommand());
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {

	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		iniciarSesion("Afiliado");

	}

}
