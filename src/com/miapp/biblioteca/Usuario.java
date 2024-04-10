package com.miapp.biblioteca;

import java.util.ArrayList;

//La clase Usuario debe incluir atributos como nombre,
//número de identificación y lista de libros prestados.

public class Usuario {
	private String id;
    private String nombre;
    private String correo;
    private ArrayList<Libro> librosPrestados;
   
    
    //constructor vacio
    public Usuario() {}

    //constructor
    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.librosPrestados= new ArrayList<>();   
               
    }
    // Getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
			 
	    };
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	public void setLibrosPrestados(ArrayList<Libro> librosPrestados) {
		this.librosPrestados = librosPrestados;
	}
	
	  public void prestarLibro(Libro libro) {
	        librosPrestados.add(libro);
	    }

	    public void devolverLibro(Libro libro) {
	        librosPrestados.remove(libro);
	    }
	    
	    @Override
	    public String toString()
	    {
	    	return "Usuario [nombre=" + nombre + "id=" + id + "correo = " + correo +"]";
	    }
}
