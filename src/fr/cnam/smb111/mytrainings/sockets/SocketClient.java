package fr.cnam.smb111.mytrainings.sockets;

import java.io.DataOutputStream;
import java.net.Socket;

public class SocketClient {
    //private final static String ServerName="nicolas-haddad.hd.free.fr";
    private final static String ServerName = "localhost";

    public static void main(String[] args) {

        try {
            Socket s = new Socket(ServerName, 2000);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            for (int messageNum = 0; messageNum < 100; messageNum++) {
                StringBuilder message = new StringBuilder();
                message.append("Client01 Message: ").append(messageNum);
                dout.writeUTF(message.toString());
                dout.flush();
            }
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
