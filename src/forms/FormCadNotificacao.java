package forms;
import javax.microedition.lcdui.*;

/**
 *
 * @author ead
 */
public class FormCadNotificacao{
    //etapa 2
    //campo0 nome investigador
    //campo 1
    //campo2 Data de Notificacao
    //campo3 Unidade Notificadora
    //Alert al = new Alert("Coleta", " ",null, AlertType.INFO);;
    public Form f0 = new Form("Notificação fase 2");
    public TextField campo20 = new TextField("Investigador:", "", 40, TextField.ANY);
    //TextField campo21 = new TextField("Paciente:", "", 8, TextField.ANY);
    public TextField campo22 = new TextField("Data da Notificacao:   ", "", 8, TextField.NUMERIC);
    public TextField campo23 = new TextField("Unidade Notificadora:", "", 40, TextField.ANY);
    //TextField campo24 = new TextField("Modo de Detecção: ", "", 5, TextField.NUMERIC);
    //TextField campo25 = new TextField("Modo de Entrada:", "", 10, TextField.NUMERIC);
    final String [] uf = {"Ignorado", "PR", "SC"};//lista1
    final String [] municipio = {"Ignorado", "Curitiba", "Colombo", "Almirante Tamandare", "Pinhais"};
    final String [] deteccao = {"Ignorado","Encaminhamento","Demanda Espontânea","Exame de Coletividade","Exame de Contatos","Outros Modos"};
    final String [] entrada = {"Ignorado","Caso Novo","Transferência do Mesmo Município","Transferência de Outro Município( mesma UF )","Transferência de Outro Estado","Transferência de Outro País","Recidiva","Outros Reingressos"};
    public List listaetapa21 = new List("UF", List.EXCLUSIVE, uf, null);
    public List listaetapa22 = new List("Municipio", List.EXCLUSIVE, municipio, null);
    public List listaetapa23 = new List("Modos de Deteccão", List.EXCLUSIVE, deteccao, null);
    public List listaetapa24 = new List("Modos de Entrada", List.EXCLUSIVE, entrada, null);
}
/*
CID 10 - A30.0   	Hanseníase (lepra) indeterminada
CID 10 - A30.1   	Hanseníase (lepra) tuberculóide
CID 10 - A30.2   	Hanseníase (lepra) tuberculóide borderline
CID 10 - A30.3   	Hanseníase (lepra) dimorfa
CID 10 - A30.4   	Hanseníase (lepra) lepromatosa borderline
CID 10 - A30.5   	Hanseníase (lepra) lepromatosa
CID 10 - A30.8   	Outras formas de hanseníase (lepra)
CID 10 - A30.9   	Hanseníase (lepra) não especificada
*/
