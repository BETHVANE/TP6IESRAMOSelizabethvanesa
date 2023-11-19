package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ies6.model.Docente;


// import ar.edu.ies6.model.Docente;
public class listadodeDocente {

	private static List <Docente> listado = new ArrayList<>();
	public listadodeDocente() {	
	}
	public static List<Docente> getListado(){
		return listado;
	}
	public static void setListado(List<Docente> listado) {
		listadodeDocente.listado=listado;
	}
		
}