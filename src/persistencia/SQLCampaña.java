package persistencia;


import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Afiliado;
import negocio.Campa�a;

public class SQLCampa�a {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLCampa�a (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarCampa�a(PersistenceManager pm,  String nombre, Date inicio, Date fin, int cantMinima, int cantEsperada) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCampa�a() +  "(nombre, cant_esperada, cant_minima, inicio, fin) values (?,?,?,?,?)");
		q.setParameters(nombre,cantEsperada,cantMinima, inicio, fin);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarCampa�a(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCampa�a() + " WHERE nombre = ?");
		q.setParameters(nombre);
		return (long) q.executeUnique();		
	}
	
	
	public Campa�a darCampa�aPorId(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampa�a() + " WHERE nombre = ?");
		q.setResultClass(Campa�a.class);
		q.setParameters(nombre);
		return (Campa�a) q.executeUnique();		
	}
	
	
	public List<Campa�a> darCampa�as(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCampa�a() );
		q.setParameters(Campa�a.class);
		return (List<Campa�a>) q.executeUnique();		
	}
}
