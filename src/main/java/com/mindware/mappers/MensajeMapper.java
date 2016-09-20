package com.mindware.mappers;

import com.mindware.domain.Mensaje;

import java.util.List;

/**
 * Created by freddy on 18-09-16.
 */
public interface MensajeMapper {
    void insertarMensaje(Mensaje mensaje);
    List<String> findAllMensajesUsuario(String usuario);
}
