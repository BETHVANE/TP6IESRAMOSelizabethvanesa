package ar.edu.ies6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import ar.edu.ies6.model.Docente;
import ar.edu.ies6.repository.DocenteRepository;
import org.springframework.stereotype.Service;


@Service
public class DocenteService {
	@Autowired
	DocenteRepository docenteRepository;

	public void guardarDocente(Docente docente) {
		//metodo para guardar
		docente.setEstado(true);
		docenteRepository.save(docente);
	}
	public void eliminarDocente(Integer dni) throws Exception{
		//eliminar un objeto por su identificador
		Docente auxiliar=new Docente();
		auxiliar=encontrarUnDocente (dni);
		auxiliar.setEstado(false);
		docenteRepository.save(auxiliar);
	}
	public List<Docente>buscartodosDocente(){
		//algoritmo para buscar docente
			
		return (List<Docente>) docenteRepository.findByEstado(true);
	}
	
    public void modificarDocente(Docente docente) {	
    	
    }
    public Docente encontrarUnDocente(Integer dni)throws Exception{
    	return docenteRepository. findById(dni).orElseThrow(()->new Exception("Docente no encontrado"));
    }
}
