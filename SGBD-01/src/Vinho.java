
public class Vinho {
	
	private String vcode;
	private String produtor;
	private String cepa;
	private String pais;
	private int colheita;
	
	public Vinho(String vcode, String produtor, String cepa, String pais, int colheita) {
		this.vcode = vcode;
		this.produtor = produtor;
		this.cepa = cepa;
		this.colheita = colheita;
		this.pais = pais;
	}
	
	public String getVcode() {
		return vcode;
	}
	
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	
	public void setCepa(String cepa) {
		this.cepa = cepa;
	}
	
	public String getCepa() {
		return cepa;
	}
	
	public void setColheita(int colheita) {
		this.colheita = colheita;
	}
	
	public int getColheita() {
		return colheita;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return pais;
	}
	
	public String getProdutor() {
		return produtor;
	}
	
	@Override
	public String toString() {
		return this.vcode + "-" + this.produtor + "-" + this.cepa + "-" + this.pais + "-" + this.colheita;
	}
}
