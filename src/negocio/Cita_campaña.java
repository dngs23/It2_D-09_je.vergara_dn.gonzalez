package negocio;

public class Cita_campa�a implements VOCita_campa�a{
	private long id;
	private long cita;
	private String campa�a;
	private String sitio;
	public Cita_campa�a() {
		this.id=0;
		this.cita=0;
		this.campa�a="";
		this.sitio="";
	}
	public Cita_campa�a(long id, long cita, String campa�a, String sitio) {
		this.id=id;
		this.cita=cita;
		this.campa�a=campa�a;
		this.sitio=sitio;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public long getCita() {
		// TODO Auto-generated method stub
		return cita;
	}
	public void setCita(long id) {
		this.cita=id;
	}

	@Override
	public String getCampa�a() {
		// TODO Auto-generated method stub
		return campa�a;
	}
	public void setCampa�a(String campa�a) {
		this.campa�a=campa�a;
	}

	@Override
	public String getSitio() {
		// TODO Auto-generated method stub
		return sitio;
	}
	public void setSitio(String sitio) {
		this.sitio=sitio;
	}

}
