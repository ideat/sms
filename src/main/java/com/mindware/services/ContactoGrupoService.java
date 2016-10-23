package com.mindware.services;

import com.mindware.domain.Contacto;
import com.mindware.mappers.GrupoMapper;
import com.mindware.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by freddy on 24-09-16.
 */
public class ContactoGrupoService {

public List<Contacto> getContactosGrupo(int grupoId){
    SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
    try {
        GrupoMapper grupoMapper= sqlSession.getMapper(GrupoMapper.class);
        return grupoMapper.getContactosGrupo(grupoId);
    }
    finally {
        sqlSession.close();
    }
}


}
