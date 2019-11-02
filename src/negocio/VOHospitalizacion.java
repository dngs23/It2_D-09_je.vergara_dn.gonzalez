package negocio;

import java.util.Date;

public interface VOHospitalizacion {
	public long getId();
	public long getServicio();
	public String getIps();
	public long getAfiliado();
	public Date getInic();
	public Date getFin();
}
