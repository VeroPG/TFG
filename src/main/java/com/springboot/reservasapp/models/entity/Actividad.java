package com.springboot.reservasapp.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name="ACTIVIDADES")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ACTIVIDAD")
	private int idActividad;

	private String nombre;

	private String descripcion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	//Indicando esta etiqueta Spring será capaz de entender la fecha que proviene
	//del tipo date en el input de HTML5
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;


	private BigDecimal precio;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="ID_TIPO")
	private Tipo tipo;

	
	public Actividad() {
		super();
	}


	public Actividad(int idActividad, String nombre, String descripcion, String estado, Date fechaInicio,
			int minimoAsistencia, BigDecimal precio, Tipo tipo) {
		super();
		this.idActividad = idActividad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.precio = precio;
		this.tipo = tipo;
	}


	public int getIdActividad() {
		return idActividad;
	}


	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + idActividad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Actividad other = (Actividad) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (idActividad != other.idActividad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Actividad [idActividad=" + idActividad + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", fechaInicio=" + fechaInicio 
				+ ", precio=" + precio + ", tipo=" + tipo + "]";
	}

	
	
}