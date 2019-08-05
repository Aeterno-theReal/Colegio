import java.util.Scanner;

public class Estudios {
	

	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		Colegio colegio=new Colegio();
		
		int opcionmarcada=-1, opcionprincipal=-1;
		
		do {
			menuPrincipal();
			opcionprincipal=comprobarMenuPrincipal(0,3, teclado);
			switch(opcionprincipal)
			{
				case 1:
					do {
						boolean vacio=true;
						menuAlumnos();
						opcionmarcada=comprobarSubMenuAlumnos(0,9,teclado);
						switch(opcionmarcada)
						{
							case 1:
								colegio.visualizarAlumnos();
								break;
							case 2:
								colegio.anadirAlumno();
								break;
							case 3:
								colegio.visualizarAlumnos();
								vacio=colegio.arrayVacioAlumno();
								if(!vacio)
									colegio.mostrarAsignaturasAlumnos();
								break;
							case 4:
								colegio.visualizarAlumnos();
								vacio=colegio.arrayVacioAlumno();
								if(!vacio)
									colegio.mostrarAsignaturasAlumnos(introducirFecha(teclado));
								break;
							case 5:
								colegio.visualizarAlumnos();
								vacio=colegio.arrayVacioAsignatura();
								if(!vacio)
									colegio.matricularAlumno(teclado);
								else {
									colegio.visualizarAsignaturas();
								}
								break;
							case 6:
								colegio.guardarFicheroAlumnos();
								break;
							case 7:
								colegio.cargarFicheroAlumnos();
								break;
							case 8:
								colegio.ordenarArrayAlumnos();
								break;
							case 9:
								colegio.visualizarAlumnos();
								colegio.eliminarAlumnos();
								break;
							case 0:
								System.out.println();
								break;
						}
					}while(opcionmarcada!=0);
					break;
				case 2:
					do {
						boolean vacio=true;
						menuProfesores();
						opcionmarcada=comprobarSubMenuProfesores(0,9,teclado);
						switch(opcionmarcada)
						{
							case 1:
								colegio.visualizarProfesores();
								break;
							case 2:
								colegio.anadirProfesor();
								break;
							case 3:
								colegio.visualizarProfesores();
								vacio=colegio.arrayVacioProfesor();
								if(!vacio)
									colegio.mostrarAsignaturasProfesores();
								break;
							case 4:
								colegio.visualizarProfesores();
								vacio=colegio.arrayVacioProfesor();
								if(!vacio)
									colegio.mostrarAsignaturasProfesores(introducirFecha(teclado));
								break;
							case 5:
								colegio.visualizarProfesores();
								vacio=colegio.arrayVacioAsignatura();
								if(!vacio)
									colegio.asignarProfesor(teclado);
								else {
									colegio.visualizarAsignaturas();
								}
								break;
							case 6:
								colegio.guardarFicheroProfesores();
								break;
							case 7:
								colegio.cargarFicheroProfesores();
								break;
							case 8:
								colegio.ordenarArrayProfesores();
								break;
							case 9:
								colegio.visualizarProfesores();
								colegio.eliminarProfesores();
							case 0:
								System.out.println();
								break;
						}
					}while(opcionmarcada!=0);
					break;
				case 3:
					do {
						boolean vacio=true;
						menuAsignaturas();
						opcionmarcada=comprobarSubMenuAsignaturas(0,9,teclado);
						switch(opcionmarcada)
						{
							case 1:
								colegio.visualizarAsignaturas();
								break;
							case 2:
								colegio.anadirAsignatura();
								break;
							case 3:
								colegio.visualizarAsignaturas();
								vacio=colegio.arrayVacioAsignatura();
								if(!vacio)
									colegio.mostrarAlumnosAsignaturas();
								break;
							case 4:
								colegio.visualizarAsignaturas();
								vacio=colegio.arrayVacioAsignatura();
								if(!vacio)
									colegio.mostrarProfesoresAsignaturas();
								break;
							case 6:
								colegio.guardarFicheroAsignaturas();
								break;
							case 7:
								colegio.cargarFicheroAsignaturas();
								break;
							case 8:
								colegio.ordenarArrayAsignatura();
								break;
							case 9:
								colegio.visualizarAsignaturas();
								vacio=colegio.arrayVacioAsignatura();
								if(!vacio)
								{
									colegio.eliminarAsignatura();
									colegio.visualizarAsignaturas();
								}
								break;
							case 0:
								System.out.println();
								break;
						}
					}while(opcionmarcada!=0);
					break;
			}
		}while(opcionprincipal!=0);
		
