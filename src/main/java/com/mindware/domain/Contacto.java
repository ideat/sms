package com.mindware.domain;

import java.util.Date;

public class Contacto {

	private int contacto_id;
	private String nombre_contacto;
	private Date fechaImportacion;
	private String celular;
	private String campo1;
	private String campo2;
	private String campo3;
	private String campo4;
	private String campo5;
	private String campo6;
	private String estado;
	private String usuario;
	
	
	public Contacto (int contacto_id, String nombre_contacto, Date fechaImportacion
			, String celular, String campo1, String campo2, String campo3, String campo4
			, String campo5, String campo6, String estado, String usuario) {
		
		this.contacto_id = contacto_id;
		this.nombre_contacto = nombre_contacto;
		this.fechaImportacion = fechaImportacion;
		this.celular = celular;
		this.campo1 = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
		this.campo4 = campo4;
		this.campo5 = campo5;
		this.campo6 = campo6;
		this.estado = estado;
		this.usuario = usuario;
	}
	
	public Contacto (String nombre_contacto, Date fechaImportacion
			, String celular, String campo1, String campo2, String campo3, String campo4
			, String campo5, String campo6, String estado, String usuario) {
		
		this.nombre_contacto = nombre_contacto;
		this.fechaImportacion = fechaImportacion;
		this.celular = celular;
		this.campo1 = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
		this.campo4 = campo4;
		this.campo5 = campo5;
		this.campo6 = campo6;
		this.estado = estado;
		this.usuario = usuario;
	}
	
	public int getContacto_id() {
		return contacto_id;
	}
	public void setContacto_id(int contacto_id) {
		this.contacto_id = contacto_id;
	}
	public String getNombre_contacto() {
		return nombre_contacto;
	}
	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaImportacion() {
		return fechaImportacion;
	}
	public void setFechaImportacion(Date fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}
	public String getCelular() {
		return celular;
	}
	public void  setCelular(String celular) {
		this.celular = celular;
	}
	public String getCampo1() {
		return campo1;
	}
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	public String getCampo2() {
		return campo2;
	}
	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
	public String getCampo3() {
		return campo3;
	}
	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}
	public String getCampo4() {
		return campo4;
	}
	public void setCampo4(String campo4) {
		this.campo4 = campo4;
	}
	public String getCampo5() {
		return campo5;
	}
	public void setCampo5(String campo5) {
		this.campo5 = campo5;
	}
	public String getCampo6() {
		return campo6;
	}
	public void setCampo6(String campo6) {
		this.campo6 = campo6;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
		
	
}
