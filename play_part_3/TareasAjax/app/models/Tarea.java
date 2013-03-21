package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Tarea extends Model{

	public String titulo;
	public boolean completada;

	public Tarea(String titulo){
		this.titulo = titulo;
	}
}
