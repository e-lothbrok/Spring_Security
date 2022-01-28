package com.example.dao;

import com.example.pojo.Usuario;

import java.util.List;

public interface UsuarioDao {
    public Usuario findByUserName(String usuario);

    void saveUser(Usuario usuario);

    List<Usuario> findAll();
}
