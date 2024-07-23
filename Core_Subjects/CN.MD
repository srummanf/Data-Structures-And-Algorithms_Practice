
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

---

This structure uses concise points and categorization for easier understanding and revision.
