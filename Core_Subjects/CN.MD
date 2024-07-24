# Computer Networks Revision Notes

## Overview

Computer Networks enable the exchange of data between devices using various technologies and protocols. Key components include network topologies, models, protocols, and algorithms for efficient data transmission and routing.

## Topology

- **Bus Topology**: Single central cable, all devices connected. Simple but prone to collisions.
- **Star Topology**: Devices connected to a central hub. Easy to manage but single point of failure.
- **Ring Topology**: Each device connected to two others, forming a ring. Data travels in one direction, but a failure in any cable can disrupt the network.
- **Mesh Topology**: Devices interconnected. Provides high redundancy but is complex to install.
- **Hybrid Topology**: Combination of two or more different topologies.

## OSI Model

Divides network communication into seven layers, each with specific functions.

| Layer           | Function                             | Protocols and Devices |
| --------------- | ------------------------------------ | --------------------- |
| 7. Application  | End-user services                    | HTTP, FTP, SMTP       |
| 6. Presentation | Data translation and encryption      | SSL, JPEG             |
| 5. Session      | Session management                   | NetBIOS, PPTP         |
| 4. Transport    | Reliable data transfer               | TCP, UDP              |
| 3. Network      | Path determination and IP addressing | IP, ICMP, Routers     |
| 2. Data Link    | Node-to-node data transfer           | Ethernet, Switches    |
| 1. Physical     | Physical connection                  | Cables, Hubs          |

## TCP/IP Model

A simplified, four-layer model.

- **Application Layer**: Handles high-level protocols, issues of representation, encoding, and dialog control.
- **Transport Layer**: Ensures error-free data transmission between hosts.
- **Internet Layer**: Manages logical addressing and routing.
- **Network Access Layer**: Deals with hardware addressing and physical transmission.

## OSPF (Open Shortest Path First)

- **Purpose**: A link-state routing protocol used to find the best path for data through a network.
- **Features**:
  - Uses Dijkstra's algorithm for shortest path calculation.
  - Hierarchical design: Divides large networks into areas.
  - Fast convergence and scalability.
  - Supports CIDR and VLSM.

## Dijkstra's Algorithm

- **Use**: Calculates the shortest path from a single source node to all other nodes in a weighted graph.
- **Steps**:
  1. Initialize distances: Set source node distance to 0, all others to infinity.
  2. Mark all nodes unvisited. Set initial node as current.
  3. For the current node, consider all unvisited neighbors. Calculate their tentative distances.
  4. When all neighbors are visited, mark the current node as visited. A visited node will not be checked again.
  5. Select the unvisited node with the smallest tentative distance and set it as the new current node.
  6. Repeat steps 3-5 until all nodes are visited.

## Routing

- **Static Routing**: Manually configured routes. Simple but not scalable.
- **Dynamic Routing**: Uses protocols to automatically update routing tables.
  - **RIP**: Uses hop count as a metric, simple but inefficient for large networks.
  - **OSPF**: Link-state protocol, efficient, and suitable for large networks.
  - **BGP**: Used for routing between autonomous systems on the internet.

## Class and Classless Addressing

- **Classful Addressing**:

  - **Class A**: 1.0.0.0 to 126.0.0.0, /8 subnet mask.
  - **Class B**: 128.0.0.0 to 191.255.0.0, /16 subnet mask.
  - **Class C**: 192.0.0.0 to 223.255.255.0, /24 subnet mask.
- **Classless Addressing (CIDR)**:

  - Allows for variable-length subnet masking.
  - More efficient use of IP addresses.

## Subnet Masking

- **Purpose**: Divides an IP address into network and host portions.
- **Example**:
  - IP Address: 192.168.1.1
  - Subnet Mask: 255.255.255.0
  - Network Address: 192.168.1.0
  - Host Range: 192.168.1.1 to 192.168.1.254
  - Broadcast Address: 192.168.1.255

---

# Chapter 1 : Introduction Concepts

- **Definition**: A telecommunications network allowing autonomous digital devices (nodes) to exchange data via wired or wireless connections to share resources (hardware or software) interconnected by a single technology (e.g., the internet).

## Goals of Computer Networks

- **Facilitating Communication**:
  - Supports video conferencing, emails, instant messaging.
- **Resource Sharing**:
  - Allows users to share hardware and software resources (e.g., printers, files).
- **Data Storage and Access**:
  - Centralized storage systems enabling access from any connected device.
  - Simplifies data backup and recovery.
- **Cost Efficiency**:
  - Reduces costs by sharing resources and avoiding hardware/software duplication.
- **Reliability and Redundancy**:
  - Enhances reliability with alternate paths and redundant systems.
- **Business and Commerce**:
  - E-commerce, online banking, stock trading.
  - Facilitates remote working and global collaboration.
- **Education**:
  - E-learning platforms, virtual classrooms, online exams.
  - Supports research and knowledge sharing.
- **Healthcare**:
  - Telemedicine, electronic health records, remote patient monitoring.
- **Government Services**:
  - E-governance, online public services, secure communication between agencies.
- **Entertainment**:
  - Online gaming, streaming services, social media platforms.
- **Scientific Research**:
  - Facilitates data sharing and collaboration on research projects.
- **Travel and Hospitality**:
  - Online ticket booking, hotel reservations, GPS, and navigation services.

## Data Communication

- **Definition**: Exchange of data between two devices via a transmission medium.
- **Components**:
  1. **Message**: Information (data) to be communicated (e.g., text, audio, video).
  2. **Sender**: Device sending the message (e.g., computer, phone, camera).
  3. **Receiver**: Device receiving the message (e.g., computer, phone, television).
  4. **Transmission Medium**: Physical path for message travel from sender to receiver.
  5. **Protocol**: Rules governing data communication, including syntax, semantics, and timing.

## Transmission Modes

- **Simplex**:
  - Unidirectional communication (e.g., radio, mouse).
  - Entire channel capacity used for sending data in one direction.
- **Half Duplex**:
  - Both stations can transmit and receive, but not simultaneously (e.g., walkie-talkies).
  - Entire channel capacity used by the transmitting device.
