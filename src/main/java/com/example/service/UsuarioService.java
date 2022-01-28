package com.example.service;

import com.example.dao.UsuarioDao;
import com.example.pojo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(Usuario usuario) {
        usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
        String claveUsr = usuario.getClave();
        usuario.setClave(passwordEncoder.encode(claveUsr));
        usuarioDao.saveUser(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }
}
