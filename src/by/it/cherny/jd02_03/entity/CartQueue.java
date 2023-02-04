package by.it.cherny.jd02_03.entity;

public class CartQueue {
    private volatile int queue = 0;

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public synchronized void addOne(Customer customer){
        this.queue++;
        System.err.println("   "+ customer +" add One         "+queue);
    }
    public synchronized void removeOne(Customer customer){
        this.queue--;
        System.err.println("   "+ customer +"  Remove one         "+queue);
    }
}
