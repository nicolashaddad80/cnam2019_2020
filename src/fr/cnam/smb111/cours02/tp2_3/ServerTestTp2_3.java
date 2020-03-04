package fr.cnam.smb111.cours02.tp2_3;


public class ServerTestTp2_3 {

    public static void main(String[] args) {
        if (DebugTp2_3.SERVER_TRACE_ON) System.out.println("Creating Server Daemon");
        Thread serverDaemon = new Thread(new CounterServer(ServerParametersTp2_3.SERVER_PORT_NUMBER));
        serverDaemon.setDaemon(true);
        if (DebugTp2_3.SERVER_TRACE_ON) System.out.println("Starting Server Daemon......");
        serverDaemon.start();
        if (DebugTp2_3.SERVER_TRACE_ON) System.out.println("Server Daemon started");
        System.out.println("Server is running Press CTRL+C To Exit");
        while (true) ;
    }
}
