package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/probar-conexion")
    public String probarConexion(Model model) {

        try {
            jdbcTemplate.execute("SELECT 1");
            model.addAttribute("mensaje", "✅ Conexión exitosa a la base de datos");
        } catch (Exception e) {
            model.addAttribute("mensaje", "❌ Error en la conexión: " + e.getMessage());
        }

        return "index";
    }
}
