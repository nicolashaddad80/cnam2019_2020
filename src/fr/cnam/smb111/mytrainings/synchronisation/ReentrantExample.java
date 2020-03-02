package fr.cnam.smb111.mytrainings.synchronisation;

public class ReentrantExample{
    private static Reentrant re= new Reentrant();;

    public static void main(String args[]){


        Thread t1=new Thread(){
            public void run(){
                re.m();//calling method of Reentrant class

        }
        };
        t1.start();
    }


}
