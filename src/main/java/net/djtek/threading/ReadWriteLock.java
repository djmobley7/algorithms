package net.djtek.threading;

public class ReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    /**
     * Lock for reading.  All theads gets read access unless there is a thread with write access or
     * one or more threads have requested write access
     * @throws InterruptedException
     */
    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0){
            // make current thread wait until another thread calls notify for this object
            wait();
        }
        ++readers;
    }

    /**
     * Unlock for reading.
     */
    public synchronized void unlockRead(){
        --readers;
        notifyAll();
    }

    /**
     * Lock for writing.  Writer threads request access waiting for any existing reader/writer threads to
     * complete.
     * @throws InterruptedException
     */
    public synchronized void lockWrite() throws InterruptedException {
        ++writeRequests;

        while (readers > 0 || writers > 0){
            wait();
        }

        --writeRequests;
        ++writers;
    }

    /**
     * Unlock for writing.
     * @throws InterruptedException
     */
    public synchronized void unlockWrite() throws InterruptedException {
        --writers;
        notifyAll();
    }
}
