package pront;

import forms.FormEndPaciente;
import forms.FormDiagonostico;
import forms.FormTratamento;
import forms.FormCadPaciente;
import forms.FormCadNotificacao;
import forms.FormTelaUpload;
import forms.FormConfig;
import java.util.Vector;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 * @author ead
 */
public class Prontuario extends MIDlet implements CommandListener {

    byte pagina = 1;
    int etapa = 0;
    String[] dados;
    Display tela;
    FormCadPaciente fcad1;
    FormCadNotificacao fcad2;
    FormEndPaciente fcad3;
    FormDiagonostico fcad4;
    FormTratamento fcad5;
    FormTelaUpload fup;
    FormConfig fconf;
    String[] itensmenuinicial = {"Cadastro Novo", "1 - Cadastrar Paciente", "2 - Cadastrar Dados", "3 - Cadastrar Endereco", "4 - Cadastrar Diagonóstico", "5 - Cadastrar Tratamento", "Outras Opcoes"};
    List menuinicial = new List("Escolha a etapa de notificação", List.IMPLICIT, itensmenuinicial, null);
    final Command voltar = new Command("Voltar", Command.BACK, 0);
    final Command escolher = new Command("Escolher", Command.ITEM, 1);
    final Command selecionar = new Command("Selecionar", Command.ITEM, 1);
    final Command cancelar = new Command("Cancelar", Command.CANCEL, 0);
    final Command proximo = new Command("Proximo", Command.ITEM, 1);
    final Command armazena = new Command("Armazena", Command.ITEM, 1);
    final Command listar = new Command("Listar", Command.ITEM, 1);
    public Command up = new Command("Atualizar", Command.ITEM, 1);
    final Command sair = new Command("Sair", Command.ITEM, 1);
    public Command enviar = new Command("Enviar", Command.ITEM, 1);
    public Command carregar = new Command("Carregar", Command.ITEM, 1);
    List listarms = new List("RMS", List.IMPLICIT);
    List listenvia = new List("Envia ao Servidor", List.IMPLICIT);
    //List l;
    List outras;
    GravarDados dadosrms = null;
    IOdados io = new IOdados();

    public Prontuario() {
        tela = Display.getDisplay(this);
        menuinicial.addCommand(escolher);
        menuinicial.addCommand(cancelar);
        menuinicial.setCommandListener(this);
        listarms.addCommand(voltar);
        listarms.addCommand(up);
        listarms.setCommandListener(this);
        listenvia.addCommand(voltar);
        listenvia.addCommand(enviar);
        listenvia.setCommandListener(this);
        dadosrms = new GravarDados(this);
        fconf = new FormConfig();
        //fconf.f0.addCommand(up);
        fconf.f0.addCommand(voltar);
        fconf.f0.append(fconf.ip);
        fconf.f0.append(fconf.porta);
        fconf.f0.setCommandListener(this);
    }

