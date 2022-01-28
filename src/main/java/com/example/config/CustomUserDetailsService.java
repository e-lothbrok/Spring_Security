package com.example.config;

import com.example.dao.UsuarioDao;
import com.example.pojo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Usuario usuario = usuarioDao.findByUserName(s);

        if (usuario != null){
            authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
            User user =  new User(usuario.getUsuario(), usuario.getClave(), authorities);
            return user;
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

    }
}
