package entity;

public class Chave {

	private Long chave_id;
	private String nome;
	private String slug;
	private Partida_Ida partida_ida;
	private Long partida_ida_id;
	
	public Chave() {
		
	}

	public Chave(String nome, String slug, Partida_Ida partida_ida, Long partida_ida_id) {
		super();
		this.nome = nome;
		this.slug = slug;
		this.partida_ida = partida_ida;
		this.partida_ida_id = partida_ida_id;
	}

	public Chave(Long chave_id, String nome, String slug, Partida_Ida partida_ida, Long partida_ida_id) {
		super();
		this.chave_id = chave_id;
		this.nome = nome;
		this.slug = slug;
		this.partida_ida = partida_ida;
		this.partida_ida_id = partida_ida_id;
	}

	public Long getChave_id() {
		return chave_id;
	}

	public void setChave_id(Long chave_id) {
		this.chave_id = chave_id;
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

	public Partida_Ida getPartida_ida() {
		return partida_ida;
	}

	public void setPartida_ida(Partida_Ida partida_ida) {
		this.partida_ida = partida_ida;
	}

	public Long getPartida_ida_id() {
		return partida_ida_id;
	}

	public void setPartida_ida_id(Long partida_ida_id) {
		this.partida_ida_id = partida_ida_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave_id == null) ? 0 : chave_id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((partida_ida == null) ? 0 : partida_ida.hashCode());
		result = prime * result + ((partida_ida_id == null) ? 0 : partida_ida_id.hashCode());
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
		Chave other = (Chave) obj;
		if (chave_id == null) {
			if (other.chave_id != null)
				return false;
		} else if (!chave_id.equals(other.chave_id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (partida_ida == null) {
			if (other.partida_ida != null)
				return false;
		} else if (!partida_ida.equals(other.partida_ida))
			return false;
		if (partida_ida_id == null) {
			if (other.partida_ida_id != null)
				return false;
		} else if (!partida_ida_id.equals(other.partida_ida_id))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		return true;
	}

	
}
