package fr.cnam.smb111.cours02.tp2;

public class ClientTest {
    public static void main(String[] args) {

        new Thread(new Client(ClientParameters.UP)).start();
        new Thread(new Client(ClientParameters.UP)).start();
        new Thread(new Client(ClientParameters.DOWN)).start();
    }

}
