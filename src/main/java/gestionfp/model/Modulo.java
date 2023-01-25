package gestionfp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulo {
	
	@Id
	@Column(name = "cod_mod_boja")
	private Long cod_mod_boja;
	
	@Column(name = "nombre", length = 128, unique = true, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<RA> ra;

	public Modulo(Long cod_mod_boja, String nombre, List<RA> ra) {
		this.cod_mod_boja = cod_mod_boja;
		this.nombre = nombre;
		this.ra = ra;
	}
	
	public Modulo() {
		super();
	}

	public Long getCod_mod_boja() {
		return cod_mod_boja;
	}

	public void setCod_mod_boja(Long cod_mod_boja) {
		this.cod_mod_boja = cod_mod_boja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RA> getRa() {
		return ra;
	}

	public void setRa(List<RA> ra) {
		this.ra = ra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_mod_boja == null) ? 0 : cod_mod_boja.hashCode());
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
		Modulo other = (Modulo) obj;
		if (cod_mod_boja == null) {
			if (other.cod_mod_boja != null)
				return false;
		} else if (!cod_mod_boja.equals(other.cod_mod_boja))
			return false;
		return true;
	}
	
}
