package com.eliseubrito.sistemacontrole.controller;

import com.eliseubrito.sistemacontrole.model.Empresa;
import com.eliseubrito.sistemacontrole.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping
    public List<Empresa> getEmpresaList() {
        return empresaService.findAll();
    }

    @PostMapping
    public Empresa createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping("/{idEmpresa}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        return ResponseEntity.ok(empresaService.getById(idEmpresa).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa) {
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity deleteByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        try {
            empresaService.deleteEmpresa(idEmpresa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();

    }

}
