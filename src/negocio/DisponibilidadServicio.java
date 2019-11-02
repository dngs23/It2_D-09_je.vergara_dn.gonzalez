package negocio;

public class DisponibilidadServicio implements VODisponibilidad_Servicio{
	private long id;
	private  long idServicio;
	private long idFranja;
	private int ocupado;
	private long afiliadoreservado;
	public DisponibilidadServicio() {
		
		this.id = 0;
		this.idServicio = 0;
		this.idFranja = 0;
		this.ocupado = 0;
		this.afiliadoreservado = 0;
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
	public long getItServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}
	public void setIdServicio(long id) {
		this.idServicio=id;
	}

	@Override
	public long getIdFranja() {
		// TODO Auto-generated method stub
		return idFranja;
	}
	public void setIdFranja(long id) {
		this.idFranja=id;
	}

	@Override
	public int getOcupado() {
		// TODO Auto-generated method stub
		return ocupado;
	}
	public void setOcupado(int ocupado) {
		this.ocupado=ocupado; 
	}

	public DisponibilidadServicio(long id, long idServicio, long idFranja, int ocupado, long afiliadoreservado) {
		
		this.id = id;
		this.idServicio = idServicio;
		this.idFranja = idFranja;
		this.ocupado = ocupado;
		this.afiliadoreservado = afiliadoreservado;
	}
	@Override
	public long getAfiliadoReservando() {
		// TODO Auto-generated method stub
		return afiliadoreservado;
	}
	public void setAfiliadoReservado(long id) {
		this.afiliadoreservado=id;
	}

}
