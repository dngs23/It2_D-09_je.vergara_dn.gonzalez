package negocio;

public class Disponibilidad_medico implements VODisponibilidad_medico{
	private long id;
	private long idMedico;
	private long idFranja;
	private int ocupado;
	
	public Disponibilidad_medico() {
		id=0;
		idMedico=0;
		idFranja=0;
		ocupado=0;
	}
	public Disponibilidad_medico(long id, long idMedico, long idFranja, int ocupado) {
		this.id=id;
		this.idMedico=idMedico;
		this.idFranja=idFranja;
		this.ocupado=ocupado;
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
	public long getIdMedico() {
		// TODO Auto-generated method stub
		return idMedico;
	}
	public void setIdMedico(long id) {
		this.idMedico=id;
	}

	@Override
	public long getIdFranja() {
		// TODO Auto-generated method stub
		return idFranja;
	}
	public void setIdFranja(long idFranja) {
		this.idFranja=idFranja;
	}

	@Override
	public int getOcupado() {
		// TODO Auto-generated method stub
		return ocupado;
	}
	public void setOcupado(int ocupado) {
		this.ocupado=ocupado;
	}

}