- **Full Duplex**:
  - Both stations can transmit and receive simultaneously (e.g., telephone network).
  - Channel capacity divided between two directions.

## Network Criteria

- **Delivery & Accuracy**:
  - Data must reach the correct destination without errors.
- **Performance**:
  - Measured by transit time, response time, number of users, transmission medium, hardware capabilities, and software efficiency.
- **Reliability**:
  - Frequency of failure and time to recover from failures.
- **Security**:
  - Protects data from unauthorized access and damage.

## Types of Connections

- **Point-to-Point**:
  - Dedicated link between two devices (e.g., wire, microwave, satellite).
- **Multipoint (Multidrop)**:
  - More than two devices share a single link.

## Physical Topologies

- **Mesh Topology**:
  - Every device has a dedicated point-to-point link to every other device.
  - Advantages: No traffic problems, robust, secure, easy fault identification/isolation.
  - Disadvantages: Difficult installation, bulky wiring, expensive.
- **Star Topology**:
  - Devices connect to a central hub, not directly to each other.
  - Advantages: Less expensive, easy to install/reconfigure, robust, easy fault identification/isolation.
  - Disadvantages: Dependency on the hub, more cabling required.
- **Bus Topology**:
  - Multipoint connection using a single backbone cable.
  - Advantages: Easy installation, uses less cabling.
  - Disadvantages: Difficult reconnection/fault isolation, difficult to add new devices, single cable fault stops all transmission.
- **Ring Topology**:
  - Devices connected in a circular manner with a point-to-point connection.
  - Advantages: Easy installation/reconfiguration, simplified fault isolation.
  - Disadvantages: A break in the ring can disable the entire network.

## Network Types

- **Local Area Network (LAN)**:
  - Limited to a few kilometers, privately owned (e.g., network in an office).
- **Wide Area Network (WAN)**:
  - Covers large geographic areas (e.g., network across a state).
- **Metropolitan Area Network (MAN)**:
  - Size between LAN and WAN, covers a city (e.g., network in Mumbai).

---

# Network Models

## OSI Model

- **Purpose**: Facilitates communication between different systems without changes to hardware/software.
- **Layers**: Seven layers, each defining part of the network communication process.

## Layered Architecture

1. **Layer Interaction**: Each layer uses services of the layer below and provides services to the layer above.
2. **Communication**: Layers on different machines communicate through protocols.
3. **Peer-to-Peer Processes**: Processes at the same layer on different machines.

## Peer-to-Peer Processes

- **Physical Layer**: Direct communication.
- **Higher Layers**: Data passes through layers, adding information at each layer.

## Physical Layer

1. **Bit Representation**: Encodes bits into electrical/optical signals.
2. **Data Rate**: Defines transmission rate (bps).
3. **Line Configuration**: Connection of devices to media.
4. **Topology**: Physical arrangement of network.
5. **Transmission Mode**: Simplex, half-duplex, full-duplex.

## Data Link Layer

1. **Framing**: Divides bit stream into frames.
2. **Physical Addressing**: Adds header with sender/receiver addresses.
3. **Access Control**: Manages control over the link.
4. **Flow Control**: Prevents receiver overload.
5. **Error Control**: Detects and retransmits damaged frames.

## Network Layer

1. **Logical Addressing**: Adds logical addresses to packets.
2. **Routing**: Routes packets across multiple networks.

## Transport Layer

1. **Service-Point Addressing**: Uses port addresses for process delivery.
2. **Segmentation/Reassembly**: Divides and reassembles messages.
3. **Connection Control**: Manages connections (connectionless/connection-oriented).
4. **Flow Control**: End-to-end flow control.
5. **Error Control**: End-to-end error control.

## Session Layer

- **Dialog Control**: Manages dialogs (half/full-duplex).
- **Synchronization**: Adds checkpoints.

## Presentation Layer

1. **Translation**: Converts data formats.
2. **Encryption**: Ensures privacy.
3. **Compression**: Reduces data size.

## Application Layer

- **User Interface**: Accesses network services.
- **Services**:
  - **Network Virtual Terminal**: Remote login.
  - **File Transfer, Access, and Management**: Manages remote files.
  - **Mail Services**: Email forwarding/storage.
  - **Directory Services**: Distributed database access.

---

# Transmission Media

## Guided Media

1. **Twisted Pair**: Two insulated copper wires.
2. **Coaxial Cable**: Central conductor with insulating sheath.
3. **Fiber Optic**: Transmits signals as light.

## Unguided Media: Wireless

1. **Ground Propagation**: Low-frequency waves.
2. **Sky Propagation**: High-frequency waves reflected by ionosphere.
3. **Line of Sight**: Very high-frequency direct signals.
4. **Radio Waves**: Omnidirectional, penetrate walls.
5. **Microwaves**: Unidirectional, cannot penetrate walls.
6. **Infrared**: Short-range communication.

---

# Switching

## Circuit Switching

- **Method**: Establishes dedicated path.
- **Multiplexing**: TDM and FDM.

## Packet Switching

1. **Datagram Network**: No resource allocation, first-come, first-served.
2. **Virtual Network**: Combines circuit and datagram features.

---

# ISDN (Integrated Services Digital Network)

1. **Definition**: Digital transmission set of protocols.
2. **Development**: 1980s-1990s.
3. **Channels**: B-channels for data, D-channels for control.
4. **Interfaces**: BRI (home/small enterprise) and PRI (large installations).
5. **Speed**: BRI up to 128 kbps, PRI up to 1.544 Mbps (NA) / 2.048 Mbps (Europe).
6. **Usage**: Early internet access, declined with broadband.

# Data Link Layer Sublayers

### Two Sublayers

1. **Logical Link Control (LLC)** (TOP) and **Media Access Control (MAC)** (BOTTOM):

   - IEEE has subdivided the data-link layer into these two sublayers.
2. **Media Access Control (MAC)**:

   - Defines the specific access method for each LAN (e.g., Ethernet).
   - Manages addressing at the LAN technology level.
