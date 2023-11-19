package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.ies6.model.Alumnos;


@Repository 
public interface AlumnoRepository extends CrudRepository < Alumnos, Integer>{

	public List<Alumnos>findByEstado(Boolean estado);
}
