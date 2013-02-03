package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Tareas extends Controller {

    public static void index(String filtro) {
    	List<Tarea> tareas;
    	if(filtro == null || filtro.isEmpty()){
    		tareas = Tarea.findAll();
    	}else{
    		tareas = Tarea.findByTitulo( filtro );
    	}
    	renderArgs.put("filtro" , filtro);
    	renderArgs.put("tareas" , tareas);
        render();
    }
    
    public static void addTarea(@Required @MinSize(value = 3) String nombre){    	
    	if(validation.hasErrors()){
    		flash.error("Por favor ingrese el nombre de la tarea.");
    	}else{
    		Tarea tarea = new Tarea(nombre).save();
    	}
    	index( null );	
    }  
    
    public static void verTarea(Long idTarea){
    	Tarea tarea = Tarea.find( "byId" , idTarea).first();
    	render( tarea );
    } 
    
    public static void completarTarea(Long idTarea){
    	System.out.println(">> "+idTarea);
    	Tarea tarea = Tarea.find( "byId" , idTarea).first();
    	tarea.completada = true;
    	tarea.save();
    	index( null );
    }
    
}
