package negocio;

public class Afiliado implements VOAfiliado{
	
	public long id;
	
	public Afiliado() {
		this.id=0;
	}
	public Afiliado(long id) {
		this.id=id;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
}
