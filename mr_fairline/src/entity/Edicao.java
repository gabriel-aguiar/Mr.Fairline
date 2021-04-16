package entity;

public class Edicao {

	private Long edicao_id;
	private String temporada;
	private String nome;
	private String nome_popular;
	private String slug;

	public Edicao() {

	}

	public Edicao(String temporada, String nome, String nome_popular, String slug) {
		super();
		this.temporada = temporada;
		this.nome = nome;
		this.nome_popular = nome_popular;
		this.slug = slug;
	}

	public Edicao(Long edicao_id, String temporada, String nome, String nome_popular, String slug) {
		super();
		this.edicao_id = edicao_id;
		this.temporada = temporada;
		this.nome = nome;
		this.nome_popular = nome_popular;
		this.slug = slug;
	}

	public Long getEdicao_id() {
		return edicao_id;
	}

	public void setEdicao_id(Long edicao_id) {
		this.edicao_id = edicao_id;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edicao_id == null) ? 0 : edicao_id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
		result = prime * result + ((temporada == null) ? 0 : temporada.hashCode());
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
		Edicao other = (Edicao) obj;
		if (edicao_id == null) {
			if (other.edicao_id != null)
				return false;
		} else if (!edicao_id.equals(other.edicao_id))
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
		if (temporada == null) {
			if (other.temporada != null)
				return false;
		} else if (!temporada.equals(other.temporada))
			return false;
		return true;
	}

}
