## What is functional programming in JS?

Functional programming in JavaScript, in simple words, means writing your code in a way that treats everything as small, reusable building blocks (functions) and avoids changing or messing with data whenever possible. It's like playing with LEGO bricks, where you snap pieces together to create something without breaking or changing the bricks themselves. This approach makes your code easier to understand, test, and maintain.

EG: ReactJS and NextJS often encourage functional programming concepts. Components are typically designed as pure functions that take inputs and return a UI based on those inputs.

## What is the role of a callback function?

A callback function in JavaScript is a function that is passed as an argument to another function and is typically executed after the completion of that function. The role of a callback function is to provide a way to perform actions or handle data once a specific operation has finished. Here's how it relates to your profile:

EG: In JavaScript and frameworks like ReactJS, callback functions are commonly used for handling events, asynchronous operations, or responding to user interactions. For example, you might use a callback to update the UI after data is loaded from a server.

## What is event loop?

The event loop is a fundamental concept in JavaScript and many other programming languages. It's responsible for managing how asynchronous operations are handled in a single-threaded environment. Here's a concise explanation of the event loop:

The event loop is like a traffic cop for your JavaScript code. It ensures that tasks (such as handling user input, making network requests, or running timers) are executed in the right order and at the right time. It constantly checks a queue of tasks and processes them one by one, allowing your code to be non-blocking and responsive, even when dealing with potentially time-consuming operations. This makes JavaScript suitable for tasks like web development, where it needs to respond quickly to user interactions and perform various tasks simultaneously, despite being single-threaded.

## What is singleton function?

The Singleton pattern is a design pattern in software engineering. It ensures that a class has only one instance and provides a global point of access to that instance. Here's how it works:

1. **Single Instance:** The Singleton pattern ensures that a class has only one instance created during the application's lifecycle.
2. **Global Access:** This single instance is accessible globally from anywhere in your code. You can access it through a well-defined method or property.
3. **Lazy Initialization:** The instance is often created only when it's first needed, a concept known as lazy initialization. This means that resources are not wasted on creating the object if it's not used.

The Singleton pattern is often used for scenarios where you want to control access to resources or coordinate actions across an application, like managing a configuration, database connections and such other

## What do you understand about RDBMS?

A Relational Database Management System (RDBMS) is a type of database management system that organizes and manages data in a structured manner using a relational model. It follows structured data, SQL, ACID properties and data integrity.

## What is Node.js? List its major uses

Node.js is an open-source, server-side runtime environment that allows developers to run JavaScript code on the server. It's built on the V8 JavaScript engine, and it's known for its non-blocking, event-driven architecture. Used to build web servers, API servers, microservices and such other.

## State important SQL functions and their uses.

SQL (Structured Query Language) provides a variety of functions that you can use to perform operations on data in relational databases. Here are some important SQL functions and their common uses:

1. **SELECT:** The `SELECT` statement is used to retrieve data from a database table. You can specify the columns you want to retrieve, filter the data, and sort the results using `ORDER BY`.
2. **COUNT:** The `COUNT` function counts the number of rows that match a specified condition. It's often used to get the count of records in a table or to count the occurrences of a specific value.
3. **SUM:** The `SUM` function calculates the sum of values in a numeric column. It's useful for obtaining the total of a particular column, such as calculating the total revenue.
4. **AVG:** The `AVG` function calculates the average of values in a numeric column. It's commonly used to find the average of values, like the average age of users.
5. **MAX and MIN:** The `MAX` function returns the maximum value in a column, while the `MIN` function returns the minimum value. They are used to find the highest and lowest values in a column.
6. **GROUP BY:** The `GROUP BY` clause is used to group rows based on the values in one or more columns. This is often used with aggregate functions like `COUNT`, `SUM`, or `AVG` to create summary reports.
7. **WHERE:** The `WHERE` clause is used to filter rows based on a specified condition. It's used with `SELECT` to retrieve rows that meet specific criteria.
8. **LIKE:** The `LIKE` operator is used to search for a specified pattern in a column. It's helpful for searching text values using wildcard characters (% and _).
9. **DISTINCT:** The `DISTINCT` keyword is used to retrieve unique values in a column, eliminating duplicate entries.
10. **JOIN:** SQL supports different types of joins (INNER, LEFT, RIGHT, FULL) to combine data from multiple tables based on a related column. This is essential for querying data from multiple tables.
11. **SUBSTRING:** The `SUBSTRING` function extracts a portion of a string column. It's useful for manipulating and extracting substrings from text data.
12. **DATE and TIME Functions:** SQL provides functions for working with date and time data, including `DATE`, `TIME`, and `TIMESTAMP`. Common functions include `DATE_FORMAT`, `DATEADD`, and `DATEDIFF`.
13. **CASE:** The `CASE` statement allows conditional logic in SQL queries. It's used to create conditional expressions and return different values based on specified conditions.
14. **COALESCE:** The `COALESCE` function returns the first non-null value from a list of expressions. It's helpful for handling missing or null data.

These are some of the essential SQL functions and clauses used for data retrieval, aggregation, filtering, and manipulation in relational databases. The specific SQL functions you use will depend on the requirements of your queries and the database system you're working with.

## What is Hadoop?

Hadoop is an open-source framework for distributed storage and processing of large datasets. It's designed to handle big data efficiently. Here are the key features of Hadoop:

1. **Distributed Storage:** Hadoop distributes data across a cluster of commodity hardware, which provides fault tolerance and high availability. Data is stored redundantly to prevent data loss.
2. **Distributed Processing:** Hadoop allows the distributed processing of data across the cluster. It's based on the MapReduce programming model, which enables parallel processing of large datasets.
3. **Scalability:** Hadoop is highly scalable. You can add more nodes to the cluster to increase storage and processing capacity, making it suitable for handling ever-growing datasets.
4. **Fault Tolerance:** Hadoop is designed to be fault-tolerant. If a node fails, the system automatically redirects the work to other available nodes. This ensures data integrity and system reliability.
5. **Data Locality:** Hadoop optimizes data processing by moving computation closer to the data, rather than the other way around. This reduces network congestion and speeds up data processing.

## Differentiate between Node.js events and callbacks.

* Events are used for creating event-driven architectures and handling multiple asynchronous events simultaneously. They are suitable for scenarios where multiple parts of your application need to respond to events triggered by various components.
* Callbacks are primarily used for handling the results of asynchronous operations and managing the flow of code execution. They are executed when an asynchronous task is completed, allowing you to work with the data or handle errors.

## Explain the role of the debugger keywords in JavaScript.

In JavaScript, the `debugger` keyword is used to control and inspect the execution of your code during debugging. It plays a crucial role in helping developers identify and fix issues in their JavaScript applications.
