package negocio;

import java.util.Date;

public class Campaña implements VOCampaña{
	
	private String nombre;
	private int cantEsperada;
	private int cantMinima;
	private Date fechaInic;
	private Date fechaFin;
	
	public Campaña() {
		nombre="";
		cantEsperada=0;
		cantMinima=0;
		fechaInic=null;
		fechaFin=null;
		
	}
	public Campaña(String nombre,int cantEsperada, int cantMinima, Date fechaInic, Date fechaFin) {
		this.nombre=nombre;
		this.cantEsperada=cantEsperada;
		this.cantMinima=cantMinima;
		this.fechaInic=fechaInic;
		this.fechaFin=fechaFin;
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
	public int getCantidadEsperada() {
		// TODO Auto-generated method stub
		return cantEsperada;
	}
	public void setCantidadEsperada(int cantEsperada) {
		this.cantEsperada=cantEsperada;
	}

	@Override
	public int getCantidadMinima() {
		// TODO Auto-generated method stub
		return cantMinima;
	}
	public void setCantidadMinima(int cantMinima) {
		this.cantMinima=cantMinima;
	}

	@Override
	public Date getFechaInicial() {
		// TODO Auto-generated method stub
		return fechaInic;
	}
	public void setFechaInicial(Date fechaInic) {
		this.fechaInic=fechaInic;
	}

	@Override
	public Date getFechaFinal() {
		// TODO Auto-generated method stub
		return fechaFin;
	}
	public void setFechaFinal(Date fechaFin) {
		this.fechaFin=fechaFin;
	}

}
