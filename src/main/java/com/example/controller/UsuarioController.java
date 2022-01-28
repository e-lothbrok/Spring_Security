package com.example.controller;

import com.example.pojo.Usuario;
import com.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/usuario")
    public String showUsuario(Model model,
                              @ModelAttribute("resultado") String resultado){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("resultado", resultado);
        return "usuario";
    }

    @RequestMapping("/usuario/save")
    public String saveUsuario(Model model, RedirectAttributes ra,
                              @ModelAttribute("usuario") Usuario usuarioForm){
        usuarioService.saveUser(usuarioForm);
        ra.addFlashAttribute("resultado", "cambios guardados");
        return "redirect:/usuario";
    }
}
