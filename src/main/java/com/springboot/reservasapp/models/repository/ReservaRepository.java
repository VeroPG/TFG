package com.springboot.reservasapp.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.reservasapp.models.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
