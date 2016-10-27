package com.mindware.domain;

import java.util.Date;

public class Mensaje {
	private Integer mensaje_id;
	private String mensaje;
	private Date fecha_envio;
	private Date hora_envio;
	private String enviado;
	private String nombre;
	private String grupo;
	private String celular;
	private Integer contacto_id;
	private Integer longitud_sms;
	private Integer numero_intentos;

	public Integer getContacto_id() {
		return contacto_id;
	}

	public void setContacto_id(Integer contacto_id) {
		this.contacto_id = contacto_id;
	}

	public Integer getLongitud_sms() {
		return longitud_sms;
	}

	public void setLongitud_sms(Integer longitud_sms) {
		this.longitud_sms = longitud_sms;
	}

	public Integer getNumero_intentos() {
		return numero_intentos;
	}

	public void setNumero_intentos(Integer numero_intentos) {
		this.numero_intentos = numero_intentos;
	}

	public Integer getMensaje_id() {
		return mensaje_id;
	}
	public void setMensaje_id(Integer mensaje_id) {
		this.mensaje_id = mensaje_id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
