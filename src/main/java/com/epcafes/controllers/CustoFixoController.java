package com.epcafes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epcafes.entities.CustoFixo;
import com.epcafes.services.CustoFixoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/custoFixo")
public class CustoFixoController {

    @Autowired
    private CustoFixoService custoFixoService;

    
    @PostMapping
    public String salvar(@Valid CustoFixo custoFixo) {
    	
    	custoFixo.setTenantId(1L);
        custoFixoService.salvar(custoFixo);
        return "redirect:/custoFixo";
    }
    
    @GetMapping
    public String listarCustosFixos(Model model) {
    	
        model.addAttribute("listaCustosFixos", custoFixoService.buscarTodos());
        model.addAttribute("newCustoFixo", new CustoFixo());
        return "custoFixo";
    }
  
}
