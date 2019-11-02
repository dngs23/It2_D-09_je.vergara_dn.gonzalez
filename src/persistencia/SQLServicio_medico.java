package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Orden;
import negocio.Servicio_medico;

public class SQLServicio_medico {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLServicio_medico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarServicio_medico(PersistenceManager pm,  long id, long servicio, long medico) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaServicio_medico() +  "(id, servicio, medico) values (?,?,?,?,?,?)");
		q.setParameters(id, servicio, medico);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarServicio_medico(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio_medico() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Servicio_medico darServicio_medicoPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio_medico() + " WHERE id = ?");
		q.setResultClass(Servicio_medico.class);
		q.setParameters(id);
		return (Servicio_medico) q.executeUnique();		
	}
	
	
	public List<Servicio_medico> darServicio_medicos(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicio_medico() );
		q.setParameters(Servicio_medico.class);
		return (List<Servicio_medico>) q.executeUnique();		
	}
}