3. **Logical Link Control (LLC)**:

   - Handles flow control, error control, and part of the framing duties.
4. **Framing**:

   - Managed by both LLC and MAC sublayers.

## Media Access Control

- **Multiple-Access Protocol**:

  - Used to coordinate access to a common link when nodes or stations are connected.
  - Various protocols handle access to a shared link.
- **Propagation Delay**:

  - Time it takes for a bit to travel from point A to point B in the transmission media.
  - \( TP = \frac{\text{Distance}}{\text{Propagation speed}} \)
- **Transmission Delay (TT)**:

  - Time required for a sender to put the bits in a packet on the line one by one.
  - \( TT = \frac{\text{Packet length} (L)}{\text{Transmission rate or Bandwidth} (B)} = \frac{L}{B} \)

## Random Access

1. **Characteristics**:

   - No station is superior or controls another.
   - Stations do not have assigned times to transmit; transmissions are random.
   - No rules dictate which station should send next, leading to contention and possible collisions.
2. **Collision Handling**:

   - If more than one station transmits simultaneously, a collision occurs, destroying or modifying frames.
   - Protocols answer key questions regarding medium access, busy medium, transmission success or failure, and conflict resolution.

## ALOHA

- **Pure ALOHA**:

  - Developed at the University of Hawaii around 1970.
  - Designed for a radio LAN but applicable to any shared medium.
  - Each station sends a frame whenever it has one, leading to possible collisions.
  - Vulnerable time for collision is \( 2 \times \text{frame transmission time} (Tfr) \).
- **Collision Handling**:

  - Stations wait a random back-off time \( (T_B) \) after a time-out before resending frames to avoid collisions.
  - After a maximum number of retransmission attempts \( (K_{max}) \), stations must give up and try later.

### Slotted ALOHA

- **Improvements**:

  - Time divided into slots of \( Tfr \).
  - Stations send only at the beginning of a time slot.
  - Reduces vulnerable time to \( Tfr \).
- **Efficiency**:

  - Pure ALOHA: ~18.4%
  - Slotted ALOHA: ~37%

### Comparison: Pure ALOHA vs. Slotted ALOHA

| Aspect             | Pure ALOHA                                   | Slotted ALOHA                                     |
| ------------------ | -------------------------------------------- | ------------------------------------------------- |
| Time Structure     | No specific structure; data sent at any time | Data sent at the beginning of time slots          |
| Efficiency         | ~18.4%                                       | ~37%                                              |
| Collision Handling | Resend after a random interval               | Send at time slot beginnings, reducing collisions |
| Complexity         | Less complex, no synchronization             | More complex, requires synchronization            |

---

## Carrier Sense Multiple Access (CSMA)

### Overview

- **Purpose**: Minimize collision chance and increase performance by sensing the medium before transmission.
- **Mechanism**: Each station listens to the medium before sending, known as "sense before transmit" or "listen before talk."
- **Limitation**: Collisions cannot be entirely eliminated due to propagation delay.

### Vulnerable Time

- **Definition**: The vulnerable time for CSMA is the propagation time \( T_p \).
- **Scenario**: If a station sends a frame and another station sends a frame during this time, a collision occurs.
- **Resolution**: If the first bit of the frame reaches the end of the medium, all stations will refrain from sending.

### Persistence Methods

1. **1-Persistent Method**

   - A station sends its frame immediately upon finding the line idle.
   - **Risk**: High chance of collision if multiple stations find the line idle simultaneously.
2. **Nonpersistent Method**

   - A station senses the line and waits a random amount of time if the line is busy before retrying.
   - **Advantage**: Reduces collision chances.
   - **Disadvantage**: Decreases network efficiency due to idle medium.
3. **P-Persistent Method**

   - A station sends its frame with probability \( p \) if the line is idle.
   - **Process**:
     - If the line is busy, it waits for the next time slot and checks again.
     - If the line remains idle, the station follows the same steps.
     - If a collision occurs, it uses the backoff procedure.
   - **Advantage**: Balances collision reduction and network efficiency.

## Carrier Sense Multiple Access with Collision Detection (CSMA/CD)

### Mechanism

- **Post-Transmission Monitoring**: A station monitors the medium after sending a frame to check for collisions.
- **Collision Handling**: If a collision is detected, the station resends the frame.

### Requirements

- **Minimum Frame Size**: Ensures collision detection by requiring the frame transmission time \( T_{fr} \) to be at least twice the maximum propagation time \( T_p \).

### Energy Levels

- **Zero Level**: Channel is idle.
- **Normal Level**: A station is successfully sending a frame.
- **Abnormal Level**: Indicates a collision, with energy level twice the normal.

## Carrier Sense Multiple Access with Collision Avoidance (CSMA/CA)

### Overview

- **Use Case**: Ideal for wireless networks where collisions cannot be easily detected.
- **Goal**: Avoid collisions through specific strategies.

### Strategies

1. **Interframe Space (IFS)**

   - Defers transmission even if the channel is idle by waiting for a period called IFS.
   - Allows the signal to reach distant stations and prioritizes stations or frame types.
2. **Contention Window**

   - Divides the waiting time into slots and selects a random number of slots as the wait time.
   - Uses binary exponential back-off strategy, doubling the number of slots each time.
   - Monitors the channel after each slot, resuming the timer when the channel is idle.
3. **Acknowledgment**

   - Ensures data integrity by using positive acknowledgment and time-out timers to confirm frame reception.

## Flow Control

- **Purpose**: Prevent data overflow by managing the buffer memory of the receiving device.
- **Mechanism**: The receiver communicates with the sender to adjust the transmission rate, ensuring smooth data flow and avoiding system overload.

# Error Control

- **Components**: Detection and retransmission of lost, out-of-order, or corrupt frames.
- **Implementation**: Utilizes Automatic Repeat Request (ARQ) process to detect errors and trigger retransmission, maintaining data integrity.

---

### Sliding Window Protocol

#### 1. Stop-and-Wait Automatic Repeat Request (ARQ)

