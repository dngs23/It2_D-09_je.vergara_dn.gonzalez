package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Ips;

public class SQLIps {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLIps (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarIps(PersistenceManager pm,  String nombre, int capacidad_diaria) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaIps() +  "(nombre, capacidad_diaria) values (?,?)");
		q.setParameters(nombre, capacidad_diaria);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarIps(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaIps() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();		
	}
	
	
	public Ips darIpsPorId(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps() + " WHERE nombre = ?");
		q.setResultClass(Ips.class);
		q.setParameters(nombre);
		return (Ips) q.executeUnique();		
	}
	
	
	public List<Ips> darCampañas(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaIps() );
		q.setParameters(Campaña.class);
		return (List<Ips>) q.executeUnique();		
	}
}
