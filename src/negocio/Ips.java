package negocio;

public class Ips implements VOIps{
	
	private String nombre;
	
	private int capacidadDiaria;
	
	public Ips() {
		nombre="";
		capacidadDiaria=0;
	}
	public Ips(String nombre, int capacidadDiaria) {
		this.nombre=nombre;
		this.capacidadDiaria=capacidadDiaria;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public int getCapacidadDiaria() {
		// TODO Auto-generated method stub
		return capacidadDiaria;
	}
	public void setCapacidadDiaria(int capacidadDiaria) {
		this.capacidadDiaria=capacidadDiaria;
	}

}
