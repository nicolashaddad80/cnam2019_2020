package fr.cnam.smb111.mytrainings.sockets;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(2000);
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            /*for(int i=0;i<100;i++) */ while (true){
                String str = (String) dis.readUTF();
                System.out.println("message= " + str);
            }
            /*ss.close();*/
        }catch(Exception e){System.out.println(e);}
    }
}
