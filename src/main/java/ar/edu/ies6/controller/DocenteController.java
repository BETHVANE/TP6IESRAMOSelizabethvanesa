package ar.edu.ies6.controller;


 import java.time.LocalDate;
//import java.util.ArrayList;
 //import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Docente;
import ar.edu.ies6.service.DocenteService;

 
@Controller
public class DocenteController{
	
	@Autowired
	Docente doc;
	
	@Autowired
	DocenteService docenteService;
	
	@GetMapping ({"/base","/","/home"})
	public ModelAndView cargarAlumno () {
		Docente doc= new Docente();
		doc.setFechaNac(LocalDate.of(1988, 6,15));
        System.out.println("Edad:"+doc.getEdad());
        
		ModelAndView modelView= new ModelAndView("base");
		modelView.addObject("docente",doc);
		return modelView;
	}
		
  @PostMapping("/cargarDocente")
   public ModelAndView cargarDocente(@ModelAttribute("docente")Docente docente) {
	  //primero
	  //tengo que cargar el alumno, en donde ESTRUCTURA DE DATO(BD tabla)
	  //todo guardar el alumno en una lista
	  //List<Alumnos>listado=new ArrayList<>();
	  
	  //Listadodealumno.getListado().add(alumnos);
	  // ahora se guarda en la bd
	  docenteService.guardarDocente(docente);
	  
	  
	  ModelAndView modelView=new ModelAndView("listadoDocente");
	  
	  //modelView.addObject("listado",Listadodealumno.getListado());
	  //buscar desde la BD
	  modelView.addObject("listado",docenteService.buscartodosDocente());
	  return modelView;
		}
  @GetMapping("/eliminarDocente/{dni}")
  public String eliminarDocente(@PathVariable Integer dni)throws Exception {
	  docenteService.eliminarDocente(dni);
	return"redirect:/mostrarlistado";
	  } 
  @GetMapping("/mostrarlistado")
  public ModelAndView mostrarDocente() {
	  ModelAndView listado=new ModelAndView("listadoDocente");
	  //modelView.addObject("listado", Listadodealumno.getListado());
	  listado.addObject("listado",docenteService.buscartodosDocente());
	  return listado;
	  }
  @GetMapping("/modificarDocente/{dni}")
  public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception{
	  ModelAndView modifica=new ModelAndView("base");
	  //modelView.addObject("listado", ListadodeDocente.getListado());
	  modifica.addObject("docente",docenteService.encontrarUnDocente(dni));
	  return modifica;
	  }
  @PostMapping("/modificarDocente")
  public ModelAndView modicarUnDocente(@ModelAttribute("docente")Docente docente) {
	  
	  docenteService.guardarDocente(docente);
	   
	  ModelAndView modelView=new ModelAndView("listadoDocente");
	  
	  modelView.addObject("listado",docenteService.buscartodosDocente());
	  return modelView;
	  }
  
  @GetMapping("/listadoDocente/volver")
  public ModelAndView volver() {
	  ModelAndView modelAndView=new ModelAndView("redirect:/base");
	  
	  return modelAndView;
  }
}
