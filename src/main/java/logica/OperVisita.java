package logica;

import dao.Cita;
import database.Conexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class OperVisita implements Operaciones<Cita> {

    @Override
    public boolean agendar(Cita cita){
        Conexiones c = new Conexiones();
         boolean respuesta = false;
       if( cita == null || cita.getInconveniente() == "" || cita.getIdT() == "" || cita.getDia() == "" || cita.getHora() == "" || 
           cita.getCliente()== "" || cita.getTelefono() == 0 || cita.getDireccion() == "" || cita.getVivienda() ==""){
           respuesta = false;
       }else{
            
       
        String dia = "";
            try {
                Connection cActiva = c.conectarse();
                String sql = ("INSERT INTO citas (Inconveniente, IdT, Dia, Hora, Cliente, Telefono, Direccion, Vivienda ) VALUES (?,?,?,?,?,?,?,?)");
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, cita.getInconveniente());
                ps.setString(2, cita.getIdT());
                ps.setString(3, cita.getDia());
                ps.setString(4, cita.getHora());
                ps.setString(5, cita.getCliente());
                ps.setInt(6, cita.getTelefono());
                ps.setString(7, cita.getDireccion());
                ps.setString(8, cita.getVivienda());
                respuesta = ps.execute();
                c.desconectarse(cActiva);

                Connection cActiva2 = c.conectarse();
                String sql2 = "select * from agenda where Hora = ?";
                PreparedStatement pss = cActiva2.prepareStatement(sql);
                pss.setString(1, cita.getHora());
                ResultSet RS = pss.executeQuery();

                while (RS.next()) {
                    dia = RS.getString(cita.getDia());
                }
                c.desconectarse(cActiva2);
                
                Connection cActiva3 = c.conectarse();
                String Rs = ("UPDATE agenda SET " + cita.getDia() + " = ? where Hora = ?");
                PreparedStatement Ps = cActiva3.prepareStatement(Rs);
                if ("".equals(dia)) {
                    Ps.setString(1, consultaID(cita));
                } else {
                    Ps.setString(1, dia + "," + consultaID(cita));
                }
                Ps.setString(2, cita.getHora());
                respuesta = Ps.execute();
                c.desconectarse(cActiva3);
                respuesta = true;
            } catch (SQLException ex) {
                Logger.getLogger(OperVisita.class.getName()).log(Level.SEVERE, null, ex);
            }  
           
    }
       return respuesta;
    }

    @Override
    public int eliminarCita(Cita cita) {
        Conexiones c = new Conexiones();
        Cita cita1 = cita;
        if(cita != null && cita.getIdC() != 0 && 0 != cita.getIdC()){
            String sql = "DELETE FROM citas WHERE IdC = ?";
        try {
            Connection cActiva = c.conectarse();
            PreparedStatement ps = cActiva.prepareStatement(sql);
            ps.setInt(1, cita.getIdC());
            int respuesta = ps.executeUpdate();
            c.desconectarse(cActiva);
            eliminarAgenda(cita1);
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(OperVisita.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        
        }
        return 0;
    }

    @Override
    public void eliminarAgenda(Cita cita) {
        Conexiones c = new Conexiones();
        String dia = null;
        String cadenaNueva = "";
        try {
            Connection cActiva = c.conectarse();

            String sql = "select * from agenda where Hora =?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            ps.setString(1, cita.getHora());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dia = rs.getString(cita.getDia());
            }
            if ("".equals(dia)) {
                c.desconectarse(cActiva);

            } else {
                String[] citas = dia.split(",");
                for (String cita1 : citas) {
                    if (cita1.equals(Integer.toString(cita.getIdC()))) {

                    } else {
                        if ("".equals(cadenaNueva)) {
                            cadenaNueva += cita1;
                        } else {
                            cadenaNueva += "," + cita1;
                        }
                    }
                }
                c.desconectarse(cActiva);
                Connection cActiva1 = c.conectarse();
                String Rs = ("UPDATE agenda SET " + cita.getDia() + " = ? where Hora = ?");
                PreparedStatement Ps = cActiva1.prepareStatement(Rs);
                Ps.setString(1, cadenaNueva);
                Ps.setString(2, cita.getHora());
                Ps.execute();
                cActiva1.close();

            }

        } catch (Exception e) {

        }
    }

    @Override
    public int actualizarCita(Cita dato) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        
        if (cActiva != null && dato != null && dato.getInconveniente() != "" && dato.getIdT() != "" && dato.getDia() != "" && dato.getHora() != "" &&
           dato.getCliente()!= "" && dato.getTelefono() != 0 && dato.getDireccion() != "" && dato.getVivienda() !="") {
            try {
                String sql = "update citas set Inconveniente = ?, IdT = ?, Dia = ?, Hora = ?, Cliente = ?, Telefono = ?, Direccion = ?, Vivienda = ? where IdC = ?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setString(1, dato.getInconveniente());
                ps.setString(2, dato.getIdT());
                ps.setString(3, dato.getDia());
                ps.setString(4, dato.getHora());
                ps.setString(5, dato.getCliente());
                ps.setInt(6, dato.getTelefono());
                ps.setString(7, dato.getDireccion());
                ps.setString(8, dato.getVivienda());
                int rta = ps.executeUpdate();
                return rta;

            } catch (SQLException ex) {
                Logger.getLogger(OperVisita.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectarse(cActiva);
            }
        }
        return 0;
    }
    
  @Override
    public String consultaID(Cita cita){
         Conexiones c = new Conexiones();
        
        String idC = "";
        Statement stmt = null;
        try {
            Connection cActiva = c.conectarse();
            stmt = cActiva.createStatement();
            String rs = ("SELECT * FROM citas WHERE Inconveniente = ? AND IdT = ? AND Dia = ? AND Hora = ? AND Cliente = ? AND Telefono = ? AND Direccion = ? AND Vivienda = ?");
            PreparedStatement ps = cActiva.prepareStatement(rs);
            ps.setString(1, cita.getInconveniente());
            ps.setString(2, cita.getIdT());
            ps.setString(3, cita.getDia());
            ps.setString(4, cita.getHora());
            ps.setString(5, cita.getCliente());
            ps.setInt(6, cita.getTelefono());
            ps.setString(7, cita.getDireccion());
            ps.setString(8, cita.getVivienda());

            ResultSet sr = ps.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            ResultSetMetaData metaDatos = sr.getMetaData();

            while (sr.next()) {
                idC = sr.getObject(1).toString();
            }
            c.desconectarse(cActiva);
        } catch (Exception e) {
            System.out.println("No llego" + e);
        }
        return idC;
        
    }
    public List<Cita> consultar() {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        List<Cita> datos = new ArrayList<>();
        if (cActiva != null) {
            try {
                String sql = "select * from citas";
                PreparedStatement ps = cActiva.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cita e = new Cita();
                    int IdC = rs.getInt("id");
                    e.setIdC(IdC);

                    e.setInconveniente(rs.getString("Inconveniente"));
                    e.setIdT(rs.getString("IdT"));
                    e.setDia(rs.getString("Dia"));
                    e.setHora(rs.getString("Hora"));
                    e.setCliente(rs.getString("Cliente"));
                    e.setTelefono(rs.getInt("Telefono"));
                    e.setDireccion(rs.getString("Direccion"));
                    e.setVivienda(rs.getString("Vivienda"));

                    datos.add(e);
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperVisita.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectarse(cActiva);
            }
        }
        return datos;
    }

    @Override
    public Cita consultar(int IdC) {
        Conexiones c = new Conexiones();
        Connection cActiva = c.conectarse();
        Cita datos = new  Cita();
        datos = null;
        if (cActiva != null && IdC != 0) {
            try {
                String sql = "select * from citas where IdC = ?";
                PreparedStatement ps = cActiva.prepareStatement(sql);
                ps.setInt(1, IdC);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cita e = new Cita();

                    e.setInconveniente(rs.getString("Inconveniente"));
                    e.setIdT(rs.getString("IdT"));
                    e.setDia(rs.getString("Dia"));
                    e.setHora(rs.getString("Hora"));
                    e.setCliente(rs.getString("Cliente"));
                    e.setTelefono(rs.getInt("Telefono"));
                    e.setDireccion(rs.getString("Direccion"));
                    e.setVivienda(rs.getString("Vivienda"));

                    
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperVisita.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                c.desconectarse(cActiva);
            }
        }
        return datos;
    }

    @Override
    public List listaTecnicos(Cita cita) {
        
       Conexiones c = new Conexiones();
        Statement stmt = null;
        List list = new ArrayList();
        try {
            Connection cActiva = c.conectarse();
            stmt = cActiva.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tecnicos");

            DefaultTableModel modelo = new DefaultTableModel();
            ResultSetMetaData metaDatos = rs.getMetaData();

            while (rs.next()) {
                String tecnico = rs.getObject(1) + " " + rs.getObject(2) + " " + rs.getObject(3);
                list.add(tecnico);
            }
            c.desconectarse(cActiva);
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List listaHora(Cita cita) {
        Conexiones c = new Conexiones();
        Statement stmt = null;
        List list = new ArrayList();
        try {
             Connection cActiva = c.conectarse();
            stmt = cActiva.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda");

            DefaultTableModel modelo = new DefaultTableModel();
            ResultSetMetaData metaDatos = rs.getMetaData();

            while (rs.next()) {
                String hora = rs.getObject(1).toString();
                list.add(hora);
            }
            c.desconectarse(cActiva);
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List listaDia(Cita cita) {
        Conexiones c = new Conexiones();
        Statement stmt = null;
        List list = new ArrayList();
        try {
             Connection cActiva = c.conectarse();
            Statement st = cActiva.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM agenda");
            ResultSetMetaData rsmd = rs.getMetaData();
            int numeroColumnas = 6;
            for (int i = 2; i <= numeroColumnas; i++) {
                list.add(rsmd.getColumnName(i));
            }
            c.desconectarse(cActiva);
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Cita consultarCita(Cita cita) {
        Conexiones c = new Conexiones();
        Statement stmt = null;
        try {
            Connection cActiva = c.conectarse();
            stmt = cActiva.createStatement();
            String sql = "select * from citas where IdC = ?";
            PreparedStatement ps = cActiva.prepareStatement(sql);
            ps.setLong(1, cita.getIdC());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cita.setInconveniente(rs.getString("Inconveniente"));
                cita.setIdT(rs.getString("IdT"));
                cita.setDia(rs.getString("Dia"));
                cita.setHora(rs.getString("Hora"));
                cita.setCliente(rs.getString("Cliente"));
                cita.setTelefono(rs.getInt("Telefono"));
                cita.setDireccion(rs.getString("Direccion"));
                cita.setVivienda(rs.getString("Vivienda"));
                cita.existencia = true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return cita;
    }

}
