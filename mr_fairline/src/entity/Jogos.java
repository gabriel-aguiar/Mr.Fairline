package entity;

public class Jogos {

	private Long jogos_id;
	private String nome;
	private Campeonato campeonato;
	private Long campeonato_id;
	private String placar;
	private Long time_visitante_id;
	private Long time_mandante_id;
	private int placar_mandante;
	private int placar_visitante;
	private String nome_time_mandante;
	private String nome_time_visitante;
	private String status;
	private String slug;
	private String data_realizacao;
	private String hora_realizacao;
	private String data_realizacao_iso;
	private Estadio estadio;
	private Long estadio_id;
	private String nome_estadio;
	private String link;
	private Fase fase;
	private Long fase_id;
	private String logo;
	private String sigla;

	public Jogos() {

	}

	public Jogos(String nome, Campeonato campeonato, Long campeonato_id, String placar, Long time_visitante_id,
			Long time_mandante_id, int placar_mandante, int placar_visitante, String nome_time_mandante,
			String nome_time_visitante, String status, String slug, String data_realizacao, String hora_realizacao,
			String data_realizacao_iso, Estadio estadio, Long estadio_id, String nome_estadio, String link, Fase fase,
			Long fase_id, String logo, String sigla) {
		super();
		this.nome = nome;
		this.campeonato = campeonato;
		this.campeonato_id = campeonato_id;
		this.placar = placar;
		this.time_visitante_id = time_visitante_id;
		this.time_mandante_id = time_mandante_id;
		this.placar_mandante = placar_mandante;
		this.placar_visitante = placar_visitante;
		this.nome_time_mandante = nome_time_mandante;
		this.nome_time_visitante = nome_time_visitante;
		this.status = status;
		this.slug = slug;
		this.data_realizacao = data_realizacao;
		this.hora_realizacao = hora_realizacao;
		this.data_realizacao_iso = data_realizacao_iso;
		this.estadio = estadio;
		this.estadio_id = estadio_id;
		this.nome_estadio = nome_estadio;
		this.link = link;
		this.fase = fase;
		this.fase_id = fase_id;
		this.logo = logo;
		this.sigla = sigla;
	}

	public Jogos(Long jogos_id, String nome, Campeonato campeonato, Long campeonato_id, String placar,
			Long time_visitante_id, Long time_mandante_id, int placar_mandante, int placar_visitante,
			String nome_time_mandante, String nome_time_visitante, String status, String slug, String data_realizacao,
			String hora_realizacao, String data_realizacao_iso, Estadio estadio, Long estadio_id, String nome_estadio,
			String link, Fase fase, Long fase_id, String logo, String sigla) {
		super();
		this.jogos_id = jogos_id;
		this.nome = nome;
		this.campeonato = campeonato;
		this.campeonato_id = campeonato_id;
		this.placar = placar;
		this.time_visitante_id = time_visitante_id;
		this.time_mandante_id = time_mandante_id;
		this.placar_mandante = placar_mandante;
		this.placar_visitante = placar_visitante;
		this.nome_time_mandante = nome_time_mandante;
		this.nome_time_visitante = nome_time_visitante;
		this.status = status;
		this.slug = slug;
		this.data_realizacao = data_realizacao;
		this.hora_realizacao = hora_realizacao;
		this.data_realizacao_iso = data_realizacao_iso;
		this.estadio = estadio;
		this.estadio_id = estadio_id;
		this.nome_estadio = nome_estadio;
		this.link = link;
		this.fase = fase;
		this.fase_id = fase_id;
		this.logo = logo;
		this.sigla = sigla;
	}

	public Long getJogos_id() {
		return jogos_id;
	}

