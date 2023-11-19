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

import ar.edu.ies6.model.Alumnos;
import ar.edu.ies6.service.AlumnoService;

@Controller
public class Alumnocontroller {
	
	@Autowired
	Alumnos alu;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping ({"/index","/","/home"})
	public ModelAndView cargarAlumno () {
		Alumnos alu= new Alumnos();
		alu.setFechaNac(LocalDate.of(1988, 6,15));
        System.out.println("Edad:"+alu.getEdad());
        
		ModelAndView modelView= new ModelAndView("index");
		modelView.addObject("alumno",alu);
		return modelView;
	}
		
  @PostMapping("/cargarAlumno")
   public ModelAndView cargarAlumno(@ModelAttribute("alumnos")Alumnos alumnos) {
	  //primero
	  //tengo que cargar el alumno, en donde ESTRUCTURA DE DATO(BD tabla)
	  //todo guardar el alumno en una lista
	  //List<Alumnos>listado=new ArrayList<>();
	  
	  //Listadodealumno.getListado().add(alumnos);
	  // ahora se guarda en la bd
	  alumnoService.guardarAlumnos(alumnos);
	  
	  
	  ModelAndView modelView=new ModelAndView("listadoalumno");
	  
	  //modelView.addObject("listado",Listadodealumno.getListado());
	  //buscar desde la BD
	  modelView.addObject("listado",alumnoService.buscartodosAlumnos());
	  return modelView;
		}
  @GetMapping("/eliminarAlumno/{dni}")
  public String eliminarAlumnos(@PathVariable Integer dni)throws Exception {
	  //System.out.println("entrando al metodo "+dni);
	  //for(int i=0;i<Listadodealumno.getListado().size();i++) {
	 // if(Listadodealumno.getListado().get(i).getDni().equals(dni)) {
	//Listadodealumno.getListado().remove(i);
	  alumnoService.eliminarAlumno(dni);
	  return"redirect:/mostrarlistado";
	  } 
  @GetMapping("/mostrarlistado")
  public ModelAndView mostrarAlumno() {
	  ModelAndView listado=new ModelAndView("listadoalumno");
	  //modelView.addObject("listado", Listadodealumno.getListado());
	  listado.addObject("listado",alumnoService.buscartodosAlumnos());
	  return listado;
	  }
  @GetMapping("/modificarAlumno/{dni}")
  public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception{
	  ModelAndView modifica=new ModelAndView("index");
	  //modelView.addObject("listado", Listadodealumno.getListado());
	  modifica.addObject("alumno",alumnoService.encontrarUnAlumno(dni));
	  return modifica;
	  }
  @PostMapping("/modificarAlumno")
  public ModelAndView modicarUnAlumno(@ModelAttribute("alumnos")Alumnos alumnos) {
	  
	  alumnoService.guardarAlumnos(alumnos);
	   
	  ModelAndView modelView=new ModelAndView("listadoalumno");
	  
	  modelView.addObject("listado",alumnoService.buscartodosAlumnos());
	  return modelView;
	  }
  
  @GetMapping("/listadoalumno/volver")
  public ModelAndView volver() {
	  ModelAndView modelAndView=new ModelAndView("redirect:/index");
	  
	  return modelAndView;
  }
}