    public void startApp() {
        Display.getDisplay(this);
        tela.setCurrent(menuinicial);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void upCompEtapa1(String[] data) {
        //Update etapa 1        
        etapa = 1;
        fcad1 = new FormCadPaciente();
        //Form F0
        fcad1.f0.deleteAll();
        fcad1.f0.addCommand(voltar);
        fcad1.f0.addCommand(proximo);
        fcad1.f0.addCommand(sair);
        fcad1.f0.setCommandListener(this);

        fcad1.f0.append(fcad1.campo10);
        fcad1.f0.append(fcad1.campo11);
        fcad1.f0.append(fcad1.campo12);
        fcad1.f0.append(fcad1.campo13);
        fcad1.f0.append(fcad1.campo14);
        fcad1.f0.append(fcad1.campo15);
        fcad1.f0.append(fcad1.campo16);

        //Listas etapa 1
        fcad1.listaetapa12.addCommand(voltar);
        fcad1.listaetapa12.addCommand(proximo);
        fcad1.listaetapa12.addCommand(sair);
        fcad1.listaetapa12.setCommandListener(this);

        fcad1.listaetapa13.addCommand(voltar);
        fcad1.listaetapa13.addCommand(proximo);
        fcad1.listaetapa13.addCommand(sair);
        fcad1.listaetapa13.setCommandListener(this);

        fcad1.listaetapa14.addCommand(voltar);
        fcad1.listaetapa14.addCommand(armazena);
        fcad1.listaetapa14.addCommand(sair);
        fcad1.listaetapa14.setCommandListener(this);

        fcad1.campo10.setString(data[0]);
        fcad1.campo11.setString(data[1]);
        fcad1.campo12.setString(data[2]);
        fcad1.campo13.setString(data[3]);
        fcad1.campo14.setString(data[4]);
        fcad1.campo15.setString(data[5]);
        fcad1.campo16.setString(data[6]);
        fcad1.listaetapa12.setSelectedIndex(Byte.parseByte(data[7]), true);
        fcad1.listaetapa13.setSelectedIndex(Byte.parseByte(data[8]), true);
        fcad1.listaetapa14.setSelectedIndex(Byte.parseByte(data[9]), true);

//        fcad1.al.addCommand(voltar);
//        fcad1.al.addCommand(proximo);
//        fcad1.al.addCommand(sair);
//        fcad1.al.setCommandListener(this);
    }

    public void upCompEtapa2(String[] data) {
        //Update etapa 2
        etapa = 2;
        fcad2 = new FormCadNotificacao();
        //Form F0
        fcad2.f0.deleteAll();
        fcad2.f0.addCommand(voltar);
        fcad2.f0.addCommand(proximo);
        fcad2.f0.addCommand(sair);
        fcad2.f0.setCommandListener(this);

        fcad2.f0.append(fcad2.campo20);
        //fcad2.f0.append(fcad2.campo21);
        fcad2.f0.append(fcad2.campo22);
        fcad2.f0.append(fcad2.campo23);

        //Listas etapa 2
        fcad2.listaetapa21.addCommand(voltar);
        fcad2.listaetapa21.addCommand(proximo);
        fcad2.listaetapa21.addCommand(sair);
        fcad2.listaetapa21.setCommandListener(this);

        fcad2.listaetapa22.addCommand(voltar);
        fcad2.listaetapa22.addCommand(proximo);
        fcad2.listaetapa22.addCommand(sair);
        fcad2.listaetapa22.setCommandListener(this);

        fcad2.listaetapa23.addCommand(voltar);
        fcad2.listaetapa23.addCommand(proximo);
        fcad2.listaetapa23.addCommand(sair);
        fcad2.listaetapa23.setCommandListener(this);

        fcad2.listaetapa24.addCommand(voltar);
        fcad2.listaetapa24.addCommand(armazena);
        fcad2.listaetapa24.addCommand(sair);
        fcad2.listaetapa24.setCommandListener(this);

        fcad2.campo20.setString(data[10]);
        fcad2.campo22.setString(data[11]);
        fcad2.campo23.setString(data[12]);
        fcad2.listaetapa21.setSelectedIndex(Byte.parseByte(data[13]), true);
        fcad2.listaetapa22.setSelectedIndex(Byte.parseByte(data[14]), true);
        fcad2.listaetapa23.setSelectedIndex(Byte.parseByte(data[15]), true);
        fcad2.listaetapa24.setSelectedIndex(Byte.parseByte(data[16]), true);
    }

    public void upCompEtapa3(String[] data) {
        //Update etapa 3
        etapa = 3;
        fcad3 = new FormEndPaciente();
        //Form F0
        fcad3.f0.deleteAll();
        fcad3.f0.addCommand(voltar);
        fcad3.f0.addCommand(proximo);
        fcad3.f0.addCommand(sair);
        fcad3.f0.setCommandListener(this);

        //fcad3.f0.append(fcad3.campo30);
        fcad3.f0.append(fcad3.campo31);
        fcad3.f0.append(fcad3.campo32);
        fcad3.f0.append(fcad3.campo33);
        fcad3.f0.append(fcad3.campo34);
        fcad3.f0.append(fcad3.campo35);
        fcad3.f0.append(fcad3.campo36);

        //Listas etapa 3
        fcad3.listaetapa31.addCommand(voltar);
        fcad3.listaetapa31.addCommand(proximo);
        fcad3.listaetapa31.addCommand(sair);
        fcad3.listaetapa31.setCommandListener(this);

        fcad3.listaetapa32.addCommand(voltar);
        fcad3.listaetapa32.addCommand(armazena);
        fcad3.listaetapa32.addCommand(sair);
        fcad3.listaetapa32.setCommandListener(this);

        //fcad3.campo30.setString(data[17]);
        fcad3.campo31.setString(data[17]);
        fcad3.campo32.setString(data[18]);
        fcad3.campo33.setString(data[19]);
        fcad3.campo34.setString(data[20]);
        fcad3.campo35.setString(data[21]);
        fcad3.campo36.setString(data[22]);
        fcad3.listaetapa31.setSelectedIndex(Byte.parseByte(data[23]), true);
        fcad3.listaetapa32.setSelectedIndex(Byte.parseByte(data[24]), true);
    }

    public void upCompEtapa4(String[] data) {
        //Update etapa 4
        etapa = 4;
        fcad4 = new FormDiagonostico();
        //Form F0
        fcad4.f0.deleteAll();
        fcad4.f0.addCommand(voltar);
        fcad4.f0.addCommand(proximo);
        fcad4.f0.addCommand(sair);
        fcad4.f0.setCommandListener(this);

        fcad4.al.addCommand(voltar);
        fcad4.al.addCommand(sair);
        //fcad3.f0.append(fcad3.campo30);
        fcad4.f0.append(fcad4.campo40);
        fcad4.f0.append(fcad4.campo41);
        fcad4.f0.append(fcad4.campo42);
        fcad4.f0.append(fcad4.campo43);
        fcad4.f0.append(fcad4.campo44);

        //Listas etapa 4
        fcad4.listaetapa41.addCommand(voltar);
        fcad4.listaetapa41.addCommand(proximo);
        fcad4.listaetapa41.addCommand(sair);
        fcad4.listaetapa41.setCommandListener(this);

        fcad4.listaetapa42.addCommand(voltar);
        fcad4.listaetapa42.addCommand(proximo);
        fcad4.listaetapa42.addCommand(sair);
        fcad4.listaetapa42.setCommandListener(this);

        fcad4.listaetapa43.addCommand(voltar);
        fcad4.listaetapa43.addCommand(proximo);
        fcad4.listaetapa43.addCommand(sair);
        fcad4.listaetapa43.setCommandListener(this);

        fcad4.listaetapa44.addCommand(voltar);
        fcad4.listaetapa44.addCommand(proximo);
        fcad4.listaetapa44.addCommand(sair);
        fcad4.listaetapa44.setCommandListener(this);

        fcad4.listaetapa45.addCommand(voltar);
        fcad4.listaetapa45.addCommand(armazena);
        fcad4.listaetapa45.addCommand(sair);
        fcad4.listaetapa45.setCommandListener(this);

        fcad4.campo40.setString(data[25]);
        fcad4.campo41.setString(data[26]);
        fcad4.campo42.setString(data[27]);
        fcad4.campo43.setString(data[28]);
        fcad4.campo44.setString(data[29]);
        fcad4.listaetapa41.setSelectedIndex(Byte.parseByte(data[30]), true);
        fcad4.listaetapa42.setSelectedIndex(Byte.parseByte(data[31]), true);
        fcad4.listaetapa43.setSelectedIndex(Byte.parseByte(data[32]), true);
        fcad4.listaetapa44.setSelectedIndex(Byte.parseByte(data[33]), true);
        fcad4.listaetapa45.setSelectedIndex(Byte.parseByte(data[34]), true);
    }

    public void upCompEtapa5(String[] data) {
        //Update etapa 5
        etapa = 5;
        fcad5 = new FormTratamento();
        //Form F0
        fcad5.f0.deleteAll();
        fcad5.f0.addCommand(voltar);
        fcad5.f0.addCommand(proximo);
        fcad5.f0.addCommand(sair);
        fcad5.f0.setCommandListener(this);

        fcad5.f0.append(fcad5.campo50);

        //Listas etapa 5
        fcad5.listaetapa51.addCommand(voltar);
        fcad5.listaetapa51.addCommand(armazena);
        fcad5.listaetapa51.addCommand(sair);
        fcad5.listaetapa51.setCommandListener(this);

        fcad5.campo50.setString(data[35]);
        fcad5.listaetapa51.setSelectedIndex(Byte.parseByte(data[36]), true);
    }

    public void outrasOpcoes() {
        etapa = 6;
        outras = new List("Outras Opcoes", List.IMPLICIT);
        outras.append("Enviar Dados", null);
        outras.append("Receber Dados", null);
        outras.append("Apagar item da lista", null);
        outras.append("Apagar Banco RMS", null);
        outras.append("Configurar endereco do Servidor", null);
        outras.addCommand(selecionar);
        outras.addCommand(sair);
        outras.setCommandListener(this);
        //l = outras;
        //tela.setCurrent(l);
        tela.setCurrent(outras);
    }

    public void montarReceberDados() {
        fup = new FormTelaUpload();

        fup.listaetapa.addCommand(voltar);
        fup.listaetapa.addCommand(proximo);
        fup.listaetapa.addCommand(carregar);
        fup.listaetapa.setCommandListener(this);
        fup.f0.deleteAll();
        fup.f0.addCommand(voltar);
        fup.f0.addCommand(carregar);
        fup.f0.addCommand(sair);
        fup.f0.append(fup.campo);
        fup.f0.setCommandListener(this);
    }

    public void montarEnviaDados() {
    }

    public void criaPaciente() {
        BeanFormCadPaciente bean1 = new BeanFormCadPaciente();
        BeanCadNotificacao bean2 = new BeanCadNotificacao();
        BeanEndPaciente bean3 = new BeanEndPaciente();
        BeanDiagonostico bean4 = new BeanDiagonostico();
        BeanTratamento bean5 = new BeanTratamento();
        dadosrms.adicionarNoBanco(bean1, bean2, bean3, bean4, bean5);
    }

    public void armazenaDados() {
        if (etapa == 1) {
            dados[0] = fcad1.campo10.getString();
            dados[1] = fcad1.campo11.getString();
            dados[2] = fcad1.campo12.getString();
            dados[3] = fcad1.campo13.getString();
            dados[4] = fcad1.campo14.getString();
            dados[5] = fcad1.campo15.getString();
            dados[6] = fcad1.campo16.getString();
            dados[7] = Integer.toString(fcad1.listaetapa12.getSelectedIndex());
            dados[8] = Integer.toString(fcad1.listaetapa13.getSelectedIndex());
            dados[9] = Integer.toString(fcad1.listaetapa14.getSelectedIndex());
            dadosrms.update(dadosrms.posicao, dados);
        }
        if (etapa == 2) {
            dados[10] = fcad2.campo20.getString();
            dados[11] = fcad2.campo22.getString();
            dados[12] = fcad2.campo23.getString();
            dados[13] = Integer.toString(fcad2.listaetapa21.getSelectedIndex());
            dados[14] = Integer.toString(fcad2.listaetapa22.getSelectedIndex());
            dados[15] = Integer.toString(fcad2.listaetapa23.getSelectedIndex());
            dados[16] = Integer.toString(fcad2.listaetapa24.getSelectedIndex());
            dadosrms.update(dadosrms.posicao, dados);
        }
        if (etapa == 3) {
            //dados[17] = fcad3.campo30.getString();
            dados[17] = fcad3.campo31.getString();
            dados[18] = fcad3.campo32.getString();
            dados[19] = fcad3.campo33.getString();
            dados[20] = fcad3.campo34.getString();
            dados[21] = fcad3.campo35.getString();
            dados[22] = fcad3.campo36.getString();
            dados[23] = Integer.toString(fcad3.listaetapa31.getSelectedIndex());
            dados[24] = Integer.toString(fcad3.listaetapa32.getSelectedIndex());
            dadosrms.update(dadosrms.posicao, dados);
        }
        if (etapa == 4) {
            //dados[17] = fcad3.campo30.getString();
            dados[25] = fcad4.campo40.getString();
            dados[26] = fcad4.campo41.getString();
            dados[27] = fcad4.campo42.getString();
            dados[28] = fcad4.campo43.getString();
            dados[29] = fcad4.campo44.getString();
            //dados[22] = fcad3.campo36.getString();
            dados[30] = Integer.toString(fcad4.listaetapa41.getSelectedIndex());
            dados[31] = Integer.toString(fcad4.listaetapa42.getSelectedIndex());
            dados[32] = Integer.toString(fcad4.listaetapa43.getSelectedIndex());
            dados[33] = Integer.toString(fcad4.listaetapa44.getSelectedIndex());
            dados[34] = Integer.toString(fcad4.listaetapa45.getSelectedIndex());
            dadosrms.update(dadosrms.posicao, dados);
        }
        if (etapa == 5) {
            //dados[17] = fcad3.campo30.getString();
            dados[35] = fcad5.campo50.getString();
            dados[36] = Integer.toString(fcad5.listaetapa51.getSelectedIndex());
            dadosrms.update(dadosrms.posicao, dados);
        }
    }

    public boolean validaEtapa4() {

        boolean bool;
        int i = fcad4.listaetapa42.getSelectedIndex();
        int j = fcad4.listaetapa43.getSelectedIndex();
        String aviso = "";
        switch (i) {
            case 1:
                if ((j == 2) | (j == 3)) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro A Forma clínica indicada para a Baciloscopia Positiva é: DIMORFA ou VIRCHOWIANA !";
                    System.out.println(aviso + dados[32]);
                }
                break;
            case 2:
                if ((j == 0) | (j == 1)) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro A Forma clínica indicada para a Baciloscopia Negativa é: INDETERMINADA ou TUBERCULOIDE !";
                    System.out.println(aviso + dados[32]);
                }
                break;
        }
        i = fcad4.listaetapa43.getSelectedIndex();
        j = fcad4.listaetapa44.getSelectedIndex();
        switch (i) {
            case 0:
                if (j == 1) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: PB - PAUCIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 1:
                if (j == 1) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: PB - PAUCIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 2:
                if (j == 2) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: MB - MULTIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 3:
                if (j == 2) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: MB - MULTIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
        }
        fcad4.al.setString(aviso);
        if (aviso.length() > 2) {
            bool = false;
        } else {
            bool = true;
        }
        /*
        1.Para Baciloscopia Positiva, Forma clinica é DIMORFA ou VIRCHOWIANA.
        2.Para baciloscopia do diagnóstico sendo Negativa, Forma clínica é INDETERMINADA ou TUBERCULOIDE.
        3.Para Forma clínica Indeterminada ou Tuberculoide, Classificação Operacional é PB - PAUCIBACILARES.
        4.Para Forma clínica Dimorfa ou Virchowiana, Classificação Operacional é MB - MULTIBACILARES.
         */
        return bool;
    }

        public boolean validaEtapa5() {

        boolean bool;
        int i = fcad4.listaetapa42.getSelectedIndex();
        int j = fcad4.listaetapa43.getSelectedIndex();
        String aviso = "";
        switch (i) {
            case 1:
                if ((j == 2) | (j == 3)) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro A Forma clínica indicada para a Baciloscopia Positiva é: DIMORFA ou VIRCHOWIANA !";
                    System.out.println(aviso + dados[32]);
                }
                break;
            case 2:
                if ((j == 0) | (j == 1)) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro A Forma clínica indicada para a Baciloscopia Negativa é: INDETERMINADA ou TUBERCULOIDE !";
                    System.out.println(aviso + dados[32]);
                }
                break;
        }
        i = fcad4.listaetapa43.getSelectedIndex();
        j = fcad4.listaetapa44.getSelectedIndex();
        switch (i) {
            case 0:
                if (j == 1) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: PB - PAUCIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 1:
                if (j == 1) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: PB - PAUCIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 2:
                if (j == 2) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: MB - MULTIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
            case 3:
                if (j == 2) {
                    System.out.println("ta certo");
                } else {
                    aviso = "Erro: A Classificação Operacional indicada para esta Forma Clínica é: MB - MULTIBACILARES !";
                    System.out.println(aviso + dados[33]);
                }
                break;
        }
        fcad4.al.setString(aviso);
        if (aviso.length() > 2) {
            bool = false;
        } else {
            bool = true;
        }
        /*
        1.Para Baciloscopia Positiva, Forma clinica é DIMORFA ou VIRCHOWIANA.
        2.Para baciloscopia do diagnóstico sendo Negativa, Forma clínica é INDETERMINADA ou TUBERCULOIDE.
        3.Para Forma clínica Indeterminada ou Tuberculoide, Classificação Operacional é PB - PAUCIBACILARES.
        4.Para Forma clínica Dimorfa ou Virchowiana, Classificação Operacional é MB - MULTIBACILARES.
         */
        return bool;
    }

    public void retornaDados() {
        int indexrms = 1;
        listarms.deleteAll();
        listenvia.deleteAll();
        while (indexrms != dadosrms.getTotalRecord() + 1) {
            if (dadosrms.getRecord(indexrms) != null) {
                listarms.append(dadosrms.getRecord(indexrms), null);
                listenvia.append(dadosrms.getRecord(indexrms), null);
            }
            indexrms++;
        }
    }

    public void operacaoSocket(String s) {
        //IOdados io = new IOdados();
        io.enviaDados(s, fconf.ip.getString(), fconf.porta.getString());
        confirmaOperacao();
    }

    public void confirmaOperacao(){
        tela.setCurrent(new Alert("Confirmação", io.msg,null, AlertType.CONFIRMATION));
        io.msg = "";
    }

    public void commandAction(Command c, Displayable d) {
        if (c == escolher) {
            switch (menuinicial.getSelectedIndex()) {
                case 0:
                    criaPaciente();
                    break;
                //case 1: MontarCompEtapa1(); tela.setCurrent(fcad1.f0); break;
                case 1:
                    retornaDados();
                    etapa = 1;
                    tela.setCurrent(listarms);
                    break;
                case 2:
                    retornaDados();
                    etapa = 2;
                    tela.setCurrent(listarms);
                    break;
                case 3:
                    retornaDados();
                    etapa = 3;
                    tela.setCurrent(listarms);
                    break;
                case 4:
                    retornaDados();
                    etapa = 4;
                    tela.setCurrent(listarms);
                    break;
                case 5:
                    retornaDados();
                    etapa = 5;
                    tela.setCurrent(listarms);
                    break;
                case 6:
                    outrasOpcoes();
                    break;
            }
        }
        //cadastrar paciente
        if (etapa == 1) {
            if (c == voltar) {
                --pagina;
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad1.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad1.listaetapa12);
                        break;
                    case 3:
                        tela.setCurrent(fcad1.listaetapa13);
                        break;
                    case 4:
                        tela.setCurrent(fcad1.listaetapa14);
                        break;
                    case 5:
                        break;
                }
                if (pagina == 0) {
                    pagina = 1;
                    tela.setCurrent(menuinicial);
                }
                //this.notifyDestroyed();
            }
            if (c == proximo) {
                ++pagina;
                if (pagina == 5) {
                    pagina = 4;
                }
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad1.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad1.listaetapa12);
                        break;
                    case 3:
                        tela.setCurrent(fcad1.listaetapa13);
                        break;
                    case 4:
                        tela.setCurrent(fcad1.listaetapa14);
                        break;
                    //case 5:RetornaDados(); tela.setCurrent(fcad1.al); break;
                    case 6:
                        break;
                }
            }
            if (c == armazena) {
                armazenaDados();
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        if (etapa == 2) {
            if (c == voltar) {
                --pagina;
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad2.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad2.listaetapa21);
                        break;
                    case 3:
                        tela.setCurrent(fcad2.listaetapa22);
                        break;
                    case 4:
                        tela.setCurrent(fcad2.listaetapa23);
                        break;
                    case 5:
                        tela.setCurrent(fcad2.listaetapa24);
                        break;
                    case 6:
                        break;
                }
                if (pagina == 0) {
                    pagina = 1;
                    tela.setCurrent(menuinicial);
                }
            }
            if (c == proximo) {
                ++pagina;
                if (pagina == 6) {
                    pagina = 5;
                }
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad2.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad2.listaetapa21);
                        break;
                    case 3:
                        tela.setCurrent(fcad2.listaetapa22);
                        break;
                    case 4:
                        tela.setCurrent(fcad2.listaetapa23);
                        break;
                    case 5:
                        tela.setCurrent(fcad2.listaetapa24);
                        break;
                    case 6:
                        break;
                }
            }
            if (c == armazena) {
                armazenaDados();
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        //etapa3
        if (etapa == 3) {
            if (c == voltar) {
                --pagina;
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad3.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad3.listaetapa31);
                        break;
                    case 3:
                        tela.setCurrent(fcad3.listaetapa32);
                        break;
                }
                if (pagina == 0) {
                    pagina = 1;
                    tela.setCurrent(menuinicial);
                }
            }
            if (c == proximo) {
                ++pagina;
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad3.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad3.listaetapa31);
                        break;
                    case 3:
                        tela.setCurrent(fcad3.listaetapa32);
                        break;
                    case 4:
                        break;
                }
            }
            if (c == armazena) {
                armazenaDados();
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        //etapa 4
        if (etapa == 4) {
            if (c == voltar) {
                --pagina;
                System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad4.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad4.listaetapa41);
                        break;
                    case 3:
                        tela.setCurrent(fcad4.listaetapa42);
                        break;
                    case 4:
                        tela.setCurrent(fcad4.listaetapa43);
                        break;
                    case 5:
                        tela.setCurrent(fcad4.listaetapa44);
                        break;
                    case 6:
                        tela.setCurrent(fcad4.listaetapa45);
                        break;
                    case 7:
                        tela.setCurrent(fcad4.al);
                        break;
                }
                if (pagina == 0) {
                    pagina = 1;
                    tela.setCurrent(menuinicial);
                }
            }
            if (c == proximo) {
                ++pagina;
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad4.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad4.listaetapa41);
                        break;
                    case 3:
                        tela.setCurrent(fcad4.listaetapa42);
                        break;
                    case 4:
                        tela.setCurrent(fcad4.listaetapa43);
                        break;
                    case 5:
                        tela.setCurrent(fcad4.listaetapa44);
                        break;
                    case 6:
                        tela.setCurrent(fcad4.listaetapa45);
                        break;
                    case 7:
                        tela.setCurrent(fcad4.al);
                        break;
                }
            }
            if (c == armazena) {
                if (validaEtapa4()) {
                    armazenaDados();
                } else {
                    //++pagina;
                    tela.setCurrent(fcad4.al);
                }
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        //etapa 5
        if (etapa == 5) {
            if (c == voltar) {
                --pagina;
                //System.out.println(pagina);
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad5.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad5.listaetapa51);
                        break;
                    case 6:
                        break;
                }
                if (pagina == 0) {
                    pagina = 1;
                    tela.setCurrent(menuinicial);
                }
            }
            if (c == proximo) {
                ++pagina;
                switch (pagina) {
                    case 1:
                        tela.setCurrent(fcad5.f0);
                        break;
                    case 2:
                        tela.setCurrent(fcad5.listaetapa51);
                        break;
                }
            }
            if (c == armazena) {
                armazenaDados();
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        //outras opções
        if (etapa == 6) {
            if (c == selecionar) {
                switch (outras.getSelectedIndex()) {
                    case 0:
                        retornaDados();
                        tela.setCurrent(listenvia);
                        break;
                    case 1:
                        montarReceberDados();
                        tela.setCurrent(fup.listaetapa);
                        break;
                    case 2:
                        retornaDados();
                        tela.setCurrent(listarms);
                        break;
                    case 3:
                        try {
                            dadosrms.apagaBanco();
                        } catch (RecordStoreNotOpenException ex) {
                            ex.printStackTrace();
                        } catch (RecordStoreException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case 4:
                        tela.setCurrent(fconf.f0);
                        break;
                }
            }
            if (c == carregar) {
                //adiciona uma linha na lista rms do resultado do que é pego no socket
                //dadosrms.adicionarNoBanco(io.pegaDados(Integer.toString(fup.listaetapa.getSelectedIndex()), fconf.ip.getString(), fconf.porta.getString()));
                String linha= io.pegaDados(fup.campo.getString(), fconf.ip.getString(), fconf.porta.getString());
                System.out.println("A linha eh "+linha);
 //               linha = linha.toString();
                dadosrms.adicionarNoBanco2(linha.toString());
            }
            if (c == proximo) {
                tela.setCurrent(fup.f0);
            }
            if (c == voltar) {
                //OutrasOpcoes();
                tela.setCurrent(outras);
            }
            if (c == cancelar) {
                try {
                    dadosrms.fechar();
                } catch (RecordStoreNotOpenException ex) {
                    ex.printStackTrace();
                } catch (RecordStoreException ex) {
                    ex.printStackTrace();
                }
                this.notifyDestroyed();
            }
        }
        if (c == listar) {
            ++pagina;
            retornaDados();
            tela.setCurrent(listarms);
            //RetornaDados();tela.setCurrent(fcad1.al);
        }
        if (c == cancelar) {
            try {
                dadosrms.fechar();
            } catch (RecordStoreNotOpenException ex) {
                ex.printStackTrace();
            } catch (RecordStoreException ex) {
                ex.printStackTrace();
            }
            this.notifyDestroyed();
        }
        if (c == sair) {
            etapa = 0;
            pagina = 1;
            tela.setCurrent(menuinicial);
        }
        if (c == enviar) {
            String teste = dadosrms.getRecord(dadosrms.posicao = listenvia.getSelectedIndex() + 1);
            operacaoSocket(teste);
        }
        if (c == up) {//Para atualizar cadastros
            if (etapa == 1) {
                String teste = dadosrms.getRecord(dadosrms.posicao = listarms.getSelectedIndex() + 1);
                dados = null;
                dados = split(teste);
                upCompEtapa1(dados);
                tela.setCurrent(fcad1.f0);
            }
            if (etapa == 2) {
                String teste = dadosrms.getRecord(dadosrms.posicao = listarms.getSelectedIndex() + 1);
                dados = null;
                dados = split(teste);
                upCompEtapa2(dados);
                tela.setCurrent(fcad2.f0);
            }
            if (etapa == 3) {
                String teste = dadosrms.getRecord(dadosrms.posicao = listarms.getSelectedIndex() + 1);
                dados = null;
                dados = split(teste);
                upCompEtapa3(dados);
                tela.setCurrent(fcad3.f0);
            }
            if (etapa == 4) {
                String teste = dadosrms.getRecord(dadosrms.posicao = listarms.getSelectedIndex() + 1);
                dados = null;
                dados = split(teste);
                upCompEtapa4(dados);
                tela.setCurrent(fcad4.f0);
            }
            if (etapa == 5) {
                String teste = dadosrms.getRecord(dadosrms.posicao = listarms.getSelectedIndex() + 1);
                dados = null;
                dados = split(teste);
                upCompEtapa5(dados);
                tela.setCurrent(fcad5.f0);
            }
            if (etapa == 6) {
                int i = listarms.getSelectedIndex() + 1;
                dadosrms.setaDelete(i);
                //String teste = dadosrms.getRecord(dadosrms.posicao =listarms.getSelectedIndex()+1);
                //dados = null;
                //dados = split(teste);

                tela.setCurrent(menuinicial);
            }
        }
    }
    //teste separador de csv

    private String[] split(String original) {
        Vector nodes = new Vector();
        String separator = ",";
        //System.out.println("split start...................");
        // Parse nodes into vector
        int index = original.indexOf(separator);
        while (index >= 0) {
            //System.out.println(index);
            nodes.addElement(original.substring(0, index));
            original = original.substring(index + separator.length());
            index = original.indexOf(separator);
        }
        // Get the last node
        nodes.addElement(original);

        // Create splitted string array
        String[] result = new String[nodes.size()];
        if (nodes.size() > 0) {
            for (int loop = 0; loop < nodes.size(); loop++) {
                result[loop] = (String) nodes.elementAt(loop);
                //System.out.println(result[loop]);
            }
        }
        return result;
    }
    //fim de teste separador de csv
}
