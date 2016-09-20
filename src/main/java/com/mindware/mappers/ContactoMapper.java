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
	List<Contacto> findContactoByUser(String usuario);
	ArrayList<Contacto> contactSelected(@Param("usuario") String usuario, @Param("list") List<String> celulares);
	int deleteContacto(int id);

}
