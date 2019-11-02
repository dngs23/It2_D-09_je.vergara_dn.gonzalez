package negocio;

public class Servicio_medico implements VOServicio_medico{

	private long id;
	private long idServicio;
	private long idMedico;
	
	public Servicio_medico() {
		this.id=0;
		this.idServicio=0;
		this.idMedico=0;
	}
	public Servicio_medico(long id, long idServicio, long idMedico) {
		this.id=id;
		this.idServicio=idServicio;
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
	public long getIdServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}
	public void setIdServicio(long idServicio) {
		this.idServicio=idServicio;
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