	public void setJogos_id(Long jogos_id) {
		this.jogos_id = jogos_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Long getCampeonato_id() {
		return campeonato_id;
	}

	public void setCampeonato_id(Long campeonato_id) {
		this.campeonato_id = campeonato_id;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public Long getTime_visitante_id() {
		return time_visitante_id;
	}

	public void setTime_visitante_id(Long time_visitante_id) {
		this.time_visitante_id = time_visitante_id;
	}

	public Long getTime_mandante_id() {
		return time_mandante_id;
	}

	public void setTime_mandante_id(Long time_mandante_id) {
		this.time_mandante_id = time_mandante_id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public String getData_realizacao_iso() {
		return data_realizacao_iso;
	}

	public void setData_realizacao_iso(String data_realizacao_iso) {
		this.data_realizacao_iso = data_realizacao_iso;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Long getEstadio_id() {
		return estadio_id;
	}

	public void setEstadio_id(Long estadio_id) {
		this.estadio_id = estadio_id;
	}

	public String getNome_estadio() {
		return nome_estadio;
	}

	public void setNome_estadio(String nome_estadio) {
		this.nome_estadio = nome_estadio;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Long getFase_id() {
		return fase_id;
	}

	public void setFase_id(Long fase_id) {
		this.fase_id = fase_id;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result + ((campeonato_id == null) ? 0 : campeonato_id.hashCode());
		result = prime * result + ((data_realizacao == null) ? 0 : data_realizacao.hashCode());
		result = prime * result + ((data_realizacao_iso == null) ? 0 : data_realizacao_iso.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((estadio_id == null) ? 0 : estadio_id.hashCode());
		result = prime * result + ((fase == null) ? 0 : fase.hashCode());
		result = prime * result + ((fase_id == null) ? 0 : fase_id.hashCode());
		result = prime * result + ((hora_realizacao == null) ? 0 : hora_realizacao.hashCode());
		result = prime * result + ((jogos_id == null) ? 0 : jogos_id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_estadio == null) ? 0 : nome_estadio.hashCode());
		result = prime * result + ((nome_time_mandante == null) ? 0 : nome_time_mandante.hashCode());
		result = prime * result + ((nome_time_visitante == null) ? 0 : nome_time_visitante.hashCode());
		result = prime * result + ((placar == null) ? 0 : placar.hashCode());
		result = prime * result + placar_mandante;
		result = prime * result + placar_visitante;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time_mandante_id == null) ? 0 : time_mandante_id.hashCode());
		result = prime * result + ((time_visitante_id == null) ? 0 : time_visitante_id.hashCode());
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
		Jogos other = (Jogos) obj;
		if (campeonato == null) {
			if (other.campeonato != null)
				return false;
		} else if (!campeonato.equals(other.campeonato))
			return false;
		if (campeonato_id == null) {
			if (other.campeonato_id != null)
				return false;
		} else if (!campeonato_id.equals(other.campeonato_id))
			return false;
		if (data_realizacao == null) {
			if (other.data_realizacao != null)
				return false;
		} else if (!data_realizacao.equals(other.data_realizacao))
			return false;
		if (data_realizacao_iso == null) {
			if (other.data_realizacao_iso != null)
				return false;
		} else if (!data_realizacao_iso.equals(other.data_realizacao_iso))
			return false;
		if (estadio == null) {
			if (other.estadio != null)
				return false;
		} else if (!estadio.equals(other.estadio))
			return false;
		if (estadio_id == null) {
			if (other.estadio_id != null)
				return false;
		} else if (!estadio_id.equals(other.estadio_id))
			return false;
		if (fase == null) {
			if (other.fase != null)
				return false;
		} else if (!fase.equals(other.fase))
			return false;
		if (fase_id == null) {
			if (other.fase_id != null)
				return false;
		} else if (!fase_id.equals(other.fase_id))
			return false;
		if (hora_realizacao == null) {
			if (other.hora_realizacao != null)
				return false;
		} else if (!hora_realizacao.equals(other.hora_realizacao))
			return false;
		if (jogos_id == null) {
			if (other.jogos_id != null)
				return false;
		} else if (!jogos_id.equals(other.jogos_id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		if (placar == null) {
			if (other.placar != null)
				return false;
		} else if (!placar.equals(other.placar))
			return false;
		if (placar_mandante != other.placar_mandante)
			return false;
		if (placar_visitante != other.placar_visitante)
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (time_mandante_id == null) {
			if (other.time_mandante_id != null)
				return false;
		} else if (!time_mandante_id.equals(other.time_mandante_id))
			return false;
		if (time_visitante_id == null) {
			if (other.time_visitante_id != null)
				return false;
		} else if (!time_visitante_id.equals(other.time_visitante_id))
			return false;
		return true;
	}

}
