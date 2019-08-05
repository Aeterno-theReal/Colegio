
public class Asignatura {

	private String nombre;
	private String curso;
	private int inicio;
	private int fin;
	
	
	public Asignatura()
	{
		this.nombre="";
		this.curso="";
		this.inicio=Integer.MIN_VALUE;
		this.fin=Integer.MAX_VALUE;
	}
	
	public Asignatura(String nombre, String curso, int inicio, int fin)
	{
		this.nombre=nombre;
		this.curso=curso;
		this.inicio=inicio;
		this.fin=fin;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getInicio() {
		return inicio;
	}
	public void setInicio(int inicio) {
		this.inicio = inicio;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	
	public void visualizar()
	{
		System.out.println("- Asignatura: " + this.nombre + "; Curso: " + this.curso + "; Inicio: " + this.inicio + "; fin: " + this.fin + " -");
	}
	
}
