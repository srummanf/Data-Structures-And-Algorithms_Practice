#### What is functional programming in JS?

Functional programming in JavaScript, in simple words, means writing your code in a way that treats everything as small, reusable building blocks (functions) and avoids changing or messing with data whenever possible. It's like playing with LEGO bricks, where you snap pieces together to create something without breaking or changing the bricks themselves. This approach makes your code easier to understand, test, and maintain.

EG: ReactJS and NextJS often encourage functional programming concepts. Components are typically designed as pure functions that take inputs and return a UI based on those inputs.

#### What is the role of a callback function?

A callback function in JavaScript is a function that is passed as an argument to another function and is typically executed after the completion of that function. The role of a callback function is to provide a way to perform actions or handle data once a specific operation has finished. Here's how it relates to your profile:

EG: In JavaScript and frameworks like ReactJS, callback functions are commonly used for handling events, asynchronous operations, or responding to user interactions. For example, you might use a callback to update the UI after data is loaded from a server.

#### What is event loop?

The event loop is a fundamental concept in JavaScript and many other programming languages. It's responsible for managing how asynchronous operations are handled in a single-threaded environment. Here's a concise explanation of the event loop:

The event loop is like a traffic cop for your JavaScript code. It ensures that tasks (such as handling user input, making network requests, or running timers) are executed in the right order and at the right time. It constantly checks a queue of tasks and processes them one by one, allowing your code to be non-blocking and responsive, even when dealing with potentially time-consuming operations. This makes JavaScript suitable for tasks like web development, where it needs to respond quickly to user interactions and perform various tasks simultaneously, despite being single-threaded.

#### What is singleton function?

The Singleton pattern is a design pattern in software engineering. It ensures that a class has only one instance and provides a global point of access to that instance. Here's how it works:

1. **Single Instance:** The Singleton pattern ensures that a class has only one instance created during the application's lifecycle.
2. **Global Access:** This single instance is accessible globally from anywhere in your code. You can access it through a well-defined method or property.
3. **Lazy Initialization:** The instance is often created only when it's first needed, a concept known as lazy initialization. This means that resources are not wasted on creating the object if it's not used.

The Singleton pattern is often used for scenarios where you want to control access to resources or coordinate actions across an application, like managing a configuration, database connections and such other
