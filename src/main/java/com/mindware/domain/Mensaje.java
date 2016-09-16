package com.mindware.domain;

import java.util.Date;

public class Mensaje {
	private Integer mensaje_id;
	private String mensaje_enviado;
	private Date fecha_envio;
	private Date hora_envio;
	private String enviado;
	private String nombre;
	private String grupo;
	private String celular;

	public Integer getMensaje_id() {
		return mensaje_id;
	}
	public void setMensaje_id(Integer mensaje_id) {
		this.mensaje_id = mensaje_id;
	}
	public String getMensaje_enviado() {
		return mensaje_enviado;
	}
	public void setMensaje_enviado(String mensaje_enviado) {
		this.mensaje_enviado = mensaje_enviado;
	}
	public Date getFecha_envio() {
		return fecha_envio;
	}
	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}
	public Date getHora_envio() {
		return hora_envio;
	}
	public void setHora_envio(Date hora_envio) {
		this.hora_envio = hora_envio;
	}
	public String getEnviado() {
		return enviado;
	}
	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}
