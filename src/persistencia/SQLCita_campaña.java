package persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Cita_campaña;

public class SQLCita_campaña {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCita_campaña (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCita_campaña(PersistenceManager pm,  long id, long cita, String campaña, String sitio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCita_campaña() +  "(id, cita, campaña, sitio) values (?,?,?,?)");
		q.setParameters(id,cita,campaña, sitio);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarCita_campaña(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCita_campaña() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Cita_campaña darCita_campañaPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita_campaña() + " WHERE id = ?");
		q.setResultClass(Campaña.class);
		q.setParameters(id);
		return (Cita_campaña) q.executeUnique();		
	}
	
	
	public List<Cita_campaña> darCita_campaña(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita_campaña() );
		q.setParameters(Campaña.class);
		return (List<Cita_campaña>) q.executeUnique();		
	}
}
