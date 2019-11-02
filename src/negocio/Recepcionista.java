package negocio;

public class Recepcionista implements VORecepcionista{
	
	private long id;
	
	private long idIps;
	
	public Recepcionista() {
		this.id=0;
		this.idIps=0;
	}
	
	public Recepcionista(long id,  long idIps) {
		this.id=id;
		this.idIps=idIps;
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
	public long getIdIps() {
		// TODO Auto-generated method stub
		return idIps;
	}
	public void setIdIps(long idIps) {
		this.idIps=idIps;
	}

}