		System.out.println("\n -- FIN DEL PROGRAMA --");
		
	}
	
	public static void menuPrincipal()
	{
		System.out.print("Introduzca la opción que desea realizar:\r\n" + 
				"1. Menú alumnos\r\n" + 
				"2. Menú profesores\r\n" + 
				"3. Menú asignaturas\r\n" + 
				"0. Salir");
	}
	
	public static void menuAlumnos()
	{
		System.out.println();
		System.out.println("Menú Alumnos:\r\n" + 
				"1. Mostrar alumnos\r\n" + 
				"2. Añadir alumnos\r\n" + 
				"3. Mostrar asignaturas del alumno\r\n" + 
				"4. Mostrar asignaturas del alumno para el año \r\n" + 
				"5. Matricular alumno a la asignatura\r\n" + 
				"6. Guardar la informacion de alumnos en un fichero\r\n" +
				"7. Cargar la informacion de alumnos desde un fichero\r\n" +
				"8. Ordenar listado de Alumnos\r\n" +
				"9. Eliminar Alumnos\r\n" +
				"0. Volver al menú principal");
	}
	
	public static void menuProfesores()
	{
		System.out.println();
		System.out.println("Menú profesores:\r\n" + 
				"1. Mostrar profesores\r\n" + 
				"2. Añadir profesores\r\n" + 
				"3. Mostrar asignaturas que imparte el profesor\r\n" + 
				"4. Mostrar asignaturas del año que imparte el profesor \r\n" + 
				"5. Asignar docencia al profesor\r\n" +
				"6. Guardar la informacion de profesores en un fichero\r\n" +
				"7. Cargar la informacion de profesores desde un fichero\r\n" +
				"8. Ordenar listado de Profesores\r\n" +
				"9. Eliminar Profesores\r\n" +
				"0. Volver al menú principal");
	}
	
	public static void menuAsignaturas()
	{
		System.out.println();
		System.out.println("Menú asignatura:\r\n" + 
				"1. Mostrar asignaturas\r\n" + 
				"2. Añadir asignaturas\r\n" + 
				"3. Mostrar alumnos de la asignatura\r\n" + 
				"4. Mostrar profesores de la asignatura\r\n" + 
				"6. Guardar la informacion de Asignaturas en un fichero\r\n" +
				"7. Cargar la informacion de Asignaturas desde un fichero\r\n" +
				"8. Ordenar listado de Asignaturas\r\n" +
				"9. Eliminar Asignatura no asignada\r\n" +
				"0. Volver al menú principal");
	}
	
	public static int comprobarMenuPrincipal(int rangoa, int rangob, Scanner teclado)
	{
		int opcion=-1;
		
		try
		{
			System.out.print("\nIntroduzca su opcion: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			if(opcion<rangoa || opcion>rangob)
				informarErrorIntroducido(rangoa, rangob);
			
		}catch(Exception e)
		{
			informarErrorIntroducido(rangoa, rangob);
		}
		System.out.println();
		return opcion;
	}
	
	public static int comprobarSubMenuAlumnos(int rangoa, int rangob, Scanner teclado)
	{
		int opcion=-1;
		
		try
		{
			System.out.print("\nIntroduzca su opcion: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			if(opcion<rangoa || opcion>rangob)
				informarErrorIntroducido(rangoa, rangob);
			System.out.println();
			
		}catch(Exception e)
		{
			informarErrorIntroducido(rangoa, rangob);
		}
		return opcion;
	}
	

	public static int comprobarSubMenuProfesores(int rangoa, int rangob, Scanner teclado)
	{
		int opcion=-1;
		
		try
		{
			System.out.print("\nIntroduzca su opcion: ");	
			opcion=teclado.nextInt();
			teclado.nextLine();
			if(opcion<rangoa || opcion>rangob)
				informarErrorIntroducido(rangoa, rangob);
			System.out.println();
			
		}catch(Exception e)
		{
			informarErrorIntroducido(rangoa, rangob);
		}
		return opcion;
	}
	
	public static int comprobarSubMenuAsignaturas(int rangoa, int rangob, Scanner teclado)
	{
		int opcion=-1;
		
		try
		{
			System.out.print("\nIntroduzca su opcion: ");
			opcion=teclado.nextInt();
			teclado.nextLine();
			if(opcion<rangoa || opcion>rangob)
				informarErrorIntroducido(rangoa, rangob);
			System.out.println();
			
		}catch(Exception e)
		{
			informarErrorIntroducido(rangoa, rangob);
		}
		return opcion;
	}
	
	//Introducimos la fecha de la asignatura a la que queremos acceder
	public static int introducirFecha(Scanner teclado)
	{
		int fecha=-1;
		
		try
		{
			System.out.print("\nIntroduzca la fecha de la asignatura que desea mostrar: ");
			fecha=teclado.nextInt();
			teclado.nextLine();
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
		
		return fecha;
	}

	//Método para informar al usuario que ha introducido un dato erróneo por teclado.
	public static void informarErrorIntroducido()
	{
		System.out.println("\n-Se ha introducido un dato erróneo, por favor, compruébelo y vuelva a introducirlo-\n");
	}
	
	//Método para informar al usuario que ha introducido un dato erróneo por teclado con rango de selección.
	public static void informarErrorIntroducido(int a, int b)
	{
		System.out.println("\nError!, se ha introducido un dato erróneo, por favor, compruébelo y vuelva a introducirlo- (use sólo números [" + a + "-" + b +"]): \n");
	}
	
}
