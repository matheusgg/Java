import java.rmi.*;

public class MyRemoteClient {

    public static void main(String[] args) {
        try{
            Metodos_Remotos mr = (Metodos_Remotos) Naming.lookup("rmi://localhost/RemoteService"); //AQUI É CRIADA UMA VARIÁVEL DE REFERÊNCIA DE METODOS_REMOTOS (INTERFACE DO SERVIDOR REMOTO) E PASSADO O NOME DO SERVIÇO REGISTRADO PARA ELA
            String s = mr.exibir_msg(); // E AQUI, É INVOCADO UM METODO DA VERIÁVEL DE REFERÊNCIA, QUE SOLICITA O METODO PARA O STUB, ESTE POR SUA VEZ, VAI ATE O SERVIDOR, VERIFICA E RETORNA O MÉTODO SOLICITADO            
            System.out.println(s);
        } catch(Exception ex){ex.printStackTrace();}
    }
}
