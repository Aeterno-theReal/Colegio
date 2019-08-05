
public class Profesor extends Persona{
	
	private String direccion;
	Asignatura[] imparte;
	

	public Profesor()
	{
		super();
		this.direccion="Por defecto";
		this.imparte=new Asignatura[50];
		
	}
	
	public Profesor(String nombre, String apellido, String dni, String email, String direccion)
	{
		super(nombre, apellido, dni, email);
		
		this.direccion=direccion;
		this.imparte=new Asignatura[50];
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Asignatura[] getImparte() {
		return imparte;
	}
	
	public String getImparte(int i)
	{
		if(imparte[i]!=null)
			return imparte[i].getNombre();
		else
			return null;
	}
	
	public String getCurso(int i)
	{
		if(imparte[i]!=null)
			return imparte[i].getCurso();
		else
			return null;
	}
	
	public int getInicio(int i)
	{
		return imparte[i].getInicio();
	}
	
	public int getFin(int i)
	{
		return imparte[i].getFin();
	}
	
	public void setImparte(Asignatura[] imparte) {
		this.imparte = imparte;
	}
	
	public boolean asignar(Asignatura[] asig, int pos)
	{
		boolean incorporado = false;
		
		for(int i=0; i<imparte.length; i++)
		{
			if(imparte[i]==null)
			{
				imparte[i]=new Asignatura();
				imparte[i]=asig[pos];
				incorporado=true;
				i=imparte.length;
			}
		}
		
		return incorporado;
	}
	
	public void visualizar()
	{
		System.out.println("- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " direccion: " + getDireccion() + " -");
	}
	
	public void visualizarAsig()
	{
		System.out.println("\n- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " direccion: " + getDireccion() + " -");
		System.out.println("- Las asignaturas que cursa este alumno son: ");
		System.out.println("--------------------------------------------");
		
		for(int i=0; i<imparte.length; i++)
		{
			if(imparte[i]!=null)
				System.out.print("- " + imparte[i].getNombre() + " - ");
			else
				i=imparte.length;
		}
	}
	
	public void visualizarAsig(int anyo)
	{
		System.out.println("\n- Nombre: " + getNombre() + "; Apellido: " + getApellido() + "; DNI: " + getDni() + "; email: " + getEmail() + " direccion: " + getDireccion() + " -");
		System.out.println("- Las asignaturas que cursa este alumno en el año " + anyo + " son: ");
		System.out.println("-------------------------------------------------------------");
		
		for(int i=0; i<imparte.length; i++)
		{
			if(imparte[i]!=null && imparte[i].getInicio()<=anyo && imparte[i].getFin()>=anyo)
				System.out.print("- " + imparte[i].getNombre() + " - ");
			else
				if(imparte[i]==null)
					i=imparte.length;
		}
	}
	
	public boolean existeAsignaturas(Asignatura asignatura)
	{
		boolean existe=false;
		
		for(int i=0; i<imparte.length; i++)
		{
			if(asignatura==imparte[i])
			{
				existe=true;
				i=imparte.length;
			}
		}
		return existe;
	}
	
	public boolean arrayVacio()
	{
		boolean vacio=true;
		if(imparte[0]!=null)
			vacio=false;
		return vacio;
	}
}