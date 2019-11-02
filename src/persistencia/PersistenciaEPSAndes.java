package persistencia;

import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import negocio.Ips;
import negocio.Usuario;


public class PersistenciaEPSAndes {

	
	private static Logger log = Logger.getLogger(PersistenciaEPSAndes.class.getName());

	
	public final static String SQL = "javax.jdo.query.SQL";


	private SQLUtil sqlUtil;

	
	private PersistenceManagerFactory pmf;
	
	private static PersistenciaEPSAndes instance;

	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, Usuario, medico, afiliado, recepcionista, servicio,
	 */
	private List <String> tablasSQL;

	private SQLUsuario sqlUsuario;

	private SQLMedico sqlMedico;

	private SQLAfiliado sqlAfiliado;

	private SQLRecepcionista sqlRecepcionista;

	private SQLServicio sqlServicio;

	private SQLIps sqlIps;
	
	private SQLCampaña sqlCampaña;
	
	private SQLCampaña_servicio sqlCampaña_servicio;
	
	private SQLCita sqlCita;
	
	private SQLCita_campaña sqlCita_campaña;
	
	private SQLDisponibilidad_medico sqlDisponibilidad_medico;
	
	private SQLDisponibilidad_servicio sqlDisponibilidad_servicio;
	
	private SQLFranja_horaria sqlFranja_horaria;
	
	private SQLHospitalizacion sqlHospitalizacion;
	
	private SQLIps_medico sqlIps_medico;
	
	private SQLIps_servicio sqlIps_servicio;
	
	private SQLOrden sqlOrden;
	
	private SQLServicio_medico sqlServicio_medico;
	
	

	private PersistenciaEPSAndes()
	{
		
		pmf = JDOHelper.getPersistenceManagerFactory("EPSAndes");		
		crearClasesSQL ();

		tablasSQL = new LinkedList<String> ();

		tablasSQL.add ("USUARIO");
		tablasSQL.add("MEDICO");
		tablasSQL.add("AFILIADO");
		tablasSQL.add("RECEPCIONISTA");
		tablasSQL.add("SERVICIO");

		tablasSQL.add("IPS");
		tablasSQL.add("CITA");

		tablasSQL.add("ORDEN");
		tablasSQL.add("CAMPAÑA");
		tablasSQL.add("CAMPAÑA_SERVICIO");
		tablasSQL.add("CITA_CAMPAÑA");
		tablasSQL.add("DISPONIBILIDAD_MEDICO");
		tablasSQL.add("DISPONIBILIDAD_SERVICIO");
		tablasSQL.add("FRANJA_HORARIA");
		tablasSQL.add("HOSPITALIZACION");
		tablasSQL.add("IPS_MEDICO");
		tablasSQL.add("IPS_SERVICIO");
		tablasSQL.add("SERVICIO_MEDICO");
		sqlUtil = new SQLUtil(this);
	}
	

	private PersistenciaEPSAndes(JsonObject tableConfig)
	{

		crearClasesSQL ();
		tablasSQL = leerNombresTablas(tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo a la unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
		sqlUtil = new SQLUtil(this);
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;
		

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}

	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlUsuario = new SQLUsuario(this);
		sqlMedico = new SQLMedico(this);
		sqlAfiliado = new SQLAfiliado(this);
		sqlRecepcionista = new SQLRecepcionista(this);
//		sqlServicio = new SQLServicio(this);
//		sqlIps = new SQLIps(this);
		sqlCampaña = new SQLCampaña(this);
		sqlCampaña_servicio = new SQLCampaña_servicio(this);
		sqlCita = new SQLCita(this);
		sqlCita_campaña = new SQLCita_campaña(this);
		sqlDisponibilidad_medico = new SQLDisponibilidad_medico(this);
		sqlDisponibilidad_servicio = new SQLDisponibilidad_servicio(this);
		sqlFranja_horaria = new SQLFranja_horaria(this);
		sqlHospitalizacion = new SQLHospitalizacion(this);
		sqlIps = new SQLIps(this);
		sqlIps_medico = new SQLIps_medico(this);
		sqlIps_servicio = new SQLIps_servicio(this);
		sqlOrden = new SQLOrden(this);
		sqlServicio_medico = new SQLServicio_medico(this);
//		sqlClase = new SQLClase(this);
//		sqlCampña_cita = new SQLCampaña_cita(this);
		
	}
	
	public String darSeqEPSAndes()
	{
		return "epsandes_sequence";
	}

	public String darTablaUsuario()
	{
		return "";
	}

	public String darTablaMedico()
	{
		return tablasSQL.get(2);
	}

	public String darTablaAfiliado()
	{
		return tablasSQL.get(3);
	}

	public String darTablaRecepcionista()
	{
		return "";
	}

	public String darTablaServicio()
	{
		return tablasSQL.get(5);
	}

	public String darTablaTerapia()
	{
		return tablasSQL.get(6);
	}

	public String darTablaServicioIps()
	{
		return tablasSQL.get(7);
	}

	public String darTablaMedicoServicio()
	{
		return tablasSQL.get(8);
	}
	public String darTablaServicio_medico() {
		return "";
	}

	

	
	
	public String darTablaCampaña() 
	{
		return tablasSQL.get(13);
	}
	
	public String darTablaClase()
	{
		return tablasSQL.get(14);
	}
	
	public String darTablaCampaña_cita()
	{
		return tablasSQL.get(15);
	}
	public String darTablaCampaña_servicio() {
		return "";
	}
	public String darTablaCita() {
		return "";
	}
	public String darTablaCita_campaña() {
		return "";
	}
	public String darTablaDisponibilidad_medico() {
		return "";
	}
	public String darTablaDisponibilidad_servicio() {
		return "";
	}
	public String darTablaFranja_horaria() {
		return "";
	}
	public String darTablaHospitalizacion() {
		return "";
	}
	public String darTablaIps() {
		return "";
	}
	public String darTablaIps_medico() {
		return "";
	}
	public String darTablaIps_servicio() {
		return "";
	}
	public String darTablaOrden() {
		return "";
	}

	/**
	 * Transacción para el generador de secuencia de EPSAndes
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de EPSAndes
	 */
	private long nextval ()
	{
		long r = sqlUtil.nextval(pmf.getPersistenceManager());
		log.trace ("Generando secuencia: " + r);
		return r;
	}

	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar la tabla Ips
	 *****************************************************************/
	
	/**
	 * Método que inserta, de manera transaccional, una tupla en la tabla Ips
	 * Adiciona entradas al log de la aplicación
	 * @param nombreIps- El nombre de la ips
	 * @param loc - la localización de la ips
	 * @return Un objeto Ips con la información dada. Null si ocurre alguna Excepción
	 */
	public Ips agregarIps(String nombreIps, String loc)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("||||||||||||||||||||| perate");

            long id = nextval();
            System.out.println("||||||||||||||||||||| "+id);
            long tuplasInsertadas = sqlIps.adicionarIps(pm, nombreIps, loc);
            tx.commit();

            log.trace ("Inserción de Ips: " + nombreIps + " , " + loc +" : " + tuplasInsertadas + " tuplas insertadas");

            return new Ips(nombreIps, loc);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}

	/**
	 * @return Retorna el único objeto EPSAndesPersistence existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes();
		}
		return instance;
	}
	
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto EPSAndesPersistence existente - Patrón SINGLETON
	 */
	public static PersistenciaEPSAndes getInstance(JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaEPSAndes(tableConfig);
		}
		return instance;
	}

}
