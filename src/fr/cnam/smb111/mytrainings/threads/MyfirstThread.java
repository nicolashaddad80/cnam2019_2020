package fr.cnam.smb111.mytrainings.threads;
class MyfirstThread extends Thread{
    @Override
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String args[]){
        MyfirstThread t1=new MyfirstThread();
        t1.start();
    }
}

