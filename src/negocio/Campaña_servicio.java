package negocio;

public class Campa�a_servicio implements VOCampa�a_servicio{
	private long id;
	private String campa�a;
	private  long servicio;
	public Campa�a_servicio() {
		id=0;
		campa�a="";
		servicio=0;
	}
	public Campa�a_servicio(long id, String campa�a, long servicio) {
		this.id=id;
		this.campa�a=campa�a;
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
	public String getCampa�a() {
		// TODO Auto-generated method stub
		return campa�a;
	}
	public void setCampa�a(String campa�a) {
		this.campa�a=campa�a;
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
