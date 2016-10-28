package com.mindware.mappers;

import com.mindware.domain.Contacto;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface ContactoMapper {
	List<Contacto> findAllContactos();
	void insertContacto(Contacto contacto);
	//void updateContacto(Contacto contacto);
	Contacto findContactoById(int id);
	List<Contacto> findContactoByUser(int usuarioId);
	List<Contacto> findAvailableContactoByGroup(int grupoId);
	List<Contacto> findAvailableContactoActivo();
	ArrayList<Contacto> contactSelected(@Param("usuarioId") int usuarioId, @Param("list") List<String> celulares);
	ArrayList<Contacto> contactByGroup(int grupoId);
	int deleteContacto(int id);

}
