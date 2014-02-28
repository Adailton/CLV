package teste.json.helloworld;

public class Secao {
	private String endereco;
	private String id;
	
	public Secao(String endereco, String id) {
		this.endereco = endereco;
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
