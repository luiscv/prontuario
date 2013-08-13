package forms;
import javax.microedition.lcdui.*;
/**
 *
 * @author Luis
 */
public class FormEndPaciente {
    //etapa 3 Cadastro do endereço do paciente
    //campo0 nome investigador
    //campo 1
    //campo2 Data de Notificacao
    //campo3 Unidade Notificadora
    //Alert al = new Alert("Coleta", " ",null, AlertType.INFO);;
    public Form f0 = new Form("Notificação fase 3");
    //TextField campo30 = new TextField("Codigo da Notificação:", "", 5, TextField.ANY);
    public TextField campo31 = new TextField("Endereço", "", 40, TextField.ANY);
    public TextField campo32 = new TextField("Numero do Endereço", "", 8, TextField.NUMERIC);
    public TextField campo33 = new TextField("Complemento", "", 20, TextField.ANY);
    public TextField campo34 = new TextField("Ponto de Referencia", "", 40, TextField.ANY);
    public TextField campo35 = new TextField("CEP", "", 8, TextField.NUMERIC);
    public TextField campo36 = new TextField("Bairro:", "", 15, TextField.ANY);
    final String [] zona = {"Ignorado", "Rural", "Urbana", "Rural/Urbana"};
    final String [] municipio = {"Ignorado", "Curitiba", "Colombo", "Almirante Tamandare", "Pinhais"};
    //final String [] bairro = {"Ignorado", "Curitiba", "Colombo", "Almirante Tamandare", "Pinhais"};
    public List listaetapa31 = new List("UF", List.EXCLUSIVE, zona, null);
    public List listaetapa32 = new List("Municipio", List.EXCLUSIVE, municipio, null);
}
