package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.DisponibilidadServicio;

public class SQLDisponibilidad_servicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLDisponibilidad_servicio (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarDisponibilidad_servicio(PersistenceManager pm,  long id, long servicio, long franja, int ocupado, long afiliado_reservando) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaDisponibilidad_servicio() +  "(id, servicio, franja, ocupado, afiliado_reservando) values (?,?,?,?,?)");
		q.setParameters(id, servicio, franja, ocupado, afiliado_reservando);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarDisponibilidad_servicio(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDisponibilidad_servicio() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Campaña darDisponibilidad_servicioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDisponibilidad_servicio() + " WHERE id = ?");
		q.setResultClass(Campaña.class);
		q.setParameters(id);
		return (Campaña) q.executeUnique();		
	}
	
	
	public List<DisponibilidadServicio> darDisponibilidad_servicios(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDisponibilidad_servicio() );
		q.setParameters(DisponibilidadServicio.class);
		return (List<DisponibilidadServicio>) q.executeUnique();		
	}
}
