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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message="Debe ingresar un nombre de usuario")
	private String nombre;
	
	@NotBlank(message="Debe ingresar un correo")
	@Email (message="Debe ingresar un correo válido")
    private String correo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull (message="Debe ingresar una fecha")
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;
	
	@NotBlank (message="Debe ingresar una contraseña")
    private String pass;
	
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
    
    public Usuario() {
		super();
	}
}
