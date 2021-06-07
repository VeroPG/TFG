package com.springboot.reservasapp.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.reservasapp.models.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
