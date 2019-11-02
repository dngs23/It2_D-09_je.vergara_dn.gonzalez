package interfazApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import negocio.EPSAndes;
import negocio.VOIps;

public class EPSAndesInterfaz extends JFrame implements ActionListener{

	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecuci�n
	 */
	private static Logger log = Logger.getLogger(EPSAndesInterfaz.class.getName());

	/**
	 * Ruta al archivo de configuraci�n de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./resources/config/TablasBD_A.json"; 


	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
	 */
	private JsonObject tableConfig;

	private EPSAndes epsandes;
	
	/**
	 * Menu bar de la aplicaci�n
	 */
	private Menu menu;
	
	private PanelAdministrador panelAdmin;
	
	private PanelAfiliado panelAfiliado;
	
	private PanelOrganizador panelOrg;

	private JPanel panelBoton;
	private JButton botonAgregar;

	public EPSAndesInterfaz()
	{
		BasicConfigurator.configure();
		
		panelAdmin = new PanelAdministrador();
		panelAfiliado = new PanelAfiliado();
		panelOrg = new PanelOrganizador(this);

		tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
		epsandes = new EPSAndes(tableConfig);

		setLayout (new BorderLayout());
		setSize(1050,1000);
		
		menu = new Menu(this);

		panelBoton = new JPanel();
		botonAgregar = new JButton("Agregar Ips");
		botonAgregar.setActionCommand("a");
		botonAgregar.addActionListener(this);

		panelBoton.add(new JLabel("EPSAndes"));
		panelBoton.add(botonAgregar);

		add(panelBoton, BorderLayout.NORTH);
		
		
//////Esto aqu� son paneles para los usuarios
		
//		add(panelAdmin, BorderLayout.CENTER);
//		panelAdmin.setVisible(false);
		
//		add(panelAfiliado, BorderLayout.CENTER);
//		panelAfiliado.setVisible(false);
		
//		add(panelOrg, BorderLayout.CENTER);
//		panelOrg.setVisible(false);

	}

	public static void main(String[] args0)
	{
		try {
			(new EPSAndesInterfaz()).setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Adiciona una IPS con la informaci�n dada por el usuario
	 * Se crea una nueva tupla de IPS en la base de datos
	 */
	public void adicionarIps( )
	{
		try 
		{
			JTextField nombreIps = new JTextField();
			JTextField loc = new JTextField();

			Object[] message = {
					"nombre de la Ips: ", nombreIps, "Localizaci�n: ", loc };

			int option = JOptionPane.showConfirmDialog(this,message, "Agregar Ips", JOptionPane.OK_CANCEL_OPTION);
			if(option == JOptionPane.OK_OPTION) {
				System.out.println("||||||||||||||||||||| hundi� OK");
				if (nombreIps.getText() != null)
				{
					VOIps tb = epsandes.agregarIps(nombreIps.getText(), loc.getText());
					String resultado = "|||||||||||||||||||||| En adicionar Ips \n\n";
					resultado += "Ips agregada exitosamente: " + tb;
					resultado += "\n Operaci�n terminada";
					System.out.println(resultado);
//				panelDatos.actualizarInterfaz(resultado);
				}
			}
			else
			{
				//  			panelDatos.actualizarInterfaz("Operaci�n cancelada por el usuario");
			}
		} 
		catch (Exception e) 
		{
			//			e.printStackTrace();
			//			String resultado = generarMensajeError(e);
			//			panelDatos.actualizarInterfaz(resultado);
		}
	}


	/* ****************************************************************
	 * 			M�todos de configuraci�n de la interfaz
	 *****************************************************************/
	/**
	 * Lee datos de configuraci�n para la aplicaci�n, a partir de un archivo JSON o con valores por defecto si hay errores.
	 * @param tipo - El tipo de configuraci�n deseada
	 * @param archConfig - Archivo Json que contiene la configuraci�n
	 * @return Un objeto JSON con la configuraci�n del tipo especificado
	 * 			NULL si hay un error en el archivo.
	 */
	private JsonObject openConfig (String tipo, String archConfig)
	{
		JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			//			log.info ("Se encontr� un archivo de configuraci�n v�lido: " + tipo);
		} 
		catch (Exception e)
		{
			//			e.printStackTrace ();
			//			log.info ("NO se encontr� un archivo de configuraci�n v�lido");			
			JOptionPane.showMessageDialog(null, "No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
		return config;
	}

	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String evento = pEvento.getActionCommand( );		
		try 
		{
			if(evento.equals("a"))
			{
				adicionarIps( );
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 

	}

}
