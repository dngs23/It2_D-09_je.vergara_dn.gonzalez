package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Afiliado;

public class SQLAfiliado {
	
	private final static String SQL = PersistenciaEPSAndes.SQL;

	
	private PersistenciaEPSAndes pp;

	
	public SQLAfiliado(PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarAfiliado(PersistenceManager pm, long id) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaAfiliado() + "(id) values (?)");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarAfiliadoPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaAfiliado() + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	
	public Afiliado darAfiliadoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado() + " WHERE id = ?");
		q.setResultClass(Afiliado.class);
		q.setParameters(id);
		return (Afiliado) q.executeUnique();
	}
	
	
	
	public List<Afiliado> darAfiliados(PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaAfiliado());
		q.setResultClass(Afiliado.class);
		return (List<Afiliado>) q.executeList();
	}


}
