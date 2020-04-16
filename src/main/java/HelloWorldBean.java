import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("helloworld")
@ManagedBean
@ViewScoped
public class HelloWorldBean implements Serializable {

    public String getMessage() {
        return "Eu estou funcionando";
    }

}
