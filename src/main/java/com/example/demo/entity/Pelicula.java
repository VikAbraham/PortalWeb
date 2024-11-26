package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pelicula")
public class Pelicula implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message="Debes agregar el título de la película")
	private String titulo;
	
	@NotNull (message="Debes agregar el año de la película")
	@Min(value=1895,message="La primera película fue en 1895, de ahí en adelante papu")
	@Max(value=2077, message="2077 es el límite, por Cyberpunk, por eso")
	private Long anio;
	
	@NotBlank (message="Debes agregar director de la película")
	private String director;
	
	@NotBlank (message="Debes agregar el género de la película")
	private String genero;
	
	@NotBlank (message="Debes agregar la sinopsis de la película")
	private String sinopsis;
	
	@NotNull (message="Debes agregar la duración de la película")
	@Min(value=1,message="Mínimo de 1 minutos")
	@Max(value=1000, message="El límite de tiempo son 1000 minutos")
	private Long duracion;
	
	@NotBlank (message="Debes agregar la url de la película")
	private String imagen;
	@Column (name="create_at")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	public Pelicula() {
		super();
	}
	
	//Getter and Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getAnio() {
		return anio;
	}
	public void setAnio(Long anio) {
		this.anio = anio;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
