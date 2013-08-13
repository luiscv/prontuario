package forms;

import javax.microedition.lcdui.*;
/**
 *
 * @author Luis
 */
public class FormDiagonostico {
    public Form f0 = new Form("Notificação fase 4");
    public Alert al = new Alert("Informação Incorreta", " ",null, AlertType.INFO);
    public TextField campo40 = new TextField("Numero de Lesões Cutâneas: ", "", 2, TextField.NUMERIC);
    public TextField campo41 = new TextField("Numero de Troncos Acometidos: ", "", 2, TextField.NUMERIC);
    public TextField campo42 = new TextField("Numero de Contatos Registrados: ", "", 2, TextField.NUMERIC);
    public TextField campo43 = new TextField("Data do Diagonóstico: ", "", 8, TextField.NUMERIC);
    public TextField campo44 = new TextField("Observações: ", "", 40, TextField.ANY);
    final String [] incapacidade = {"Ignorado","Grau Zero", "Grau 1","Grau 2","Grau 3","Não Avaliado"};
    public List listaetapa41 = new List("Avaliação de Incapacidade", List.EXCLUSIVE, incapacidade, null);
    final String [] baciloscopia = {"Ignorado","Positiva", "Negativa","Não Avaliado"};
    public List listaetapa42 = new List("Baciloscopia", List.EXCLUSIVE, baciloscopia, null);
    final String [] formaclinica = {"Indeterminada", "Tuberculóide", "Dimorfa", "Virchowiana", "Não classificado"};
    public List listaetapa43 = new List("Forma Clínica", List.EXCLUSIVE, formaclinica, null);
    final String [] classoperacional = {"Ignorado","PB - Paucibacilares","MB - Multibacilares"};
    public List listaetapa44 = new List("Classificação Operacional", List.EXCLUSIVE, classoperacional, null);
    final String [] doencarelacionada = {"Ignorado","Sim","Não"};
    public List listaetapa45 = new List("Doença Relaiconada ao Trabalho", List.EXCLUSIVE, doencarelacionada, null);
    final String [] cid10 = {"A30.0 - Hanseníase indeterminada","A30.1 - Hanseníase tuberculóide", "A30.2 - Hanseníase boderline","A30.3 - Hanseníase dimorfa","A30.4 - Hanseníase lepromatosa borderline","A30.5 - Hanseníase lepromatosa","A30.8 - Outras formas de Hanseníase","A30.9 - Hanseníase não especificada"};
    public List listaetapa46 = new List("cid10", List.EXCLUSIVE, cid10, null);
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
