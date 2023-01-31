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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre", length = 128, nullable = false)
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rol", nullable = false)
	@JsonBackReference
	private Rol rol;
	
	@OneToMany(mappedBy = "id_centro", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<User> id_centro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private User id_empresa;
	
	@OneToMany(mappedBy = "id_alumno", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<User> id_alumno;
	
	@Column(name = "alta", nullable = false)
	private boolean alta;
	
	@Column(name = "documentos", length = 128, unique = true, nullable = false)
	private String documentos;
	
	@Column(name = "correo", length = 100, unique = true, nullable = false)
	private String correo;
	
	@Column(name = "password", length = 20, nullable = true)
	private String password;
	
	public User(Long id, String nombre, Rol rol, List<User> id_centro, User id_empresa, List<User> id_alumno,
			boolean alta, String documentos, String correo, String password) {
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.id_centro = id_centro;
		this.id_empresa = id_empresa;
		this.id_alumno = id_alumno;
		this.alta = alta;
		this.documentos = documentos;
		this.correo = correo;
		this.password = password;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<User> getId_centro() {
		return id_centro;
	}

	public void setId_centro(List<User> id_centro) {
		this.id_centro = id_centro;
	}

	public User getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(User id_empresa) {
		this.id_empresa = id_empresa;
	}

	public List<User> getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(List<User> id_alumno) {
		this.id_alumno = id_alumno;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
