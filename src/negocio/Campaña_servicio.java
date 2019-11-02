package negocio;

public class Campaña_servicio implements VOCampaña_servicio{
	private long id;
	private String campaña;
	private  long servicio;
	public Campaña_servicio() {
		id=0;
		campaña="";
		servicio=0;
	}
	public Campaña_servicio(long id, String campaña, long servicio) {
		this.id=id;
		this.campaña=campaña;
		this.servicio=servicio;
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
	public String getCampaña() {
		// TODO Auto-generated method stub
		return campaña;
	}
	public void setCampaña(String campaña) {
		this.campaña=campaña;
	}

	@Override
	public long getIdServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}
	public void setIdServicio(long servicio) {
		this.servicio=servicio;
	}

}
