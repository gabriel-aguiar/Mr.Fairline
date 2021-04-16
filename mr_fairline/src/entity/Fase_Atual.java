package entity;

public class Fase_Atual {

	private Long fase_atual_id;
	private String nome;
	private String slug;
	private String tipo;
	private String link;
	
	public Fase_Atual() {
		
	}

	public Fase_Atual(String nome, String slug, String tipo, String link) {
		super();
		this.nome = nome;
		this.slug = slug;
		this.tipo = tipo;
		this.link = link;
	}

	public Fase_Atual(Long fase_atual_id, String nome, String slug, String tipo, String link) {
		super();
		this.fase_atual_id = fase_atual_id;
		this.nome = nome;
		this.slug = slug;
		this.tipo = tipo;
		this.link = link;
	}

	public Long getFase_atual_id() {
		return fase_atual_id;
	}

	public void setFase_atual_id(Long fase_atual_id) {
		this.fase_atual_id = fase_atual_id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		result = prime * result + ((fase_atual_id == null) ? 0 : fase_atual_id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
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
		Fase_Atual other = (Fase_Atual) obj;
		if (fase_atual_id == null) {
			if (other.fase_atual_id != null)
				return false;
		} else if (!fase_atual_id.equals(other.fase_atual_id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
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
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	
}
