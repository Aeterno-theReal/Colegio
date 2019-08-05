
public class Alumno extends Persona implements Comparable<Alumno>{

	Asignatura[] matriculado;

	public Alumno() 
	{
		super();
		
		this.matriculado=new Asignatura[50];
	}

	public Alumno(String nombre, String apellido, String dni, String email) 
	{
		super(nombre, apellido, dni, email);
		
		this.matriculado=new Asignatura[50];
	}

	public Asignatura[] getMatriculado() {
		return matriculado;
	}
	
	public String getMatriculado(int i)
	{
		if(matriculado[i]!=null)
			return matriculado[i].getNombre();
		else
			return null;
	}
	
	public String getCurso(int i)
	{
		if(matriculado[i]!=null)
			return matriculado[i].getCurso();
		else
			return null;
	}
	
	public int getMatriculadoInicio(int i)
	{
		if(matriculado[i]!=null)
			return matriculado[i].getInicio();
		else
			return -1;
	}
	
	public int getMatriculadoFin(int i)
	{
		if(matriculado[i]!=null)
			return matriculado[i].getFin();
		else
			return -1;
	}

	public void setMatriculado(Asignatura[] matriculado) {
		this.matriculado = matriculado;
	}
	
	public int getInicio(int i)
	{
		return matriculado[i].getInicio();
	}
	
	public int getFin(int i)
	{
		return matriculado[i].getFin();
	}
	
	public boolean matricular(Asignatura[] asig, int pos)
	{
		boolean matricula=false;

		for(int i=0; i<matriculado.length; i++)
		{
			if(matriculado[i]==null)
			{
				matriculado[i]=new Asignatura();
				matriculado[i]=asig[pos];
				matricula=true;
				i=matriculado.length;
			}
		}

		return matricula;
	}
	
	public void visualizar()
	{
		System.out.println("- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " -");
	}
	
	public void visualizarAsig()
	{
		System.out.println("\n- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " -");
		System.out.println("- Las asignaturas que cursa este alumno son: ");
		System.out.println("--------------------------------------------");
		
		for(int i=0; i<matriculado.length; i++)
		{
			if(matriculado[i]!=null)
				System.out.print("- " + matriculado[i].getNombre() + " - ");
			else
				i=matriculado.length;
		}
	}
	
	public void visualizarAsig(int anyo)
	{
		System.out.println("\n- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " -");
		System.out.println("- Las asignaturas que cursa este alumno en el año " + anyo + " son: ");
		System.out.println("-------------------------------------------------------------");
		
		for(int i=0; i<matriculado.length; i++)
		{
			if(matriculado[i]!=null && matriculado[i].getInicio()<=anyo && matriculado[i].getFin()>=anyo)
				System.out.print("- " + matriculado[i].getNombre() + " - ");
			else
				if(matriculado[i]==null)
					i=matriculado.length;
		}
	}
	
	public boolean existeAsignaturas(Asignatura asignatura)
	{
		boolean existe=false;

		for(int i=0; i<matriculado.length; i++)
		{
			if(asignatura==matriculado[i])
			{
				existe=true;
				i=matriculado.length;
			}
		}

		return existe;
	}
	
	public boolean arrayVacio()
	{
		boolean vacio=true;
		if(matriculado[0]!=null)
			vacio=false;
		return vacio;
	}
	
	@Override
	public int compareTo(Alumno o)
	{
		int dv=0;
		
	//	if(this.getEdad().equals(o.getEdad()))   --> en esto hay que imprimentar la edad, para luego
	//	{
		if(this.getNombre().equals(o.getNombre()))
		{
			if(this.getApellido().equals(o.getApellido()))
			{
				dv=0;
			}
			else {
				dv=this.getApellido().compareTo(o.getApellido());
			}
		}
		else
		{
			dv=this.getNombre().compareTo(o.getNombre());
		}
		return dv;
	}

}
