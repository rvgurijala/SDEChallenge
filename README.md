# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.


## Coding Question Documentation

# Interface IMovingAverage

It represents the moving average. It has 5 methods addValue, getAverage, reset, getAllElements and getElement. Generic type
allows you to decide the data type while implementing.

# class MovingAverageImpl

It implements the interface IMovingAverage and provides main logic. I am using ArrayList for storing the elements and I am not
removing elements even after reaching the window size. It maybe useful later. However, it may cause to out of memory exception
but I am assuming we have less data set for now. 
I use a sum variable to store the total of last N elements. 
I can reset list and sum by using reset method. 
I have a getElements method for retrieving all elements and a getElement method for retrieving an element by using index.

Average logic:
If elements size is less than window size, I will use list size for dividing the sum.
If elements size is greater than window size, I will use window size for dividing the sum.

It is not thread safe.

# class SynchronizedMovingAverageImpl

It works like MovingAverageImpl but all methods are synchronized.

It is thread safe


# Design document 

Please have a look at [`DESIGN.md`](DESIGN.md) for the analytics design.



 