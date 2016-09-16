package com.mindware.services;

import com.mindware.domain.Contacto;
import com.mindware.mappers.ContactoMapper;
import com.mindware.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by freddy on 03-08-16.
 */
public class ContactoService {
    public List<Contacto> findAllContactos() {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper contactoMapper = sqlSession.getMapper(ContactoMapper.class);
            return contactoMapper.findAllContactos();
        }finally {
            sqlSession.close();
        }
    }

    public Contacto findContactoById(int contactoId) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper contactoMapper = sqlSession.getMapper(ContactoMapper.class);
            return contactoMapper.findContactoById(contactoId);

        } finally {
            sqlSession.close();
        }
    }

    public List<Contacto> findContactoByUser(String usuario) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper contactoMapper = sqlSession.getMapper(ContactoMapper.class);
            return contactoMapper.findContactoByUser(usuario);

        } finally {
            sqlSession.close();
        }
    }

    public void insertaContacto(Contacto contacto) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper contactoMapper = sqlSession.getMapper(ContactoMapper.class);
            contactoMapper.insertContacto(contacto);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void insertarContactos(List<Contacto> contactos) {

        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper contactoMapper = sqlSession.getMapper(ContactoMapper.class);
//            contactos.parallelStream().forEach(contacto -> contactoMapper.insertContacto(contacto));
            for(Contacto contacto:contactos) {
                contactoMapper.insertContacto(contacto);
            }
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }

    public boolean deleteContacto(int id) {
        SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
        try {
            ContactoMapper mapper = sqlSession.getMapper(ContactoMapper.class);
            int count = mapper.deleteContacto(id);
            sqlSession.commit();
            return count > 0;
        }
        catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }

    }


}
