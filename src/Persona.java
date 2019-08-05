
public abstract class Persona {
	
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	
	
	protected Persona()
	{
		this.nombre="Por defecto";
		this.apellido="Por defecto";
		this.dni="12345678A";
		this.email="Por defecto";
	}
	
	protected Persona(String nombre, String apellido, String dni, String email)
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.email=email;
	}
	
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getApellido() {
		return apellido;
	}
	protected void setApellido(String apellido) {
		this.apellido = apellido;
	}
	protected String getDni() {
		return dni;
	}
	protected void setDni(String dni) {
		this.dni = dni;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	
	protected static boolean comprobarDNI(String dni)
	{
		boolean correcto=false;
		
		int dniaux=0;
		int resul=0;
		char[] arrayDNI = new char[24];
		char[] numDNI=dni.toCharArray();
		
		for(int i=0; i<numDNI.length-1; i++)
		{
			dniaux=(dniaux*10)+convertirCharToInt(numDNI[i]);
		}
		
		llenarArrayDNI(arrayDNI);

		resul=dniaux%23;
		
		if(numDNI[numDNI.length-1]==arrayDNI[resul])
			correcto=true;
		
		return correcto;
	}
	
	protected static void llenarArrayDNI(char[] array)
	{
		array[0]='T';
		array[1]='R';
		array[2]='W';
		array[3]='A';
		array[4]='G';
		array[5]='M';
		array[6]='Y';
		array[7]='F';
		array[8]='P';
		array[9]='D';
		array[10]='X';
		array[11]='B';
		array[12]='N';
		array[13]='J';
		array[14]='Z';
		array[15]='S';
		array[16]='Q';
		array[17]='V';
		array[18]='H';
		array[19]='L';
		array[20]='C';
		array[21]='K';
		array[22]='E';
		array[23]='T';
	}
	
	protected static int convertirCharToInt(char num)
	{
		int entero=0;
		
		switch (num) {
		case '0':
			entero=0;
			break;
		case '1':
			entero=1;
			break;
		case '2':
			entero=2;
			break;
		case '3':
			entero=3;
			break;
		case '4':
			entero=4;
			break;
		case '5':
			entero=5;
			break;
		case '6':
			entero=6;
			break;
		case '7':
			entero=7;
			break;
		case '8':
			entero=8;
			break;
		case '9':
			entero=9;
			break;
		default:
			break;
		}
		
		return entero;
	}

}
