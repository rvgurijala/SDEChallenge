### Paytm Analytics Design
We have tracking ids in websites and that will be sent along with customer and web page information to Paytm servers when users perform the actions.
We use that data for analysis and reports.

Please have a look at architecture diagram [`paytm_analytics.png`](paytm_analytics.png)

### Browsers/Mobile Apps
Analytics APIs will be triggered from here and when users perform actions. Paytm analytics get billions of API hits every day.

### Load Balancer 1
It is the first point of contact to the analytics system and it routes the traffic among multiple API gateway instances.
There are many powerful load balancers are there in the market such as Amazon ELB, HAProxy ect.

### API Gateways 2
It will receive hits from load balancer and perform many operations such as authenticating, rate limiting and traffic routing to among
microservice instances.

### Spring Boot MicroServices 1
These servers take requests from API gateways and store data into MongoDBs. As well as these services has logic to produce different kafka events
and send those to kafka clusters.

### MongoDBs
It will maintain raw data which we get from customer websites. Data Model is not structural that's why NoSQL DB is good for
storing the data. And also, these are highly scalable, we can store TBs of data. We can move this data to historical data warehouses when data becomes old.

### Apache Kafka
It is one of powerful open source messaging brokers and it can persist the event for a long time also. It is highly scalable and reliable.
We can maintain multiple data replicas.

### Apache Spark
It is very famous for processing the data streams. It is too fast because it does process the data in-memory.
It generates time series data and stores it into Cassandra.

### Apache Cassandra
It is a very powerful database to store huge volumes of data and it is very scalable.
It is good store time series data in Cassandra. We can move old data to the data warehouse.

### Spring Boot MicroServices 2
It will query the Cassandra database and load the queried data to Redis for fast access for the same query next time.

### Redis cache
It will maintain frequently using data so microservies won't go to the database for fetching the data. It decreases many query calls.

### Load Balancer 1
It will receive requests from the analytics dashboard and route traffic to API Gateways 2.

### API Gateways 2
It will receive hits from load balancer and perform operations such as authenticating, rate limiting and traffic routing to among
microservice2 instances.

### Analytics Dashboard
It will represent data in graphically for end users.
We can use ReactJs javascript framework in the front end.



### Requirements

1. Handle large write volume: Billions of write events per day.
  We will maintain hundreds of API gateway instances and Microservice instances all over the world to service requests.
  Great infrastructure and multiple data centers enable us to serve billions of requests per day.

2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
  We have Spring boot microservice to do this. And Redis will cache frequently using data so read queries are very fast.
  We will maintain hundreds of Redis clusters to store more data and make it perform well.

3. Provide metrics to customers with at most one hour delay.
  Time consuming part is data processing at Spark so we should concentrate more here.

  Fast service depends on how fast we are processing the data. Spark clusters run operations parallelly and it is so fast.
  So until unless our Spark processing is fast enough we can provide metrics to customers with at most one hour delay.

4. Run with minimum downtime
  We maintain multiple data centers all over the world in cloud so application is available if we have downtime at one data center.
  We deploy our application by using Kubernetes so it enables easy deploy and restart applications with minimum downtime.
  And also, it is very easy to scale up and scale down our application.

5. Have the ability to reprocess historical data in case of bugs in the processing logic.
  If any exceptions while processing data in Spark. We have strategies to reprocess the same data by using fetch Kafka offsets.
  If Kafka offset is not there Spark should be capable of fetching data MongoDBs.
  Many frameworks like Akka Streams can handle this situation.





















