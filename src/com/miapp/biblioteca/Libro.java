package com.miapp.biblioteca;

import java.util.ArrayList;

//La clase Libro debe incluir atributos como título, autor, ISBN,
//género y disponibilidad.

public class Libro {
	
	    
	    private String titulo;
	    private String autor;
	    private String ISBN;
	    private String genero;
	    private boolean disponibilidad;
	    private String descripcion;
	    private Resena resena;
	    private double calificacion;
	    private ArrayList<Resena> listaResenas;
	    
	   //constructor vacio
	    public Libro() {}

	    public Libro(String titulo, String autor, String ISBN, String genero, String descripcion) {
	       
	        this.titulo = titulo;
	        this.autor = autor;
	        this.ISBN = ISBN;
	        this.genero = genero;
	        this.disponibilidad = true;
	        this.descripcion= descripcion;
	       this.calificacion = 0.0; // Calificación inicial
	      //  this.resena = ""; // Reseña inicial vacía
	        this.listaResenas = new ArrayList<>();
	    }

	    // Getters y setters
	    public String getISBN() {
	        return ISBN;
	    }

	    public void setISBN(String ISBN) {
	        this.ISBN = ISBN;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getAutor() {
	        return autor;
	    }

	    public void setAutor(String autor) {
	        this.autor = autor;
	    }
	    public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public boolean isDisponibilidad() {
			return disponibilidad;
		}

		public void setDisponibilidad(boolean disponibilidad) {
			this.disponibilidad = disponibilidad;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getCalificacion() {
			return calificacion;
		}

		public void setCalificacion(double calificacion) {
			this.calificacion = calificacion;
		}

		public Resena getResena() {
			return resena;
		}

		public void setResena(Resena resena) {
			this.resena = resena;
		}

		public ArrayList<Resena> getListaResenas() {
			return listaResenas;
		}

		public void setListaResenas(ArrayList<Resena> listaResenas) {
			this.listaResenas = listaResenas;
		}

		public void agregarResena(Resena resena) {
	        listaResenas.add(resena);
	        
	        // Actualizar la calificación promedio basada en la nueva reseña
	        calcularCalificacionPromedio();
	    }

	    public void calcularCalificacionPromedio() {
	        double sumaCalificaciones = 0;
	        for (Resena resena : listaResenas) {
	            sumaCalificaciones += resena.getCalificacion();
	        }
	       
			if (listaResenas.size() > 0) { // Evitar división por cero
	            calificacion = sumaCalificaciones / listaResenas.size();
	        } else {
	            calificacion = 0; // Si no hay reseñas, la calificación promedio es 0
	        }
	    }
	    public double getCalificacionPromedio() {
	        return calificacion;
	    }
	    
	    @Override
	    public String toString() {
	    	return "Libro[titulo=" + titulo +", Autor=" + autor +", ISBN= " + ISBN + ", genero= " + genero + ", disponibilidad=" + disponibilidad + "]";
	    }
	    
		
}


