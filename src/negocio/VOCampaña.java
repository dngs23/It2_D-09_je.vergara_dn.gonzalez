package negocio;

import java.util.Date;

public interface VOCampaña {
	public String getNombre();
	public int getCantidadEsperada();
	public int getCantidadMinima();
	public Date getFechaInicial();
	public Date getFechaFinal();
}
