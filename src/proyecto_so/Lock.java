package proyecto_so;



/**
 *
 * @author Maru
 */
public class Lock {
    
	protected boolean locked;

	public Lock(){
            locked=false;
	}

	public synchronized void Lock (String nombre_hilo) throws InterruptedException {
                while(locked) {
                    System.out.println("bloqueo para el "+ nombre_hilo);
                    wait();
                }
                locked=true;
            }

	public synchronized void unlock(){
		locked=false;
		notifyAll();
	}

}
