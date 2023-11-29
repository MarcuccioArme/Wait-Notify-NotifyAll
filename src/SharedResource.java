public class SharedResource {

    private boolean isResourceAvailabe = false;

    public synchronized void useResource() {

        while (!isResourceAvailabe) {

            try {
                wait(); //Il Thread attende finchè la risorsa non è disponibile.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //Utilizzo della risorsa
        System.out.println("Risorsa utilizzata.");
        isResourceAvailabe = false;
        notify();
        //Notifica gli altri thread in attesa che la risorsa è stata utilizzata.

    }

    public synchronized void provideResource() {

        //Produzione della risorsa.
        System.out.println("Risorsa pronta.");
        isResourceAvailabe = true;
        notify();
        //Notifica agli altri thread in attesa che la risorsa è pronta.

    }

}
