package fr.cnam.smb111.mytrainings.threads;

class TestShutdown1 extends Thread {
    public static void main(String[] args) throws Exception {

        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new TestShutdown1());

        System.out.println("Now main sleeping... press ctrl+c to exit and wait until system stop");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
    }

    public void run() {
        System.out.println("shut down hook task completed..");
    }
}