- **Error Handling**: When a frame is corrupted, it is silently discarded. The lack of an acknowledgment (ACK) indicates an error to the sender.
- **Retransmission**: The sender keeps a copy of the sent frame and starts a timer. If the timer expires without receiving an ACK, the frame is resent.
- **Sequence Numbers**: Frames are numbered using sequence numbers to differentiate between new and retransmitted frames. Only two numbers (0 and 1) are used to avoid confusion.

  **Delays**:

  - **Propagation Delay (Tp)**: Time taken for a bit to travel from sender to receiver.
  - **Transmission Delay (Tt)**: Time taken to put all bits of a frame on the transmission medium.
  - **Queuing Delay**: Time a packet waits in the input/output queue of a router.
  - **Processing Delay**: Time to process the packet at the destination.

  **Total Time Calculation**:

  - Total Time = Tt(data) + 2 * Tp
  - Efficiency (η) = 1 / (1 + 2 * Tp/Tt)
  - Throughput = η * Bandwidth (B)

#### 2. Go-Back-N Automatic Repeat Request (ARQ)

- **Efficiency**: Improves over Stop-and-Wait by allowing multiple frames to be sent before receiving acknowledgments.
- **Sliding Window**: Sender maintains a window of frames that can be sent without waiting for an ACK.

  - **Window Variables**:
    - Sf: First outstanding frame
    - Sn: Next frame to be sent
    - Ssize: Window size
- **Receiver**: Has a fixed window size of one and sends cumulative acknowledgments for correctly received frames.
- **Timers**: Single timer for the first outstanding frame. If it expires, all outstanding frames are resent.

  **Sequence and Acknowledgment Numbers**:

  - Window Size (Ws) = (1 + 2a)
  - Number of bits for sequence numbers = ceil(log2(1 + 2a))

#### 3. Selective Repeat Automatic Repeat Request (ARQ)

- **Selective Resend**: Only the frames that are received incorrectly are resent, improving efficiency over Go-Back-N in unstable connections.
- **Receiver**: Can store out-of-order frames and acknowledges each correctly received frame.
- **Timers**: Each frame has its own timer.
- **Piggybacking**: Data frames can carry acknowledgment information for frames traveling in the opposite direction.

### Error Detection and Correction

#### Types of Errors

- **Single-bit Error**: Only one bit in the data unit changes.
- **Burst Error**: Two or more bits in the data unit change.

#### Hamming Distance

- **Definition**: Number of differing bits between two words.
- **Calculation**: XOR the two words and count the number of 1s in the result.

#### Simple Parity-Check Code

- **Parity Bit**: An additional bit ensuring an even or odd number of 1s.
- **Hamming Distance**: Minimum distance of 2, detects single-bit errors.

#### Two-Dimensional Parity Check

- **Table Arrangement**: Data arranged in a table with parity bits for rows and columns.
- **Error Detection**: Can detect up to three errors, may miss four or more errors.

#### Hamming Codes

- **Error-Correcting Codes**: Detect up to two errors or correct one error.
- **Parity Bits**: Placed at positions \(2^0, 2^1, 2^2, \ldots, 2^n\).

#### Checksum

- **Addition Method**: Add all numbers, send the sum with the data.
- **Validation**: Receiver adds numbers and compares the sum.

#### One's Complement

- **Negative Representation**: Inverting all bits.
- **Checksum Validation**: Adding all numbers (including the checksum) should result in 0 if no errors.

#### Cyclic Codes

- **Property**: Cyclic shift of a codeword results in another codeword.

#### Cyclic Redundancy Check (CRC)

- **Process**: Dataword augmented with zeros, divided by a predefined divisor. Remainder appended to dataword.
- **Encoder/Decoder**: Uses polynomials to represent binary patterns.

---

# Network Layer

**Key Points:**

- **Source to Destination Delivery:** Delivers packets over multiple networks.
- **Logical Addressing:** Uses logical addresses for sender and receiver identification.
- **Routing:** Finds the best route using routing protocols.
- **Packetizing:** Encapsulates payload, adds header, ensures payload integrity.
- **Error and Flow Control:** Adds checksum for header corruption detection, limited flow control, uses ICMP for error control.
- **Congestion Control:** Manages congestion by handling datagram crowding and capacity exceedance.

### IPv4

**Key Points:**

- **Connectionless Datagram Protocol:** Best-effort delivery without guarantees for packet safety or order.
- **Datagram Approach:** Treats each datagram independently, allowing different routes.
- **Coupling with TCP:** Enhances reliability by forming the TCP/IP stack.

### Datagram Format

**Key Points:**

- **Variable-Length Packet:** Consists of a header (20-60 bytes) and payload.
- **Header Fields:** Include version number, header length, service type, total length, etc.

**Datagram Header Fields:**

| Field                         | Description                                              |
| ----------------------------- | -------------------------------------------------------- |
| **Version**             | 4-bit field, value 4 for IPv4                            |
| **Header Length**       | 4-bit field, length in 4-byte words (20-60 bytes)        |
| **Service Type**        | 8-bit field, defines QoS                                 |
| **Total Length**        | 16-bit field, total length of datagram (header + data)   |
| **Identification**      | 16-bit field, unique identifier for fragmentation        |
| **Flags**               | 3-bit field, controls fragmentation                      |
| **Fragment Offset**     | 13-bit field, position of fragment in original datagram  |
| **Time to Live (TTL)**  | Limits hops, decrements at each router                   |
| **Protocol**            | Identifies upper-layer protocol (e.g., TCP, UDP)         |
| **Header Checksum**     | Verifies header integrity, recalculated at each router   |
| **Source Address**      | 32-bit field, IP address of the sender                   |
| **Destination Address** | 32-bit field, IP address of the receiver                 |
| **Options**             | Variable, up to 40 bytes, used for testing and debugging |

### Maximum Transfer Unit (MTU)

**Key Points:**

- **MTU Variance:** Different for LAN (typically 1500 bytes) and WAN.
- **Fragmentation:** Occurs if datagram size exceeds MTU, reassembled only at the destination.

### Fragmentation

**Key Points:**

