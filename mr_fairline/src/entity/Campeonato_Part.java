package entity;

public class Campeonato_Part {

	private int campeonato_part_id;
	private String nome;
	private String slug;

	public Campeonato_Part() {

	}

	public Campeonato_Part(String nome, String slug) {
		super();
		this.nome = nome;
		this.slug = slug;
	}

	public Campeonato_Part(int campeonato_part_id, String nome, String slug) {
		super();
		this.campeonato_part_id = campeonato_part_id;
		this.nome = nome;
		this.slug = slug;
	}

	public int getCampeonato_part_id() {
		return campeonato_part_id;
	}

	public void setCampeonato_part_id(int campeonato_part_id) {
		this.campeonato_part_id = campeonato_part_id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + campeonato_part_id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
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
		Campeonato_Part other = (Campeonato_Part) obj;
		if (campeonato_part_id != other.campeonato_part_id)
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
		return true;
	}

	
}
