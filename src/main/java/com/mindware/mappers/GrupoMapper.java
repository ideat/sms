package com.mindware.mappers;

import com.mindware.domain.Grupo;

import java.util.List;

/**
 * Created by freddy on 20-08-16.
 */
public interface GrupoMapper {
    List<Grupo> getGruposUsuario(int usuarioId);
    List<Grupo> getGrupoMiembros(int usuarioId);
    void insertGrupo(Grupo grupo);
    int deleteGrupo(int grupoId);

}
