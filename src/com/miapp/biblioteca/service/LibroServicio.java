package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Resena;



public class LibroServicio {
	
	private ArrayList<Libro> biblioteca;
	
	public LibroServicio(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
		}
	
	public void crearLibro(String titulo, String autor, String ISBN, String genero, String descripcion) {
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero, descripcion);
		biblioteca.add(nuevoLibro);
	}
	public void agregarLibro(Libro libro) {
		biblioteca.add(libro);
	}
    public void actualizarLibro (String ISBN, String nuevoTitulo, String nuevoAutor,String nuevoGenero, String nuevaDescripcion) {
    	
    	for(Libro libro : biblioteca) {
    		if(libro.getISBN().equals(ISBN)) {
    			libro.setTitulo(nuevoTitulo);
    			libro.setAutor(nuevoAutor);
    			libro.setGenero(nuevoGenero);
    			libro.setDescripcion(nuevaDescripcion);
    		}
    	}
    }
    public void eliminarLibro(String ISBN) {
    	Iterator<Libro> it = biblioteca.iterator();
    	
    	while (it.hasNext()) {
    		
    		if (it.next().getISBN().equals(ISBN)) {
    			it.remove();
    		}
    	}
    }
    public Libro buscarLibroPorISBN(String ISBN) {
    	for(Libro libro : biblioteca) {
    		if (libro.getISBN().equals(ISBN)) {
    			return libro;
    		}
    	}
    	System.out.println("El ISBN " + ISBN + " no está registrado.");
    	return null;
    }
    //buscar un libro por titulo o parte del titulo
    public ArrayList<Libro> buscarLibrosPorTitulo(String titulo){
    	ArrayList<Libro>librosEncontrados = new ArrayList<>();
    	for(Libro libro: biblioteca) {
    		if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
    			librosEncontrados.add(libro);
    		}
    	}
    	return librosEncontrados;
    }
    //por autor o por parte del nombre del autor
    public ArrayList<Libro> buscarLibrosPorAutor(String autor){
    	ArrayList<Libro>librosEncontrados = new ArrayList<>();
    	for(Libro libro: biblioteca) {
    		if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
    			librosEncontrados.add(libro);
    		}
    	}
    	return librosEncontrados;
    }
    public boolean verificarDisponibilidad(Libro libro) {
    	return libro.isDisponibilidad();
    }

	public ArrayList<Libro> obtenerTodosLosLibros() {
		
		return biblioteca;
	}
	public void agregarResena(Libro libro, Resena resena) {
		 // Obtener la lista de reseñas del libro
        ArrayList<Resena> listaResenas = libro.getListaResenas();
        
        // Agregar la nueva reseña a la lista de reseñas del libro
        listaResenas.add(resena);
        
        // Actualizar la lista de reseñas del libro
        libro.setListaResenas(listaResenas);
        
        // Calcular la calificación promedio del libro
        libro.calcularCalificacionPromedio();
        
	}
	//public void agregarCalificacion(Libro libro, double calificacion) {
	//	libro.setCalificacion(calificacion);
	//}
}