- **Process:** Dividing datagram into fragments, can be done by source or routers.
- **Reassembly:** Done only by the destination host.
- **Flags:**
  - **D bit:** Do not fragment (1 means no fragmentation)
  - **M bit:** More fragments (1 means more fragments follow)

### Time-to-Live (TTL)

**Key Points:**

- **Field:** Limits the number of hops a datagram can take.
- **Purpose:** Prevents indefinite circulation due to routing errors.

### Header Checksum

**Key Points:**

- **Verification:** Only the header, not the payload.
- **Recalculation:** Needed at each router due to changes in fields like TTL.

### Options Field

**Key Points:**

- **End of Option:** Padding at the end of the option field.
- **Record Route:** Records routers handling the datagram.
- **Strict Source Route:** Predetermines a strict route for the datagram.
- **Loose Source Route:** Predetermines a flexible route, allowing other routers.
- **Timestamp:** Records time of datagram processing by routers.

**Variable Part Options:**

| Option                        | Description                                                  |
| ----------------------------- | ------------------------------------------------------------ |
| **End of Option**       | 1-byte option for padding                                    |
| **Record Route**        | Records up to nine router addresses for debugging/management |
| **Strict Source Route** | Predetermines a strict route for the datagram                |
| **Loose Source Route**  | Predetermines a flexible route                               |
| **Timestamp**           | Records processing time in milliseconds                      |

### IPv6 Overview

**Packet Structure:**

- **Base Header:** Contains essential information.
- **Payload:** Comprises two parts:
  - **Optional Extension Header**
  - **Upper Layer Data**

**Base Header Fields:**

1. **Version:** (4 bits) Always set to 6 for IPv6.
2. **Priority:** (4 bits) Defines packet priority during congestion.
3. **Flow Label:** (3 bytes) Facilitates special handling of data flow.
4. **Payload Length:** (2 bytes) Length of the payload excluding the base header.
5. **Next Header:** (8 bits) Identifies the following header in the packet.
6. **Hop Limit:** (8 bits) Similar to TTL in IPv4.
7. **Source Address:** (16 bytes) IP address of the packet's origin.
8. **Destination Address:** (16 bytes) IP address of the packet's destination.

**IPv4 vs. IPv6:**

1. **Address Length:**
   - IPv4: 32-bit (4 bytes)
   - IPv6: 128-bit (16 bytes)
2. **Address Notation:**
   - IPv4: Decimal (e.g., 192.168.1.1)
   - IPv6: Hexadecimal (e.g., 2001:0db8:85a3:0000)
3. **Number of Addresses:**
   - IPv4: ~4.3 billion
   - IPv6: ~340 undecillion
4. **Configuration:**
   - IPv4: Manual or DHCP
   - IPv6: SLAAC or DHCPv6
5. **Security:**
   - IPv4: Added later as extensions
   - IPv6: Built-in support for IPsec

**Advancements in IPv6:**

- **Larger Address Space:** Accommodates virtually unlimited unique addresses.
- **Simplified Header:** Enhances routing efficiency.
- **Improved Multicast:** Conserves bandwidth via multicast addressing.
- **No NAT Required:** Simplifies end-to-end connections.
- **Enhanced Mobility and Security:** Better support for modern requirements.

### Additional Protocols

**ARP (Address Resolution Protocol):**

- Maps IP addresses to link-layer addresses.
- Used when a host/router needs to find the link-layer address of another host/router.
- Process:
  1. Send ARP request packet (broadcast).
  2. Intended recipient sends back ARP response (unicast).

**RARP (Reverse Address Resolution Protocol):**

- Finds the logical IP address for a machine knowing only its physical address.
- Useful for diskless machines that need to discover their IP address at boot time.
- Process:
  1. Send RARP request (broadcast).
  2. RARP server replies with the IP address.

**ICMP (Internet Control Message Protocol):**

- Addresses deficiencies in IP regarding error control and queries.
- Types of Messages:
  - **Error-Reporting Messages:** Report problems encountered during packet processing (e.g., Time Exceeded, Parameter Problem, Destination Unreachable, Redirection).
  - **Query Messages:** Help diagnose network issues (e.g., Echo Request and Reply, Router Solicitation and Advertisement, Address-Mask Request and Reply, Timestamp Request and Reply).

**IGMP (Internet Group Management Protocol):**

- Supports multicasting (one-to-many communication).
- Applications include video-on-demand and distance learning.

### Congestion Control

**Congestion Control Mechanisms:**

- **Open-Loop Congestion Control:** Prevents congestion before it happens (e.g., Retransmission policy, Window policy, Acknowledgement policy).
- **Closed-Loop Congestion Control:** Manages congestion after it occurs (e.g., Backpressure, Choke packet, Implicit signaling, Explicit signaling).

**Algorithms:**

**Leaky Bucket Algorithm:**

- Smooths out bursty traffic by outputting packets at a constant rate.
- Handles variable length packets by managing a counter and a FIFO queue.

**Token Bucket Algorithm:**

- Controls data rate using tokens added to a bucket at a fixed rate.
- Allows bursts of data until tokens are depleted, providing more flexibility than the leaky bucket.

# IPv4 Addresses

## Overview

- **Length:** 32 bits, resulting in a maximum of 2^32 addresses (over 4 billion devices).
- **Restrictions:** The actual usable number is less due to certain reserved addresses.

## Need for More Addresses

- **IPv6:** Introduced to address the limitations of IPv4, using 128-bit addresses, allowing for 3.4 * 10^38 addresses.

## Unique and Universal

- **Uniqueness:** Each address uniquely defines a connection.
- **Universality:** IPv4 addresses are universally accepted for devices connecting to the Internet.

## Notations

- **Binary Notation:** IPv4 address displayed as 32 bits (e.g., `01110101 10010101 00011101 00000010`).
- **Dotted-Decimal Notation:** More compact form, with each byte separated by a dot (e.g., `117.149.29.2`).

## Classful Addressing

- **Concept:** IPv4 addresses initially used classes: A, B, C, D, and E.
- **Structure:** Divided into a prefix (NetworkID) and suffix (HostID).

