# CAP Theorem

The CAP Theorem is a fundamental principle in the design of distributed systems. It was proposed by Eric Brewer and stands for Consistency, Availability, and Partition Tolerance. According to the CAP Theorem, a distributed system can only provide two out of the following three guarantees simultaneously:

1. **Consistency (C)**
2. **Availability (A)**
3. **Partition Tolerance (P)**

### Definitions

1. **Consistency:** Every read receives the most recent write or an error.
2. **Availability:** Every request receives a (non-error) response – without guaranteeing it contains the most recent write.
3. **Partition Tolerance:** The system continues to operate despite an arbitrary number of messages being dropped (or delayed) by the network between nodes.

### Explanation

In a distributed system, network partitions can occur, which means some nodes cannot communicate with others. During such events, the system has to make a choice between consistency and availability. Let's discuss each pair:

1. **Consistency and Availability (CA)**

   - In CA systems, the system is consistent and available as long as there is no network partition. However, if a partition occurs, the system might fail to deliver both properties.
2. **Consistency and Partition Tolerance (CP)**

   - In CP systems, the system maintains consistency even in the presence of network partitions, but might not be able to respond to some requests (i.e., it might be unavailable during the partition).
3. **Availability and Partition Tolerance (AP)**

   - In AP systems, the system remains available and tolerant of partitions, but it may return out-of-date information, sacrificing consistency.

### Practical Implications

In practice, it's crucial to decide which two out of the three properties are most important for your application:

1. **Banking Systems (CP)**

   - Consistency is critical (no stale data), and partition tolerance is a must, but they can afford some downtime (availability can be compromised).
2. **Online Retail (AP)**

   - Availability and partition tolerance are prioritized to ensure users can always place orders, even if they might not see the most up-to-date stock information immediately.
3. **CA Systems**

   - These are rare in true distributed systems since they cannot tolerate network partitions, which are common in distributed environments.

### CAP Theorem Table

| Property                | Description                                                | Example Use Case             |
| ----------------------- | ---------------------------------------------------------- | ---------------------------- |
| Consistency (C)         | Every read receives the most recent write or an error      | Banking Systems              |
| Availability (A)        | Every request receives a (non-error) response              | Online Retail                |
| Partition Tolerance (P) | The system continues to operate despite network partitions | Global Distributed Databases |

| Pair                                    | Description                                                  | Example                                      |
| --------------------------------------- | ------------------------------------------------------------ | -------------------------------------------- |
| CA (Consistency + Availability)         | Consistent and available without network partition tolerance | Rare, mostly in non-distributed environments |
| CP (Consistency + Partition Tolerance)  | Consistent and partition-tolerant but might not be available | Banking Systems                              |
| AP (Availability + Partition Tolerance) | Available and partition-tolerant but might not be consistent | Online Retail                                |

### Conclusion

The CAP Theorem provides a guideline for designing distributed systems by highlighting the trade-offs between consistency, availability, and partition tolerance. Understanding these trade-offs helps in making informed decisions about the architecture of the system to meet specific application requirements.

### Summary

- **Consistency (C):** Ensures the latest data is always read.
- **Availability (A):** Ensures the system is always responsive.
- **Partition Tolerance (P):** Ensures the system continues to function despite network failures.
- You can only choose two out of the three properties in any distributed system.

This understanding is crucial for system architects and developers working on distributed systems to make the right trade-offs and design decisions based on their specific needs and constraints.
