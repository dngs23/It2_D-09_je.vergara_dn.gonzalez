package persistencia;


import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Afiliado;
import negocio.Campaña;

public class SQLCampaña {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCampaña (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCampaña(PersistenceManager pm,  String nombre, Date inicio, Date fin, int cantMinima, int cantEsperada) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampaña() +  "(nombre, cant_esperada, cant_minima, inicio, fin) values (?,?,?,?,?)");
		q.setParameters(nombre,cantEsperada,cantMinima, inicio, fin);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarCampaña(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampaña() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();		
	}
	
	
	public Campaña darCampañaPorId(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña() + " WHERE nombre = ?");
		q.setResultClass(Campaña.class);
		q.setParameters(nombre);
		return (Campaña) q.executeUnique();		
	}
	
	
	public List<Campaña> darCampañas(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña() );
		q.setParameters(Campaña.class);
		return (List<Campaña>) q.executeUnique();		
	}
}