### Class A

- **NetID:** 8 bits
- **HostID:** 24 bits
- **Identification:** First bit is 0
- **Range:** [0, 127]
- **Reserved Addresses:** `0.0.0.0` for broadcasting, `127.0.0.1` for loopback

### Class B

- **NetID:** 16 bits
- **HostID:** 16 bits
- **Identification:** First two bits are 10
- **Range:** [128, 191]

### Class C

- **NetID:** 24 bits
- **HostID:** 8 bits
- **Identification:** First three bits are 110
- **Range:** [192, 223]

### Class D

- **Purpose:** Multicasting
- **Identification:** First four bits are 1110
- **Range:** [224, 239]

### Class E

- **Purpose:** Future/experimental use
- **Identification:** First four bits are 1111
- **Range:** [240, 255]

## Casting in Networks

- **Unicast:** One-to-one transmission.
- **Broadcast:** One-to-all transmission.
  - **Limited Broadcast:** Within the same network (255.255.255.255).
  - **Direct Broadcast:** From one network to another.
- **Multicast:** One-to-many transmission.

## Subnetting

- **Reason:** Improves security and simplifies maintenance for large networks.
- **Types:** Fixed Length and Variable Length.
- **Subnet Masks:** Identifies the subnet within a network.
  - **Class A:** 255.0.0.0
  - **Class B:** 255.255.0.0
  - **Class C:** 255.255.255.0

## Address Depletion

- **Issues:** Inefficient distribution, leading to rapid exhaustion of available addresses.

## Classless Addressing (CIDR)

- **Improvement:** Removes class restrictions, allowing for more flexible address allocation.
- **CIDR Notation:** Uses a slash (/) to denote the prefix length (e.g., `192.168.1.0/24`).
- **Calculations:**
  - **Number of Addresses:** `N = 2^(32-n)`
  - **First Address:** Set the (32-n) rightmost bits to 0.
  - **Last Address:** Set the (32-n) rightmost bits to 1.

### Routing

- **Definition**: When a router receives an IP packet, it uses a routing table to decide the appropriate interface to send the packet to reach its destination.
- **Routing Table**: Contains information about the network and helps in deciding the interface for sending packets.
  - **Static Routing**: Manually entered routing information.
    - Pros: Simple, low overhead.
    - Cons: Not feasible for large, dynamic networks like the internet.
  - **Dynamic Routing**: Automatically updated routing information.
    - Pros: Adapts to changes in the network.
    - Cons: More complex, requires more resources.

### Flooding

- **Definition**: A method where a packet is sent to all possible paths instead of calculating the shortest path.
- **Advantages**:
  - No routing algorithm required.
  - Shortest path is guaranteed.
  - Highly reliable.
- **Disadvantages**:
  - High traffic.
  - Duplicate packets may arrive at the destination and intermediate routers.

### Unicast Routing Protocols

- **Purpose**: Facilitate dynamic routing by enabling routers to inform each other of changes.
- **Function**: Allows routers to share information about the network, including failures and topology changes.

### Intra-domain and Interdomain Routing

- **Intra-domain Routing**: Routing within an autonomous system (AS).
- **Interdomain Routing**: Routing between autonomous systems.
- **Autonomous System (AS)**: A group of networks and routers under a single administration.

### Distance Vector Routing

- **Definition**: Uses a vector (table) of minimum distances to every node to determine the least-cost route.
- **Key Concepts**:
  - Sharing information between neighbors.
  - Nodes send their entire table to neighbors, who then decide what to use.
  - Periodic and triggered updates.

### Link State Routing

- **Definition**: Each node has the entire topology of the domain and uses Dijkstra's algorithm to build a routing table.
- **Key Concepts**:
  - Creation and dissemination of Link State Packets (LSP).
  - Formation of shortest path trees.
  - Calculation of routing tables based on shortest path trees.

### Difference between Distance Vector Routing (DVR) and Link State Routing (LSR)

- **DVR**:
  - Shares local knowledge.
  - Less bandwidth requirement.
  - Based on Bellman-Ford Algorithm.
  - Converges slowly.
  - Can count to infinity.
  - Example: RIP.
- **LSR**:
  - Shares global knowledge.
  - Higher bandwidth requirement.
  - Based on Dijkstra’s Algorithm.
  - Converges faster.
  - No count to infinity.
  - Example: OSPF.

### Split Horizon

- **Definition**: Prevents routing loops by not advertising a route back to the router from which it was learned.
- **Function**: Reduces routing confusion and helps stabilize the network.

### Building Routing Tables in Link State Routing

1. **Creation of LSPs**: Each node creates a packet representing the state of its links.
2. **Dissemination of LSPs**: LSPs are flooded throughout the network.
3. **Formation of Shortest Path Tree**: Each node uses Dijkstra's algorithm.
4. **Calculation of Routing Tables**: Based on the shortest path tree.

### Dijkstra's Algorithm

- **Process**:
  1. Nodes are divided into tentative and permanent sets.
  2. Neighbors of a current node are made tentative and examined.
  3. Nodes that pass criteria are made permanent.
  4. The cumulative cost from the root to each node is calculated.

### Count to Infinity Problem

- **Issue**: In distance-vector routing, broken links are not immediately recognized as infinity, leading to slow convergence.


## Transport Layer Services

### Overview

- **Network Layer Responsibility**: Manages communication between hosts (host-to-host communication) but only delivers messages to the destination computer, not the specific process.
- **Transport Layer Responsibility**: Delivers the message to the correct process, providing end-to-end or process-to-process communication.

### Types of Transport Layer Protocols

- **Connectionless Protocol**: Treats each segment as an independent packet and delivers it to the transport layer at the destination.
- **Connection-Oriented Protocol**: Establishes a connection with the transport layer at the destination before delivering packets and terminates the connection after data transfer.

### Reliability

- **Reliable Protocols**: Implement flow and error control, offering slower but more reliable services (e.g., TCP, SCTP).
- **Unreliable Protocols**: Do not implement flow and error control, suitable for fast or real-time applications that do not require reliability (e.g., UDP).

