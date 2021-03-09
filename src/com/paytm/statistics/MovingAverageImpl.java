package com.paytm.statistics;

import java.util.ArrayList;
import java.util.List;

/**
 * It provides moving average for Double type values
 * It implements IMovingAverage. it is not thread safe.
 */
public class MovingAverageImpl implements IMovingAverage<Double> {

    /**
     * It represent size of last N elements
     */
    private int window;

    /**
     * It contains all elements
     */
    private List<Double> elements;

    /**
     * It maintains sum of added elements in list so far
     */
    private double sum;

    /**
     * It initialises/assigns window size, container and sum
     *
     * @param window size of last N elements
     */
    MovingAverageImpl(int window) {
        if(window <= 0) {
          throw new IllegalArgumentException("Window size should be more than zero");
        }
        this.window = window;
        this.elements = new ArrayList<>();
        this.sum = 0.0;
    }

    /**
     * It adds value to elements and update the total
     *
     * @param value Elements to store
     */
    @Override
    public void addValue(Double value) {
        if(value == null) {
            throw new IllegalArgumentException("Value shouldn't be null");
        }
        sum += value;
        elements.add(value);

        if (elements.size() > window) {
            sum -= elements.get(elements.size() - window - 1);
        }
    }

    /**
     * It provides moving average result
     *
     * @return Return average result
     */
    @Override
    public Double getAverage() {
        if(elements.size() >= window) {
            return sum / window;
        } else {
            return sum/elements.size();
        }
    }

    /**
     * reset the average and container
     */
    @Override
    public void reset() {
        this.elements.clear();
        this.sum = 0.0;
    }

    /**
     * It provides all elements
     *
     * @return Returns all elements added so far
     */
    @Override
    public List<Double> getAllElements() {
        return elements;
    }

    /**
     * It provides element that added before by using index
     *
     * @param index index of element added before
     * @return Returns element
     */
    @Override
    public Double getElement(int index) {
        return elements.get(index);
    }

}
