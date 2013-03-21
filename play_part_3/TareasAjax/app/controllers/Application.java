package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
	List tareas = Tarea.find("ORDER BY id DESC").fetch();
        render( tareas );
    }

    public static void crearTarea( String titulo ){
	Tarea tarea = new Tarea( titulo ).save();
	renderJSON( tarea );
    }

    public static void cambiarEstado(Long id, boolean completada){
	Tarea tarea = Tarea.findById( id );
	tarea.completada = completada;
	tarea.save();
	renderJSON( tarea );
    }

}
