package negocio;

public class Servicio implements VOServicio{
	
	private long id;
	
	private String info;
		
	private int capacidad;
	
	public Servicio() {
		this.capacidad=0;
		this.id=0;
		this.info="";
	}
	public Servicio(long id, String info, int capacidad) {
		this.id=id;
		this.info=info;
		this.capacidad=capacidad;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId (long id) {
		this.id=id;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return info;
	}
	public void setInfo(String info) {
		this.info=info;
	}

	@Override
	public int getCapacidad() {
		// TODO Auto-generated method stub
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad=capacidad;
	}

}
