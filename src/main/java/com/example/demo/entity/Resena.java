package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="resena")
public class Resena implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	@NotNull (message="Usuario no debe estar vacío")
	private Usuario id_usuario;
	
	@ManyToOne
	@JoinColumn(name="id_pelicula")
	@NotNull (message="Debes seleccionar una película")
    private Pelicula id_pelicula;
	
	@NotNull (message="Debes ingresar una puntuación entre 1 y 10")
	@DecimalMin(value="1", message="Sé que no te gustó pero el mínimo es 1")
	@DecimalMax(value="10", message="Vaya que te gustó! pero el máximo es 10")
    private BigDecimal puntuacion;
	
	@NotBlank (message="Debes ingresar un comentario")
    private String comentario;
    private Date createAt;

    @PrePersist
    protected void onCreate() {
    	this.createAt = Calendar.getInstance().getTime();
    }
    
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Pelicula getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Pelicula id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public BigDecimal getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(BigDecimal puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


    public Resena() {
		super();
	}
}
