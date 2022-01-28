package com.example.dao;

import com.example.pojo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public Usuario findByUserName(String usuario) {
        Criteria  criteria = getSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("usuario", usuario));
        return (Usuario) criteria.uniqueResult();
    }

    @Override
    public void saveUser(Usuario usuario) {
        getSession().save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return getSession().createQuery("from Usuario").list();
    }
}
