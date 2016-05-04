
public class Indice {
	
	private int key;
	private String rid;
	private String tipoArquivo;
	
	public Indice(int key, String rid, String tipoArquivo) {
		this.key = key;
		this.rid = rid;
		this.tipoArquivo = tipoArquivo;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getRid() {
		return rid;
	}
	
	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}
	
	public String getTipoArquivo() {
		return tipoArquivo;
	}
	
	@Override
	public String toString() {
		return this.key + " " + this.rid + " " + this.tipoArquivo;
	}
}
