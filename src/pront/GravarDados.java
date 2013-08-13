package pront;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

/**
 *
 * @author Luis
 */
//  import javax.microedition.rms.*;
//  import java.io.*;
public class GravarDados {

    private RecordStore rs;
    //private ProntuarioBeta objmidlet = null;
    public int posicao = 1;

    public GravarDados(ProntuarioBeta MIDlet) {
        //objmidlet = MIDlet;
        try {
            //rs.deleteRecordStore("Dados");
            rs = RecordStore.openRecordStore("Dados", true);
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void apagaBanco() throws RecordStoreNotOpenException, RecordStoreException {
        rs.closeRecordStore();
        try {
            rs.deleteRecordStore("Dados");
            rs = RecordStore.openRecordStore("Dados", true);
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    void adicionarNoBanco(BeanFormCadPaciente objcadp, BeanCadNotificacao objcadn, BeanEndPaciente objend, BeanDiagonostico objdia, BeanTratamento objtrata) {
        try {
            //captura dados em um buffer da memória para depois transformá-lo
            //em um array de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //escreve Strings e tipos de dados primitivos em um OutPutStream
            DataOutputStream dos = new DataOutputStream(baos);
            //escreve no OutPutStream(baos) o nome e telefone
            //Este método é usado para escrever Strings. Para escrever outros tipos
            //temos o writeChar(), writeFloat(), writeInt(), writeByte(), entre outros.
            dos.writeUTF(objcadp.nome + "," + objcadp.data + "," +
                    objcadp.idade + "," + objcadp.ocupacao + "," +
                    objcadp.telefone + "," + objcadp.sus + "," +
                    objcadp.mae + "," + objcadp.genero + "," +
                    objcadp.etnia + "," + objcadp.escolaridade + "," +
                    //",0,0,,0,0,,0,0,0,"
                    objcadn.investivador + "," + objcadn.datanot + "," +
                    objcadn.unidadenot + "," + objcadn.uf + "," +
                    objcadn.municipio + "," + objcadn.mdetec + "," +
                    objcadn.mentrada + "," +
                    //",0,,0,0,0,0,"
                    objend.endereco + "," + objend.numend + "," +
                    objend.complemento + "," + objend.referencia + "," +
                    objend.cep + "," + objend.bairro + "," +
                    objend.zona + "," + objend.municipio + "," +
                    //",0,,,0,,0,0,"
                    objdia.numlesoes + "," + objdia.numtroncos + "," +
                    objdia.numcontatos + "," + objdia.datadiagonostico + "," +
                    objdia.observacoes + "," + objdia.incapacidade + "," +
                    objdia.baciloscopia + "," + objdia.formaclinica + "," +
                    objdia.classoperacional + "," + objdia.doencarelacionada + "," +
                    //"0,0,0,0,,0,0,0,0,0,"+
                    objtrata.datatratamento + "," + objtrata.esquematerapeutico);
            //"0,0"

            //esvazia os dados do OutPut Stream
            dos.flush();
            //copia os dados capturados em um array de bytes
            byte[] dados = baos.toByteArray();
            //adiciona os dados contidos no array de bytes no banco, que retorna
            //o id do registro que os dados ficaram armazenados
            int id = rs.addRecord(dados, 0, dados.length);
            //fecha o OutPut Stream e comunica os recursos do sistema associados
            // com o Stream
            dos.close();
            //fecha o ByteArrayOutPutStream, pois este ByteArrayOutPutStream não esta mais sendo usado
            baos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    void adicionarNoBanco2(String linha) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(linha);
            dos.flush();
            byte[] dados = baos.toByteArray();
            int id = rs.addRecord(dados, 0, dados.length);
            dos.close();
            baos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    void update(int id, String[] dados) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(dados[0] + "," + dados[1] + "," +
                    dados[2] + "," + dados[3] + "," +
                    dados[4] + "," + dados[5] + "," +
                    dados[6] + "," + dados[7] + "," +
                    dados[8] + "," + dados[9] + "," +
                    dados[10] + "," + dados[11] + "," +
                    dados[12] + "," + dados[13] + "," +
                    dados[14] + "," + dados[15] + "," +
                    dados[16] + "," +
                    dados[17] + "," + dados[18] + "," +
                    dados[19] + "," + dados[20] + "," +
                    dados[21] + "," + dados[22] + "," +
                    dados[23] + "," + dados[24] + "," +
                    dados[25] + "," + dados[26] + "," +
                    dados[27] + "," + dados[28] + "," +
                    dados[29] + "," + dados[30] + "," +
                    dados[31] + "," + dados[32] + "," +
                    dados[33] + "," + dados[34] + "," +
                    dados[35] + "," + dados[36]);
            dos.flush();
            byte[] data = baos.toByteArray();
            rs.setRecord(id, data, 0, data.length);
        } catch (IOException e) {
            System.out.println("-- Erro de IO");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-- Registro muito grande");
        } catch (InvalidRecordIDException e) {
            System.out.println("-- ID inexistente");
        } catch (RecordStoreNotOpenException e) {
            System.out.println("-- O Record Store esta fechado");
        } catch (RecordStoreException e) {
            System.out.println("-- Outro erro");
        }
    }

    int getTotalRecord() {
        int num = 0;
        try {
            num = rs.getNumRecords();
            //System.out.print(num);
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        }
        return num;
    }

    void listar() {
        try {
            //Os records IDs iniciam em um. O for vai do ID número 1 até a quantidade
            //total de records(registros), que é capturado através da função getNumRecords()
            for (int i = 1; i <= rs.getNumRecords(); i++) {
                //captura o record de id igual a i
                String aux = getRecord(i);
                //chama a função que escreve na tela os dados capturados no banco, como a função
                //pertence ao MIDlet acessamos a função através de um objeto do MIDlet. A função
                //manda a String com os dados de um registro do banco
                //objmidlet.listarTela(aux);
                //objmidlet.RetornaDados(aux);
            }
        } catch (RecordStoreNotOpenException e) {
            //System.out.println(e.getMessage());
        }

    }

    public String getRecord(int id) {
        String toReturn = "";
        try {
            //tamRecord recebe o tamanho do record cujo id é passado.
            int tamRecord = rs.getRecordSize(id);

            byte[] dados = new byte[tamRecord];
            //transforma um array de bytes em um InPut Stream
            ByteArrayInputStream bais = new ByteArrayInputStream(dados);
            //transforma um Input Strean em uma String ou em tipos de dados primitivos
            DataInputStream dis = new DataInputStream(bais);
            //acessa o banco no id informado e grava em array dados os dados
            //capturados no registro do Record Store
            rs.getRecord(id, dados, 0);
            //lê a String contida no DataInPutStream e armazena-a na variável toReturn
            toReturn = dis.readUTF();
            //System.out.print(toReturn);
            bais.close();
            dis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidRecordIDException e) {
            System.out.println(e.getMessage());
        } catch (RecordStoreNotOpenException e) {
            System.out.println(e.getMessage());
        } catch (RecordStoreException e) {
            System.out.println(e.getMessage());
        }
        return toReturn;
    }

    public void delete(int id) {
        try {
            rs.deleteRecord(id);
        } catch (RecordStoreNotOpenException ex) {
            ex.printStackTrace();
        } catch (InvalidRecordIDException ex) {
            ex.printStackTrace();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void setaDelete(int id) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(",0,0,,0,0,,0,0,0,,,,0,0,0,0,,0,,,0,,0,0,0,0,0,0,,0,0,0,0,0,0,0");
            dos.flush();
            byte[] data = baos.toByteArray();
            rs.setRecord(id, data, 0, data.length);
        } catch (IOException e) {
            System.out.println("-- Erro de IO");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-- Registro muito grande");
        } catch (InvalidRecordIDException e) {
            System.out.println("-- ID inexistente");
        } catch (RecordStoreNotOpenException e) {
            System.out.println("-- O Record Store esta fechado");
        } catch (RecordStoreException e) {
            System.out.println("-- Outro erro");
        }
    }

    public void trocarBanco() throws RecordStoreNotOpenException, RecordStoreException {
        rs.closeRecordStore();
        try {
            //rs.deleteRecordStore("Dados");
            rs = RecordStore.openRecordStore("Remoto", true);
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void fechar() throws RecordStoreNotOpenException, RecordStoreException {
        if (rs.getNumRecords() == 0) {
            //obtem o nome do Record Store que esta aberto
            String arquivo = rs.getName();
            //fecha o record Store que esta aberto
            rs.closeRecordStore();
            //deleta o Record Store com o nome passado por parâmetro. No caso
            //deletamos o Record Store se ele estiver vazio.
            RecordStore.deleteRecordStore(arquivo);
        } else {
            rs.closeRecordStore();
        }
    }
}
