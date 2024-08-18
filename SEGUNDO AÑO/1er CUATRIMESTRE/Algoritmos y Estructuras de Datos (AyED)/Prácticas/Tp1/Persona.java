
package Tp1;


public abstract class Persona {
    private String nombre;
    private String apellido;
    private String email;
    
    
    public String toString() {
        String aux = "Nombre:" + getNombre() +
                     " Apellido:" + getApellido() + 
                     " Email:" + getEmail();
        
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
