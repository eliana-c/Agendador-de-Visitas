package web;


import com.sun.rmi.rmid.ExecPermission;
import dao.Cita;
import database.Conexiones;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.OperVisita;

@ManagedBean
@SessionScoped
public class ManejadorBean implements Serializable {

 private int IdC;
    private String Inconveniente;
    private String IdT;
    private String Dia;
    private String Hora;
    private String Cliente;
    private int Telefono;
    private String Direccion;
    private String Vivienda;
    private String mensaje;
    
    private List<Cita> cita;
    private List<Cita> cita1 = new ArrayList<>();

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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Cita> getCita() {
        return cita;
    }

    public void setCita(List<Cita> cita) {
        this.cita = cita;
    }

    public List<Cita> getCita1() {
        return cita1;
    }

    public void setCita1(List<Cita> cita1) {
        this.cita1 = cita1;
    }

    
    public ManejadorBean() 
    {
        OperVisita oper = new OperVisita();
        this.cita = oper.consultar();
    }

   
   
}
 