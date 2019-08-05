import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Colegio {
	
	Scanner teclado=new Scanner(System.in);
	
	//Definimos el tamaño para los arrays de cada tipo.
	ArrayList<Profesor> profesores=new ArrayList<Profesor>();
	ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
	Asignatura[] asignaturas=new Asignatura[5];
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Método para informar al usuario que ha introducido un dato erróneo por teclado.
	public void informarErrorIntroducido()
	{
		System.out.println("\n-Se ha introducido un dato erróneo, por favor, compruébelo y vuelva a introducirlo-");
	}
	
	//Método para informar al usuario que ha introducido un dato erróneo por teclado con rango de selección.
	public void informarErrorIntroducido(int a, int b)
	{
		System.out.println("\nError!, se ha introducido un dato erróneo, por favor, compruébelo y vuelva a introducirlo- (use sólo números [" + a + "-" + b +"])");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//Bloque de visualizaciones
	
	//Visualizamos todos los alumnos en nuestro array.
	public void visualizarAlumnos()
	{
		if(alumnos.size()==0)
			System.out.println("-- No hay alumnos guardados. -- ");
		else 
			for(int i=0; i<alumnos.size(); i++)
			{
					if(alumnos.get(i)!=null)
					{
						System.out.print((i+1) + " ");
						((Alumno) alumnos.get(i)).visualizar();
					}
			}
	}
	
	//Visualizamos todos los profesores en nuestro array
	public void visualizarProfesores()
	{
		if(profesores.size()==0)
			System.out.println("-- No hay profesores guardados. -- ");
		else 
			for(int i=0; i<profesores.size(); i++)
			{
				if(profesores.get(i)!=null)
				{
					System.out.print((i+1) + " ");
					((Profesor) profesores.get(i)).visualizar();
				}
			}
	}
	
	//Visualizamos todas las asignatuas en nuestro array
	public void visualizarAsignaturas()
	{
		if(asignaturas[0]==null)
			System.out.println("-- No hay asignaturas guardadas. -- ");
		else 
			for(int i=0; i<asignaturas.length; i++)
			{
				if(asignaturas[i]!=null)
				{
					System.out.print((i+1) + ". ");
					asignaturas[i].visualizar();
				}
			}
	}
	
	//Entramos en el bloque de añadir
	
	//Añadimos un nuevo alumno
	public void anadirAlumno()
	{
		boolean dnicorrecto=false;
		String nombre="", apellido="", dni="", email="";
		
			//comprobar si se crea un objeto dentro de la matriz de tipo asignaturas
			System.out.print("Introduzca el nombre del alumno: ");
			nombre=teclado.nextLine();
			System.out.print("Introduzca el apellido del alumno: ");
			apellido=teclado.nextLine();
			
			do {
				System.out.print("Introduzca el dni del alumno: ");
				dni=teclado.nextLine();
				dnicorrecto=Persona.comprobarDNI(dni);
				if(!dnicorrecto)
					informarErrorIntroducido();
			}while(!dnicorrecto);
			
			System.out.print("Introduzca el email del alumno: ");
			email=teclado.nextLine();
			
			Alumno aux=new Alumno(nombre, apellido, dni, email);
			
			alumnos.add(aux);
	}
	
	//Añadimos un nuevo profesor
	public void anadirProfesor()
	{
		boolean dnicorrecto=false;
		String nombre="", apellido="", dni="", email="", direccion="";
		
		//comprobar si se crea un objeto dentro de la matriz de tipo asignaturas
		System.out.print("Introduzca el nombre del profesor: ");
		nombre=teclado.nextLine();
		System.out.print("Introduzca el apellido del profesor: ");
		apellido=teclado.nextLine();
		
		do {
			System.out.print("Introduzca el dni del profesor: ");
			dni=teclado.nextLine();
			dnicorrecto=Persona.comprobarDNI(dni);
			if(!dnicorrecto)
				informarErrorIntroducido();
		}while(!dnicorrecto);
		
		System.out.print("Introduzca el email del profesor: ");
		email=teclado.nextLine();
		System.out.print("Introduzca la dirección del profesor: ");
		direccion=teclado.nextLine();

		Profesor aux=new Profesor(nombre, apellido, dni, email, direccion);			
		profesores.add(aux);
	}
	
	//Añadimos una nueva asignatura
	public void anadirAsignatura()
	{
		String nombre="", curso="";
		int inicio=-1, fin=-1;
		
		for(int i=0; i<asignaturas.length; i++)
		{
			//comprobar si se crea un objeto dentro de la matriz de tipo asignaturas
			if(asignaturas[i]==null)
			{
				try
				{
					System.out.print("Introduzca el nombre de la asignatura: ");
					nombre=teclado.nextLine();
					
					System.out.print("Introduzca el curso de la asignatura: ");
					curso=teclado.nextLine();
					
					System.out.print("Introduzca el año de inicio de la asignatura: ");
					inicio=teclado.nextInt();
					teclado.nextLine();
					System.out.print("Introduzca el año de finalizacion de la asignatura: ");
					fin=teclado.nextInt();
					teclado.nextLine();
					
					asignaturas[i]=new Asignatura(nombre, curso, inicio, fin);
					
					//Nos falta compbrobar que el numero introducido es correcto, es decir, es un número entero y no introduce caracteres.
					i=asignaturas.length;
				}catch(Exception ioException)
				{
					System.out.println("\nError!, los datos introducidos no son coherentes.");
					i=asignaturas.length;
				}
			}
			else {
				//incrementar array añadir incremento del array. Incrementa cuando supera el tamaño del array.
				if(i==asignaturas.length-1)
				{
					Asignatura[] asignaturas2=new Asignatura[asignaturas.length+5];
					for(int j=0; j<asignaturas.length; j++)
					{
						asignaturas2[j]=new Asignatura();
						asignaturas2[j]=asignaturas[j];
					}
					asignaturas=asignaturas2;
					asignaturas2=null;
					anadirAsignatura();
					i=asignaturas.length;
				}
			}
		}
	}
	
	//Mostrar asignaturas del alumno
	public void mostrarAsignaturasAlumnos()
	{
		int posicion=-1;
		
		try
		{
			System.out.print("\nSeleccione un alumno para mostrar las asignaturas en las que está matriculado: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
			
			if(!((Alumno) alumnos.get(posicion-1)).arrayVacio())
			{
				if(alumnos.get(posicion-1)==null)
				{
					informarErrorIntroducido();
				}
				else
				{
					for(int i=0; i<((Alumno) alumnos.get(posicion-1)).getMatriculado().length; i++)
					{
						if(((Alumno) alumnos.get(posicion-1)).getMatriculado(i)!=null)
						{
							System.out.println("El alumno " + alumnos.get(posicion-1).getNombre() + " está matriculado en la asignatura " + ((Alumno)alumnos.get(posicion-1)).getMatriculado(i) + ".");
						}
					}
				}
			}
			else
				System.out.println("\nNo hay asignaturas matriculadas para el alumno seleccionado.");
		}catch(Exception e)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Mostrar asignaturas que imparte el profesor
	public void mostrarAsignaturasProfesores()
	{
		int posicion=-1;
		
		try
		{
			System.out.print("\nSeleccione un profesor para mostrar las asignaturas que está impartiendo: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
			
			if(!((Profesor) profesores.get(posicion-1)).arrayVacio())
			{
				if(profesores.get(posicion-1)==null)
				{
					informarErrorIntroducido();
				}
				else
				{
					for(int i=0; i<((Profesor) profesores.get(posicion-1)).getImparte().length; i++)
					{
						if(((Profesor) profesores.get(posicion-1)).getImparte(i)!=null)
						{
							System.out.println("El profesor" + profesores.get(posicion-1).getNombre() + " está impartiendo la asignatura " + ((Profesor)profesores.get(posicion-1)).getImparte(i) + ".");
						}
					}
				}
			}
			else
				System.out.println("\nNo hay asignaturas asignadas al profesor seleccionado.");
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Mostrar asignaturas que imparte el profesor para el año introducido
	public void mostrarAsignaturasAlumnos(int anyo)
	{
		int posicion=-1, cont=0;
		
		try
		{
			System.out.print("Seleccione un alumno para mostrar las asignaturas en las que está matriculado: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
			
			if(!((Alumno) alumnos.get(posicion-1)).arrayVacio())
			{
				if(alumnos.get(posicion-1)==null)
				{
					informarErrorIntroducido();
				}
				else
				{
					for(int i=0; i<((Alumno) alumnos.get(posicion-1)).getMatriculado().length; i++)
					{
						if(((Alumno) alumnos.get(posicion-1)).getMatriculado(i)!=null && (anyo >= ((Alumno) alumnos.get(posicion-1)).getInicio(i) && anyo <= ((Alumno) alumnos.get(posicion-1)).getFin(i)))
						{
							System.out.println("El alumno " + alumnos.get(posicion-1).getNombre() + " ha cursado la asignatura " + ((Alumno)alumnos.get(posicion-1)).getMatriculado(i) + ".");
							System.out.println("El año de esta asignatura está entre " + ((Alumno) alumnos.get(posicion-1)).getInicio(i) + " y " + ((Alumno) alumnos.get(posicion-1)).getFin(i));
							cont++;
						}
					}
				}
				if(cont==0)
					System.out.println("\nEl alumno no ha estado matriculado en ninguna asignatura durante el año indicado.");
			}
			else
				System.out.println("\nNo hay asignaturas matriculadas para el alumno seleccionado.");
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Mostrar asignaturas que imparte el profesor para el año introducido
	public void mostrarAsignaturasProfesores(int anyo)
	{
		int posicion=-1, cont=0;
		
		try
		{
			System.out.print("Seleccione un profesor para mostrar las asignaturas que está impartiendo: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
			
			if(!((Profesor) profesores.get(posicion-1)).arrayVacio())
			{
				if(profesores.get(posicion-1)==null)
				{
					informarErrorIntroducido();
				}
				else
				{
					for(int i=0; i<((Profesor) profesores.get(posicion-1)).getImparte().length; i++)
					{
						if(((Profesor) profesores.get(posicion-1)).getImparte(i)!=null && (anyo >= ((Profesor) profesores.get(posicion-1)).getInicio(i) && anyo <= ((Profesor) profesores.get(posicion-1)).getFin(i)))
						{
							System.out.println("El profesor" + profesores.get(posicion-1).getNombre() + " ha impartiendo la asignatura " + ((Profesor) profesores.get(posicion-1)).getImparte(i) + ".");
							System.out.println("El año de esta asignatura está entre " + ((Profesor) profesores.get(posicion-1)).getInicio(i) + " y " + ((Profesor) profesores.get(posicion-1)).getFin(i));
							cont++;
						}
					}
				}
				if(cont==0)
					System.out.println("\nEl profesor no ha estado impartiendo ninguna asignatura durante el año indicado.");
			}
			else
				System.out.println("\nNo hay asignaturas asignadas al profesor seleccionado.");
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Matricular alumno en asignatura.
	public void matricularAlumno(Scanner teclado)
	{
		int posicion=-1, asig=-1;
		boolean matriculado=false;
		
		try
		{
			do {
				System.out.print("\nSeleccione el alumno al que desea matricular una asignatura: ");
				posicion=teclado.nextInt();
				teclado.nextLine();
				
				System.out.println("\nAhora mostramos las asignaturas a las que se puede matricular el alumno: ");
				visualizarAsignaturas();
				
				System.out.print("\nSeleccione una asignatura para matricular al alumno: ");
				asig=teclado.nextInt();
				teclado.nextLine();
				
				matriculado=((Alumno) alumnos.get(posicion-1)).matricular(asignaturas, asig-1);
				
				if(!matriculado)
					informarErrorIntroducido();
					
			}while(!matriculado);
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Asignar profesor a asignatura

	public void asignarProfesor(Scanner teclado)
	{
		int posicion=-1, asig=-1;
		boolean imparte=false;
		
		try
		{
			do {
				System.out.println("Seleccione el profesor al que desea dar como docencia una asignatura: ");
				posicion=teclado.nextInt();
				teclado.nextLine();
				
				System.out.println("Ahora mostramos las asignaturas a las que se puede dar como docencia al profesor: ");
				visualizarAsignaturas();
				
				System.out.println("Seleccione una asignatura para asignar al profesor: ");
				asig=teclado.nextInt();
				teclado.nextLine();
				
				imparte=((Profesor) profesores.get(posicion-1)).asignar(asignaturas, asig-1);
				
				if(!imparte)
					informarErrorIntroducido();
					
			}while(!imparte);
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Mostrar alumnos de la asignatura
	public void mostrarAlumnosAsignaturas()
	{
		int posicion=-1;
		
		try
		{
			System.out.print("\nSeleccione una asignatura para mostrar los alumnos matriculados: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
			
			if(asignaturas[posicion-1]==null)
			{
				informarErrorIntroducido();
			}
			else
			{
				if(alumnos.size()!=0)
				{
					for(int i=0; i<alumnos.size() && alumnos.get(i)!=null; i++)
					{
						for(int j=0; j<((Alumno) alumnos.get(i)).getMatriculado().length && ((Alumno)alumnos.get(i)).getMatriculado(j) != null; j++)
						{
							if(alumnos.get(i)!=null && ((Alumno)alumnos.get(i)).getMatriculado(j) != null)
							{
								if(((Alumno) alumnos.get(i)).getMatriculado(j).equals(asignaturas[posicion-1].getNombre()))
								{
									System.out.println("El alumno " + alumnos.get(i).getNombre() + " está matriculado en la asignatura " + asignaturas[posicion-1].getNombre() + ".");
								}
							}
						}
					}
				}
				else
					System.out.println("\nPara esta asignatura no existen Alumnos matriculados.");
			}
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	//Mostrar profesores de la asignatura
	public void mostrarProfesoresAsignaturas()
	{
		int posicion=-1;
		
		try
		{
			System.out.println("Seleccione una asignatura para mostrar los Profesores que la imparten: ");
			posicion=teclado.nextInt();
			teclado.nextLine();
	
			if(asignaturas[posicion-1]==null)
			{
				informarErrorIntroducido();
			}
			else
			{
				for(int i=0; i<profesores.size(); i++)
				{
					for(int j=0; j<((Profesor) profesores.get(i)).getImparte().length; j++)
					{
						if(profesores.get(i)!=null && ((Profesor)profesores.get(i)).getImparte(j) != null)
						{
							if(((Profesor) profesores.get(i)).getImparte(j).equals(asignaturas[posicion-1].getNombre()))
							{
								System.out.println("El profesor " + profesores.get(i).getNombre() + " imparte la asignatura " + asignaturas[posicion-1].getNombre() + ".");
							}
						}
					}
				}
			}
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	public void eliminarAlumnos()
	{
		int alumno=-1;
		
		try
		{
			System.out.print("\nIntroduzca el alumno que desea eliminar: ");
			alumno=teclado.nextInt();
			teclado.nextLine();
			
			if(alumno<1 || alumno>alumnos.size())
				System.out.println("\nError!, introduzca un valor válido. \n");
			else
			{
				alumnos.remove(alumno-1);
				System.out.println("\nEl alumno se ha eliminado correctamente.");
			}
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	public void eliminarProfesores()
	{
		int profesor=-1;
		
		try
		{
			System.out.print("\nIntroduzca el profesor que desea eliminar: ");
			profesor=teclado.nextInt();
			teclado.nextLine();
			
			if(profesor<1 || profesor>profesores.size())
				System.out.println("\nError!, introduzca un valor válido. \n");
			else
			{
				alumnos.remove(profesor-1);
				System.out.println("\nEl profesor se ha eliminado correctamente.");
			}
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	public void eliminarAsignatura()
	{
		boolean puede=true;
		int asignatura=-1;
		int contador=0;
		
		try
		{
			System.out.print("\nIntroduzca la asignatura que desea eliminar: ");
			asignatura=teclado.nextInt();
			teclado.nextLine();
			
			for(int i=0; i<asignaturas.length; i++)
			{
				if(asignaturas[i]!=null)
					contador++;
			}
			if(asignatura<1 || asignatura>contador)
				System.out.println("\nError!, introduzca un valor válido.\n");
			else {
				for(int i=0; i<alumnos.size(); i++)
				{
					if(alumnos.size()!=0)
					{
						if(((Alumno) alumnos.get(i)).existeAsignaturas(asignaturas[asignatura-1]))
						{
							puede=false;
							i=alumnos.size();
						}
					}
				}
				for(int i=0; i<profesores.size(); i++)
				{
					if(profesores.size()!=0)
					{
						if(((Profesor) profesores.get(i)).existeAsignaturas(asignaturas[asignatura-1]))
						{
							puede=false;
							i=profesores.size();
						}
					}
				}
			
				if(puede)
				{
					System.out.println("Eliminamos la asignatura " + asignaturas[asignatura-1].getNombre() + "\n");
					asignaturas[asignatura-1]=null;
					reordenarArrayEliminado(asignaturas);
					
					int contnull=0;
					for(int i=0; i<asignaturas.length; i++)
					{
						if(asignaturas[i]==null)
							contnull++;
						if(contnull>5)
						{
							//decrementar array asignaturas para cuando sea necesario tras eliminar asignaturas.
							Asignatura[] asignaturas2=new Asignatura[asignaturas.length-5];
							for(int j=0; j<asignaturas2.length; j++)
							{
								asignaturas2[j]=new Asignatura();
								asignaturas2[j]=asignaturas[j];
							}
							asignaturas=asignaturas2;
							asignaturas2=null;
							contnull=0;
						}
					}
				}
				else
				{
					System.out.println("La asignatura " + asignaturas[asignatura-1].getNombre() + " no se puede eliminar ya que está asociada."); 
				}
			}
		}catch(Exception ioException)
		{
			System.out.println("\nError!, los datos introducidos no son coherentes.");
		}
	}
	
	public void reordenarArrayEliminado(Asignatura[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			if(a[i]==null && i<a.length-1)
			{
				a[i]=a[i+1];
				for(int j=i+1; j<a.length-1; j++)
				{
					a[j]=a[j+1];
				}
				i=a.length;
			}
		}
		a[a.length-1]=null;
	}
	
	public boolean arrayVacioAsignatura()
	{
		boolean vacio=true;
		if(asignaturas[0]!=null)
			vacio=false;
		return vacio;
	}
	
	public boolean arrayVacioProfesor()
	{
		boolean vacio=true;
		if(profesores.size()!=0)
			vacio=false;
		return vacio;
	}
	
	public boolean arrayVacioAlumno()
	{
		boolean vacio=true;
		if(alumnos.size()!=0)
			vacio=false;
		return vacio;
	}
	
	public boolean arrayVacioPersonaAlumno(int i)
	{
		boolean vacio=true;
		vacio=((Alumno) alumnos.get(i)).arrayVacio();
		return vacio;
	}
	
	public boolean arrayVacioPersonaProfesor(int i)
	{
		boolean vacio=true;
		vacio=((Profesor) profesores.get(i)).arrayVacio();
		return vacio;
	}
	
	public void guardarFicheroAlumnos()
	{
		File f=new File("FicheroAlumnos.txt");
		
		if(f.exists())
		{
			System.out.println("El fichero ya existe, se va a proceder a sobreescribirlo");
		}
		else
			System.out.println("El fichero no existe, se va a crear uno nuevo.");

		try {
			FileWriter fw = new FileWriter(f, false);
	
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);

			for(int i=0; i<alumnos.size(); i++)
			{
				pw.print(alumnos.get(i).getNombre());
				pw.print("##");
				pw.print(alumnos.get(i).getApellido());
				pw.print("##");
				pw.print(alumnos.get(i).getDni());
				pw.print("##");
				pw.print(alumnos.get(i).getEmail());
				for(int j=0; alumnos.get(i).getMatriculado(j)!=null; j++)
				{
					pw.print("##");
					pw.print(alumnos.get(i).getMatriculado(j));
					pw.print("##");
					pw.print(alumnos.get(i).getCurso(j));
					pw.print("##");
					pw.print(alumnos.get(i).getMatriculadoInicio(j));
					pw.print("##");
					pw.print(alumnos.get(i).getMatriculadoFin(j));
				}
				pw.println();
			}
			
			pw.close();
			bw.close();
			fw.close();
			
			System.out.println("\n - El fichero de alumnos se ha guardado correctamente - ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarFicheroProfesores()
	{
		File f=new File("FicheroProfesores.txt");
		
		if(f.exists())
		{
			System.out.println("El fichero ya existe, se va a proceder a sobreescribirlo");
		}
		else
			System.out.println("El fichero no existe, se va a crear uno nuevo.");

		try {
			FileWriter fw = new FileWriter(f, false);
	
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);

			for(int i=0; i<profesores.size(); i++)
			{
				pw.print(profesores.get(i).getNombre());
				pw.print("##");
				pw.print(profesores.get(i).getApellido());
				pw.print("##");
				pw.print(profesores.get(i).getDni());
				pw.print("##");
				pw.print(profesores.get(i).getEmail());
				pw.print("##");
				pw.print(profesores.get(i).getDireccion());
				
				for(int j=0; profesores.get(i).getImparte(j)!=null; j++)
				{
					pw.print("##");
					pw.print(profesores.get(i).getImparte(j));
					pw.print("##");
					pw.print(profesores.get(i).getCurso(j));
					pw.print("##");
					pw.print(profesores.get(i).getInicio(j));
					pw.print("##");
					pw.print(profesores.get(i).getFin(j));
				}
				pw.println();
			}
			
			pw.close();
			bw.close();
			fw.close();
			
			System.out.println("\n - El fichero de profesores se ha guardado correctamente - ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarFicheroAsignaturas()
	{
		File f=new File("FicheroAsignaturas.txt");
		
		if(f.exists())
		{
			System.out.println("El fichero ya existe, se va a proceder a sobreescribirlo");
		}
		else
			System.out.println("El fichero no existe, se va a crear uno nuevo.");

		try {
			FileWriter fw = new FileWriter(f, false);
	
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			
			
			for(int i=0; asignaturas[i]!=null; i++)
			{
				System.out.println("la posicion del array asignaturas es " + i );
				pw.print(asignaturas[i].getNombre());
				pw.print("##");
				pw.print(asignaturas[i].getCurso());
				pw.print("##");
				pw.print(asignaturas[i].getInicio());
				pw.print("##");
				pw.print(asignaturas[i].getFin());
				
				pw.println();
			}
			
			pw.close();
			bw.close();
			fw.close();
			
			System.out.println("\n - El fichero de asignaturas se ha guardado correctamente - ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarFicheroAlumnos()
	{
		String contenido="";
		String nombre="", apellido="", dni="", email="";
		String nomasig="", curso="";
		boolean matriculado=false;
		int ainicio=-1, afinal=-1, posalumn=0;

		Alumno a;
		
		File f=new File("FicheroAlumnos.txt");
		
		if(!f.exists())
		{
			System.out.println("Error!, el fichero de carga de Alumnos no existe.");
		}
		else
		{
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				contenido=br.readLine();
				
				while(contenido!=null)
				{
					//Usamos el split para dividir el string que leemos cuando encontramos el caracter dado.
					String[] aux=contenido.split("##");
					
					if(aux.length>=4)
					{
						try 
						{
							nombre=aux[0];
							apellido=aux[1];
							dni=aux[2];
							email=aux[3];
							
							a=new Alumno(nombre, apellido, dni, email);
							alumnos.add(a);
							
							for(int i=4; i<aux.length; i++)
							{
								nomasig=aux[i];
								i++;
								curso=aux[i];
								i++;
								ainicio=Integer.parseInt(aux[i]);
								i++;
								afinal=Integer.parseInt(aux[i]);	
								
								boolean encontrado=false;
								for(int j=0; j<asignaturas.length; j++)
								{
									if(nomasig==asignaturas[j].getNombre() && curso==asignaturas[j].getCurso() && 
											ainicio==asignaturas[j].getInicio() && afinal==asignaturas[j].getFin())
									{
										matriculado=alumnos.get(posalumn).matricular(asignaturas, j);
										encontrado=true;
										j=asignaturas.length;
									}
								}
								if(!encontrado)
									System.out.println("- La asignatura " + nomasig + " no está dada de alta en la base de datos... "
											+ " Esta asignatura no se guardará.");
								
								if(!matriculado)
								{
									System.out.println("La asignatura" + nomasig + " no se ha podido asignar al alumno " + nombre);
								}
							}
							posalumn++;
						}catch(Exception e)
						{
							System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
						}
					}
					else {
						System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
					}
					
					contenido=br.readLine();
				}

				br.close();
				fr.close();
				
				ordenarArrayAlumnos();
				System.out.println("\n - El fichero de alumnos se ha cargado correctamente - ");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void cargarFicheroProfesores()
	{
		String contenido="";
		String nombre="", apellido="", dni="", email="", direccion="";
		String nomasig="", curso="";
		boolean asignado=false;
		int ainicio=-1, afinal=-1, posprofe=0;

		Profesor p;
		
		File f=new File("FicheroProfesores.txt");
		
		if(!f.exists())
		{
			System.out.println("Error!, el fichero de carga de Profesores no existe.");
		}
		else
		{
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				contenido=br.readLine();
				
				while(contenido!=null)
				{
					//Usamos el split para dividir el string que leemos cuando encontramos el caracter dado.
					String[] aux=contenido.split("##");
					
					if(aux.length>=5)
					{
						try
						{
							nombre=aux[0];
							apellido=aux[1];
							dni=aux[2];
							email=aux[3];
							direccion=aux[4];
							
							p=new Profesor(nombre, apellido, dni, email, direccion);
							profesores.add(p);
							
							for(int i=5; i<aux.length; i++)
							{
								nomasig=aux[i];
								i++;
								curso=aux[i];
								i++;
								ainicio=Integer.parseInt(aux[i]);
								i++;
								afinal=Integer.parseInt(aux[i]);
								
								boolean encontrado=false;
								for(int j=0; j<asignaturas.length; j++)
								{
									if(nomasig==asignaturas[j].getNombre() && curso==asignaturas[j].getCurso() && 
											ainicio==asignaturas[j].getInicio() && afinal==asignaturas[j].getFin())
									{
										asignado=profesores.get(posprofe).asignar(asignaturas, j);
										encontrado=true;
										j=asignaturas.length;
									}
									if(!encontrado)
										System.out.println("- La asignatura " + nomasig + " no está dada de alta en la base de datos... "
												+ " Esta asignatura no se guardará.");
									if(!asignado)
									{
										System.out.println("La asignatura" + nomasig + " no se ha podido asignar al profesor" + nombre);
									}
								}
							}
							posprofe++;
						}catch(Exception e)
						{
							System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
						}
					}
					else {
						System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
					}
					contenido=br.readLine();
				}
				
				br.close();
				fr.close();
				
				ordenarArrayProfesores();
				System.out.println("\n - El fichero de profesores se ha cargado correctamente - ");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void cargarFicheroAsignaturas()
	{
		String contenido="";
		String nombre="", curso="", inicio="", fin="";
		int posasig=0;

		Asignatura a;
		
		File f=new File("FicheroAsignaturas.txt");
		
		if(!f.exists())
		{
			System.out.println("Error!, el fichero de carga de Asignaturas no existe.");
		}
		else
		{
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				contenido=br.readLine();
				
				while(contenido!=null)
				{
					//Usamos el split para dividir el string que leemos cuando encontramos el caracter dado.
					String[] aux=contenido.split("##");
					
					if(aux.length==4)
					{
						try
						{
							nombre=aux[0];
							curso=aux[1];
							inicio=aux[2];
							fin=aux[3];
							
							a=new Asignatura(nombre, curso, Integer.parseInt(inicio), Integer.parseInt(fin));	
							asignaturas[posasig]=a;
							posasig++;
						}catch(Exception e)
						{
							System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
						}
					}
					else
						System.out.println("\n### ATENCIÓN: - El fichero puede estar corrupto, tal vez no se hayan podido cargar algunos datos.\n");
					
					contenido=br.readLine();
				}

				br.close();
				fr.close();
				
				ordenarArrayAsignatura();
				System.out.println("\n - El fichero de asignaturas se ha cargado correctamente - ");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ordenarArrayAlumnos()
	{
		Collections.sort(alumnos);
	}
	
	public void ordenarArrayProfesores()
	{
		Collections.sort(profesores, new Comparator<Profesor>() {
			@Override
			public int compare(Profesor p1, Profesor p2)
			{
				int dv=0;
				
				dv=p1.getDni().compareTo(p2.getDni());
				return dv;
			}
		});
	}
	
	public void ordenarArrayAsignatura()
	{ 
        Asignatura temp;  
        
        for(int i=0; i < asignaturas.length; i++)  
        {
			 for(int j=1; j < (asignaturas.length-i); j++)
			 {
		          if(asignaturas[j]!=null && asignaturas[j-1].getInicio() > asignaturas[j].getInicio())
		          {   
		                 temp = asignaturas[j-1];  
		                 asignaturas[j-1] = asignaturas[j];  
		                 asignaturas[j] = temp;
		          }
			 }
        }
        
        for(int i=0; i<asignaturas.length; i++)
        {
        	for(int j=1; j<(asignaturas.length-i); j++)
        	{
        		  if(asignaturas[j]!=null && asignaturas[j-1].getInicio() == (asignaturas[j].getInicio()))
	        	  {
        			  if(asignaturas[j-1].getCurso().compareTo(asignaturas[j].getCurso())>=1)
	        		  {
		                 temp = asignaturas[j-1];  
		                 asignaturas[j-1] = asignaturas[j];  
		                 asignaturas[j] = temp; 
	        		  }
	        	  }
        	}
        }
        
        for(int i=0; i< asignaturas.length; i++)
        {
        	for(int j=1; j<(asignaturas.length-i); j++)
        	{
        		  if((asignaturas[j]!=null && asignaturas[j-1].getInicio() == asignaturas[j].getInicio()) && (asignaturas[j-1].getCurso().equals(asignaturas[j].getCurso())))
	        	  {
	        		  if(asignaturas[j-1].getNombre().compareTo(asignaturas[j].getNombre())>=1)
	        		  {
		                 temp = asignaturas[j-1];  
		                 asignaturas[j-1] = asignaturas[j];  
		                 asignaturas[j] = temp; 
	        		  }
	        	  }
        	}
        }
	}
}
