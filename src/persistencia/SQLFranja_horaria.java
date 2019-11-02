package persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Campaña;
import negocio.Franja_horaria;

public class SQLFranja_horaria {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLFranja_horaria (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCampaña(PersistenceManager pm,  long id, SimpleDateFormat inicio, SimpleDateFormat fin) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaFranja_horaria() +  "(id, inicio, fin) values (?,?,?)");
		q.setParameters(id, inicio, fin);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarFranja_horaria(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaFranja_horaria() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Franja_horaria darFranja_horariaPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaFranja_horaria() + " WHERE id = ?");
		q.setResultClass(Franja_horaria.class);
		q.setParameters(id);
		return (Franja_horaria) q.executeUnique();		
	}
	
	
	public List<Franja_horaria> darFranja_horarias(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaFranja_horaria() );
		q.setParameters(Franja_horaria.class);
		return (List<Franja_horaria>) q.executeUnique();		
	}
}
