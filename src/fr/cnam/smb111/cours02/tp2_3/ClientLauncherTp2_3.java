package fr.cnam.smb111.cours02.tp2_3;


public class ClientLauncherTp2_3 {

    private static final Thread counterThread= new Thread(new CounterClient(ServerParametersTp2_3.SERVER_PORT_NUMBER));

    //put constructor to avoid invocking it
    private ClientLauncherTp2_3(){}

    public static void start(){
       counterThread.start();
    }
}