import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class HelloWorldBean implements Serializable {

    public String getMessage() {
        return "Eu estou funcionando";
    }

}
