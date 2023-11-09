package ar.edu.ies6.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.ies6.model.Alumnos;
import ar.edu.ies6.util.Listadodealumno;

@Controller
public class Alumnocontroller {
	
	@GetMapping ({"/index","/","/home"})
	public ModelAndView cargarAlumno () {
		Alumnos alu= new Alumnos();
		alu.setFechaNac(LocalDate.of(1988, 6,15));
        System.out.println("Edad:"+alu.getEdad());
		ModelAndView modelView= new ModelAndView("index");
		modelView.addObject("Alumnos",alu);
		return modelView;
	}
		
  @PostMapping("/cargarAlumno")
   public ModelAndView cargarAlumno(@ModelAttribute("alumnos")Alumnos alumnos) {
	  
	  List<Alumnos>listado=new ArrayList<>();
	  listado.add(alumnos);
	  
	  ModelAndView modelView=new ModelAndView("listadoAlumno");
	  
	  modelView.addObject("listado",listado);
	  return modelView;
		}
  @GetMapping("/eliminarAlumnos/{dni}")
  public ModelAndView eliminarAlumnos(@PathVariable Integer dni) {
	  
	  for(int i=0;i<Listadodealumno.getListado().size();i++) {
	  if(Listadodealumno.getListado().get(i).getDni().equals(dni)) {
	Listadodealumno.getListado().remove(i);
	  }  
	}
	  ModelAndView modelView=new ModelAndView("listadoalumno");
	  modelView.addObject("listado", Listadodealumno.getListado());
	  return modelView.addOject("redireccion"," /index");
	  }
  
}
