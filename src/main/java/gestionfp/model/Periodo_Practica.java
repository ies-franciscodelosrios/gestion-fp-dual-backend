package gestionfp.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="periodo_practicas")
public class Periodo_Practica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centro", nullable = false)
	private User id_centro;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private User id_empresa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno", nullable = false)
	private User id_alumno;
	
	@OneToMany(mappedBy = "periodo_practica", fetch = FetchType.LAZY)
	private List<Encargo> encargo;
	
	@ManyToMany
	@JoinTable(
			  name = "periodo_Ra", 
			  joinColumns = @JoinColumn(name = "Id_Periodo"), 
			  inverseJoinColumns = @JoinColumn(name = "Id_RA"))
	private List<RA> ra;
	
	@Column(name = "tiempo_inicio", nullable = false)
	private Timestamp tiempo_inicio;
	
	@Column(name = "tiempo_final", nullable = false)
	private Timestamp tiempo_final;
	
	@Column(name = "estado", nullable = false)
	private boolean estado;

	public Periodo_Practica(Long id, User id_centro, User id_empresa, User id_alumno, List<Encargo> encargo,
			List<RA> ra, Timestamp tiempo_inicio, Timestamp tiempo_final, boolean estado) {
		this.id = id;
		this.id_centro = id_centro;
		this.id_empresa = id_empresa;
		this.id_alumno = id_alumno;
		this.encargo = encargo;
		this.ra = ra;
		this.tiempo_inicio = tiempo_inicio;
		this.tiempo_final = tiempo_final;
		this.estado = estado;
	}

	public Periodo_Practica() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getId_centro() {
		return id_centro;
	}

	public void setId_centro(User id_centro) {
		this.id_centro = id_centro;
	}

	public User getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(User id_empresa) {
		this.id_empresa = id_empresa;
	}

	public User getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(User id_alumno) {
		this.id_alumno = id_alumno;
	}

	public List<Encargo> getEncargo() {
		return encargo;
	}

	public void setEncargo(List<Encargo> encargo) {
		this.encargo = encargo;
	}

	public List<RA> getRa() {
		return ra;
	}

	public void setRa(List<RA> ra) {
		this.ra = ra;
	}

	public Timestamp getTiempo_inicio() {
		return tiempo_inicio;
	}

	public void setTiempo_inicio(Timestamp tiempo_inicio) {
		this.tiempo_inicio = tiempo_inicio;
	}

	public Timestamp getTiempo_final() {
		return tiempo_final;
	}

	public void setTiempo_final(Timestamp tiempo_final) {
		this.tiempo_final = tiempo_final;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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
		Periodo_Practica other = (Periodo_Practica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
