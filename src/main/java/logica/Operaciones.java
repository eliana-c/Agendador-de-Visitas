
package logica;

import dao.Cita;
import java.util.List;

public interface Operaciones<Cita> 
{
    
   
    
    public String consultaID(Cita cita);
    public List listaTecnicos(Cita cita);
    public List listaHora(Cita cita);
    public List listaDia(Cita cita);
    public void eliminarAgenda(Cita cita);
    public boolean agendar(Cita cita);
    public Cita consultarCita(Cita cita);
    public int actualizarCita(Cita cita);
    public int eliminarCita(Cita cita);
    public List<Cita> consultar(int IdC);
}
