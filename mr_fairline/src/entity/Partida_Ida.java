package entity;

public class Partida_Ida {

	private int partida_ida_id;
	private Campeonato_Part campeonato;
	private int campeonato_part_id;
	private String placar;
	private Time_Mandante time_mandante;
	private int time_mandante_id;
	private Time_Visitante time_visitante;
	private int time_visitante_id;
	private int placar_mandante;
	private int placar_visitante;
	private int status;
	private int slug;
	private String data_realizacao;
	private int hora_realizacao;
	private String data_realizacao_iso;
	private Estadio estadio;
	private int estadio_id;
	private String link;

	public Partida_Ida() {

	}

	public Partida_Ida(Campeonato_Part campeonato, int campeonato_part_id, String placar, Time_Mandante time_mandante,
			int time_mandante_id, Time_Visitante time_visitante, int time_visitante_id, int placar_mandante,
			int placar_visitante, int status, int slug, String data_realizacao, int hora_realizacao,
			String data_realizacao_iso, Estadio estadio, int estadio_id, String link) {
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

	public Partida_Ida(int partida_ida_id, Campeonato_Part campeonato, int campeonato_part_id, String placar,
			Time_Mandante time_mandante, int time_mandante_id, Time_Visitante time_visitante, int time_visitante_id,
			int placar_mandante, int placar_visitante, int status, int slug, String data_realizacao, int hora_realizacao,
			String data_realizacao_iso, Estadio estadio, int estadio_id, String link) {
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

	public int getPartida_ida_id() {
		return partida_ida_id;
	}

	public void setPartida_ida_id(int partida_ida_id) {
		this.partida_ida_id = partida_ida_id;
	}

	public Campeonato_Part getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato_Part campeonato) {
		this.campeonato = campeonato;
	}

	public int getCampeonato_part_id() {
		return campeonato_part_id;
	}

	public void setCampeonato_part_id(int campeonato_part_id) {
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

	public int getTime_mandante_id() {
		return time_mandante_id;
	}

	public void setTime_mandante_id(int time_mandante_id) {
		this.time_mandante_id = time_mandante_id;
	}

	public Time_Visitante getTime_visitante() {
		return time_visitante;
	}

	public void setTime_visitante(Time_Visitante time_visitante) {
		this.time_visitante = time_visitante;
	}

	public int getTime_visitante_id() {
		return time_visitante_id;
	}

	public void setTime_visitante_id(int time_visitante_id) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSlug() {
		return slug;
	}

	public void setSlug(int slug) {
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

	public int getEstadio_id() {
		return estadio_id;
	}

	public void setEstadio_id(int estadio_id) {
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
		result = prime * result + campeonato_part_id;
		result = prime * result + ((data_realizacao == null) ? 0 : data_realizacao.hashCode());
		result = prime * result + ((data_realizacao_iso == null) ? 0 : data_realizacao_iso.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + estadio_id;
		result = prime * result + hora_realizacao;
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + partida_ida_id;
		result = prime * result + ((placar == null) ? 0 : placar.hashCode());
		result = prime * result + placar_mandante;
		result = prime * result + placar_visitante;
		result = prime * result + slug;
		result = prime * result + status;
		result = prime * result + ((time_mandante == null) ? 0 : time_mandante.hashCode());
		result = prime * result + time_mandante_id;
		result = prime * result + ((time_visitante == null) ? 0 : time_visitante.hashCode());
		result = prime * result + time_visitante_id;
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
		if (campeonato_part_id != other.campeonato_part_id)
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
		if (estadio_id != other.estadio_id)
			return false;
		if (hora_realizacao != other.hora_realizacao)
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (partida_ida_id != other.partida_ida_id)
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
		if (slug != other.slug)
			return false;
		if (status != other.status)
			return false;
		if (time_mandante == null) {
			if (other.time_mandante != null)
				return false;
		} else if (!time_mandante.equals(other.time_mandante))
			return false;
		if (time_mandante_id != other.time_mandante_id)
			return false;
		if (time_visitante == null) {
			if (other.time_visitante != null)
				return false;
		} else if (!time_visitante.equals(other.time_visitante))
			return false;
		if (time_visitante_id != other.time_visitante_id)
			return false;
		return true;
	}

	
}
