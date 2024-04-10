package com.miapp.biblioteca.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;

public class UsuarioServicio {
	private ArrayList<Usuario> usuarios;

	public UsuarioServicio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;

	}
	public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
	public void crearUsuario(String nombre, String id, String correo) {

		// verifico si el correo ya esta registrado

		for (Usuario usuario : usuarios) {
			if (usuario.getCorreo().equals(correo)) {
				System.out.println("El correo ya esta registrado");
				return;
			} else {

				// si el correo no esta registrado, creo el nuevo usuario

				Usuario nuevoUsuario = new Usuario(nombre, id, correo);
				usuarios.add(nuevoUsuario);
				System.out.println("Usuario creado exitosamente");
				return;
			}
		}
	}

	public void actualizarUsuario(String id, String nuevoNombre, String nuevoCorreo) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				usuario.setNombre(nuevoNombre);
				usuario.setCorreo(nuevoCorreo);
				return;
			}
		}
	}

	public void eliminarUsuariosPorId(String id) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {
				it.remove();
			}
		}

	}

	public void eliminarUsuariosPorCorreo(String correo) {
		Iterator<Usuario> it = usuarios.iterator();

		while (it.hasNext()) {
			if (it.next().getCorreo().equals(correo)) {
				it.remove();
			}
		}

	}
	public Usuario buscarUSuarioPorId(String id) {
		for(Usuario usuario : usuarios) {
			if(usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}
	public Usuario buscarUsuarioPorCorreo(String correo) {
	   	    for (Usuario usuario : usuarios) {
	        if (usuario.getCorreo().equals(correo)) {
	            return usuario;
	          
	        }
	    }
			return null;
	  
	}
	public void prestarLibro(Usuario usuario, Libro libro) {
		if (libro.isDisponibilidad()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponibilidad(false);
			
		} else {
			System.out.println("El libro no está disponible");
		}
	}
	public void devolverLibro(Usuario usuario, Libro libro) {
		if(usuario.getLibrosPrestados().contains(libro)) {
			usuario.getLibrosPrestados().remove(libro);
			libro.setDisponibilidad(true);
			}else {
				System.out.println("Este libro no fue prestado a este usuario.");
			}
	}
	public ArrayList<Libro> obtenerLibrosPrestados(Usuario usuario){
		return usuario.getLibrosPrestados();
	}
}
