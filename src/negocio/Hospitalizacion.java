package negocio;

import java.util.Date;

public class Hospitalizacion implements VOHospitalizacion{
	public long id;
	public long servicio;
	public String ips;
	public long afiliado;
	public Date inic;
	public Date fin;
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Hospitalizacion() {
		id=0;
		servicio=0;
		ips="";
		afiliado=0;
		inic=null;
		fin=null;
	}

	public Hospitalizacion(long id, long servicio, String ips, long afiliado, Date inic, Date fin) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.ips = ips;
		this.afiliado = afiliado;
		this.inic = inic;
		this.fin = fin;
	}

	@Override
	public long getServicio() {
		// TODO Auto-generated method stub
		return servicio;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setServicio(long servicio) {
		this.servicio = servicio;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public void setAfiliado(long afiliado) {
		this.afiliado = afiliado;
	}

	public void setInic(Date inic) {
		this.inic = inic;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String getIps() {
		// TODO Auto-generated method stub
		return ips;
	}

	@Override
	public long getAfiliado() {
		// TODO Auto-generated method stub
		return afiliado;
	}

	@Override
	public Date getInic() {
		// TODO Auto-generated method stub
		return inic;
	}

	@Override
	public Date getFin() {
		// TODO Auto-generated method stub
		return fin;
	}

}
