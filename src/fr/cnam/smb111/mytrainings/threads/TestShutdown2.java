package fr.cnam.smb111.mytrainings.threads;

public class TestShutdown2{
    public static void main(String[] args)throws Exception {

        Runtime r=Runtime.getRuntime();

        r.addShutdownHook(new Thread(){
                              public void run(){
                                  System.out.println("shut down hook task completed..");
                              }
                          }
        );

        System.out.println("Now main sleeping... press ctrl+c to exit and wait until system stop");
        try{Thread.sleep(5000);}catch (Exception e) {}
    }
}
