package com.mindware.mappers;

import com.mindware.domain.Contacto;

import java.util.List;

public interface ContactoMapper {
	List<Contacto> findAllContactos();
	void insertContacto (Contacto contacto);
	void updateContacto(Contacto contacto);
	Contacto findContactoById(int id);
	int deleteContacto(int id);

}
