package com.eliseubrito.sistemacontrole.controller;

import com.eliseubrito.sistemacontrole.model.Localidade;
import com.eliseubrito.sistemacontrole.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @GetMapping
    public List<Localidade> getLocalidadeList() {
        return localidadeService.findAll();
    }

    @PostMapping
    public Localidade createLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.saveLocalidade(localidade);
    }

    @GetMapping("/{idLocalidade}")
    public ResponseEntity<Localidade> getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        return ResponseEntity.ok(localidadeService.getById(idLocalidade).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Localidade updateLocalidade(@RequestBody Localidade localidade) {
        return localidadeService.updateLocalidade(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity deleteByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        try {
            localidadeService.deleteLocalidade(idLocalidade);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();

    }

}
