package com.example.crud.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuariosRepository extends JpaRepository <Usuarios, Long> {
    Optional <Usuarios> findByUsername(String username);

    Boolean existsByUsername(String username);
}
