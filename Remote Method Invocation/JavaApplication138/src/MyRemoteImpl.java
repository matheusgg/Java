import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements Metodos_Remotos{ //É A CLASSE QUE IMPLEMENTARÁ A INTERFACE CRIADA, ELA DEVE EXTENDER A CLASSE UNICASTREMOTEOBJECT (CLASSE RESPONSÁVEL PELOS PROCESSOS DE REDE, E/S, SOCKETS, ETC)

    public MyRemoteImpl() throws RemoteException{} //COMO O CONSTRUTOR DA SUPERCLASSE UNICASTREMOTEOBJECT LANÇA UMA EXCEÇÃO, DEVE-SE DECLARAR ESSA EXCEÇÃO NO CONSTRUTOR DA SUBCLASSE
    
    public String exibir_msg(){ //MÉTODO IMPLEMENTADO DA INTERFACE MYREMOTE
        return "mensagem de teste";
    }   
    
    public static void main(String[] args) {
        try{
            Metodos_Remotos mr = new MyRemoteImpl(); //AQUI É CRIADO O SERVIÇO REMOTO INSTANCIANDO A INTERFACE METODOS_REMOTOS E PASSANDO A CLASSE QUE A IMPLEMENTE COMO REFERÊNCIA PARA A VARIÁVEL DE REFERÊNCIA
            Naming.bind("rmi://localhost/RemoteService", mr); //AQUI É FEITO O REGISTRO DO SERVIÇO REMOTO
        } catch(Exception ex){ex.printStackTrace();}        
    }
}

interface Metodos_Remotos extends Remote{ //DEVE-SE CRIAR UMA INTERFACE QUE CONTERÁ TODOS OS MÉTODOS QUE PODERÁ SER CHAMADO PELO CLIENTE, E ESSE INTERFACE DEVE EXTENDER OUTRA INTERFACE: REMOTE
    public String exibir_msg() throws RemoteException; //TODOS OS MÉTODOS DA INTERFACE DEVEM DECLARAR UMA REMOTE EXCEPTION
}



/* Criado o servidor, deve-se compilar este arquivo de código-fonte: java MyRemoteImpl.java.
 * Logo após, deve-se registrar a classe que implementa a interface remota utilizando o comando rmic: rmic MyRemoteImpl.
 * Aqui, é criado o arquivo Stub, ou seja, o auxiliar do cliente.
 * Agora, deve-se iniciar o servidor remoto executando a classe que implementa a interface remota: java MyRemoteImpl.
 * Após isso, deve-se iniciar o registro do rmi: rmiregistry.
 * Depois, em outra janela do dos e com todos os arquivos no mesmo diretório, deve-se executar a classe principal do cliente, onde é chamado os métodos remotos: java MyRemoteClient
 */
