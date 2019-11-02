package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Campaña_servicio;

public class SQLCampaña_servicio {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCampaña_servicio (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	public long adicionarCampaña_servicio(PersistenceManager pm, long id, String campaña, long servicio) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampaña_servicio() +  "(id, campaña, servicio) values (?,?,?)");
		q.setParameters(id,campaña,servicio);
		return (long) q.executeUnique();	
	}
	public long eliminarCampañ_servicio(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampaña_servicio() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();
	}
	public Campaña_servicio darCampaña_servicioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña_servicio() + " WHERE id = ?");
		q.setResultClass(Campaña_servicio.class);
		q.setParameters(id);
		return (Campaña_servicio) q.executeUnique();	
	}
	public List<Campaña_servicio> darCampañas(PersistenceManager pm){
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampaña_servicio() );
		q.setParameters(Campaña_servicio.class);
		return (List<Campaña_servicio>) q.executeUnique();	
	}
}
