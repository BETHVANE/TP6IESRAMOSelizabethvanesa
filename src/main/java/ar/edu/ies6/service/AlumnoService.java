package ar.edu.ies6.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Alumnos;
import ar.edu.ies6.repository.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	AlumnoRepository alumnoRepository;

	public void guardarAlumnos(Alumnos alumnos) {
		//metodo para guardar
		alumnos.setEstado(true);
		alumnoRepository.save(alumnos);
	}
	public void eliminarAlumno(Integer dni) throws Exception{
		//eliminar un objeto por su identificador
		Alumnos auxiliar=new Alumnos();
		auxiliar=encontrarUnAlumno (dni);
		auxiliar.setEstado(false);
		alumnoRepository.save(auxiliar);
	}
	public List<Alumnos>buscartodosAlumnos(){
		//algoritmo para buscar alumnos
		//List<Alumnos>listado=new ArrayList<>();{
		//return listado;
		
		return (List<Alumnos>) alumnoRepository.findByEstado(true);
	}
	
    public void modificarAlumnos(Alumnos alumno) {	
    	
    }
    public Alumnos encontrarUnAlumno(Integer dni)throws Exception{
    	return alumnoRepository. findById(dni).orElseThrow(()->new Exception("Alumno no encontrado"));
    }
}
