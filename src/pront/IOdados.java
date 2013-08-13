package pront;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

/**
 *
 * @author Luis
 */
public class IOdados implements Runnable {
    //private Display display;
    //private Form fmMain;
    //private Command cmConectar;

    private SocketConnection sc;
    private InputStream is;
    public String linha;
    public String local;
    public String dados;
    public String endereco = "";
    public String msg = "";
    int operacao;

    public IOdados() {
    }
    //public void enviaDados(String dados){

    public void enviaDados(String dados, String ip, String porta) {
        this.dados = dados + "#";
        endereco = "socket://" + ip + ":" + porta;
        //tam = dados.length();
        operacao = 0;
        Thread t = new Thread(this);
        t.start();
    }

    public String pegaDados(String dados, String ip, String porta) {
        endereco = "socket://" + ip + ":" + porta;
        //System.out.println("os dados do pegadados() são: "+ dados);
        //tam = dados.length();
        //this.dados = "!" + dados + "#";
        this.dados = dados + "#";
        operacao = 1;
        Thread t = new Thread(this);
        t.start();
        //linha = ",0,0,,0,0,,0,0,0,,0,,0,0,0,0,,0,,,0,,0,0,0,0,0,0,,0,0,0,0,0,0,0";
        return linha;
    }

    public void run() {
        if (operacao == 0) {
            try {
                //sc = (SocketConnection) Connector.open("socket://192.168.1.101:6500");
                sc = (SocketConnection) Connector.open(endereco);
                OutputStream os = sc.openOutputStream();
                //os.write("abcd".getBytes());
                os.write(dados.getBytes());
                os.flush();
                os.close();
                StringBuffer sb = new StringBuffer();
                is = sc.openInputStream();
                int c = is.read();
//                int i;               
                while (c != -1) {
                    //System.out.println(sb.append((char)c));
                    sb.append((char) c);
                    c = is.read();
                }
                //fmMain.append(sb.toString());
                System.out.println("Aqui " + sb.toString());
                msg = sb.toString();
            } catch (IOException e) {
                System.out.println("erro: " + e);
            }
        }
        if (operacao == 1) {
            try {
                //sc = (SocketConnection) Connector.open("socket://192.168.1.101:6500");
                sc = (SocketConnection) Connector.open(endereco);
                OutputStream os = sc.openOutputStream();
                //os.write("abcd".getBytes());
                System.out.println("os dados do pegadados() são: "+ dados);
                os.write(dados.getBytes());
                os.flush();
                os.close();
                StringBuffer sb = new StringBuffer();
                is = sc.openInputStream();
                int c = is.read();
                int i;
                //while ((c = is.read()) != -1) {
                while (c != -1) {
                    //System.out.println(sb.append((char)c));
                    sb.append((char) c);
                    c = is.read();
                }
                //fmMain.append(sb.toString());
                linha = sb.toString();
                System.out.println("Aqui " + linha);
            } catch (IOException e) {
                System.out.println("erro: " + e);
            }
        }
        // finally {
        try {
            if (is != null) {
                is.close();
            }
            if (sc != null) {
                sc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // throw new UnsupportedOperationException("Not supported yet.");    }
}
