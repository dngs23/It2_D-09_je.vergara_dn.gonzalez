package negocio;

import java.text.SimpleDateFormat;

public class Franja_horaria implements VOFranja_horaria{
	private long id;
	
	private SimpleDateFormat inicio;
	
	private SimpleDateFormat fin;
	
	public Franja_horaria() {
		this.id=0;
		this.inicio= null;
		this.fin= null;
	}
	
	public Franja_horaria(long id, SimpleDateFormat inicio, SimpleDateFormat fin) {
		this.id=id;
		this.inicio=inicio;
		this.fin=fin;
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
	public SimpleDateFormat getInicio() {
		// TODO Auto-generated method stub
		return inicio;
	}
	public void setInicio(SimpleDateFormat inicio) {
		this.inicio=inicio;
	}

	@Override
	public SimpleDateFormat getFin() {
		// TODO Auto-generated method stub
		return fin;
	}
	public void setFin(SimpleDateFormat fin) {
		this.fin=fin;
	}

}
