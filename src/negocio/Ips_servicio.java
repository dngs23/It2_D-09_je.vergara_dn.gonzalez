package negocio;

public class Ips_servicio implements VOIps_servicio{
	
	private long id;
	
	private long idServicio;
	
	private String idIps;
	
	public Ips_servicio() {
		this.id=0;
		this.idServicio=0;
		this.idIps="";
	}
	public Ips_servicio(long id, long idServicio, String idIps) {
		this.id=id;
		this.idServicio=idServicio;
		this.idIps=idIps;
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
	public long getIdServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}
	public void setIdServicio(long idServicio) {
		this.idServicio=idServicio;
	}

	@Override
	public String getIdIps() {
		// TODO Auto-generated method stub
		return idIps;
	}
	public void setIdIps(String idIps) {
		this.idIps=idIps;
	}

}
