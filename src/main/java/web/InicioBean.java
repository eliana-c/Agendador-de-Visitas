package web;

import dao.Cita;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import logica.OperVisita;

@ManagedBean
@SessionScoped
public class InicioBean implements Serializable {

    public String agendardor() {
        
        System.out.println("No llega");
        return "agendador";
    }
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

    public InicioBean() {
        OperVisita oper = new OperVisita();
        this.cita = oper.consultar();
    }
    
     public void guardar() {
        OperVisita oper = new OperVisita();
        Cita e = new Cita();
        e.setInconveniente(Inconveniente);
        e.setIdT(IdT);
        e.setDia(Dia);
        e.setHora(Hora);
        e.setCliente(Cliente);
        e.setTelefono(Telefono);
        e.setDireccion(Direccion);
        e.setVivienda(Vivienda);
        
        
        if (oper.agendar(e) == false) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Visita Almacenada"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "No es posible almacenar la visita"));
        }

    }

    public void eliminar() {
        OperVisita oper = new OperVisita();
        Cita e = new Cita();
        e.setIdC(IdC);
        
        System.out.println("Producto " + e);
        this.mensaje = "Se ha eliminado \n";

        if (oper.eliminarCita(e) != 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto eliminado", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "No se pudo eliminar"));
        }

    }


    public void update()
    {
        OperVisita oper = new OperVisita();
        Cita e = new Cita();
        e.setInconveniente(Inconveniente);
        e.setIdT(IdT);
        e.setDia(Dia);
        e.setHora(Hora);
        e.setCliente(Cliente);
        e.setTelefono(Telefono);
        e.setDireccion(Direccion);
        e.setVivienda(Vivienda);
        this.mensaje = "Se Modifico \n";

        if (oper.actualizarCita(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Información cambiada del empleado con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Se presentó inconveniente en el almacenamiento, intente mas tarde "));
        }
    }
    public void consultaId()
    {
        cita1 = cita;
        OperVisita oper = new OperVisita();
        Cita e = new Cita();       
        e.setIdC(IdC);
        this.cita = oper.consultar(IdC);
        if (oper.actualizarCita(e) > 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Información del producto consultada"));
           
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "No se pudo consultar "));
        }   
           
    }

}
