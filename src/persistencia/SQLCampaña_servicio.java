package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campa�a;
import negocio.Campa�a_servicio;

public class SQLCampa�a_servicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCampa�a_servicio (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	public long adicionarCampa�a_servicio(PersistenceManager pm, long id, String campa�a, long servicio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampa�a_servicio() +  "(id, campa�a, servicio) values (?,?,?)");
		q.setParameters(id,campa�a,servicio);
		return (long) q.executeUnique();	
	}
	public long eliminarCampa�_servicio(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampa�a_servicio() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
	public Campa�a_servicio darCampa�a_servicioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampa�a_servicio() + " WHERE id = ?");
		q.setResultClass(Campa�a_servicio.class);
		q.setParameters(id);
		return (Campa�a_servicio) q.executeUnique();	
	}
	public List<Campa�a_servicio> darCampa�as(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampa�a_servicio() );
		q.setParameters(Campa�a_servicio.class);
		return (List<Campa�a_servicio>) q.executeUnique();	
	}
}
