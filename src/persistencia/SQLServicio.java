package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import negocio.Servicio;

public class SQLServicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLServicio (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicio(PersistenceManager pm,  long id, String info, int capacidad) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio() +  "(id, info, capacidad) values (?,?,?)");
		q.setParameters(id, info, capacidad);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarServicio(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Servicio darServicioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() + " WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(id);
		return (Servicio) q.executeUnique();		
	}
	
	
	public List<Servicio> darServicios(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio() );
		q.setParameters(Servicio.class);
		return (List<Servicio>) q.executeUnique();		
	}
}
