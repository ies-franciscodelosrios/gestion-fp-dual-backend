package gestionfp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="encargos")
public class Encargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_periodo", nullable = false)
	@JsonBackReference
	private Periodo_Practica periodo_practica;
	
	@Column(name = "tarea", length = 128, nullable = false)
	private String tarea;
	
	@Column(name = "fecha", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Timestamp fecha;
	
	@Column(name = "estado", nullable = false)
	private boolean estado;
	
	@Column(name = "comentario", length = 128, nullable = false)
	private String comentario;
	
	public Encargo(Long id, Periodo_Practica periodo_practica, String tarea, Timestamp fecha, boolean estado,
			String comentario) {
		super();
		this.id = id;
		this.periodo_practica = periodo_practica;
		this.tarea = tarea;
		this.fecha = fecha;
		this.estado = estado;
		this.comentario = comentario;
	}

	public Encargo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Periodo_Practica getPeriodo_practica() {
		return periodo_practica;
	}

	public void setPeriodo_practica(Periodo_Practica periodo_practica) {
		this.periodo_practica = periodo_practica;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		Encargo other = (Encargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
