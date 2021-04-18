package entity;

public class Campeonato {

	private Long campeonato_id;
	private String nome;
	private String slug;
	private String nome_popular;
	//private Edicao edicao;
	private Long edicao_id;
	private String status;
	private String tipo;
	private String logo;
	private String link;

	public Campeonato() {

	}

	public Campeonato(String nome, String slug, String nome_popular, Edicao edicao, Long edicao_id,
			String status, String tipo, String logo, String link) {
		super();
		this.nome = nome;
		this.slug = slug;
		this.nome_popular = nome_popular;
		//this.edicao = edicao;
		this.edicao_id = edicao_id;
		this.status = status;
		this.tipo = tipo;
		this.logo = logo;
		this.link = link;
	}

	public Campeonato(Long campeonato_id, String nome, String slug, String nome_popular, Edicao edicao, Long edicao_id,
			String status, String tipo, String logo, String link) {
		super();
		this.campeonato_id = campeonato_id;
		this.nome = nome;
		this.slug = slug;
		this.nome_popular = nome_popular;
		//this.edicao = edicao;
		this.edicao_id = edicao_id;
		this.status = status;
		this.tipo = tipo;
		this.logo = logo;
		this.link = link;
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

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	/*public Edicao getEdicao() {
		return edicao;
	}

	public void setEdicao(Edicao edicao) {
		this.edicao = edicao;
	}*/

	public Long getEdicao_id() {
		return edicao_id;
	}

	public void setEdicao_id(Long edicao_id) {
		this.edicao_id = edicao_id;
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
		result = prime * result + ((campeonato_id == null) ? 0 : campeonato_id.hashCode());
		//result = prime * result + ((edicao == null) ? 0 : edicao.hashCode());
		result = prime * result + ((edicao_id == null) ? 0 : edicao_id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
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
		if (campeonato_id == null) {
			if (other.campeonato_id != null)
				return false;
		} else if (!campeonato_id.equals(other.campeonato_id))
			return false;
		/*if (edicao == null) {
			if (other.edicao != null)
				return false;
		} else if (!edicao.equals(other.edicao))
			return false;*/
		if (edicao_id == null) {
			if (other.edicao_id != null)
				return false;
		} else if (!edicao_id.equals(other.edicao_id))
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
