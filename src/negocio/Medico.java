package negocio;

public class Medico implements VOMedico{
	
	private long id;
	
	private int noRegistro;
	
	public Medico() {
		this.id=  0;
		this.noRegistro=0;
	}
	
	public Medico(long id, int noRegistro) {
		this.id=id;
		this.noRegistro=noRegistro;
		
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
	public int getNoRegistro() {
		// TODO Auto-generated method stub
		return noRegistro;
	}
	public void setNoRegistro(int noRegistro) {
		this.noRegistro=noRegistro;
	}
	
	public String toString() {
		return "Medico [id="+id+", noRegistro="+noRegistro+"]";
	}

}
