package forms;
import javax.microedition.lcdui.*;

/**
 *
 * @author ead
 */
public class FormCadPaciente{
    //etapa 1
    //campo0 nome paciente
    //campo1 data nascimento
    //campo2 idade
    //Alert al = new Alert("Coleta", " ",null, AlertType.INFO);
    public Form f0 = new Form("Notificação fase 1");
    public TextField campo10 = new TextField("Nome do paciente:", "", 50, TextField.ANY);
    public TextField campo11 = new TextField("Data de Nascimento:", "", 8, TextField.NUMERIC);
    public TextField campo12 = new TextField("Idade do paciente:   ", "", 4, TextField.NUMERIC);
    public TextField campo13 = new TextField("Ocupação:", "", 15, TextField.ANY);
    public TextField campo14 = new TextField("Telefone: ", "", 12, TextField.NUMERIC);
    public TextField campo15 = new TextField("Numero do Cartão do SUS:", "", 15, TextField.NUMERIC);
    public TextField campo16 = new TextField("Nome da mãe:", "", 50, TextField.ANY);
    final String [] genero = {"Ignorado", "Masculino", "Feminino"};//lista1
    final String [] etnia = {"Ignorado", "Branca", "Negra", "Parda", "Amarela", "Indígena"};
    final String [] escolaridade = {"Nao Informado","Primeio Grau Incompleto", "Primeio Grau Completo", "Segundo Grau Incompleto", "Segundo Grau Completo", "Curso Superior Incompleto", "Curso Superior Completo"};
    public List listaetapa12 = new List("Sexo do Paciente", List.EXCLUSIVE, genero, null);
    public List listaetapa13 = new List("Etnia do Paciente", List.EXCLUSIVE, etnia, null);
    public List listaetapa14 = new List("Escolaridade do Paciente", List.EXCLUSIVE, escolaridade, null);
}
