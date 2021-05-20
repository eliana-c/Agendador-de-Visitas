
package dao;

public class Cita 
{
    private int IdC;
    private String Inconveniente;
    private String IdT;
    private String Dia;
    private String Hora;
    private String Cliente;
    private int Telefono;
    private String Direccion;
    private String Vivienda;
    public boolean existencia = false;

    public Cita() {
       
    }

    public int getIdC() {
        return IdC;
    }

    public void setIdC(int IdC) {
        this.IdC = IdC;
    }

    public String getInconveniente() {
        return Inconveniente;
    }

    public void setInconveniente(String Inconveniente) {
        this.Inconveniente = Inconveniente;
    }

    public String getIdT() {
        return IdT;
    }

    public void setIdT(String IdT) {
        this.IdT = IdT;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getVivienda() {
        return Vivienda;
    }

    public void setVivienda(String Vivienda) {
        this.Vivienda = Vivienda;
    }

    public boolean getExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
    

    public Cita(int IdC, String Inconveniente, String IdT, String Dia, String Hora, String Cliente, int Telefono, String Direccion, String Vivienda, boolean existencia) {
        this.IdC = IdC;
        this.Inconveniente = Inconveniente;
        this.IdT = IdT;
        this.Dia = Dia;
        this.Hora = Hora;
        this.Cliente = Cliente;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.Vivienda = Vivienda;
        this.existencia = existencia;
    }

    
    
    
}
