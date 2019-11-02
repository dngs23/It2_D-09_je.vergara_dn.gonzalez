package negocio;

public class Cita implements VOCitas{
	private long id;
	
	private long idAfiliado;
	
	private long idMedico;
	
	private long idServicio;
	
	private String idIps;
	
	private long franja;
	
	private int ocupado;
	
	public Cita() {
		this.id=0;
		this.idAfiliado=0;
		this.idMedico=0;
		this.idServicio=0;
		this.idIps="";
		this.ocupado=0;
	}
	public Cita(long id, long idAfiliado, long idMedico, long idServicio, String idIps, int ocupado) {
		this.id=id;
		this.idAfiliado=idAfiliado;
		this.idMedico=idMedico;
		this.idServicio=idServicio;
		this.idIps=idIps;
		this.ocupado=ocupado;
	}
	public int getOcupado() {
		return ocupado;
	}
	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
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
	public long getIdAfiliado() {
		// TODO Auto-generated method stub
		return idAfiliado;
	}
	public void setIdAfiliado(long id) {
		this.idAfiliado=id;
	}

	@Override
	public long getIdMedico() {
		// TODO Auto-generated method stub
		return idMedico;
	}
	public void setIdMedico(long id) {
		this.idMedico=id;
	}

	@Override
	public long getIdServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}
	public void setIdServicio(long id) {
		this.idServicio=id;
	}

	@Override
	public String getIdIps() {
		// TODO Auto-generated method stub
		return idIps;
	}
	public void setIdIps(String id) {
		this.idIps=id;
	}

	@Override
	public long getFranja() {
		// TODO Auto-generated method stub
		return franja;
	}
	public void setFranja(long id) {
		this.franja=id;
	}

}
