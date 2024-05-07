package com.example.crud.controller;


import com.example.crud.DB.Notas;
import com.example.crud.dto.NotasDTO;
import com.example.crud.service.NotasService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/notas")
public class NotasController {

    NotasService notasService;

    @GetMapping(path = "ver-notas")
    public List<Notas> verNotas(){
        return notasService.seeNotas();
    }

    @PostMapping(path = "insertar-nota")
    public String insertarNota(@RequestBody NotasDTO notasDTO){
        notasService.insertNotas(notasDTO);
        return "Se insertaron las notas con exito";
    }
}
