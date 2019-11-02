package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Orden;
import negocio.Usuario;

public class SQLUsuario {
	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes pp;

	
	public SQLUsuario (PersistenciaEPSAndes pp)
	{
		this.pp = pp;
	}
	
	
	public long adicionarUsuario(PersistenceManager pm,  long id, int tipodoc, long nodoc, String nombre, Date fechanacimiento, String correo, int tipo) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario() +  "(id, tipodoc, nodoc, nombre, fechanacimiento, correo, tipo) values (?,?,?,?,?,?,?)");
		q.setParameters(id, tipodoc, nodoc, nombre, fechanacimiento, correo, tipo);
		return (long) q.executeUnique();		
	}
	
	
	public long eliminarUsuario(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario() + " WHERE id = ?");
		q.setParameters(id);
		return (long) q.executeUnique();		
	}
	
	
	public Usuario darUsuarioPorId(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(id);
		return (Usuario) q.executeUnique();		
	}
	
	
	public List<Usuario> darOrdenes(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario() );
		q.setParameters(Usuario.class);
		return (List<Usuario>) q.executeUnique();		
	}
}
