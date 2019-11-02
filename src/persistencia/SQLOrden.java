package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Medico;
import negocio.Orden;

public class SQLOrden {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLOrden (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarOrden(PersistenceManager pm,  long id, long afiliado, long medico, long servicio, String ips, int sesiones) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOrden() +  "(id, afiliado, medico, servicio, ips, sesiones) values (?,?,?,?,?,?)");
		q.setParameters(id, afiliado, medico, servicio, ips, sesiones);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarOrden(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaOrden() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Orden darOrdenPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrden() + " WHERE id = ?");
		q.setResultClass(Orden.class);
		q.setParameters(id);
		return (Orden) q.executeUnique();		
	}
	
	
	public List<Orden> darOrdenes(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOrden() );
		q.setParameters(Orden.class);
		return (List<Orden>) q.executeUnique();		
	}
}
