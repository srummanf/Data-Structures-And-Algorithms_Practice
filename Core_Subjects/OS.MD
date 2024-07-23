### 1. **Introduction to Operating Systems**

- **Definition**: An OS is software that manages computer hardware and software resources and provides common services for computer programs.
- **Functions**: Process management, memory management, file system management, device management, and security.

### 2. **Types of Operating Systems**

- **Batch Operating System**: Processes batches of jobs without user interaction.
- **Time-Sharing Operating System**: Allows multiple users to use the system interactively at the same time.
- **Distributed Operating System**: Manages a group of independent computers and makes them appear as a single computer.
- **Real-Time Operating System**: Provides immediate processing and response.

### 3. **Process Management**

- **Process**: A program in execution, consisting of program code, current activity, and associated resources.
- **Process States**: New, Running, Waiting, Ready, Terminated.
- **Process Control Block (PCB)**: Contains process-specific information such as process state, program counter, CPU registers, memory management information, and I/O status.

### 4. **Threads and Concurrency**

- **Thread**: The smallest sequence of programmed instructions that can be managed independently by a scheduler.
- **Multithreading**: Allows concurrent execution of two or more threads for maximum utilization of CPU.
- **Concurrency Issues**: Race conditions, deadlock, and starvation.

### 5. **CPU Scheduling**

- **Scheduling Algorithms**: First-Come, First-Served (FCFS), Shortest Job Next (SJN), Priority Scheduling, Round Robin (RR), Multilevel Queue Scheduling.
- **Criteria**: CPU utilization, throughput, turnaround time, waiting time, response time.

### 6. **Memory Management**

- **Types of Memory**: Primary (RAM), Secondary (Hard disk), Cache.
- **Memory Allocation**: Contiguous (fixed and variable partitions), Non-contiguous (paging, segmentation).
- **Virtual Memory**: Uses hardware and software to enable a computer to compensate for physical memory shortages by temporarily transferring data from RAM to disk storage.

### 7. **File Systems**

- **File Types**: Regular files, directories, character special files, block special files.
- **File Attributes**: Name, identifier, type, location, size, protection, time, date, and user identification.
- **Directory Structure**: Single-level, two-level, tree-structured, acyclic-graph, general graph.

### 8. **I/O Systems**

- **I/O Hardware**: Devices like keyboards, mice, disks, etc.
- **I/O Software**: Device drivers, interrupt handlers, and I/O control methods.
- **Buffering**: Temporary storage for data to accommodate speed differences between producers and consumers.

### 9. **Security and Protection**

- **Security**: Protects the system from external threats (viruses, worms).
- **Protection**: Ensures that all access to system resources is controlled.
- **Mechanisms**: Authentication, authorization, encryption.

### 10. **Deadlocks**

