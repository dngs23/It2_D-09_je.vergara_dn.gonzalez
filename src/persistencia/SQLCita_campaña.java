package persistencia;


import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campa�a;
import negocio.Cita_campa�a;

public class SQLCita_campa�a {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCita_campa�a (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCita_campa�a(PersistenceManager pm,  long id, long cita, String campa�a, String sitio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCita_campa�a() +  "(id, cita, campa�a, sitio) values (?,?,?,?)");
		q.setParameters(id,cita,campa�a, sitio);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarCita_campa�a(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCita_campa�a() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Cita_campa�a darCita_campa�aPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita_campa�a() + " WHERE id = ?");
		q.setResultClass(Campa�a.class);
		q.setParameters(id);
		return (Cita_campa�a) q.executeUnique();		
	}
	
	
	public List<Cita_campa�a> darCita_campa�a(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCita_campa�a() );
		q.setParameters(Campa�a.class);
		return (List<Cita_campa�a>) q.executeUnique();		
	}
}
