# Load Balancer 

#### 1. **Introduction**

- **Load Balancer**: A device or software that distributes incoming network traffic across multiple servers to ensure no single server is overwhelmed, enhancing the availability and responsiveness of the application.

#### 2. **Types of Load Balancers**

- **Hardware Load Balancer**: Physical devices designed for load balancing.
- **Software Load Balancer**: Applications or services running on standard hardware for load balancing.
- **Virtual Load Balancer**: Software-based load balancers running on virtualized environments.

#### 3. **Placement of Load Balancers**

- **Layer 4 (L4) Load Balancers**: Operate at the transport layer, making decisions based on IP and TCP/UDP headers.
- **Layer 7 (L7) Load Balancers**: Operate at the application layer, making decisions based on application-level data (e.g., HTTP headers).

#### 4. **Differences Between Hardware and Software Load Balancers**

- **Scalability**: Software load balancers scale more easily.
- **Cost**: Software load balancers are typically less expensive and easier to maintain.
- **Throughput**: Hardware load balancers often provide higher throughput.
- **Security**: Hardware load balancers are generally more secure since they are physical devices.
- **Expertise**: Hardware load balancers may require specialized knowledge for setup and maintenance.

#### 5. **Load Balancing Algorithms**

- **Round Robin**: Distributes requests sequentially across servers.
- **Weighted Round Robin**: Assigns weights to servers and distributes requests based on these weights.
- **Least Connection**: Directs requests to the server with the fewest active connections.
- **Least Response Time**: Sends requests to the server with the fastest response time.
- **IP Hashing**: Uses a hash of the client's IP address to determine which server receives the request.
- **Consistent Hashing**: A hashing technique that ensures minimal disruption when servers are added or removed.
- **Sticky Sessions (Session Persistence)**: Ensures that requests from a particular client are always sent to the same server.

#### 6. **Benefits of Load Balancers**

- **Scalability**: Easily add servers to handle increasing loads.
- **High Availability**: Continues to operate even if some servers fail.
- **Health Checks**: Monitors server health and removes unresponsive servers from the pool.
- **Security**: Can handle some security functions, such as SSL termination and DDoS protection.
- **Improved Performance**: Distributes traffic efficiently, reducing latency and ensuring better resource utilization.
- **Abstraction for Non-Functional Requirements**: Offloads certain tasks like security and session management to the load balancer, simplifying application development.

### Detailed Revision Notes

#### What is a Load Balancer?

- Acts as a traffic router, distributing incoming requests to multiple backend servers.
- Ensures even distribution of load, preventing server overload and maintaining availability.

#### Types of Load Balancers

1. **Hardware Load Balancer**:

   - Dedicated physical devices.
   - Higher throughput and security.
   - Costly and requires specialized knowledge for maintenance.
2. **Software Load Balancer**:

   - Flexible and easily scalable.
   - Lower cost and maintenance.
   - May require additional security measures.
3. **Virtual Load Balancer**:

   - Operates in virtualized environments.
   - Combines flexibility of software with some benefits of hardware solutions.

#### Placement of Load Balancers

- **Layer 4 (L4) Load Balancers**: Make routing decisions based on transport layer information (IP, TCP/UDP).
- **Layer 7 (L7) Load Balancers**: Make routing decisions based on application layer information (HTTP headers, cookies).

#### Load Balancing Algorithms

1. **Round Robin**:

   - Simple and easy to implement.
   - May not account for differences in server capacity.
2. **Weighted Round Robin**:

   - Assigns weights to servers based on capacity.
   - Distributes requests proportionally to server weights.
3. **Least Connection**:

   - Sends requests to the server with the fewest active connections.
   - Balances load based on current connection count.
4. **Least Response Time**:

   - Directs traffic to the server with the fastest response time.
   - Improves user experience by reducing latency.
5. **IP Hashing**:

   - Maps client IP addresses to servers using a hash function.
   - Ensures consistent routing of client requests.
6. **Consistent Hashing**:

   - Minimizes disruption when servers are added or removed.
   - Efficiently distributes load across servers.
7. **Sticky Sessions (Session Persistence)**:

   - Routes requests from the same client to the same server.
   - Useful for applications requiring session affinity.

#### Benefits of Load Balancers

- **Scalability**: Easily add/remove servers to match demand.
- **High Availability**: Detects server failures and reroutes traffic.
- **Health Checks**: Continuously monitors server health.
- **Security**: Can handle SSL termination and protect against attacks.
- **Performance**: Reduces latency and improves resource utilization.
- **Non-Functional Requirements**: Offloads tasks like session management and security to the load balancer.

These notes provide a comprehensive overview of load balancers, their types, placement, algorithms, and benefits, aiding in effective revision and understanding of the topic.
