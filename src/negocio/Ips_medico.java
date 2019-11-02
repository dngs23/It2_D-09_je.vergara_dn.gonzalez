package negocio;

public class Ips_medico implements VOIps_medico{
	private long id;
	
	private String idIps;
	
	private long idMedico;
	
	public Ips_medico() {
		this.id=0;
		this.idIps="";
		this.idMedico=0;
	}
	public Ips_medico(long id, String idIps, long idMedico) {
		this.id=id;
		this.idIps=idIps;
		this.idMedico=idMedico;
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
	public String getIdIps() {
		// TODO Auto-generated method stub
		return idIps;
	}
	public void setIdIps(String idIps) {
		this.idIps=idIps;
	}

	@Override
	public long getIdMedico() {
		// TODO Auto-generated method stub
		return idMedico;
	}
	public void setIdMedico(long idMedico) {
		this.idMedico=idMedico;
	}

}
