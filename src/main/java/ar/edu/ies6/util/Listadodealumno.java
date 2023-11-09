package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;
import ar.edu.ies6.model.Alumnos;

public class Listadodealumno {

	private static List <Alumnos> listado = new ArrayList<>();
	public Listadodealumno() {	
	}
	public static List<Alumnos> getListado(){
		return listado;
	}
	public static void setListado(List<Alumnos> listado) {
		Listadodealumno.listado=listado;
	}
		
}
