package entity;

public class Estadio {

	private Long estadio_id;
	private String nome_popular;

	public Estadio() {

	}

	public Estadio(String nome_popular) {
		super();
		this.nome_popular = nome_popular;
	}

	public Estadio(Long estadio_id, String nome_popular) {
		super();
		this.estadio_id = estadio_id;
		this.nome_popular = nome_popular;
	}

	public Long getEstadio_id() {
		return estadio_id;
	}

	public void setEstadio_id(Long estadio_id) {
		this.estadio_id = estadio_id;
	}

	public String getNome_popular() {
		return nome_popular;
	}

	public void setNome_popular(String nome_popular) {
		this.nome_popular = nome_popular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadio_id == null) ? 0 : estadio_id.hashCode());
		result = prime * result + ((nome_popular == null) ? 0 : nome_popular.hashCode());
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
		Estadio other = (Estadio) obj;
		if (estadio_id == null) {
			if (other.estadio_id != null)
				return false;
		} else if (!estadio_id.equals(other.estadio_id))
			return false;
		if (nome_popular == null) {
			if (other.nome_popular != null)
				return false;
		} else if (!nome_popular.equals(other.nome_popular))
			return false;
		return true;
	}
	
}
