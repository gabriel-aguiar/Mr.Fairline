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

	public Fase() {
		super();
	}

	public Fase(Edicao edicao, Long edicao_id, Campeonato campeonato, Long campeonato_id, String nome, String slug,
			String status, int decisivo, int eliminatorio, int ida_e_volta, String tipo) {
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
	}

	public Fase(Long fase_id, Edicao edicao, Long edicao_id, Campeonato campeonato, Long campeonato_id, String nome,
			String slug, String status, int decisivo, int eliminatorio, int ida_e_volta, String tipo) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result + ((campeonato_id == null) ? 0 : campeonato_id.hashCode());
		result = prime * result + decisivo;
		result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
		result = prime * result + ((edicao_id == null) ? 0 : edicao_id.hashCode());
		result = prime * result + eliminatorio;
		result = prime * result + ((fase_id == null) ? 0 : fase_id.hashCode());
		result = prime * result + ida_e_volta;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
