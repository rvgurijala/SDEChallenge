package com.paytm.statistics;


import java.util.List;

/**
 * The root interface for Moving Average. It stores element and provides moving average
 *
 * @param <T> the type of elements in this collection
 */
public interface IMovingAverage<T> {
    /**
     * It adds value to elements and update the total
     *
     * @param value Elements to store
     */
    void addValue(T value);

    /**
     * It provides moving average result
     *
     * @return Return average result
     */
    T getAverage();

    /**
     * reset the average and container
     */
    void reset();

    /**
     * It provides all elements
     *
     * @return Returns all elements added so far
     */
    List<T> getAllElements();

    /**
     * It provides element that added before by using index
     *
     * @param index index of element added before
     * @return Returns element
     */
    T getElement(int index);
}
