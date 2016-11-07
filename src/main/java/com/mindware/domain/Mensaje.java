package com.mindware.domain;

import java.util.Date;

public class Mensaje {
	private Integer mensajeId;
	private String mensaje;
	private Date fecha_envio;
	private Date hora_envio;
	private String enviado;
	private String nombre;
	private String grupo;
	private String celular;
	private Integer contactoId;
	private Integer longitudSms;
	private Integer numero_intentos;
	private Integer grupoId;
	private Integer usuarioId;

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Integer getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(Integer grupoId) {
		this.grupoId = grupoId;
	}

	public Integer getContactoId() {
		return contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

	public Integer getLongitudSms() {
		return longitudSms;
	}

	public void setLongitudSms(Integer longitudSms) {
		this.longitudSms = longitudSms;
	}

	public Integer getNumero_intentos() {
		return numero_intentos;
	}

	public void setNumero_intentos(Integer numero_intentos) {
		this.numero_intentos = numero_intentos;
	}

	public Integer getMensajeId() {
		return mensajeId;
	}
	public void setMensajeId(Integer mensajeId) {
		this.mensajeId = mensajeId;
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
