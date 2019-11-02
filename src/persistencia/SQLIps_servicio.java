package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Ips_servicio;

public class SQLIps_servicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLIps_servicio (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarIps_servicio(PersistenceManager pm,  long id, String ips, long servicio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIps_servicio() +  "(id, ips, servicio) values (?,?,?)");
		q.setParameters(id, ips, servicio);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarIps_servicio(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIps_servicio() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Ips_servicio darIps_servicioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps_servicio() + " WHERE id = ?");
		q.setResultClass(Ips_servicio.class);
		q.setParameters(id);
		return (Ips_servicio) q.executeUnique();		
	}
	
	
	public List<Ips_servicio> darIps_servicios(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps_servicio() );
		q.setParameters(Ips_servicio.class);
		return (List<Ips_servicio>) q.executeUnique();		
	}
}
