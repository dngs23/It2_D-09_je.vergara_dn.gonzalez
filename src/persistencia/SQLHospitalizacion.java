package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Hospitalizacion;

public class SQLHospitalizacion {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLHospitalizacion (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarHospitalizacion(PersistenceManager pm,  long id, long servicio, long afiliado, String ips, Date inicio, Date fin) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaHospitalizacion() +  "(id, servicio, afiliado, ips, inicio, fin) values (?,?,?,?,?,?)");
		q.setParameters(id, servicio, afiliado, ips, inicio, fin);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarHospitalizacion(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHospitalizacion() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Hospitalizacion darHospitalizacionPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHospitalizacion() + " WHERE id = ?");
		q.setResultClass(Hospitalizacion.class);
		q.setParameters(id);
		return (Hospitalizacion) q.executeUnique();		
	}
	
	
	public List<Hospitalizacion> darCampañas(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña() );
		q.setParameters(Hospitalizacion.class);
		return (List<Hospitalizacion>) q.executeUnique();		
	}
}
