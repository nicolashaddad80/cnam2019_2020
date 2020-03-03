package fr.cnam.smb111.cours02.tp2;

public class ServerTest {

    public static void main(String[] args) {
        if(Debug.SERVER_TRACE_ON) System.out.println("Creating Server Daemon");
        Thread serverDaemon = new Thread(new Server(ServerParameters.SERVER_PORT_NUMBER));
        //serverDaemon.setDaemon(true);
        if(Debug.SERVER_TRACE_ON) System.out.println("Starting Server Daemon......");
        serverDaemon.start();
        if(Debug.SERVER_TRACE_ON) System.out.println("Server Daemon started");
        System.out.println("Server is running Press CTRL+C To Exit");
        while(true);
    }
}
