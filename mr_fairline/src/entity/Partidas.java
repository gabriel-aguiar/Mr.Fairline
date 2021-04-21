package entity;

public class Partidas {
	
	private String nome_time_mandante;
	private String nome_time_visitante;
	private String nome_estadio;
	private String sigla_time_m;
	private String sigla_time_v;
	private String escudo_time_m;
	private String escudo_time_v;
	private int placar_mandante;
	private int placar_visitante;
	private String data_realizacao;
	private String hora_realizacao;
	
	public Partidas() {

	}

	public Partidas(String nome_time_mandante, String nome_time_visitante, String nome_estadio, String sigla_time_m,
			String sigla_time_v, String escudo_time_m, String escudo_time_v, int placar_mandante, int placar_visitante,
			String data_realizacao, String hora_realizacao) {
		super();
		this.nome_time_mandante = nome_time_mandante;
		this.nome_time_visitante = nome_time_visitante;
		this.nome_estadio = nome_estadio;
		this.sigla_time_m = sigla_time_m;
		this.sigla_time_v = sigla_time_v;
		this.escudo_time_m = escudo_time_m;
		this.escudo_time_v = escudo_time_v;
		this.placar_mandante = placar_mandante;
		this.placar_visitante = placar_visitante;
		this.data_realizacao = data_realizacao;
		this.hora_realizacao = hora_realizacao;
	}

	public String getNome_time_mandante() {
		return nome_time_mandante;
	}

	public void setNome_time_mandante(String nome_time_mandante) {
		this.nome_time_mandante = nome_time_mandante;
	}

	public String getNome_time_visitante() {
		return nome_time_visitante;
	}

	public void setNome_time_visitante(String nome_time_visitante) {
		this.nome_time_visitante = nome_time_visitante;
	}

	public String getNome_estadio() {
		return nome_estadio;
	}

	public void setNome_estadio(String nome_estadio) {
		this.nome_estadio = nome_estadio;
	}

	public String getSigla_time_m() {
		return sigla_time_m;
	}

	public void setSigla_time_m(String sigla_time_m) {
		this.sigla_time_m = sigla_time_m;
	}

	public String getSigla_time_v() {
		return sigla_time_v;
	}

	public void setSigla_time_v(String sigla_time_v) {
		this.sigla_time_v = sigla_time_v;
	}

	public String getEscudo_time_m() {
		return escudo_time_m;
	}

	public void setEscudo_time_m(String escudo_time_m) {
		this.escudo_time_m = escudo_time_m;
	}

	public String getEscudo_time_v() {
		return escudo_time_v;
	}

	public void setEscudo_time_v(String escudo_time_v) {
		this.escudo_time_v = escudo_time_v;
	}

	public int getPlacar_mandante() {
		return placar_mandante;
	}

	public void setPlacar_mandante(int placar_mandante) {
		this.placar_mandante = placar_mandante;
	}

	public int getPlacar_visitante() {
		return placar_visitante;
	}

	public void setPlacar_visitante(int placar_visitante) {
		this.placar_visitante = placar_visitante;
	}

	public String getData_realizacao() {
		return data_realizacao;
	}

	public void setData_realizacao(String data_realizacao) {
		this.data_realizacao = data_realizacao;
	}

	public String getHora_realizacao() {
		return hora_realizacao;
	}

	public void setHora_realizacao(String hora_realizacao) {
		this.hora_realizacao = hora_realizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_realizacao == null) ? 0 : data_realizacao.hashCode());
		result = prime * result + ((escudo_time_m == null) ? 0 : escudo_time_m.hashCode());
		result = prime * result + ((escudo_time_v == null) ? 0 : escudo_time_v.hashCode());
		result = prime * result + ((hora_realizacao == null) ? 0 : hora_realizacao.hashCode());
		result = prime * result + ((nome_estadio == null) ? 0 : nome_estadio.hashCode());
		result = prime * result + ((nome_time_mandante == null) ? 0 : nome_time_mandante.hashCode());
		result = prime * result + ((nome_time_visitante == null) ? 0 : nome_time_visitante.hashCode());
		result = prime * result + placar_mandante;
		result = prime * result + placar_visitante;
		result = prime * result + ((sigla_time_m == null) ? 0 : sigla_time_m.hashCode());
		result = prime * result + ((sigla_time_v == null) ? 0 : sigla_time_v.hashCode());
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
		Partidas other = (Partidas) obj;
		if (data_realizacao == null) {
			if (other.data_realizacao != null)
				return false;
		} else if (!data_realizacao.equals(other.data_realizacao))
			return false;
		if (escudo_time_m == null) {
			if (other.escudo_time_m != null)
				return false;
		} else if (!escudo_time_m.equals(other.escudo_time_m))
			return false;
		if (escudo_time_v == null) {
			if (other.escudo_time_v != null)
				return false;
		} else if (!escudo_time_v.equals(other.escudo_time_v))
			return false;
		if (hora_realizacao == null) {
			if (other.hora_realizacao != null)
				return false;
		} else if (!hora_realizacao.equals(other.hora_realizacao))
			return false;
		if (nome_estadio == null) {
			if (other.nome_estadio != null)
				return false;
		} else if (!nome_estadio.equals(other.nome_estadio))
			return false;
		if (nome_time_mandante == null) {
			if (other.nome_time_mandante != null)
				return false;
		} else if (!nome_time_mandante.equals(other.nome_time_mandante))
			return false;
		if (nome_time_visitante == null) {
			if (other.nome_time_visitante != null)
				return false;
		} else if (!nome_time_visitante.equals(other.nome_time_visitante))
			return false;
		if (placar_mandante != other.placar_mandante)
			return false;
		if (placar_visitante != other.placar_visitante)
			return false;
		if (sigla_time_m == null) {
			if (other.sigla_time_m != null)
				return false;
		} else if (!sigla_time_m.equals(other.sigla_time_m))
			return false;
		if (sigla_time_v == null) {
			if (other.sigla_time_v != null)
				return false;
		} else if (!sigla_time_v.equals(other.sigla_time_v))
			return false;
		return true;
	}

	
}
