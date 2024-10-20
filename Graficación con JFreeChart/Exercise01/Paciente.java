public class Paciente {

    private String diagnostico;
    private int edad;

    public Paciente(String diagnostico, int edad) {
        this.diagnostico = diagnostico;
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public int getEdad() {
        return edad;
    }
    
}