### Common Transport Layer Protocols

- **UDP**: Connectionless and unreliable.
- **TCP**: Connection-oriented and reliable.
- **SCTP**: Connection-oriented and reliable, supporting multiple streams within a single connection.

### Addressing: Port Numbers

- **Port Numbers**: 16-bit integers ranging from 0 to 65535, identifying processes within a host.
- **Port Ranges**:
  - **Well-Known Ports (0-1023)**: Assigned and controlled by IANA.
  - **Registered Ports (1024-49151)**: Not assigned or controlled by IANA but can be registered.
  - **Dynamic/Ephemeral Ports (49152-65535)**: Neither controlled nor registered, used by any process and typically chosen randomly by the client.

### Socket Addresses

- **Definition**: Combination of an IP address and a port number.
- **Usage**: Required at both ends to make a connection, forming client and server socket addresses.

### Encapsulation and Decapsulation

- **Encapsulation**: At the sender site, the transport layer adds a header to the message, creating segments.
- **Decapsulation**: At the receiver site, the transport layer removes the header and delivers the message to the application layer process.

## TCP (Transmission Control Protocol)

### Virtual Connection

- **Stream of Bytes**: Allows sending and receiving processes to handle data as a continuous stream, simulating a direct connection.

### Control Mechanisms

- **Flow Control**: Prevents the receiver from being overwhelmed by controlling the amount of data sent.
- **Error Control**: Ensures reliable service by detecting and retransmitting lost or corrupted segments.
- **Congestion Control**: Adjusts the amount of data sent based on network congestion levels.

### TCP Header

- **Header Size**: 20 to 60 bytes, depending on options.
- **Fields**:
  - **Source and Destination Port Addresses**: 16-bit fields for the sending and receiving application ports.
  - **Sequence Number**: 32-bit field, ensuring data integrity and order.
  - **Acknowledgment Number**: 32-bit field, confirming receipt of data.
  - **Header Length**: 4-bit field indicating the header size.
  - **Checksum**: 16-bit field for error-checking.
  - **Window Size**: 16-bit field for flow control, indicating the size of the receiver's buffer.
  - **Control Flags**: 6 bits for controlling data flow and connection states.
  - **Urgent Pointer**: 16-bit field used with the urgent flag to handle urgent data.
  - **Push Flag (PSH)**: Indicates immediate delivery of data without waiting for buffer to fill.
  - **Reset Flag (RST)**: Terminates a problematic connection.

### TCP Connection

- **Three-Way Handshake**: Establishes a connection using SYN and ACK segments.
  1. **Client SYN**: Requests connection initiation.
  2. **Server SYN+ACK**: Acknowledges and responds.
  3. **Client ACK**: Confirms the connection.
- **Data Transfer**: After the handshake, bidirectional data transfer occurs.



Here’s a more organized version of the content with tables where necessary:

---

### **Transport-Layer Services**

- **Network Layer vs. Transport Layer**:

  - **Network Layer**: Handles host-to-host communication.
  - **Transport Layer**: Delivers messages to the correct process, providing end-to-end or process-to-process communication.
- **Types of Transport Layer Protocols**:

  - **Connectionless**: Each segment is independent.
  - **Connection-Oriented**: Establishes a connection before transferring data and terminates it afterward.
- **Reliability**:

  - **Reliable Protocol**: Includes flow and error control (e.g., TCP).
  - **Unreliable Protocol**: No flow and error control (e.g., UDP).
- **Common Transport Layer Protocols**:

  | Protocol | Type                | Reliability |
  | -------- | ------------------- | ----------- |
  | UDP      | Connectionless      | Unreliable  |
  | TCP      | Connection-Oriented | Reliable    |
  | SCTP     | Connection-Oriented | Reliable    |

---

### **Addressing: Port Numbers**

- **Port Number Ranges**:| Range            | Description                                       |
  | ---------------- | ------------------------------------------------- |
  | 0 to 1023        | Well-known ports (assigned by IANA)               |
  | 1024 to 49,151   | Registered ports (can be registered with IANA)    |
  | 49,152 to 65,535 | Dynamic/Ephemeral ports (used by client programs) |

---

### **Socket Addresses**

- **Definition**: Combination of IP address and port number used for transport layer services.

---

### **Encapsulation and Decapsulation**

- **Encapsulation**: At sender’s site, adds transport-layer header to the message.
- **Decapsulation**: At receiver’s site, removes transport-layer header and delivers the message.

---

### **TCP (Transmission Control Protocol)**

- **Characteristics**:

  - **Connection-Oriented**: Establishes a connection before data transfer.
  - **Reliable**: Ensures error control, flow control, and congestion control.
- **TCP Header**:

  | Field                             | Description                                                                   |
  | --------------------------------- | ----------------------------------------------------------------------------- |
  | Source & Destination Port Address | 16-bit fields defining port numbers                                           |
  | Sequence Number                   | 32-bit field for numbering bytes                                              |
  | Acknowledgment Number             | Cumulative acknowledgment number                                              |
  | Header Length                     | Indicates number of 4-byte words in header                                    |
  | Checksum                          | 16-bit field for error checking                                               |
  | Window Size/Advertisement Window  | Size of the receiver’s buffer (16 bits, optional 14 bits for larger windows) |
  | Control Flags                     | 6 bits used for flags like SYN, ACK, RST, etc.                                |
  | Urgent Pointer                    | Indicates urgent data when the urgent flag is set                             |
  | Push Flag (PSH)                   | Tells receiver to forward data immediately                                    |
- **Three-Way Handshake**:

  1. **SYN**: Client sends a SYN request.
  2. **SYN-ACK**: Server responds with SYN-ACK.
  3. **ACK**: Client acknowledges with ACK.

---

### **User Datagram Protocol (UDP)**

- **Characteristics**:

  - **Connectionless**: No connection establishment or termination.
  - **Unreliable**: No guaranteed delivery, flow control, or error control.
