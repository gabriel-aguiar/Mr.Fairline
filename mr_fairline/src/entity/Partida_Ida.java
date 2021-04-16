package entity;

public class Partida_Ida {

	private Long partida_ida_id;
	private Campeonato_Part campeonato;
	private Long campeonato_part_id;
	private String placar;
	private Time_Mandante time_mandante;
	private Long time_mandante_id;
	private Time_Visitante time_visitante;
	private Long time_visitante_id;
	private int placar_mandante;
	private int placar_visitante;
	private String status;
	private String slug;
	private String data_realizacao;
	private int hora_realizacao;
	private String data_realizacao_iso;
	private Estadio estadio;
	private Long estadio_id;
	private String link;

	public Partida_Ida() {

	}

	public Partida_Ida(Campeonato_Part campeonato, Long campeonato_part_id, String placar, Time_Mandante time_mandante,
			Long time_mandante_id, Time_Visitante time_visitante, Long time_visitante_id, int placar_mandante,
			int placar_visitante, String status, String slug, String data_realizacao, int hora_realizacao,
			String data_realizacao_iso, Estadio estadio, Long estadio_id, String link) {
		super();
		this.campeonato = campeonato;
		this.campeonato_part_id = campeonato_part_id;
		this.placar = placar;
		this.time_mandante = time_mandante;
		this.time_mandante_id = time_mandante_id;
		this.time_visitante = time_visitante;
		this.time_visitante_id = time_visitante_id;
		this.placar_mandante = placar_mandante;
		this.placar_visitante = placar_visitante;
		this.status = status;
		this.slug = slug;
		this.data_realizacao = data_realizacao;
		this.hora_realizacao = hora_realizacao;
		this.data_realizacao_iso = data_realizacao_iso;
		this.estadio = estadio;
		this.estadio_id = estadio_id;
		this.link = link;
	}

	public Partida_Ida(Long partida_ida_id, Campeonato_Part campeonato, Long campeonato_part_id, String placar,
			Time_Mandante time_mandante, Long time_mandante_id, Time_Visitante time_visitante, Long time_visitante_id,
			int placar_mandante, int placar_visitante, String status, String slug, String data_realizacao,
			int hora_realizacao, String data_realizacao_iso, Estadio estadio, Long estadio_id, String link) {
		super();
		this.partida_ida_id = partida_ida_id;
		this.campeonato = campeonato;
		this.campeonato_part_id = campeonato_part_id;
		this.placar = placar;
		this.time_mandante = time_mandante;
		this.time_mandante_id = time_mandante_id;
		this.time_visitante = time_visitante;
		this.time_visitante_id = time_visitante_id;
		this.placar_mandante = placar_mandante;
		this.placar_visitante = placar_visitante;
		this.status = status;
		this.slug = slug;
		this.data_realizacao = data_realizacao;
		this.hora_realizacao = hora_realizacao;
		this.data_realizacao_iso = data_realizacao_iso;
		this.estadio = estadio;
		this.estadio_id = estadio_id;
		this.link = link;
	}

	public Long getPartida_ida_id() {
		return partida_ida_id;
	}

	public void setPartida_ida_id(Long partida_ida_id) {
		this.partida_ida_id = partida_ida_id;
	}

	public Campeonato_Part getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato_Part campeonato) {
		this.campeonato = campeonato;
	}

	public Long getCampeonato_part_id() {
		return campeonato_part_id;
	}

	public void setCampeonato_part_id(Long campeonato_part_id) {
		this.campeonato_part_id = campeonato_part_id;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public Time_Mandante getTime_mandante() {
		return time_mandante;
	}

	public void setTime_mandante(Time_Mandante time_mandante) {
		this.time_mandante = time_mandante;
	}

	public Long getTime_mandante_id() {
		return time_mandante_id;
	}

	public void setTime_mandante_id(Long time_mandante_id) {
		this.time_mandante_id = time_mandante_id;
	}

	public Time_Visitante getTime_visitante() {
		return time_visitante;
	}

	public void setTime_visitante(Time_Visitante time_visitante) {
		this.time_visitante = time_visitante;
	}

	public Long getTime_visitante_id() {
		return time_visitante_id;
	}

	public void setTime_visitante_id(Long time_visitante_id) {
		this.time_visitante_id = time_visitante_id;
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

	public int getHora_realizacao() {
		return hora_realizacao;
	}

	public void setHora_realizacao(int hora_realizacao) {
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result + ((campeonato_part_id == null) ? 0 : campeonato_part_id.hashCode());
		result = prime * result + ((data_realizacao == null) ? 0 : data_realizacao.hashCode());
		result = prime * result + ((data_realizacao_iso == null) ? 0 : data_realizacao_iso.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((estadio_id == null) ? 0 : estadio_id.hashCode());
		result = prime * result + hora_realizacao;
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((partida_ida_id == null) ? 0 : partida_ida_id.hashCode());
		result = prime * result + ((placar == null) ? 0 : placar.hashCode());
		result = prime * result + placar_mandante;
		result = prime * result + placar_visitante;
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((time_mandante == null) ? 0 : time_mandante.hashCode());
		result = prime * result + ((time_mandante_id == null) ? 0 : time_mandante_id.hashCode());
		result = prime * result + ((time_visitante == null) ? 0 : time_visitante.hashCode());
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
		Partida_Ida other = (Partida_Ida) obj;
		if (campeonato == null) {
			if (other.campeonato != null)
				return false;
		} else if (!campeonato.equals(other.campeonato))
			return false;
		if (campeonato_part_id == null) {
			if (other.campeonato_part_id != null)
				return false;
		} else if (!campeonato_part_id.equals(other.campeonato_part_id))
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
		if (hora_realizacao != other.hora_realizacao)
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (partida_ida_id == null) {
			if (other.partida_ida_id != null)
				return false;
		} else if (!partida_ida_id.equals(other.partida_ida_id))
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
		if (time_mandante == null) {
			if (other.time_mandante != null)
				return false;
		} else if (!time_mandante.equals(other.time_mandante))
			return false;
		if (time_mandante_id == null) {
			if (other.time_mandante_id != null)
				return false;
		} else if (!time_mandante_id.equals(other.time_mandante_id))
			return false;
		if (time_visitante == null) {
			if (other.time_visitante != null)
				return false;
		} else if (!time_visitante.equals(other.time_visitante))
			return false;
		if (time_visitante_id == null) {
			if (other.time_visitante_id != null)
				return false;
		} else if (!time_visitante_id.equals(other.time_visitante_id))
			return false;
		return true;
	}

	
}
