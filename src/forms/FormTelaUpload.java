package forms;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Luis
 */
//Futuramente a escolha pode ser por bairros de determinada cidade, ou pelo cartao do sus do cidadão.

public class FormTelaUpload {
    public Form f0 = new Form("Carregar lista de pacientes");
    final String [] municipio = {"Todos", "Curitiba", "Colombo", "Almirante Tamandare", "Pinhais"};
    public List listaetapa = new List("Carregar Paciente por municipio", List.EXCLUSIVE, municipio, null);
    public TextField campo = new TextField("Pelo Cartão do SUS:", "", 15, TextField.NUMERIC);
}
