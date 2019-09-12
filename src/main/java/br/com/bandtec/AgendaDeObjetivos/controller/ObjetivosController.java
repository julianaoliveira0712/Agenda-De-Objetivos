package br.com.bandtec.AgendaDeObjetivos.controller;

import br.com.bandtec.AgendaDeObjetivos.modelos.Objetivo;
import br.com.bandtec.AgendaDeObjetivos.resources.TodosObjetivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ObjetivosController {
    private TodosObjetivos todosObjetivos;

    @Autowired
    public ObjetivosController(TodosObjetivos todosObjetivos) {
        this.todosObjetivos = todosObjetivos;
    }

    @PostMapping("/objetivos")
    public ResponseEntity<String> inserirObjetivo(@RequestBody Objetivo objetivo){
        todosObjetivos.save(objetivo);
        return  ResponseEntity.ok("Sucesso");
    }

    @GetMapping("/objetivos/data/{data}")
    public ResponseEntity<List<Objetivo>> buscarPorData(@PathVariable("data") String data){
        LocalDate localDate = LocalDate.parse(data);
        List<Objetivo> encontrados = todosObjetivos.ate(localDate);
        if(encontrados.isEmpty()){
            return  ResponseEntity.status(204).body(new ArrayList<Objetivo>());
        }else{
            return ResponseEntity.ok(encontrados);
        }
    }


}
