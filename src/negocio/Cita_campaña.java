package negocio;

public class Cita_campaña implements VOCita_campaña{
	private long id;
	private long cita;
	private String campaña;
	private String sitio;
	public Cita_campaña() {
		this.id=0;
		this.cita=0;
		this.campaña="";
		this.sitio="";
	}
	public Cita_campaña(long id, long cita, String campaña, String sitio) {
		this.id=id;
		this.cita=cita;
		this.campaña=campaña;
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
	public String getCampaña() {
		// TODO Auto-generated method stub
		return campaña;
	}
	public void setCampaña(String campaña) {
		this.campaña=campaña;
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
