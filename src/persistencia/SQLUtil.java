package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLUtil {


	private final static String SQL = PersistenciaEPSAndes.SQL;

	private PersistenciaEPSAndes ep;


	public SQLUtil (PersistenciaEPSAndes pp)
	{
		ep = pp;
	}
	

	public long nextval (PersistenceManager pm)
	{
		
        Query q = pm.newQuery(SQL, "SELECT "+ ep.darSeqEPSAndes() + ".nextval FROM DUAL");
        
        q.setResultClass(Long.class);
        
        long resp = (long) q.executeUnique();
        System.out.println("Hasta aquí");
        return resp;
	}

}
