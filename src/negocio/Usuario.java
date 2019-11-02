package negocio;

import java.util.Date;

public class Usuario implements VOUsuario{

	private long id;
	private int tipoDoc;
	private long noDoc;
	private String nombre;
	private Date fechaNacimiento;
	private String correo;
	private int tipo;
	
	public Usuario() {
		this.id=0;
		this.tipoDoc=0;
		this.noDoc=0;
		this.nombre="";
		this.fechaNacimiento= new Date();
		this.correo="";
		this.tipo=0;
	}
	public Usuario(long id, int tipoDoc, long noDoc, String nombre, Date fechaNacimiento, String correo, int tipo) {
		this.id=id;
		this.tipoDoc=tipoDoc;
		this.nombre=nombre;
		this.fechaNacimiento=fechaNacimiento;
		this.correo=correo;
		this.tipo=tipo;
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
	public int getTipoDoc() {
		// TODO Auto-generated method stub
		return tipoDoc;
	}
	public void setTipoDoc(int tipoDoc) {
		this.tipoDoc=tipoDoc;
	}

	@Override
	public long getNoDoc() {
		// TODO Auto-generated method stub
		return noDoc;
	}
	public void setNoDoc(long noDoc) {
		this.noDoc=noDoc;
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
	public Date getFechaNacimiento() {
		// TODO Auto-generated method stub
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento=fechaNacimiento;
	}
	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo=correo;
	}
	@Override
	public int geTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo=tipo;
	}

	
	

}
