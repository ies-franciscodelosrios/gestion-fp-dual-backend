package gestionfp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ra")
public class RA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modulo", nullable = false)
	@JsonBackReference
	private Modulo modulo;
	
	@Column(name = "resultado", length = 128, nullable = false)
	private String resultado;
	
	@OneToMany(mappedBy = "ra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<CE> ce;
	
	@ManyToMany(mappedBy = "ra")
	private List<Periodo_Practica> periodo_practica;

	public RA(Long id, Modulo modulo, String resultado, List<CE> ce, List<Periodo_Practica> periodo_practica) {
		this.id = id;
		this.modulo = modulo;
		this.resultado = resultado;
		this.ce = ce;
		this.periodo_practica = periodo_practica;
	}

	public RA() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<CE> getCe() {
		return ce;
	}

	public void setCe(List<CE> ce) {
		this.ce = ce;
	}

	public List<Periodo_Practica> getPeriodo_practica() {
		return periodo_practica;
	}

	public void setPeriodo_practica(List<Periodo_Practica> periodo_practica) {
		this.periodo_practica = periodo_practica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		RA other = (RA) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
