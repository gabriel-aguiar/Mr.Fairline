package entity;

public class Ranking {

	private String escudo;
	private String nome_popular;
	private int gols;

	public Ranking() {

	}

	public Ranking(String escudo, String nome_popular, int gols) {
		super();
		this.escudo = escudo;
		this.nome_popular = nome_popular;
		this.gols = gols;
	}

	public String getEscudo() {
		return escudo;
	}

	public void setEscudo(String escudo) {
		this.escudo = escudo;
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
		result = prime * result + ((escudo == null) ? 0 : escudo.hashCode());
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
		Ranking other = (Ranking) obj;
		if (escudo == null) {
			if (other.escudo != null)
				return false;
		} else if (!escudo.equals(other.escudo))
			return false;
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
