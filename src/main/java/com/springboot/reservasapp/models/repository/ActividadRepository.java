package com.springboot.reservasapp.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.reservasapp.models.entity.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
	
	public List<Actividad> findByEstado(String estado);
	
	@Query("select a from Actividad a where a.tipo.idTipo = ?1")
	public List<Actividad> findByTipo(String idTipo);
	

}
