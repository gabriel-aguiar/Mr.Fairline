package entity;

public class GraficosCol {
	
	private String nome_popular2;
	private int gols2;

	public GraficosCol() {

	}

	public GraficosCol(String nome_popular2, int gols2) {
		super();
		this.nome_popular2 = nome_popular2;
		this.gols2 = gols2;
	}

	public String getNome_popular() {
		return nome_popular2;
	}

	public void setNome_popular(String nome_popular2) {
		this.nome_popular2 = nome_popular2;
	}

	public int getGols() {
		return gols2;
	}

	public void setGols(int gols2) {
		this.gols2 = gols2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gols2;
		result = prime * result + ((nome_popular2 == null) ? 0 : nome_popular2.hashCode());
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
		GraficosCol other = (GraficosCol) obj;
		if (gols2 != other.gols2)
			return false;
		if (nome_popular2 == null) {
			if (other.nome_popular2 != null)
				return false;
		} else if (!nome_popular2.equals(other.nome_popular2))
			return false;
		return true;
	}

	
}