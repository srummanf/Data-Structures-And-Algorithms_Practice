# Computer Networks Revision Guide

## Table of Contents

1. [Network Topology](#network-topology)
2. [OSI Model](#osi-model)
3. [TCP/IP Model](#tcpip-model)
4. [Routing Protocols](#routing-protocols)
   - [OSPF](#ospf)
   - [Dijkstra&#39;s Algorithm](#dijkstras-algorithm)
5. [IP Addressing](#ip-addressing)
   - [Classful Addressing](#classful-addressing)
   - [Classless Addressing (CIDR)](#classless-addressing-cidr)
6. [Subnetting and Masking](#subnetting-and-masking)
7. [Miscellaneous Topics](#miscellaneous-topics)

---

## Network Topology

- **Bus Topology**: All devices share a single communication line.
- **Star Topology**: All devices connect to a central hub.
- **Ring Topology**: Each device connects to two other devices, forming a circular pathway.
- **Mesh Topology**: Devices are interconnected, providing multiple paths for data.
- **Hybrid Topology**: Combination of two or more different topologies.

## OSI Model

1. **Physical Layer**: Transmits raw bit stream over the physical medium.
2. **Data Link Layer**: Provides node-to-node data transfer and error detection.
3. **Network Layer**: Handles logical addressing and routing (IP).
4. **Transport Layer**: Ensures end-to-end communication, error recovery (TCP/UDP).
5. **Session Layer**: Manages sessions between applications.
6. **Presentation Layer**: Translates, encrypts, and compresses data.
7. **Application Layer**: Interfaces with the user and provides network services.

   ![1721147314653](image/ComputerNetworks/1721147314653.png)

   ![1721147374840](image/ComputerNetworks/1721147374840.png)

![1721147408599](image/ComputerNetworks/1721147408599.png)


#### **Application Layer**

The Application layer is the topmost layer of the OSI model. This layer is mostly used by the network applications, that use the network. It mainly acts as an interface between the user and the network services. The Application layer provides services for network applications with the help of protocols. Some of the most widely used application layer protocols are **HTTP, HTTPS, FTP, NFS, DHCP, FMTP, SNMP, SMTP, Telnet**, etc.

> ***Following are the main functionalities of an application layer:***

1. File Transfer: The Application layer mainly facilitates the file transfer between two network devices with the help of FTP(File Transfer Protocol).
2. Web Surfing: Web surfing is possible only in the application layer. Some protocols like HTTP(Hypertext Transfer Protocol), HTTPs(Hypertext Transfer Protocol Secure), etc. enables web surfing.
3. Emails: Electronic-mails can be sent from one device to another on the network only through the application layer. Some protocols like SMTP(Simple Mail Transfer Protocol), etc. are used for sending emails over the network.
4. Network Virtual Terminal: The Application layer facilitates the remote host login in the network with the help of protocols like Telnet, etc. It can also be referred to as the software version of the physical terminal in the network.

![1721147421144](image/ComputerNetworks/1721147421144.png)


#### **Presentation Layer**

The Presentation layer is the sixth layer of the OSI model. It mainly performs data translation, encryption & decryption, and compression in the network. 

At the sender's side, it receives the data from the application layer and performs data encryption and compression to it. At the receiver's side, it receives the data from the transport layer and performs data translation, decryption, and uncompresses data.

> ***Following are the main functionalities of a presentation layer:***

1. Data Translation: Data translation refers to transforming data from one form to the other. The presentation layer transforms the high-level user language data to the equivalent low-level machine-level language, and vice versa. Some of the standards used by this layer for translation are ASCII, EBCDIC, etc.
2. Data Encryption and Decryption
3. Data Compression: Data compression is the process of reducing the number of bits in the data. It can either be lossy or lossless in nature.

![1721147437985](image/ComputerNetworks/1721147437985.png)

#### **Session Layer**

The Session layer is the fifth layer of the OSI model. It mainly helps in setting up, closing and managing the connection in the network. Actually, whenever two devices get connected, a session is created, which is terminated as soon the connection is no longer required. The termination of the session is important to avoid the unnecessary wastage of resources. In other words, the session layer performs session management.

The session layer enables the devices to send and receive the data by establishing connections and also terminates the connection after the data transfer. It mainly performs authentication and authorization for establishing a secure connection in the network.

> ***Following are the main functionalities of a session layer:***

1. Authentication: Authentication is a process of verifying the user. The session layer may ask the devices to enter valid login credentials, so as to maintain a secure data connection.
2. Authorization: Authorization is the process of determining the user's authority to access the data. The session layer determines whether the device has permission to access those data elements or not.
3. **Synchronization: **The session layer synchronizes the sender and receiver. It adds various checkpoints with the data to synchronize data at the sender's and receiver's side. In case of any crash or transfer failure, the data transmission can be resumed from the last checkpoint. There is no need to retransfer the whole data.

![1721147455777](image/ComputerNetworks/1721147455777.png)


#### **Transport Layer**

**The Transport layer is the fourth layer of the OSI model. It is mainly responsible for the process-to-process delivery of the data. ****It performs flow and error control in the data for its proper transmission. **The transport layer controls the reliability of communication through various functionalities.

At the sender's side, the transport layer receives the data from the upper layer and performs segmentation. The source and destination port numbers are also included in the header file of the data before forwarding it to the network layer. At the receiver's side, the transport layer performs the reassembly and sequencing of data. It reads the port number of the data from the header file, and then direct it towards the proper application.

> ***Following are the main functionalities of a network layer:***

1. **Segmentation: **Dividing the data received into multiple data segments can be termed as segmentation. The transport layer performs the assembly as well as reassembly of data at the sender's and receiver's side respectively. Each segment has the source and destination 'port' and 'sequence' number. The port number helps to direct each data segment to the correct application, while the sequence number keeps them in a correct sequence when the segmented data is received at the receiver's side.
2. **Flow Control: **The transport layer controls the flow of the data being transmitted. It is mainly done to avoid any data loss and enhance data transmission efficiency.
3. **Error Control: **The transport layer checks for any kind of errors in the data using the checksum bits that are present in the data header. It can also request for retransmission of some data if it is not received at the receiver's end.
4. **Connection Control: **The transport layer also maintains the connection between the devices in a proper way. For connection-oriented transmission, TCP(Transmission Control Protocol) is used. TCP is quite slow but is reliable in nature. It can be used for long-distance transmissions. For connection-less transmission, UDP(User Datagram Protocol) is used. UDP is fast but not reliable in nature. It is mainly preferred for short-distance transmissions.

![1721147475898](image/ComputerNetworks/1721147475898.png)


#### **Network Layer**

**The Network layer is the third layer of the OSI model. It mainly performs the transmission of data from one computer to another in different networks. **This layer may not be so beneficial if we are transmitting the data in the same network. **The network layer performs logical addressing(IP addressing) of the data. **The source and destination IP addresses are included in the data header file by the network layer. The data is in the form of packets in this layer.

At the sender side, the network layer breaks the data segments received from the upper layer into smaller units, called data packets. Similarly, at the receiver's side, it reassembles the data packets into segments for the upper layer, i.e., the transport layer. [Routers ](https://afteracademy.com/blog/what-are-routers-hubs-switches-bridges)are mainly used in the network layer for routing purposes. Some of the protocols that are mostly used in this layer are OSPF(Open Shortest Path First), BGP(Border Gateway Protocol), IS-IS(Intermediate System to Intermediate System), etc.

> ***Following are the main functionalities of a network layer:***

1. **Logical Addressing: **Every computer in a network has a unique IP(Internet Protocol) address. The network layer attaches the source and destination IP address to the data so that it can be transmitted even in different networks. Internet Protocol Version 4(IPv4) and Internet Protocol Version 6(IPv6) addressing are used by the network layer for logical addressing.
2. **Routing: **Routing is a process through which the data packets can travel from one node to another in a computer network. In the network layer, the routing decisions are mainly based on IP addresses or logical addressing.
3. **Path Determination: **Path determination is the process of selecting a path from various available paths based on the routing information. Path determination is done by the network layer for finding the most optimum path for data transmission.

![1721147493957](image/ComputerNetworks/1721147493957.png)


#### Data-Link Layer

**The Data-Link Layer is the second layer of the OSI model. It performs the physical addressing of data. **Physical addressing is the process of adding the physical(MAC) address to the data. MAC(Media Access Control) Address is a 48-bit alpha-numeric number that is embedded in NIC(Network Interface Card) by the manufacturer. In other words, the data-link layer is embedded as software in the NIC which provides a means for data transfer from one computer to another via a local media. Thus, the data-link layer facilitates the transmission of data within the same network only.

The source and destination MAC addresses are included in the data header file by the data-link layer. At the sender's side, it receives the data in the form of packets from the network layer and converts it into smaller forms, called the data frame. At the receiver's side, it converts the data frame into packets for the network layer.

> **Following are the main functionalities of a data-link layer:**

1. **Allows media access using framing: **It allows the upper layers to access the media using framing, as it performs physical addressing of the data.
2. **Controls data: **It performs flow, error, and access control of the data. It controls the data rate of the transmission to control the data flow. It uses the header information or checksum bits to control the error. Most importantly, it performs access control of the data using the MAC address.

![1721147509767](image/ComputerNetworks/1721147509767.png)

#### Physical Layer

**The Physical Layer is the lowest layer of the OSI model and it deals with data in the form of bits or signals. **The type of signal being generated depends upon the transmission medium. For example, if we are using copper wire or LAN cable, the output signal will be an electrical signal. Likewise, the output signal will be a light signal for optical fibre cable, and radio signal for air as a transmission medium.

At the sender's side, the physical layer will get the data from the upper layer and convert it into bitstreams(0's and 1's) and send it through a physical channel. At the receiver's side, it will convert the bitstreams into frames to be passed to the data-link layer.

> **Following are the functionalities of a physical layer:**

1. It defines the transmission media between two connecting devices.
2. It also specifies the data rate(number of bits sent each second) over the defined media.
3. It defines the [topology of the network ](https://afteracademy.com/blog/what-is-network-topology-and-types-of-network-topology). The topology may be Bus, Ring, Star, Mesh, Tree, or Hybrid.
4. It defines a [data transmission mode ](https://afteracademy.com/blog/what-are-the-data-transmission-modes-in-a-network). It can be Simplex, Half-Duplex, or Duplex.
5. It defines the type of data encoding used in the transmission.
6. It defines the line configuration of the network. It can be point-to-point or multiport.

![1721147568044](image/ComputerNetworks/1721147568044.png)

## TCP/IP Model

- **Application Layer**: Corresponds to the OSI Application, Presentation, and Session layers.
- **Transport Layer**: Corresponds to the OSI Transport layer (TCP/UDP).
- **Internet Layer**: Corresponds to the OSI Network layer (IP).
- **Network Access Layer**: Corresponds to the OSI Physical and Data Link layers.

## Routing Protocols

### OSPF (Open Shortest Path First)

- **Link-state routing protocol**.
- **Uses Dijkstra's algorithm** to find the shortest path.
- **Supports hierarchical routing** with areas to optimize large networks.
- **Rapid convergence** and **multicast** for routing updates.

### Dijkstra's Algorithm

- **Algorithm** to find the shortest paths between nodes in a graph.
- **Steps**:
  1. Initialize distances.
  2. Set the initial node as current.
  3. Calculate tentative distances to neighboring nodes.
  4. Update shortest paths.
  5. Mark the current node as visited.
  6. Select the next unvisited node with the smallest tentative distance.
  7. Repeat until all nodes are visited.

## IP Addressing

### Classful Addressing

- **Class A**: `0.0.0.0 - 127.255.255.255` (Default subnet mask: `255.0.0.0`).
- **Class B**: `128.0.0.0 - 191.255.255.255` (Default subnet mask: `255.255.0.0`).
- **Class C**: `192.0.0.0 - 223.255.255.255` (Default subnet mask: `255.255.255.0`).
- **Class D**: `224.0.0.0 - 239.255.255.255` (Multicast).
- **Class E**: `240.0.0.0 - 255.255.255.255` (Experimental).

### Classless Addressing (CIDR)

- **CIDR Notation**: IP address followed by a slash and the number of significant bits (e.g., `192.168.1.0/24`).
- **Efficient use** of IP addresses.
- **Eliminates the waste** of IP addresses seen in classful addressing.

## Subnetting and Masking

- **Subnet Mask**: Determines the network and host portions of an IP address.
- **Example**: `192.168.1.0/24` (Subnet mask: `255.255.255.0`).
- **Calculating Subnets**:
  - **Number of Subnets**: `2^n` (where `n` is the number of bits borrowed from the host portion).
  - **Number of Hosts per Subnet**: `2^(remaining bits) - 2` (accounting for network and broadcast addresses).

## Miscellaneous Topics

- **NAT (Network Address Translation)**: Maps private IP addresses to a public IP address.
- **DHCP (Dynamic Host Configuration Protocol)**: Automatically assigns IP addresses to devices.
- **DNS (Domain Name System)**: Resolves domain names to IP addresses.
- **VLAN (Virtual Local Area Network)**: Creates separate broadcast domains within a single physical network.
- **Firewall**: Monitors and controls incoming and outgoing network traffic based on security rules.

---

### Study Tips

- **Understand key concepts** rather than memorizing.
- **Practice with real-world scenarios** and network simulations.
- **Review past interview questions** related to computer networks.
