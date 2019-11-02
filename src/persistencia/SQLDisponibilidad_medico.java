package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Disponibilidad_medico;

public class SQLDisponibilidad_medico {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLDisponibilidad_medico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarDisponibilidad_medico(PersistenceManager pm,  long id, long medico, long franja, int ocupado) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaDisponibilidad_medico() +  "(id, medico, franja, ocupado) values (?,?,?,?)");
		q.setParameters(id, medico, franja, ocupado);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarDisponibilidad_medico(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDisponibilidad_medico() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Disponibilidad_medico darDisponibilidad_medicoPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDisponibilidad_medico() + " WHERE id = ?");
		q.setResultClass(Disponibilidad_medico.class);
		q.setParameters(id);
		return (Disponibilidad_medico) q.executeUnique();		
	}
	
	
	public List<Disponibilidad_medico> darDisponibilidad_medicos(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDisponibilidad_medico() );
		q.setParameters(Disponibilidad_medico.class);
		return (List<Disponibilidad_medico>) q.executeUnique();		
	}
}
