package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Ips_medico;

public class SQLIps_medico {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLIps_medico (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarIps_medico(PersistenceManager pm,  long id, String ips, long medico) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIps_medico() +  "(id, ips, medico) values (?,?,?)");
		q.setParameters(id, ips, medico);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarIps_medico(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIps_medico() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Ips_medico darIps_medicoPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps_medico() + " WHERE id = ?");
		q.setResultClass(Ips_medico.class);
		q.setParameters(id);
		return (Ips_medico) q.executeUnique();		
	}
	
	
	public List<Ips_medico> darIps_medicos(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps_medico() );
		q.setParameters(Campaña.class);
		return (List<Ips_medico>) q.executeUnique();		
	}
}
