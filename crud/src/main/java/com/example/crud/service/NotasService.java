package com.example.crud.service;

import com.example.crud.DB.Notas;
import com.example.crud.dto.NotasDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.crud.DB.NotasRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class NotasService {

    NotasRepository notasRepository;



    public List<Notas> seeNotas(){
        return notasRepository.findAll();
    }

    public Notas insertNotas(NotasDTO notasDTO){
        Notas notas = new Notas();
        notas.setNombre_estudiante(notasDTO.getNombre_estudiante());
        notas.setMateria(notasDTO.getMateria());
        notas.setNota(notasDTO.getNota());
        notasRepository.save(notas);
        return notas;
    }
}
