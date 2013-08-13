package forms;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Luis
 */
public class FormConfig {
    public Form f0 = new Form("Configurar ip e porta do servidor");
    public TextField ip = new TextField("Endereco ip:", "192.168.0.100", 15, TextField.ANY);
    public TextField porta = new TextField("Porta:", "6500", 5, TextField.ANY);
}
