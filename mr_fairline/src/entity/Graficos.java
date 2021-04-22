package entity;

public class Graficos {
	
	private String nome_popular;
	private int gols;

	public Graficos() {

	}

	public Graficos(String nome_popular, int gols) {
		super();
		this.nome_popular = nome_popular;
		this.gols = gols;
	}

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gols;
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
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
		Graficos other = (Graficos) obj;
		if (gols != other.gols)
			return false;
		if (nome_popular == null) {
			if (other.nome_popular != null)
				return false;
		} else if (!nome_popular.equals(other.nome_popular))
			return false;
		return true;
	}
	
}
