package com.mindware.mappers;

import com.mindware.domain.Contacto;
import com.mindware.domain.Grupo;

import java.util.List;

/**
 * Created by freddy on 21-09-16.
 */
public interface ContactoGrupoMapper {
    int deleteContactoGrupo(int contactoId, int grupoId);
    int addContactoGrupo(int contactoId, int grupoId);
    List<Contacto> getContactosGrupo(int grupoId);
    List<Grupo> getGrupos(int contactoId);
}
