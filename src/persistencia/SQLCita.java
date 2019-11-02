package persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import negocio.Cita;

public class SQLCita {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCita (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	public long adicionarCita(PersistenceManager pm,  long id, long afiliado, long medico, long servicio, String ips, long franja, int cumplida) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCita() +  "(id, afiliado, medico, servicio, ips, franja, cumplida) values (?,?,?,?,?,?,?)");
		q.setParameters(id, afiliado, medico, servicio, ips, franja, cumplida);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarCita(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " +  pp.darTablaCita() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Cita darCitaPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita() + " WHERE id = ?");
		q.setResultClass(Cita.class);
		q.setParameters(id);
		return (Cita) q.executeUnique();		
	}
	
	
	public List<Cita> darCampañas(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita() );
		q.setParameters(Cita.class);
		return (List<Cita>) q.executeUnique();		
	}
}
