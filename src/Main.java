public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> { sharedResource.useResource(); });
        Thread thread2 = new Thread(() -> { sharedResource.provideResource(); });

        thread1.start();
        thread2.start();

    }
}