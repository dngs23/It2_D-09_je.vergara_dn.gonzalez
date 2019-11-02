package negocio;

public class Orden implements VOOrden{
	
	private long id;
	
	private long idAfiliado;
	
	private long idMedico;
	
	private long idServicio;
	
	private long idIps;
	
	private int sesiones;
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
	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado=idAfiliado;
	}

	@Override
	public long getIdMedico() {
		// TODO Auto-generated method stub
		return idMedico;
	}
	public void setIdMedico(long idMedico) {
		this.idMedico=idMedico;
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
	public long getIdIps() {
		// TODO Auto-generated method stub
		return idIps;
	}
	public void setIdIps(long idIps) {
		this.idIps=idIps;
	}

	@Override
	public int getSesiones() {
		// TODO Auto-generated method stub
		return sesiones;
	}
	public void setSesiones(int sesiones) {
		this.sesiones=sesiones;
	}

}
