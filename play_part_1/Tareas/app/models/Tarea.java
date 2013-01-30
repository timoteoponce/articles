package models;

import play.*;
import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Tarea extends Model{
	
	@Required
	public String titulo;
	public boolean completada;
	
	public Tarea(String titulo){
		this.titulo = titulo;
	}
	
	public String toString(){
		return id + " - " + titulo;
	}
}
