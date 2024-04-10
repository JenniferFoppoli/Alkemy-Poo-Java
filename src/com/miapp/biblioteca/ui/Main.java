package com.miapp.biblioteca.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Resena;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.service.LibroServicio;
import com.miapp.biblioteca.service.UsuarioServicio;

public class Main {

	public static void main(String[] args) {
		ArrayList<Libro> biblioteca = new ArrayList<>();
		ArrayList<Usuario> usuarios = new ArrayList<>();
		LibroServicio libroService = new LibroServicio(biblioteca);
		UsuarioServicio usuarioService = new UsuarioServicio(usuarios);		
		Scanner scanner = new Scanner(System.in);
		
		//creo usuarios y libros a fines practicos
		
		Usuario usuario1 = new Usuario("29905379", "Jennifer", "jennifer@hotmail.com");
		Usuario usuario2 = new Usuario("52779110", "Neiel", "neil@hotmail.com");
		Usuario usuario3 = new Usuario("43444716", "Alejandro", "alejandro@hotmail.com");
		usuarioService.agregarUsuario(usuario1);
		usuarioService.agregarUsuario(usuario2);
		usuarioService.agregarUsuario(usuario3);
		Libro libro1 = new Libro("El principito","Saint Xupery" ,"1", "Cuento","Aqui va la Descripcion");
		Libro libro2 = new Libro("¡Socorro!","Elsa Bornemann" ,"2", "Cuento","Aqui va la Descripcion");
		Libro libro3 = new Libro("Cien Años de Soledad","Gabriel Garcia Marquez" ,"3", "Novela","Aqui va la Descripcion");
		libroService.agregarLibro(libro1);
		libroService.agregarLibro(libro2);
		libroService.agregarLibro(libro3);
		// Menú de ingreso
        System.out.println("Bienvenido al sistema de la biblioteca");
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.print("Ingrese su elección: ");
        
        int opcion = scanner.nextInt();

        // Dependiendo de la opción elegida, redirigir al menú correspondiente
        switch (opcion) {
            case 1:
            	//Menu Administrador
            	do {
        			System.out.println("--- Biblioteca Virtual ---");
        			System.out.println("--------------------------");
        			System.out.println("OPCIONES:");
        			System.out.println("1) CREAR LIBRO");
        			System.out.println("2) ACTUALIZAR LIBRO");
        			System.out.println("3) BUSCAR LIBRO POR ISBN");
        			System.out.println("4) BUSCAR LIBRO POR TITULO");
        			System.out.println("5) BUSCAR LIBRO POR AUTOR");
        			System.out.println("6) LISTAR LIBROS");
        			System.out.println("7) ELIMINAR LIBRO");
        			System.out.println("8) PRESTAMOS");
        			System.out.println("9) DEVOLUCIONES");
        			System.out.println("10) SALIR");
        			System.out.println("---------------------------");
        			System.out.println("SELECCIONE UNA OPCION:");
        			opcion = scanner.nextInt();
        			scanner.nextLine();

        			switch (opcion) {
        			// crear libro
        			case 1:
        				System.out.println("Ingrese el titulo: ");
        				String titulo = scanner.nextLine();
        				System.out.println("Ingrese el autor: ");
        				String autor = scanner.nextLine();
        				System.out.println("Ingrese el ISBN");
        				String isbn = scanner.nextLine();
        				System.out.println("Ingrese el genero");
        				String genero = scanner.nextLine();
        				System.out.println("Ingrese la descripcion");
        				String descripcion = scanner.nextLine();
        				libroService.crearLibro(titulo, autor, isbn, genero, descripcion);
        				break;
        			// actualizar libro
        			case 2:
        				System.out.println("Ingrese el ISBN del libro que desea actualizar ");
        				String isbnActualizar = scanner.nextLine();
        				System.out.println("Ingrese el nuevo titulo: ");
        				String nuevoTitulo = scanner.nextLine();
        				System.out.println("Ingrese el nuevo autor: ");
        				String nuevoAutor = scanner.nextLine();
        				System.out.println("Ingrese el nuevo genero");
        				String nuevoGenero = scanner.nextLine();
        				System.out.println("Ingrese la nueva descripcion");
        				String nuevaDescripcion = scanner.nextLine();
        				libroService.actualizarLibro(isbnActualizar, nuevoTitulo, nuevoAutor, nuevoGenero, nuevaDescripcion);
        				break;
        			// buscar libro por ISBN
        			case 3:
        				System.out.print("Ingrese el ISBN del libro a buscar: ");
        				String isbnBuscar = scanner.nextLine();
        				Libro libroIsbn = libroService.buscarLibroPorISBN(isbnBuscar);
        				if (libroIsbn != null) {
        					System.out.println("Libro encontrado: " + libroIsbn.getTitulo());
        				} else {
        					System.out.println("Libro no encontrado");
        				}
        				break;
        			// buscar libro por titulo
        			case 4:
        				System.out.print("Ingrese el titulo del libro a buscar: ");
        				String tituloBuscar = scanner.nextLine();
        				ArrayList<Libro> librosPorTitulo = libroService.buscarLibrosPorTitulo(tituloBuscar);
        				if (!librosPorTitulo.isEmpty()) {
        					System.out.println("Libros encontrados: ");
        					for (Libro libro : librosPorTitulo) {
        						System.out.println(libro.getTitulo());
        					}
        				} else {
        					System.out.println("Su busqueda no coincide con ningun libro, intente nuevamente");
        				}
        				break;
        			// busqueda por autor
        			case 5:
        				System.out.print("Ingrese el nombre del autor del libro a buscar: ");
        				String autorBuscar = scanner.nextLine();
        				ArrayList<Libro> librosPorAutor = libroService.buscarLibrosPorAutor(autorBuscar);
        				if (!librosPorAutor.isEmpty()) {
        					System.out.println("Libros encontrados: ");
        					for (Libro libro : librosPorAutor) {
        						System.out.println(libro.getTitulo());
        					}
        				} else {
        					System.out.println("Su busqueda no coincide con ningun libro, intente nuevamente");
        				}
        				break;
        			// Listar Libros
        			case 6:
        				ArrayList<Libro> listaLibros = libroService.obtenerTodosLosLibros();
        				for (Libro libro : listaLibros) {
        					System.out.println(libro.getTitulo() + "(" + libro.getISBN() + ")");
        				}
        				break;
        			// Eliminar Libro
        			case 7:
        				System.out.print("Ingrese el ISBN del libro a eliminar: ");
        				String isbnEliminar = scanner.nextLine();
        				libroService.eliminarLibro(isbnEliminar);
        				break;
        			// Prestamos, se puede buscar el usuario por id o por correo
        			case 8:
        				System.out.print("Ingrse el número de identificacion del usuario o el mail: ");
        				String idOMailUsuario = scanner.nextLine();
        				Usuario usuarioPrestamo = usuarioService.buscarUSuarioPorId(idOMailUsuario);
        				// si no encuentra el usuario por Id lo busca por correo
        				if (usuarioPrestamo == null) {
        					usuarioPrestamo = usuarioService.buscarUsuarioPorCorreo(idOMailUsuario);
        				}
        				if (usuarioPrestamo != null) {
        					System.out.print("ingrese el ISBN del libro a prestar: ");
        					String isbnPrestamo = scanner.nextLine();
        					Libro libroPrestamo = libroService.buscarLibroPorISBN(isbnPrestamo);
        					if (libroPrestamo != null) {
        						if (libroService.verificarDisponibilidad(libroPrestamo)) {
        							usuarioService.prestarLibro(usuarioPrestamo, libroPrestamo);
        							System.out.println("Préstamo exitoso. Libro prestado a " + usuarioPrestamo.getNombre());

        						} else {
        							System.out.println("El libro no encontrado");
        						}
        					} else {
        						System.out.println("Libro no encontrado");
        					}
        				} else {
        					System.out.println("Usuario no encontrado");
        				}
        				break;
        			// Devoluciones
        			case 9:
        				System.out.print("Ingrse el número de identificacion del usuario o el mail: ");
        				String idOMailUsuarioDevolucion = scanner.nextLine();
        				Usuario usuarioDevolucion = usuarioService.buscarUSuarioPorId(idOMailUsuarioDevolucion);
        				// si no encuentra el usuario por Id lo busca por correo
        				if (usuarioDevolucion == null) {
        					usuarioDevolucion = usuarioService.buscarUsuarioPorCorreo(idOMailUsuarioDevolucion);
        				}
        				if (usuarioDevolucion != null) {
        					System.out.print("ingrese el ISBN del libro a devolver: ");
        					String isbnDevolucion = scanner.nextLine();
        					Libro libroDevolucion = libroService.buscarLibroPorISBN(isbnDevolucion);
        					if (libroDevolucion != null) {
        						usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);

        						System.out.println("Devolución exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());

        					} else {
        						System.out.println("Libro no encontrado");
        					}
        				} else {
        					System.out.println("Usuario no encontrado");
        				}
        				break;
        			case 10:
        				System.out.println("Gracias por usar la biblioteca Virtual");
        				break;
        			default:
        				System.out.println("Opcion no válida. Intente nuevamente");

        			}
        		} while (opcion != 10);
        	
        		break;
        	
            case 2:
                // Menú para usuarios
            	do {
        			System.out.println("--- Biblioteca Virtual ---");
        			System.out.println("--------------------------");
        			System.out.println("OPCIONES:");
        			System.out.println("1) CREAR USUARIO");
        			System.out.println("2) PEDIR LIBRO PRESTADO");
        			System.out.println("3) BUSCAR LIBRO POR ISBN");
        			System.out.println("4) BUSCAR LIBRO POR TITULO");
        			System.out.println("5) BUSCAR LIBRO POR AUTOR");
        			System.out.println("6) LISTAR LIBROS");
        			System.out.println("7) ELIMINAR USUARIO");
        			System.out.println("8) VER LIBROS QUE PEDI PRESTADOS");
        			System.out.println("9) DEVOLVER LIBRO");        			
        			System.out.println("10) DEJAR RESEÑA DE UN LIBRO ");
        			System.out.println("11) SALIR");
        			System.out.println("---------------------------");
        			System.out.println("SELECCIONE UNA OPCION:");
        			opcion = scanner.nextInt();
        			scanner.nextLine();
        			switch (opcion) {
        			// crear usuario
        			case 1:
        				System.out.println("Ingrese su nombre: ");
        				String nombre = scanner.nextLine();
        				System.out.println("Ingrese su Email; ");
        				String correo = scanner.nextLine();
        				System.out.println("Ingrese su DNI");
        				String id = scanner.nextLine();
        				usuarioService.crearUsuario(nombre, correo, id);
        				System.out.println("USUARIO REGISTRADO: " + nombre +  " Email: " + correo +  " DNI: " +id );
        				
        				break;
        				//Pedir Libro Prestado
        			case 2: 
        				System.out.print("Ingrse el número de dni del usuario o el mail: ");
        				String idOMailUsuario = scanner.nextLine();
        				Usuario usuarioPrestamo = usuarioService.buscarUSuarioPorId(idOMailUsuario);
        				// si no encuentra el usuario por Id lo busca por correo
        				if (usuarioPrestamo == null) {
        					usuarioPrestamo = usuarioService.buscarUsuarioPorCorreo(idOMailUsuario);
        				}
        				if (usuarioPrestamo != null) {
        					System.out.print("ingrese el ISBN del libro a prestar: ");
        					String isbnPrestamo = scanner.nextLine();
        					Libro libroPrestamo = libroService.buscarLibroPorISBN(isbnPrestamo);
        					if (libroPrestamo != null) {
        						if (libroService.verificarDisponibilidad(libroPrestamo)) {
        							usuarioService.prestarLibro(usuarioPrestamo, libroPrestamo);
        							System.out.println("Préstamo exitoso. Libro prestado a " + usuarioPrestamo.getNombre());

        						} else {
        							System.out.println("El libro no encontrado");
        						}
        					} else {
        						System.out.println("Libro no encontrado");
        					}
        				} else {
        					System.out.println("Usuario no encontrado");
        				}
        				break;
        				// buscar libro por ISBN
        			case 3:
        				System.out.print("Ingrese el ISBN del libro a buscar: ");
        				String isbnBuscar = scanner.nextLine();
        				Libro libroIsbn = libroService.buscarLibroPorISBN(isbnBuscar);
        				if (libroIsbn != null) {
        					System.out.println("Libro encontrado: " + libroIsbn.getTitulo());
        				} else {
        					System.out.println("Libro no encontrado");
        				}
        				break;
        			// buscar libro por titulo
        			case 4:
        				System.out.print("Ingrese el titulo del libro a buscar: ");
        				String tituloBuscar = scanner.nextLine();
        				ArrayList<Libro> librosPorTitulo = libroService.buscarLibrosPorTitulo(tituloBuscar);
        				if (!librosPorTitulo.isEmpty()) {
        					System.out.println("Libros encontrados: ");
        					for (Libro libro : librosPorTitulo) {
        						System.out.println(libro.getTitulo());
        					}
        				} else {
        					System.out.println("Su busqueda no coincide con ningun libro, intente nuevamente");
        				}
        				break;
        			// busqueda por autor
        			case 5:
        				System.out.print("Ingrese el nombre del autor del libro a buscar: ");
        				String autorBuscar = scanner.nextLine();
        				ArrayList<Libro> librosPorAutor = libroService.buscarLibrosPorAutor(autorBuscar);
        				if (!librosPorAutor.isEmpty()) {
        					System.out.println("Libros encontrados: ");
        					for (Libro libro : librosPorAutor) {
        						System.out.println(libro.getTitulo());
        					}
        				} else {
        					System.out.println("Su busqueda no coincide con ningun libro, intente nuevamente");
        				}
        				break;
        			// Listar Libros
        			case 6:
        				ArrayList<Libro> listaLibros = libroService.obtenerTodosLosLibros();
        				for (Libro libro : listaLibros) {
        					//System.out.println(" Nombre:" + libro.getTitulo() + " Autor:" + libro.getAutor() + " Calificación: " + libro.getCalificacion() + "Reseñas:" + libro.getResena() + "(" + libro.getISBN() + ")");
        					    System.out.println("Nombre: " + libro.getTitulo());
        				        System.out.println("Autor: " + libro.getAutor());
        				        System.out.println("Calificación: " + libro.getCalificacionPromedio());
        				        System.out.println("Reseñas:");

        				        // Iterar sobre las reseñas y mostrar solo las primeras dos
        				        int contadorResenas = 0;
        				        for (Resena resena : libro.getListaResenas()) {
        				            System.out.println("- " + resena);
        				            contadorResenas++;
        				            if (contadorResenas >= 2) {
        				                break; // Salir del bucle después de mostrar las primeras dos reseñas
        				            }
        				        }
        				        System.out.println("ISBN: " + libro.getISBN());
        				}
        				break;
        				// Eliminar Usuario
        			case 7:
        				System.out.print("Ingrese el DNI del usuario a eliminar: ");
        				String idUsuarioEliminar = scanner.nextLine();
        				usuarioService.eliminarUsuariosPorId(idUsuarioEliminar);
        				break;
        				// Prestamos, se puede busar el usuario por id o por correo
        			case 8:
        				System.out.print("Ingrse el número de DNI usuario o el mail: ");
        				String idOMailUsuario1 = scanner.nextLine();
        				Usuario usuarioPrestamo1 = usuarioService.buscarUSuarioPorId(idOMailUsuario1);
        				
        				// si no encuentra el usuario por Id lo busca por correo
        				if (usuarioPrestamo1 == null) {
        					usuarioPrestamo1 = usuarioService.buscarUsuarioPorCorreo(idOMailUsuario1);
        				}
        				if (usuarioPrestamo1 != null) {
        					 ArrayList<Libro> librosPrestados = usuarioService.obtenerLibrosPrestados(usuarioPrestamo1);
        					if (librosPrestados.isEmpty()) {
        			            System.out.println("No tienes libros prestados en este momento.");
        			        } else {
        			            System.out.println("Libros prestados:");
        			            for (Libro libro : librosPrestados) {
        			                System.out.println("Título: " + libro.getTitulo());
        			                System.out.println("Autor: " + libro.getAutor());
        			                System.out.println("ISBN: " + libro.getISBN());
        			                System.out.println(); // Separador entre libros
        			            }
        			        
        			        }
        				} else {
        					System.out.println("Usuario no encontrado");
        				}
        				break;
        				// Devoluciones
        			case 9:
        				System.out.print("Ingrse el número de identificacion del usuario o el mail: ");
        				String idOMailUsuarioDevolucion = scanner.nextLine();
        				Usuario usuarioDevolucion = usuarioService.buscarUSuarioPorId(idOMailUsuarioDevolucion);
        				// si no encuentra el usuario por Id lo busca por correo
        				if (usuarioDevolucion == null) {
        					usuarioDevolucion = usuarioService.buscarUsuarioPorCorreo(idOMailUsuarioDevolucion);
        				}
        				if (usuarioDevolucion != null) {
        					System.out.print("ingrese el ISBN del libro a devolver: ");
        					String isbnDevolucion = scanner.nextLine();
        					Libro libroDevolucion = libroService.buscarLibroPorISBN(isbnDevolucion);
        					if (libroDevolucion != null) {
        						usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);

        						System.out.println("Devolución exitosa. Libro devuelto por " + usuarioDevolucion.getNombre());

        					} else {
        						System.out.println("Libro no encontrado");
        					}
        				} else {
        					System.out.println("Usuario no encontrado");
        				}
        				break;
        				//DEJAR RESEÑA Y CALIFICACION
        			case 10:
        				System.out.print("Ingrese el ISBN del libro a Calificar: ");
        				String isbnBuscar2 = scanner.nextLine();
        				Libro libroIsbn1 = libroService.buscarLibroPorISBN(isbnBuscar2);
        				if (libroIsbn1 != null) {
        					System.out.println("******************");
        					System.out.println("Libro encontrado: " + libroIsbn1.getTitulo());
        					System.out.println("******************");
        					
        				 // Solicitar al usuario que ingrese la reseña
        				
        		        System.out.println("Ingrese la reseña del libro:");
        		        String textoResena = scanner.nextLine();
        		        System.out.println("******************");

        		        // Solicitar al usuario que ingrese la calificación
        		       
        		        System.out.println("Ingrese la calificación del libro (de 1 a 5):");
        		        double calificacion = Double.parseDouble(scanner.nextLine());
        		        System.out.println("******************");

        		     // Crear un objeto Resena con la reseña y la calificación ingresadas por el usuario
        		        Resena nuevaResena = new Resena();
        		        nuevaResena.setTexto(textoResena);
        		        nuevaResena.setCalificacion(calificacion);
        		        // Agregar la nueva reseña al libro
        		        libroIsbn1.agregarResena(nuevaResena);
        		      
        		        System.out.println("Muchas Gracias");
        		        System.out.println("******************");
        		    } else {
        		        System.out.println("Libro no encontrado");
        		    }
        		        
        				break;
        			
        				//CERRAR
        			case 11:
        				System.out.println("Gracias por usar la biblioteca Virtual");
        				break;
        				
                
        			default:
        				System.out.println("Opcion no válida. Intente nuevamente");
        			}
        		
        			
        		} while (opcion != 11);
        		break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
       
        scanner.close();

} 
}

