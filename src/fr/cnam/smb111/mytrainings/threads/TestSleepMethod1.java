package fr.cnam.smb111.mytrainings.threads;

class TestSleepMethod1 extends Thread{
    @Override
    public void run(){
        for(int i=1;i<5;i++){
            try{Thread.sleep(1000);}catch(InterruptedException e){System.out.println(e);}
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        TestSleepMethod1 t1=new TestSleepMethod1();
        TestSleepMethod1 t2=new TestSleepMethod1();

        t1.start();
        t2.start();
    }
}