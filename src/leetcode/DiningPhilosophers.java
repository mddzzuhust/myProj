import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    int num = 5;
    private Semaphore[] semaphores = new Semaphore[5];
    public DiningPhilosophers() {
        for (int i = 0; i < num; i++) {
            semaphores[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher+1)%num;

        while (true){
            if(semaphores[left].tryAcquire()){
                if(semaphores[right].tryAcquire()){
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    semaphores[left].release();
                    putRightFork.run();
                    semaphores[right].release();
                    break;
                }else {
                    semaphores[left].release();
                    Thread.yield();
                }
            }else {
                Thread.yield();
            }
        }
    }
}