- **Conditions**: Mutual exclusion, hold and wait, no preemption, circular wait.
- **Handling**: Deadlock prevention, avoidance (Banker's algorithm), detection, recovery.

Do you have specific topics or concepts you want to dive deeper into or need help with specific questions or coding examples related to OS?

# Chapter 1

## Operating Systems Interview Revision Notes

### What is an Operating System (OS)?

- **Intermediary**: Acts as an intermediary between the user and hardware.
- **Resource Manager/Allocator**: Controls and coordinates the use of system resources among various application programs in an unbiased fashion.
- **Platform**: Provides a platform for other application programs to be installed and executed.

### Goals and Functions of an OS

- **Primary Goals**: Convenience / User-friendly.
- **Secondary Goals**: Efficiency, Reliability, Maintainability.

#### Functions of an OS

- **Process Management**: Handles the creation, scheduling, and termination of processes.
- **Memory Management**: Manages allocation and deallocation of physical and virtual memory.
- **I/O Device Management**: Manages I/O operations of peripheral devices, including buffering and caching.
- **File Management**: Manages files on storage devices, including their information, naming, permissions, and hierarchy.
- **Network Management**: Manages network protocols and functions.
- **Security & Protection**: Ensures system protection against unauthorized access and other security threats.

### Major Components of an OS

- **Kernel**: Central component managing system resources.
- **Process Management**:
  - **Process Scheduler**: Determines process execution.
  - **Process Control Block (PCB)**: Contains process details like ID, priority, status.
- **Memory Management**:
  - **Physical Memory Management**: Manages RAM.
  - **Virtual Memory Management**: Simulates additional memory using disk space.
- **File System Management**:
  - **File Handling**: Manages file creation, deletion, and access.
  - **File Control Block**: Stores file attributes and control information.
- **Device Management**:
  - **Device Drivers**: Interface between hardware and OS.
  - **I/O Controllers**: Manage data transfer.
- **Security and Access Control**:
  - **Authentication**: Verifies user credentials.
  - **Authorization**: Controls access permissions.
  - **Encryption**: Ensures data confidentiality.
- **User Interface**:
  - **Command Line Interface (CLI)**: Text-based interaction.
  - **Graphical User Interface (GUI)**: Visual interaction.
- **Networking**:
  - **Network Protocols**: Rules for device communication.
  - **Network Interface**: Manages network connections.

### Types of Operating Systems

#### Batch Operating System

- **Early Computers**: Users prepared jobs consisting of a program, control information, and input data.
- **Job Processing**: Only one job was processed at a time, often using punch cards or tape drives.
- **Batch Processing**: Similar jobs were grouped and run as a batch to speed up processing.

#### Spooling

- **Simultaneous Peripheral Operations Online**: Temporarily holds data in memory for later use by a device.
- **Example**: Printer spooling stores print jobs in memory until the printer is ready.

#### Multiprogramming Operating System

- **Multiple Jobs**: Keeps several jobs in memory, enhancing CPU utilization.
- **Job Execution**: OS switches to another job if the current one needs to wait.

| Advantage            | Disadvantage              |
| -------------------- | ------------------------- |
| High CPU Utilization | Complex Scheduling        |
| Less Waiting Time    | Complex Memory Management |
| Multi-Task Handling  |                           |
| Shared CPU Time      |                           |

#### Multitasking Operating System

- **Time Sharing**: Allows multiple users to share the computer simultaneously.
- **Example**: Playing music, editing documents, and surfing the web concurrently.

#### Multiprocessing Operating System

- **Multiple CPUs**: Utilizes two or more CPUs within a single computer system.
- **Parallel Execution**: Achieves true parallel execution of processes.

| Point           | Symmetric Processing               | Asymmetric Processing            |
| --------------- | ---------------------------------- | -------------------------------- |
| Task Allocation | Any processor can perform any task | Tasks divided by processor roles |
| Complexity      | Simpler                            | More complex                     |
| Scalability     | Easily scalable                    | May require reconfiguration      |
| Performance     | Load evenly distributed            | Varies based on specialization   |

| Point                 | Multi-Programming                 | Multi-Processing                 |
| --------------------- | --------------------------------- | -------------------------------- |
| Definition            | Allows multiple programs on a CPU | Utilizes multiple CPUs           |
| Concurrency           | Simulates concurrent execution    | Achieves true parallel execution |
| Resource Utilization  | Maximizes CPU utilization         | Enhances performance             |
| Hardware Requirements | Requires one CPU                  | Requires multiple CPUs           |
| Complexity            | Less complex                      | More complex                     |

#### Real-Time Operating System

- **Definition**: Special purpose OS with fixed time constraints.
- **Example**: Petroleum refinery, Airlines reservation system.

| Point                | Hard Real-Time OS          | Soft Real-Time OS               |
| -------------------- | -------------------------- | ------------------------------- |
| Deadline Constraints | Must meet strict deadlines | Can miss deadlines occasionally |
| Response Time        | Fixed and guaranteed       | Predictable but not guaranteed  |
| Applications         | Life-critical systems      | Multimedia, user interfaces     |
| Complexity and Cost  | More complex and costlier  | Less complex and less expensive |
| Reliability          | Must be highly reliable    | High reliability desired        |

#### Distributed OS

- **Definition**: Software over a collection of independent, networked nodes.
- **Communication**: Nodes communicate through networks like high-speed buses or the Internet.

### Structure of Operating System

#### Simple Structure

- **Example**: MS-DOS
- **Characteristics**: Not divided into modules; interface, levels, and functionality not well separated.

#### Layered Approach

- **Definition**: OS broken into layers with defined inputs, outputs, and functions.
- **Advantages**:
  - Modular design allows easier updates and maintenance.
  - Information hiding provides implementation freedom.
  - Top-down approach separates overall functionality into components.

#### Micro-Kernel Approach

- **Definition**: OS modularized by removing nonessential components from the kernel.
- **Advantages**: Easier to extend the OS, fewer modifications needed.

### User and Operating-System Interface

#### Command-Line Interface (CLI)

- **Description**: Text-based interaction.
- **Examples**: UNIX shells (Bourne, C, Korn).

#### Graphical User Interface (GUI)

- **Description**: Visual interaction using icons and menus.
- **Examples**: Desktops on Windows, macOS, Linux.

#### Mobile Interfaces

- **Description**: Touchscreen interfaces using gestures.

### Conclusion

- **Choice of Interface**: Personal preference; CLI for system administrators, GUI for general users.

# Chapter 2 : System Calls and Process Management

## System Calls

- **Definition**: System calls provide the means for a user program to ask the operating system to perform tasks reserved for the OS on the user program’s behalf. They provide an interface to the services made available by the OS, typically available as routines written in C and C++.
- **API**: Specifies a set of functions available to an application programmer, including the parameters passed to each function and the return values.

### Types of System Calls

1. **Process Control**

   - end, abort
   - load, execute
   - create process, terminate process
   - get process attributes, set process attributes
   - wait for time
   - wait event, signal event
   - allocate and free memory
2. **File Management**

   - create file, delete file
   - open, close
   - read, write, reposition
   - get file attributes, set file attributes
3. **Device Management**

   - request device, release device
   - read, write, reposition
   - get device attributes, set device attributes
   - logically attach or detach devices
4. **Information Maintenance**

   - get time or date, set time or date
   - get system data, set system data
   - get process, file, or device attributes
   - set process, file, or device attributes
5. **Communications**

   - create, delete communication connection
   - send, receive messages
   - transfer status information

## Modes of Operation

- **User Mode and Kernel Mode**: The system needs two separate modes of operation. The mode bit indicates the current mode: kernel (0) or user (1). User mode is for executing user applications, and kernel mode is for executing OS tasks.
- **Transition**: When a user application requests an OS service (via a system call), the system transitions from user mode to kernel mode.

## Processes

- **Definition**: A process is a program in execution. A program is a passive entity stored on disk (an executable file), while a process is an active entity that requires system resources like memory, CPU time, etc.
- **Sections of a Process**:
  - **Text Section**: Program code.
  - **Stack**: Contains temporary data (function parameters, return addresses, local variables).
  - **Data Section**: Contains global variables.
  - **Heap**: Memory dynamically allocated during process runtime.

### Process Control Block (PCB)

- **Definition**: Each process is represented by a PCB, containing information such as:
  - Process state (new, ready, running, waiting, halted)
  - Program counter
  - CPU registers
  - CPU-scheduling information
  - Memory-management information
  - Accounting information
  - I/O status information

## Process States

- **New**: The process is being created.
- **Running**: Instructions are being executed.
- **Waiting (Blocked)**: The process is waiting for some event to occur.
- **Ready**: The process is waiting to be assigned to a processor.
- **Terminated**: The process has finished execution.

## Schedulers

- **Long Term Scheduler (LTS)**: Controls the admission of new processes into the system, impacting overall system performance.
- **Medium Term Scheduler**: Swaps processes in and out of memory to manage CPU usage and memory allocation.
- **Short Term Scheduler (STS)**: Selects which ready process will execute next, impacting CPU utilization and response time.

### Dispatcher

- **Definition**: The dispatcher is the module that gives control of the CPU to the process selected by the short-term scheduler.
- **Functions**: Switching context, switching to user mode, jumping to the proper location in the user program to restart it.
- **Dispatch Latency**: The time taken by the dispatcher to stop one process and start another.

## Process Types

- **I/O Bound Processes**: Spend more time doing I/O operations than computations.
- **CPU Bound Processes**: Spend more time doing computations and generate I/O requests infrequently.

## Context Switch

- **Definition**: Switching the CPU to another process requires saving the current process's state and restoring the state of the new process. Context switch time is pure overhead as the system does no useful work while switching.

# Chapter 3 : CPU Scheduling

#### Overview

1. **CPU scheduling** is the process of determining which process in the ready queue is allocated to the CPU.
2. Various scheduling algorithms can be used to make this decision, such as First Come-First-Served (FCFS), Shortest Job Next (SJN), Priority, and Round Robin (RR).
3. Different algorithms support different classes of processes and favor different scheduling criteria.

#### Types of Scheduling

- **Non-Preemptive Scheduling**

  - Once the CPU is allocated to a process, the process keeps the CPU until it releases it willingly.
  - A process will leave the CPU only when it completes its execution (Termination state) or wants to perform some I/O operations (Blocked state).
- **Preemptive Scheduling**

  - A process can be interrupted and moved to the ready queue.
  - The CPU can be reallocated when a process completes its execution, leaves the CPU voluntarily, a new higher-priority process enters, or the running process's time quantum expires.

#### Comparison of Non-Preemptive and Preemptive Scheduling

| Feature                         | Non-Preemptive Scheduling                                             | Preemptive Scheduling                                            |
| ------------------------------- | --------------------------------------------------------------------- | ---------------------------------------------------------------- |
| **CPU Allocation**        | Once a process starts, it runs to completion or waits for some event. | A process can be interrupted and moved to the ready queue.       |
| **Response Time**         | Can be longer, especially for short tasks.                            | Generally shorter, as higher-priority tasks can preempt others.  |
| **Complexity**            | Simpler to implement.                                                 | More complex, requiring careful handling of shared resources.    |
| **Resource Utilization**  | May lead to inefficient CPU utilization.                              | Typically more efficient, as it can quickly switch tasks.        |
| **Suitable Applications** | Batch systems and applications that require predictable timing.       | Interactive and real-time systems requiring responsive behavior. |

#### Scheduling Criteria

- **CPU Utilization**: Keeping the CPU as busy as possible.
- **Throughput**: Number of processes completed per time unit.
- **Waiting Time**: Sum of the periods spent waiting in the ready queue.
- **Response Time**: Time it takes to start responding, not the time it takes to output the response.

#### Terminology

- **Arrival Time (AT)**: Time at which process enters a ready state.
- **Burst Time (BT)**: Amount of CPU time required by the process to finish its execution.
- **Completion Time (CT)**: Time at which process finishes its execution.
- **Turn Around Time (TAT)**: `Completion Time (CT) - Arrival Time (AT)`
- **Waiting Time (WT)**: `Turn Around Time (TAT) - Burst Time (BT)`

#### FCFS (First Come First Serve)

- The simplest scheduling algorithm.
- Processes are executed in the order they arrive in the ready queue.
- Non-preemptive.
- Implementation is managed by FIFO Queue.
- Suffers from the "Convoy Effect" where smaller processes wait for larger ones to complete, leading to higher average waiting time.
- Suitable for background processes where execution is not urgent.

#### Shortest Job First (SJF)

- Selects the process with the smallest burst time requirement.
- Can be non-preemptive or preemptive (Shortest Remaining Time First - SRTF).
- Non-preemptive SJF runs the process to completion once started.
- Preemptive SJF (SRTF) can interrupt a running process if a new process with a smaller burst time enters.
- SJF guarantees minimal average waiting time but can lead to starvation of longer processes.
- Preemptive version provides better response time compared to FCFS.

#### Priority Scheduling

- Each process is assigned a priority.
- CPU is allocated to the highest priority process.
- Can be non-preemptive or preemptive.
- Priority can lead to starvation of lower-priority processes.
- Aging is used to prevent starvation by gradually increasing the priority of processes waiting in the system for a long time.

#### Round Robin (RR)

- Designed for time-sharing systems.
- CPU time is divided among processes in the ready queue in equal fixed-size time quantum.
- Provides better average response time for time-sharing systems.
- Performance depends heavily on the time quantum size; too small leads to high context switching, too large leads to poor response time.

#### Multi-Level Queue Scheduling

- Ready queue is partitioned into several separate queues based on process characteristics.
- Each queue has its own scheduling algorithm.
- System processes might use priority scheduling, interactive processes might use RR, and batch processes might use FCFS.
- Scheduling among queues is often fixed-priority or round-robin with different time quantum.

#### Multi-Level Feedback Queue Scheduling

- Allows processes to move between queues based on their CPU burst characteristics.
- Processes that use too much CPU time are moved to lower-priority queues.
- Processes that wait too long in lower-priority queues may be moved to higher-priority queues to prevent starvation.
- Most general CPU-scheduling algorithm but also the most complex to configure optimally.

This content covers the essentials of CPU scheduling, its types, criteria, and various algorithms. Let me know if you need more details or specific examples!

# Chapter 4 - Process Synchronization & Race Condition

**Multiprogramming Environment:**

- Multiple processes compete for limited resources.
- Concurrent access to shared data may result in data inconsistency.

**Race Condition:**

- A situation where the output of a process depends on the execution sequence of processes.
- Changing the order of execution can change the output.

### General Structure of a Process

1. **Initial Section:**
   - Process accesses private resources.
2. **Entry Section:**
   - Process requests permission to enter its critical section.
3. **Critical Section:**
   - Process accesses shared resources.
4. **Exit Section:**
   - Process exits its critical section.
5. **Remainder Section:**
   - Remaining code of the process.

### Criterion to Solve Critical Section Problem

1. **Mutual Exclusion:**
   - Only one process can be in the critical section at a time.
2. **Progress:**
   - If no process is in the critical section, processes wishing to enter can decide which one will enter next without causing deadlock.
3. **Bounded Waiting:**
   - There is a limit on how many times a process can enter its critical section, preventing indefinite waiting.

### Solutions to Critical Section Problem

1. **Two Process Solution:**
   - Using Boolean variable turn.
   - Using Boolean array flag.
   - Peterson’s Solution.
2. **Operating System Solution:**
   - Counting Semaphore.
   - Binary Semaphore.
3. **Hardware Solution:**
   - Test and Set Lock.
   - Disable Interrupt.

### Two Process Solutions

1. **Using Boolean Variable Turn:**

   ```c
   // Process P0
   while (1) {
       while (turn != 0);
       // Critical Section
       turn = 1;
       // Remainder Section
   }

   // Process P1
   while (1) {
       while (turn != 1);
       // Critical Section
       turn = 0;
       // Remainder Section
   }
   ```

   - Ensures mutual exclusion.
   - Fails to ensure progress.
2. **Using Boolean Array Flag:**

   ```c
   // Process P0
   while (1) {
       flag[0] = true;
       while (flag[1]);
       // Critical Section
       flag[0] = false;
       // Remainder Section
   }

   // Process P1
   while (1) {
       flag[1] = true;
       while (flag[0]);
       // Critical Section
       flag[1] = false;
       // Remainder Section
   }
   ```

   - Ensures mutual exclusion.
   - May lead to deadlock.
3. **Peterson’s Solution:**

   ```c
   // Process P0
   while (1) {
       flag[0] = true;
       turn = 1;
       while (turn == 1 && flag[1]);
       // Critical Section
       flag[0] = false;
       // Remainder Section
   }

   // Process P1
   while (1) {
       flag[1] = true;
       turn = 0;
       while (turn == 0 && flag[0]);
       // Critical Section
       flag[1] = false;
       // Remainder Section
   }
   ```

   - Ensures mutual exclusion, progress, and bounded waiting.

### Semaphore Solutions

1. **Semaphores:**

   - Integer variable accessed only through wait(S) and signal(S).
   - Semaphores can solve the n-process critical section problem.

   ```c
   semaphore S = 1;

   // wait operation
   wait(S) {
       while (S <= 0);
       S--;
   }

   // signal operation
   signal(S) {
       S++;
   }
   ```

   - Ensures mutual exclusion and progress.

### Classical Problems on Synchronization

1. **Producer-Consumer Problem:**

   - Producer produces items and puts them into a buffer.
   - Consumer consumes items from the buffer.
   - Requires synchronization to avoid overflow and underflow.

   ```c
   semaphore S = 1; // Mutex for critical section
   semaphore E = n; // Count of empty cells
   semaphore F = 0; // Count of filled cells

   // Producer
   while (true) {
       // Produce an item
       wait(E);
       wait(S);
       // Add item to buffer
       signal(S);
       signal(F);
   }

   // Consumer
   while (true) {
       wait(F);
       wait(S);
       // Remove item from buffer
       signal(S);
       signal(E);
       // Consume item
   }
   ```
2. **Reader-Writer Problem:**

   - Multiple readers can read the data simultaneously.
   - Writers require exclusive access.

   ```c
   semaphore mutex = 1;
   semaphore wrt = 1;
   int readcount = 0;

   // Reader
   wait(mutex);
   readcount++;
   if (readcount == 1) wait(wrt);
   signal(mutex);
   // Read data
   wait(mutex);
   readcount--;
   if (readcount == 0) signal(wrt);
   signal(mutex);

   // Writer
   wait(wrt);
   // Write data
   signal(wrt);
   ```
3. **Dining Philosopher Problem:**

   - Philosophers alternately think and eat.
   - Need two chopsticks to eat, leading to potential deadlock.

   ```c
   semaphore chopstick[5];

   // Philosopher
   while (true) {
       // Think
       wait(chopstick[i]);
       wait(chopstick[(i+1) % 5]);
       // Eat
       signal(chopstick[i]);
       signal(chopstick[(i+1) % 5]);
   }
   ```

### Hardware Solution: Test and Set

- Modern computer systems provide special hardware instructions for atomic operations.

```c
boolean test_and_set(boolean *target) {
    boolean rv = *target;
    *target = true;
    return rv;
}

while (true) {
    while (test_and_set(&lock));
    // Critical Section
    lock = false;
    // Remainder Section
}
```

- Ensures atomic execution of critical section entry.

These solutions illustrate different approaches to handling process synchronization and avoiding race conditions in a multiprogramming environment.

# Basics of Deadlock

**Definition:**

- In a multiprogramming environment, several processes may compete for a finite number of resources.
- When a process requests resources, it may have to wait if those resources are not available. A deadlock occurs when a waiting process is unable to proceed because the resources it needs are held by other waiting processes.

**Conditions:**

- A set of processes is in a deadlocked state when each process in the set is waiting for an event that can only be triggered by another process in the set.

### Necessary Conditions for Deadlock

A deadlock can occur if all the following four conditions hold simultaneously in a system:

1. **Mutual Exclusion:**

   - At least one resource must be held in a non-sharable mode; only one process at a time can use the resource.
   - If another process requests that resource, the requesting process must wait until the resource is released.
2. **Hold and Wait:**

   - A process must be holding at least one resource and waiting to acquire additional resources held by other processes.
   - Example: A process holding a plate and waiting for a spoon.
3. **No Pre-emption:**

   - Resources cannot be forcibly taken away from a process holding them; a resource can be released only voluntarily by the process holding it.
4. **Circular Wait:**

   - There must exist a set of waiting processes, {P0, P1, ..., Pn}, such that P0 is waiting for a resource held by P1, P1 is waiting for a resource held by P2, and so on, with Pn waiting for a resource held by P0.

### Deadlock Handling Methods

1. **Prevention:**

   - Design protocols to ensure at least one of the necessary conditions for deadlock cannot hold.
2. **Avoidance:**

   - Dynamically ensure the system will never enter a deadlocked state by careful resource allocation.
3. **Detection:**

   - Allow the system to enter a deadlocked state, detect it, and recover.
4. **Ignorance (Ostrich Algorithm):**

   - Ignore the problem and pretend that deadlocks never occur in the system.

### Prevention

To prevent deadlocks, ensure that at least one of the necessary conditions cannot hold:

1. **Mutual Exclusion:**

   - Cannot generally be denied since some resources are inherently non-sharable.
2. **Hold and Wait:**

   - Conservative Approach: A process requests all resources at once.
   - Alternative Protocol: Release currently held resources before requesting new ones.
   - Wait Timeout: Impose a maximum wait time after which resources are released.
3. **No Pre-emption:**

   - If a process requests resources not available, pre-empt resources from a waiting process if possible.
4. **Circular Wait:**

   - Impose an ordering of all resource types and require processes to request resources in an increasing order.

### Avoidance

- Maintain additional information about resource usage and requests to ensure that the system remains in a safe state.
- Example: Banker's Algorithm

### Deadlock Detection and Recovery

1. **Process Termination:**

   - Abort all deadlocked processes or one process at a time until the deadlock is resolved.
2. **Resource Pre-emption:**

   - Select a victim process, pre-empt its resources, and possibly roll back its operations.

### Ignorance (Ostrich Algorithm)

- Operating systems may ignore deadlocks to avoid the overhead of detection and recovery, relying on manual intervention to resolve rare occurrences.

### Banker’s Algorithm

- Used for deadlock avoidance by simulating resource allocation for processes based on their maximum possible needs.
- Data Structures:
  - **Available:** Vector of available resources.
  - **Max:** Matrix defining the maximum demand of each process.
  - **Allocation:** Matrix defining currently allocated resources.
  - **Need:** Matrix indicating remaining resource needs (Need = Max - Allocation).

### Resource Allocation Graph

- A directed graph representing processes and resources.
- **Request Edge (Pi → Rj):** Process Pi requests resource Rj.
- **Assignment Edge (Rj → Pi):** Resource Rj is allocated to process Pi.
- **Cycle:** Indicates potential deadlock if each resource has one instance.

### Safety Algorithm

- Ensures the system is in a safe state by verifying there exists at least one sequence of process execution that does not lead to a deadlock.
- 

# Fork and Multithreading

#### Fork Command

**Requirement:**

- In applications where tasks are repetitive, like handling multiple client requests in a web server, it's inefficient to create new processes from scratch every time.
- Using a `fork` command helps in creating a new process by duplicating the existing process, speeding up the creation of new processes.

**Idea:**

- The `fork` system call creates a new process by copying the entire image of the parent process. This new process is called the child process.
- After a `fork` call, the operating system distinguishes between the parent and the child process:
  - If `fork` returns `0`, it indicates the child process.
  - If `fork` returns a positive number, it indicates the parent process.

**Advantages:**

- Simplifies the creation and management of similar repetitive tasks.
- Efficiently duplicates processes rather than starting from scratch.

**Disadvantages:**

- `fork` involves a system call, which can be slow and time-consuming.
- Increases the burden on the operating system.
- Creates multiple copies of the same code in memory, leading to redundancy.

#### Multithreading

**Concept:**

- A thread is a basic unit of CPU utilization, including a program counter, stack, registers, and a thread ID.
- Traditional processes have a single thread of control, whereas multithreaded applications have multiple threads within a single process, sharing common code, data, and certain structures like open files.

**Models of Multithreading:**

1. **Many-to-One Model:**

   - Multiple user-level threads are mapped onto a single kernel thread.
   - If a thread performs a blocking system call, the entire process blocks.
   - Does not support parallel execution on multiple CPUs.
   - Historically used in systems like Green Threads for Solaris.
2. **One-to-One Model:**

   - Each user thread is mapped to a separate kernel thread.
   - Overcomes issues of blocking system calls and supports parallel execution on multiple CPUs.
   - Introduces more overhead, which can impact system performance.
   - Used in modern systems like Linux and Windows (up to XP).
3. **Many-to-Many Model:**

   - Multiplexes many user threads onto a smaller or equal number of kernel threads.
   - Provides flexibility in the number of threads, avoiding blocking of the entire process due to system calls.
   - Supports multi-CPU utilization and allocates variable numbers of kernel threads based on system factors.

### Summary

- **Fork Command**: Efficient for creating new processes by duplicating the existing process, but involves system overhead.
- **Multithreading**: Allows multiple threads within a process to run concurrently, with different models offering trade-offs in terms of overhead and CPU utilization.

# Memory Hierarchy

**Memory Hierarchy Requirements:**

1. **Large Capacity:** Storage should be able to hold a significant amount of data.
2. **Low Cost:** Cost per unit of memory should be minimal.
3. **Fast Access Time:** Quick data retrieval is crucial for performance.

**Memory Hierarchy Overview:**

- The memory hierarchy system includes all storage devices in a computer system, organized to balance the trade-offs between capacity, cost, and access speed.

**Locality of Reference:**

- **Spatial Locality:** Refers to accessing data elements located close to each other in memory.
- **Temporal Locality:** Refers to accessing the same data or resources repeatedly within a short time period.

**Operating System Duties in Memory Management:**

1. **Address Translation:** Convert logical addresses to physical addresses.
2. **Memory Allocation and Deallocation:** Manage which processes or data segments are in memory.
3. **Memory Tracking:** Monitor memory usage and allocation.
4. **Memory Protection:** Ensure data integrity and process isolation by restricting unauthorized access.

### Contiguous Allocation Policy

**Contiguous Allocation Policy:**

- Processes must be loaded into contiguous blocks of main memory.
- **Address Translation in Contiguous Allocation:**
  - **Relocation Register:** Contains the base address of the process. Logical addresses are adjusted by this base address.
  - **Limit Register:** Contains the maximum addressable limit. If the logical address is within this limit, the request is valid; otherwise, it is illegal.

**Space Allocation Methods in Contiguous Allocation:**

1. **Variable Size Partitioning:** Memory is treated as a whole; exact space requested is allocated if possible.
2. **Fixed Size Partitioning:** Memory is divided into fixed-size partitions. If a process requests space, it gets a whole partition, potentially leading to wasted space.

**Allocation Policies:**

- **First Fit:** Allocate the first available partition that fits the request.

  - *Advantage:* Simple and easy to implement.
  - *Disadvantage:* Poor performance in terms of time and space.
- **Best Fit:** Allocate the smallest partition that fits the request.

  - *Advantage:* Best performance in fixed-size partitioning.
  - *Disadvantage:* Difficult to implement and inefficient in variable-size partitioning.
- **Worst Fit:** Allocate the largest partition available.

  - *Advantage:* Best performance in variable-size partitioning.
  - *Disadvantage:* Leads to large internal fragmentation in fixed-size partitioning.
- **Next Fit:** Allocate space starting from the last allocated position.

**Fragmentation:**

- **External Fragmentation:** Occurs when free memory is scattered in small blocks, making it impossible to allocate contiguous space even if enough total memory is free.
- **Internal Fragmentation:** Occurs when allocated memory is larger than the requested size, leading to unused space within allocated partitions.

**Solutions to Fragmentation:**

- **Compaction (Defragmentation):** Periodically reorganize memory to reduce fragmentation. This is time-consuming.
- **Non-Contiguous Allocation (Paging):** Allows processes to be divided into fixed-size pages that are not contiguous in memory.

### Non-Contiguous Memory Allocation (Paging)

**Paging:**

- **Paging:** Divides both secondary memory and main memory into fixed-size blocks (pages and frames) of the same size.
- **Translation Process:**
  - **Logical Address:** Divided into page number (p) and offset (d).
  - **Page Table:** Maps page numbers to frame numbers.
  - **Physical Address:** Calculated by combining the frame number with the offset.

**Page Table:**

- Each process has its own page table.
- The size of the page table is determined by the number of pages and the size of each entry (frame number).

**Advantages of Paging:**

- Eliminates external fragmentation.
- Simplifies memory management by using fixed-size pages.

**Disadvantages of Paging:**

- Increased memory access time due to two memory accesses (one for page table and one for actual data).
- Internal fragmentation within pages.
- Additional space required for the page table.

**Translation Lookaside Buffer (TLB):**

- **TLB:** A cache that stores recent page table entries to speed up address translation.
- **Operation:** Checks if the page number is in the TLB (TLB Hit) or needs to access the page table (TLB Miss).
- **Replacement Policy:** If the TLB is full, some entries are replaced based on a replacement policy.

**TLB Disadvantages:**

- Limited to a single process at a time; frequent context switches can flush the TLB.
- Solutions include using multiple TLBs or wiring down entries for kernel code.

### Multilevel Paging / Hierarchical Paging

**Multilevel Paging:**

- Used when page tables become excessively large.
- Page table itself is divided into smaller pieces, reducing the size of individual page tables.

### Segmentation

**Segmentation:**

- **Segmentation:** Divides a process into segments based on logical units (e.g., code, data, stack).
- **Segment Table:** Each segment has a base address and a limit.
- **Addressing:** Logical address consists of a segment number and an offset.

**Segmentation with Paging:**

- Combines segmentation and paging by dividing segments into pages, reducing external fragmentation.

### Inverted Page Table

**Inverted Page Table:**

- Contains one entry for each physical page (frame).
- Each entry maps a virtual address to the physical address of the page stored.
- Reduces the number of entries compared to traditional page tables.

# Virtual Memory

#### Pure Demand Paging

- **Definition**: Process starts with no pages in memory; pages are loaded only when required.
- **Steps**:
  1. Initial page fault occurs.
  2. Load needed page.
  3. Additional page faults as more pages are needed.
  4. Execution continues once all required pages are loaded.

#### Advantages and Disadvantages

- **Advantages**:
  - Allows execution of processes larger than physical memory.
  - More programs can run concurrently.
- **Disadvantages**:
  - Complex to implement.
  - Can lead to performance degradation (thrashing).

#### Page Fault Handling

1. **Page Fault**: Load the required page into memory.
2. **Free Frame**: If available, load the page; otherwise, swap out a page and load the new page.
3. **Modify Bit (Dirty Bit)**:
   - **Set**: Write page to disk.
   - **Not Set**: No need to write; page is unmodified.
4. Update page table and process control block (PCB), then restart the interrupted instruction.

#### Performance

- **Effective Access Time**: `(1 - p) x ma + p x page fault service time`
  - `p`: Page fault rate
  - `ma`: Memory access time

#### Page Replacement Algorithms

- **FIFO (First In First Out)**:
  - Replaces the oldest page.
  - Simple but can suffer from Belady's Anomaly.
- **Optimal**:
  - Replaces the page that will not be used for the longest time.
  - Lowest page-fault rate but requires future knowledge of references.
- **LRU (Least Recently Used)**:
  - Replaces the page that has not been used for the longest time.
  - Better than FIFO, avoids Belady's Anomaly.

#### Thrashing

- **Definition**: High paging activity reduces CPU utilization, causing a cycle of increased page faults and decreased performance.
- **Solution**: Working Set Strategy
  - **Working Set**: Pages referenced in the most recent Δ page references.
  - **Δ**: Parameter defining the window size.

### Disk Management

#### Disk Structure

- **Components**: Platters, tracks, sectors, cylinders, read/write head, and arm.
- **Total Transfer Time**: `Seek Time + Rotational Latency + Transfer Time`
  - **Seek Time**: Time to move to the correct track.
  - **Rotational Latency**: Time to wait for the correct sector.
  - **Transfer Time**: Time to read/write data.

#### Disk Scheduling Algorithms

- **FCFS (First Come First Serve)**:
  - Simple, fair, but can be inefficient.
- **SSTF (Shortest Seek Time First)**:
  - Services the request closest to the current head position.
  - Reduces seek time but can cause starvation.
- **SCAN (Elevator Algorithm)**:
  - Moves the head from one end of the disk to the other, servicing requests.
  - Reduces variance in response time but can have long wait times.
- **C-SCAN (Circular SCAN)**:
  - Similar to SCAN but returns to the beginning without servicing on the return trip.
  - More uniform wait times compared to SCAN.
- **LOOK**:
  - Similar to SCAN but only goes to the last request in the current direction.
  - Avoids unnecessary travel.
- **C-LOOK**:
  - Similar to C-SCAN but only goes to the last request and then jumps to the beginning.
  - Provides uniform wait times and better response times.

## File Allocation Methods

### Contiguous Allocation

- **Description**: Files occupy a set of contiguous blocks on the disk.
- **Directory Info**: Stores file name, start dba, and length.
- **Advantages**:
  - Easy access for both sequential and direct access.
- **Disadvantages**:
  - Suffers from external fragmentation.
  - Issues with file modification.

### Linked Allocation

- **Description**: Each file is a linked list of scattered disk blocks.
- **Directory Info**: Points to the first and last blocks.
- **Advantages**:
  - Flexible file size; no external fragmentation.
  - Easy to create, read, write files.
- **Disadvantages**:
  - Only supports sequential access.
  - Additional space required for pointers.

### Indexed Allocation

- **Description**: Uses an index block to store pointers to file blocks.
- **Directory Info**: Points to the index block.
- **Variants**:
  - **Linked Scheme**: Multiple index blocks for large files.
  - **Multilevel Index**: Uses multiple levels of index blocks.
  - **Combined Scheme**: UNIX Inodes store direct and indirect pointers.
- **Advantages**:
  - Supports direct access and reduces fragmentation.
- **Disadvantages**:
  - Overhead from index block pointers.

## Free-Space Management

### Linked List

- **Description**: Links all free blocks together.
- **Disadvantages**:
  - Inefficient traversal requires substantial I/O time.

### Bit Vector

- **Description**: Uses a bit map to represent free and allocated blocks.
- **Example**: `001111001111110001100000011100000 ...`
- **Advantages**:
  - Efficient for finding free blocks.
- **Disadvantages**:
  - Inefficient for large disks due to size of bit map.

## File Organization

- **Sequential File Organization**:

  - **Access**: Records accessed in a sorted order.
  - **Speed**: Slower for large files.
  - **Efficiency**: More space-efficient; no index needed.
- **Random/Direct File Organization**:

  - **Access**: Direct access using a key.
  - **Speed**: Faster for random access.
  - **Efficiency**: Less efficient due to index storage.
- **Serial File Organization**:

  - **Access**: Records accessed sequentially.
  - **Use Case**: Primarily for magnetic tapes.
- **Indexed-Sequential File Organization**:

  - **Access**: Uses an index for direct access.
  - **Use Case**: Improved access speed with indexes.

## File Access Mechanisms

- **Sequential Access**:

  - **Description**: Processes records one after another.
  - **Use Case**: Editors, compilers.
- **Direct Access**:

  - **Description**: Random access to any block/record.
  - **Use Case**: Databases.
- **Index Access**:

  - **Description**: Uses an index to locate and access records.
  - **Use Case**: Quick lookup in databases.

## Directory Management

- **Single-Level Directory**:

  - **Characteristics**: All files in one directory.
  - **Advantages**: Simpler but less organized.
- **Two-Level Directory**:

  - **Characteristics**: Separate directories for each user.
  - **Advantages**: Better organization and user-specific directories.
- **Operations**:

  - Create, Delete, Rename, List, Move, Copy, Change, Search, Sort, Set Permissions.

## File Protection System

- **Reliability**:

  - Ensures files are accessible and retrievable.
  - Techniques: Backup, mirroring, RAID.
- **Security**:

  - Protects against unauthorized access.
  - Techniques: Encryption, firewalls, SFTP.
- **Controlled Access**:

  - Defines user permissions (read, write, execute).
  - Access Control Lists (ACLs) and Role-Based Access Control (RBAC).

## Access Matrix

- **Description**: Framework showing permissions for subjects (users) on objects (files).
- **Matrix Form**: Table of permissions.| File   | User 1 | User 2 | User 3 |
  | ------ | ------ | ------ | ------ |
  | File A | r-w    | r      | -      |
  | File B | r      | w      | -      |
  | File C | r-w    | r      | w      |
- **Implementation**:
  1. **Global Table**: Raw access matrix.
  2. **Access Lists for Objects**: Object-centric ACLs.
  3. **Capability Lists for Domains**: Subject-centric capability lists.
  4. **Lock-Key Mechanism**: Keys to unlock objects.

# Formulas

### **Paging**

| **Concept**          | **Formula**                                                                           | **Description**                                         |
| -------------------------- | ------------------------------------------------------------------------------------------- | ------------------------------------------------------------- |
| **Page Number**      | \( \text{Page Number} = \frac{\text{Logical Address}}{\text{Page Size}} \)                  | Determines the page number from a logical address.            |
| **Offset**           | \( \text{Offset} = \text{Logical Address} \mod \text{Page Size} \)                          | Determines the offset within the page.                        |
| **Logical Address**  | \( \text{Logical Address} = \text{Page Number} \times \text{Page Size} + \text{Offset} \)   | Reconstructs the logical address from page number and offset. |
| **Physical Address** | \( \text{Physical Address} = \text{Frame Number} \times \text{Page Size} + \text{Offset} \) | Maps to the physical address using frame number and offset.   |
| **Page Table Entry** | \( \text{Page Table Entry} = \text{Frame Number} \)                                         | Maps a page number to a frame number in memory.               |

### **Indexing**

| **Concept**               | **Formula**                                            | **Description**                                          |
| ------------------------------- | ------------------------------------------------------------ | -------------------------------------------------------------- |
| **Index Block Address**   | \( \text{Index Block Address} = \text{Index Block} \)        | Address of the index block containing pointers to data blocks. |
| **Direct Indexing**       | \( \text{Address} = \text{Index}[i] \)                       | Directly accesses the block using an index.                    |
| **Single Indirect Index** | \( \text{Address} = \text{Indirect Block}[i] \)              | Uses an indirect block to get addresses of data blocks.        |
| **Double Indirect Index** | \( \text{Address} = \text{Double Indirect Block}[i][j] \)    | Uses two levels of indirection to locate data blocks.          |
| **Triple Indirect Index** | \( \text{Address} = \text{Triple Indirect Block}[i][j][k] \) | Uses three levels of indirection to locate data blocks.        |

These formulas cover the essential calculations for paging and indexing in memory management and file systems.
