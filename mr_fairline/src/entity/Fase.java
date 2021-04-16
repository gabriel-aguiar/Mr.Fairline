package entity;

public class Fase {

	private Long fase_id;
    private Edicao edicao;
	private Long edicao_id;
	private Campeonato campeonato;
	private Long campeonato_id;
	private String nome;
	private String slug;
	private String status;
	private int decisivo;
	private int eliminatorio;
	private int ida_e_volta;
	private String tipo;
	private Chave chave;
	private Long chave_id;
	private Proxima_Fase proxima_fase;
	private Long proxima_fase_id;
	private int fase_anterior;


	public Fase() {
		super();
	}


	public Fase(Edicao edicao, Long edicao_id, Campeonato campeonato, Long campeonato_id, String nome, String slug,
			String status, int decisivo, int eliminatorio, int ida_e_volta, String tipo, Chave chave, Long chave_id,
			Proxima_Fase proxima_fase, Long proxima_fase_id, int fase_anterior) {
		super();
		this.edicao = edicao;
		this.edicao_id = edicao_id;
		this.campeonato = campeonato;
		this.campeonato_id = campeonato_id;
		this.nome = nome;
		this.slug = slug;
		this.status = status;
		this.decisivo = decisivo;
		this.eliminatorio = eliminatorio;
		this.ida_e_volta = ida_e_volta;
		this.tipo = tipo;
		this.chave = chave;
		this.chave_id = chave_id;
		this.proxima_fase = proxima_fase;
		this.proxima_fase_id = proxima_fase_id;
		this.fase_anterior = fase_anterior;
	}


	public Fase(Long fase_id, Edicao edicao, Long edicao_id, Campeonato campeonato, Long campeonato_id, String nome,
			String slug, String status, int decisivo, int eliminatorio, int ida_e_volta, String tipo, Chave chave,
			Long chave_id, Proxima_Fase proxima_fase, Long proxima_fase_id, int fase_anterior) {
		super();
		this.fase_id = fase_id;
		this.edicao = edicao;
		this.edicao_id = edicao_id;
		this.campeonato = campeonato;
		this.campeonato_id = campeonato_id;
		this.nome = nome;
		this.slug = slug;
		this.status = status;
		this.decisivo = decisivo;
		this.eliminatorio = eliminatorio;
		this.ida_e_volta = ida_e_volta;
		this.tipo = tipo;
		this.chave = chave;
		this.chave_id = chave_id;
		this.proxima_fase = proxima_fase;
		this.proxima_fase_id = proxima_fase_id;
		this.fase_anterior = fase_anterior;
	}


	public Long getFase_id() {
		return fase_id;
	}


	public void setFase_id(Long fase_id) {
		this.fase_id = fase_id;
	}


	public Edicao getEdicao() {
		return edicao;
	}


	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}


	public Long getEdicao_id() {
		return edicao_id;
	}


	public void setEdicao_id(Long edicao_id) {
		this.edicao_id = edicao_id;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getDecisivo() {
		return decisivo;
	}


	public void setDecisivo(int decisivo) {
		this.decisivo = decisivo;
	}


	public int getEliminatorio() {
		return eliminatorio;
	}


	public void setEliminatorio(int eliminatorio) {
		this.eliminatorio = eliminatorio;
	}


	public int getIda_e_volta() {
		return ida_e_volta;
	}


	public void setIda_e_volta(int ida_e_volta) {
		this.ida_e_volta = ida_e_volta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Chave getChave() {
		return chave;
	}


	public void setChave(Chave chave) {
		this.chave = chave;
	}


	public Long getChave_id() {
		return chave_id;
	}


	public void setChave_id(Long chave_id) {
		this.chave_id = chave_id;
	}


	public Proxima_Fase getProxima_fase() {
		return proxima_fase;
	}


	public void setProxima_fase(Proxima_Fase proxima_fase) {
		this.proxima_fase = proxima_fase;
	}


	public Long getProxima_fase_id() {
		return proxima_fase_id;
	}


	public void setProxima_fase_id(Long proxima_fase_id) {
		this.proxima_fase_id = proxima_fase_id;
	}


	public int getFase_anterior() {
		return fase_anterior;
	}


	public void setFase_anterior(int fase_anterior) {
		this.fase_anterior = fase_anterior;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result + ((campeonato_id == null) ? 0 : campeonato_id.hashCode());
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		result = prime * result + ((chave_id == null) ? 0 : chave_id.hashCode());
		result = prime * result + decisivo;
		result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
		result = prime * result + ((edicao_id == null) ? 0 : edicao_id.hashCode());
		result = prime * result + eliminatorio;
		result = prime * result + fase_anterior;
		result = prime * result + ((fase_id == null) ? 0 : fase_id.hashCode());
		result = prime * result + ida_e_volta;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((proxima_fase == null) ? 0 : proxima_fase.hashCode());
		result = prime * result + ((proxima_fase_id == null) ? 0 : proxima_fase_id.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Fase other = (Fase) obj;
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
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		if (chave_id == null) {
			if (other.chave_id != null)
				return false;
		} else if (!chave_id.equals(other.chave_id))
			return false;
		if (decisivo != other.decisivo)
			return false;
		if (edicao == null) {
			if (other.edicao != null)
				return false;
		} else if (!edicao.equals(other.edicao))
			return false;
		if (edicao_id == null) {
			if (other.edicao_id != null)
				return false;
		} else if (!edicao_id.equals(other.edicao_id))
			return false;
		if (eliminatorio != other.eliminatorio)
			return false;
		if (fase_anterior != other.fase_anterior)
			return false;
		if (fase_id == null) {
			if (other.fase_id != null)
				return false;
		} else if (!fase_id.equals(other.fase_id))
			return false;
		if (ida_e_volta != other.ida_e_volta)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (proxima_fase == null) {
			if (other.proxima_fase != null)
				return false;
		} else if (!proxima_fase.equals(other.proxima_fase))
			return false;
		if (proxima_fase_id == null) {
			if (other.proxima_fase_id != null)
				return false;
		} else if (!proxima_fase_id.equals(other.proxima_fase_id))
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
