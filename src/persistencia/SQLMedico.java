package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Medico;

public class SQLMedico {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLMedico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarMedico(PersistenceManager pm,  long id, long noregistro) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaMedico() +  "(id, noregistro) values (?,?)");
		q.setParameters(id, noregistro);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarMedico(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaMedico() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Medico darMedicoPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() + " WHERE id = ?");
		q.setResultClass(Medico.class);
		q.setParameters(id);
		return (Medico) q.executeUnique();		
	}
	
	
	public List<Medico> darMedicos(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaMedico() );
		q.setParameters(Medico.class);
		return (List<Medico>) q.executeUnique();		
	}
}
