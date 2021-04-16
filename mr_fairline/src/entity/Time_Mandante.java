package entity;

public class Time_Mandante {

	private Long time_mandante_id;
	private String nome_popular;
	private String sigla;
	private String escudo;

	public Time_Mandante() {

	}

	public Time_Mandante(String nome_popular, String sigla, String escudo) {
		super();
		this.nome_popular = nome_popular;
		this.sigla = sigla;
		this.escudo = escudo;
	}

	public Time_Mandante(Long time_mandante_id, String nome_popular, String sigla, String escudo) {
		super();
		this.time_mandante_id = time_mandante_id;
		this.nome_popular = nome_popular;
		this.sigla = sigla;
		this.escudo = escudo;
	}

	public Long getTime_mandante_id() {
		return time_mandante_id;
	}

	public void setTime_mandante_id(Long time_mandante_id) {
		this.time_mandante_id = time_mandante_id;
	}

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEscudo() {
		return escudo;
	}

	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escudo == null) ? 0 : escudo.hashCode());
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((time_mandante_id == null) ? 0 : time_mandante_id.hashCode());
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
		Time_Mandante other = (Time_Mandante) obj;
		if (escudo == null) {
			if (other.escudo != null)
				return false;
		} else if (!escudo.equals(other.escudo))
			return false;
		if (nome_popular == null) {
			if (other.nome_popular != null)
				return false;
		} else if (!nome_popular.equals(other.nome_popular))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (time_mandante_id == null) {
			if (other.time_mandante_id != null)
				return false;
		} else if (!time_mandante_id.equals(other.time_mandante_id))
			return false;
		return true;
	}

	
}