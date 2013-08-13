package forms;
import javax.microedition.lcdui.*;
/**
 *
 * @author Luis
 */
public class FormTratamento {
    public Form f0 = new Form("Notificação fase 5");
    public TextField campo50 = new TextField("Data de Inicio do Tratamento:", "", 8, TextField.NUMERIC);
    final String [] esquema = {"Ignorado","PQT/PB/6 doses", "PQT/MB/12 doses","PQT/MB/24 doses","ROM","Outros Esq. Alternativos"};
    public List listaetapa51 = new List("Esquema Terapeutico Inicial", List.EXCLUSIVE, esquema, null);
    final String [] situacao = {"Ignorado","Completo","Abandonado"};
    public List listaetapa52 = new List("Situação Atual do Tratamento", List.EXCLUSIVE, situacao, null);
}
