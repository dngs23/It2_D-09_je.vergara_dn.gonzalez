package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Orden;
import negocio.Recepcionista;

public class SQLRecepcionista {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLRecepcionista (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarRecepcionista(PersistenceManager pm,  long id,  String ips) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRecepcionista() +  "(id, ips) values (?,?)");
		q.setParameters(id,  ips);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarRecepcionista(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRecepcionista() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Recepcionista darRecepcionistaPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRecepcionista() + " WHERE id = ?");
		q.setResultClass(Recepcionista.class);
		q.setParameters(id);
		return (Recepcionista) q.executeUnique();		
	}
	
	
	public List<Recepcionista> darRecepcionistas(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRecepcionista() );
		q.setParameters(Recepcionista.class);
		return (List<Recepcionista>) q.executeUnique();		
	}
}
