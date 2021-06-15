package entity;

public class Amistoso {

	private String nome_time1;
	private String nome_time2;
	private String data_jogo;
	private String palpite_placar;
	
	public Amistoso() {

	}

	public Amistoso(String nome_time1, String nome_time2, String data_jogo, String palpite_placar) {
		super();
		this.nome_time1 = nome_time1;
		this.nome_time2 = nome_time2;
		this.data_jogo = data_jogo;
		this.palpite_placar = palpite_placar;
	}

	public String getNome_time1() {
		return nome_time1;
	}

	public void setNome_time1(String nome_time1) {
		this.nome_time1 = nome_time1;
	}

	public String getNome_time2() {
		return nome_time2;
	}

	public void setNome_time2(String nome_time2) {
		this.nome_time2 = nome_time2;
	}

	public String getData_jogo() {
		return data_jogo;
	}

	public void setData_jogo(String data_jogo) {
		this.data_jogo = data_jogo;
	}

	public String getPalpite_placar() {
		return palpite_placar;
	}

	public void setPalpite_placar(String palpite_placar) {
		this.palpite_placar = palpite_placar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_jogo == null) ? 0 : data_jogo.hashCode());
		result = prime * result + ((nome_time1 == null) ? 0 : nome_time1.hashCode());
		result = prime * result + ((nome_time2 == null) ? 0 : nome_time2.hashCode());
		result = prime * result + ((palpite_placar == null) ? 0 : palpite_placar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amistoso other = (Amistoso) obj;
		if (data_jogo == null) {
			if (other.data_jogo != null)
				return false;
		} else if (!data_jogo.equals(other.data_jogo))
			return false;
		if (nome_time1 == null) {
			if (other.nome_time1 != null)
				return false;
		} else if (!nome_time1.equals(other.nome_time1))
			return false;
		if (nome_time2 == null) {
			if (other.nome_time2 != null)
				return false;
		} else if (!nome_time2.equals(other.nome_time2))
			return false;
		if (palpite_placar == null) {
			if (other.palpite_placar != null)
				return false;
		} else if (!palpite_placar.equals(other.palpite_placar))
			return false;
		return true;
	}
	
}
