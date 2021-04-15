package entity;

public class Campeonato {

	private long campeonato_id;
	private String nome;
	private String slug;
	private String nome_popular;
	private Edicao edicao_atual;
	private long edicao_atual_id;
	private Fase fase_atual;
	private long fase_atual_id;
	private String rodada_atual;
	private String status;
	private String tipo;
	private String logo;
	private String link;

	public Campeonato() {

	}
	
	

	public Campeonato(String nome, String slug, String nome_popular, Edicao edicao_atual, long edicao_atual_id,
			Fase fase_atual, long fase_atual_id, String rodada_atual, String status, String tipo, String logo,
			String link) {
		super();
		this.nome = nome;
		this.slug = slug;
		this.nome_popular = nome_popular;
		this.edicao_atual = edicao_atual;
		this.edicao_atual_id = edicao_atual_id;
		this.fase_atual = fase_atual;
		this.fase_atual_id = fase_atual_id;
		this.rodada_atual = rodada_atual;
		this.status = status;
		this.tipo = tipo;
		this.logo = logo;
		this.link = link;
	}



	public Campeonato(long campeonato_id, String nome, String slug, String nome_popular, Edicao edicao_atual,
			long edicao_atual_id, Fase fase_atual, long fase_atual_id, String rodada_atual, String status, String tipo,
			String logo, String link) {
		super();
		this.campeonato_id = campeonato_id;
		this.nome = nome;
		this.slug = slug;
		this.nome_popular = nome_popular;
		this.edicao_atual = edicao_atual;
		this.edicao_atual_id = edicao_atual_id;
		this.fase_atual = fase_atual;
		this.fase_atual_id = fase_atual_id;
		this.rodada_atual = rodada_atual;
		this.status = status;
		this.tipo = tipo;
		this.logo = logo;
		this.link = link;
	}



	public long getCampeonato_id() {
		return campeonato_id;
	}

	public void setCampeonato_id(long campeonato_id) {
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

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	public long getEdicao_atual_id() {
		return edicao_atual_id;
	}

	public void setEdicao_atual_id(long edicao_atual_id) {
		this.edicao_atual_id = edicao_atual_id;
	}

	public Edicao getEdicao_atual() {
		return edicao_atual;
	}

	public void setEdicao_atual(Edicao edicao_atual) {
		this.edicao_atual = edicao_atual;
	}

	public long getFase_atual_id() {
		return fase_atual_id;
	}

	public void setFase_atual_id(long fase_atual_id) {
		this.fase_atual_id = fase_atual_id;
	}

	public Fase getFase_atual() {
		return fase_atual;
	}

	public void setFase_atual(Fase fase_atual) {
		this.fase_atual = fase_atual;
	}

	public String getRodada_atual() {
		return rodada_atual;
	}

	public void setRodada_atual(String rodada_atual) {
		this.rodada_atual = rodada_atual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getlink() {
		return link;
	}

	public void setlink(String link) {
		this.link = link;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (campeonato_id ^ (campeonato_id >>> 32));
		result = prime * result + ((edicao_atual == null) ? 0 : edicao_atual.hashCode());
		result = prime * result + (int) (edicao_atual_id ^ (edicao_atual_id >>> 32));
		result = prime * result + ((fase_atual == null) ? 0 : fase_atual.hashCode());
		result = prime * result + (int) (fase_atual_id ^ (fase_atual_id >>> 32));
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
		result = prime * result + ((rodada_atual == null) ? 0 : rodada_atual.hashCode());
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
		Campeonato other = (Campeonato) obj;
		if (campeonato_id != other.campeonato_id)
			return false;
		if (edicao_atual == null) {
			if (other.edicao_atual != null)
				return false;
		} else if (!edicao_atual.equals(other.edicao_atual))
			return false;
		if (edicao_atual_id != other.edicao_atual_id)
			return false;
		if (fase_atual == null) {
			if (other.fase_atual != null)
				return false;
		} else if (!fase_atual.equals(other.fase_atual))
			return false;
		if (fase_atual_id != other.fase_atual_id)
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
		if (nome_popular == null) {
			if (other.nome_popular != null)
				return false;
		} else if (!nome_popular.equals(other.nome_popular))
			return false;
		if (rodada_atual == null) {
			if (other.rodada_atual != null)
				return false;
		} else if (!rodada_atual.equals(other.rodada_atual))
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
