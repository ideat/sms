package com.mindware.domain;

import java.util.Date;

public class Mensaje {
	private Integer mensaje_id;
	private Integer miembro_grupo_id;
	private String mensaje_enviado;
	private Date fecha_envio;
	private Date hora_envio;
	private String enviado;
	public Integer getMensaje_id() {
		return mensaje_id;
	}
	public void setMensaje_id(Integer mensaje_id) {
		this.mensaje_id = mensaje_id;
	}
	public Integer getMiembro_grupo_id() {
		return miembro_grupo_id;
	}
	public void setMiembro_grupo_id(Integer miembro_grupo_id) {
		this.miembro_grupo_id = miembro_grupo_id;
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
	
	
	
}
