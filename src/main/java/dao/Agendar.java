package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("dtBasicView")
@ViewScoped
public class Agendar implements Serializable 
{
    private List<Cita> cita;
    public Agendar()
    {
        cita = new ArrayList<>();
    }

  
}