- **UDP Packet (User Datagram) Structure**:

  | Field            | Description                              |
  | ---------------- | ---------------------------------------- |
  | Source Port      | 16-bit field for source port number      |
  | Destination Port | 16-bit field for destination port number |
  | Length           | Total length of datagram (header + data) |
  | Checksum         | Optional 16-bit field for error checking |
- **UDP Services**:

  | Service                          | Description                                |
  | -------------------------------- | ------------------------------------------ |
  | Process-to-Process Communication | Uses socket addresses (IP + port)          |
  | Connectionless Services          | Independent datagrams, no connection setup |
  | Flow Control                     | No flow control mechanisms                 |
  | Error Control                    | Only optional checksum                     |
  | Congestion Control               | No congestion control                      |
- **Applications**:

  | Application            | Description                                             |
  | ---------------------- | ------------------------------------------------------- |
  | TFTP                   | Trivial File Transfer Protocol                          |
  | Multicasting           | Efficient for multicast transmissions                   |
  | SNMP                   | Simple Network Management Protocol                      |
  | RIP                    | Routing Information Protocol                            |
  | Real-Time Applications | Suitable for applications needing real-time performance |

---

### **Comparison: TCP vs. RTP**

| Feature               | TCP                               | RTP                              |
| --------------------- | --------------------------------- | -------------------------------- |
| Full Name             | Transmission Control Protocol     | Real-Time Transport Protocol     |
| Loss                  | Lossless                          | Tolerates packet loss            |
| Speed                 | Slower                            | Faster                           |
| Real-Time Suitability | Not ideal for real-time streaming | Designed for real-time streaming |

---

### **Data Compression**

- **Types**:
  | Type                 | Description                                  | Compression Ratio |
  | -------------------- | -------------------------------------------- | ----------------- |
  | Lossless Compression | No loss of information, lower ratio          | Lower             |
  | Lossy Compression    | Controlled loss of information, higher ratio | Higher            |
- **Components**:
  | Component | Description                            |
  | --------- | -------------------------------------- |
  | Encoder   | Compresses the data                    |
  | Decoder   | Decompresses and reconstructs the data |

---

### **Cryptography**

- **Symmetric Key Cryptography**:

  - **Definition**: Uses the same key for both encryption and decryption.
  - **Examples**:| Standard | Description                        |
    | -------- | ---------------------------------- |
    | DES      | Uses a 56-bit key, block cipher    |
    | AES      | More secure, standard block cipher |
- **Asymmetric Key Cryptography (Public-Key Cryptography)**:

  - **Definition**: Uses a pair of keys (public and private) for encryption and decryption.
  - **RSA Algorithm**:
    1. Choose large numbers \( p \) and \( q \), compute \( n \) and \( \phi(n) \).
    2. Select public exponent \( e \) and compute private exponent \( d \).
    3. Public key: \( (e, n) \); Private key: \( (d, n) \).
    4. Encrypt: \( C = (P^e) \mod n \); Decrypt: \( P = (C^d) \mod n \).

---

### **Block Cipher vs. Transposition Cipher**

| Feature      | Block Cipher                             | Transposition Cipher                               |
| ------------ | ---------------------------------------- | -------------------------------------------------- |
| Process      | Operates on blocks of plaintext          | Operates on individual letters                     |
| Error Impact | Errors in one block do not affect others | Errors affect the whole ciphertext                 |
| Speed        | Generally slower                         | Generally faster                                   |
| Security     | Depends on encryption function design    | Can be made more secure by multiple transpositions |

---

### **Application Layer**

- **Services Provided**:| Service                    | Description                        |
  | -------------------------- | ---------------------------------- |
  | Electronic Mail            | Email communication                |
  | File Access and Transfer   | Accessing and transferring files   |
  | Access to System Resources | Access to various system resources |
  | World Wide Web             | Browsing and accessing web content |
  | Network Management         | Managing network resources         |

# **Application Layer**

### **Electronic Mail (E-mail)**

- **Evolution:** Initially for text-based communication, now supports multimedia, multiple recipients, HTML, encryption, and integration with other services.
- **Message Transfer Agent (MTA):** Uses SMTP for sending emails between clients and servers.
- **Message Access Agent:** POP3 and IMAP4 for retrieving emails. POP3 downloads and optionally deletes emails, while IMAP4 supports server-side organization and partial downloads.
- **MIME:** Extends email to handle non-ASCII data (e.g., binary files, different languages).
- **Web-Based Mail:** Uses HTTP for accessing emails through web interfaces (e.g., Hotmail, Yahoo).

### **File Transfer**

- **FTP:** Protocol for transferring files using two connections (data and control). Port 21 for control and port 20 for data. Security issues require SSL for encryption (SSL-FTP).
- **TFTP:** Simple, UDP-based protocol for basic file transfers. Not secure or reliable for long-distance transfers.

### **World Wide Web (WWW)**

- **Architecture:** Distributed client-server model with web pages stored on servers and accessed via browsers.
- **Uniform Resource Locator (URL):** Identifies web pages using protocol, host, port, and path.
- **Cookies:** Allow stateful interactions by storing user information on the client side.

### **HTTP**

- **Hypertext Transfer Protocol (HTTP):** Retrieves web pages using TCP on port 80. Supports persistent and nonpersistent connections. HTTPS provides security by using SSL/TLS.

### **DNS (Domain Name System)**

- **Function:** Translates human-readable domain names into IP addresses.
- **Hierarchy:** Includes root name servers, top-level domain servers, and authoritative name servers.
- **Name Space:** Hierarchical with unique labels for each domain.

### **Telnet**

- **Protocol:** Text-based for remote server access on TCP port 23. Lacks encryption, making it less secure than alternatives like SSH.

### **ARPANET**

- **History:** Early packet-switched network that laid the groundwork for the Internet. Decommissioned in 1990.

### **X.25**

- **Protocol:** Old WAN protocol supporting error checking and virtual circuits. Replaced by faster technologies but influenced newer ones.

### **Simple Network Management Protocol (SNMP)**

- **Usage:** Manages and monitors network devices. Operates over UDP, interacting with MIBs for device control. Scalable with various security features.
