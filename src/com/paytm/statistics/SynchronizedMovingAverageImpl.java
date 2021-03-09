package com.paytm.statistics;

import java.util.List;

/**
 * It provides moving average for Double type values
 * It implements IMovingAverage. it is thread safe.
 */
public class SynchronizedMovingAverageImpl extends MovingAverageImpl {

    /**
     * It initialises/assigns window size, container and sum
     *
     * @param window size of last N elements
     */
    SynchronizedMovingAverageImpl(int window) {
        super(window);
    }

    /**
     * It adds value to elements and update the total
     *
     * @param value Elements to store
     */
    @Override
    public synchronized void addValue(Double value) {
          super.addValue(value);
    }

    /**
     * It provides moving average result
     *
     * @return Return average result
     */
    @Override
    public synchronized Double getAverage() {
         return super.getAverage();
    }

    /**
     * reset the average and container
     */
    @Override
    public synchronized void reset() {
        super.reset();
    }

    /**
     * It provides all elements
     *
     * @return Returns all elements added so far
     */
    @Override
    public synchronized List<Double> getAllElements() {
        return super.getAllElements();
    }

    /**
     * It provides element that added before by using index
     *
     * @param index index of element added before
     * @return Returns element
     */
    @Override
    public synchronized Double getElement(int index) {
        return super.getElement (index);
    }

}
