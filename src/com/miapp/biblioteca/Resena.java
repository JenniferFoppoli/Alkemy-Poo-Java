package com.miapp.biblioteca;

public class Resena {
	private String texto;
    private double calificacion;
    private Usuario usuario;
    private Libro libro;


    

	public Resena(String texto, double calificacion, Usuario usuario, Libro libro) {
		this.texto = texto;
		this.calificacion = calificacion;
		this.usuario = usuario;
		this.libro = libro;
	}

	public Resena() {
		// TODO Auto-generated constructor stub
	}

	

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	//public String getTituloLibro() {
		//return tituloLibro;
	//}

	//public void setTituloLibro(String tituloLibro) {
	//	this.tituloLibro = tituloLibro;
	//}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	 @Override
	    public String toString() {
	        return "Reseña: " + texto + ", Calificación: " + calificacion;
	    }
}
