/*

1. **Computer Algorithms**: The Tower of Hanoi problem is frequently used to teach and understand recursion in computer science and programming courses. It serves as a classic example of a problem that can be elegantly solved using recursive techniques.

2. **Data Backup Strategies**: In data storage and backup systems, the Tower of Hanoi problem's principles are applied to devise efficient strategies for data movement and redundancy. It helps in optimizing disk operations and ensuring fault tolerance.

3. **Automated Manufacturing Processes**: In manufacturing systems where items need to be moved between different stages of production, the Tower of Hanoi problem can represent the movement of components or materials between machines or workstations. Optimizing these movements can lead to more efficient production processes.

4. **Telecommunications and Network Routing**: The Tower of Hanoi problem's concepts are utilized in designing algorithms for routing data packets through a network efficiently. Just as disks are moved between pegs in the puzzle, data packets are routed between network nodes while minimizing delays and congestion.

5. **Robotics and Motion Planning**: In robotics, the Tower of Hanoi problem serves as a simplified model for motion planning and obstacle avoidance. It helps in devising algorithms for robotic arms or autonomous vehicles to navigate through complex environments while avoiding collisions.

6. **Resource Allocation and Task Scheduling**: In resource management systems, such as job scheduling in operating systems or task allocation in distributed computing environments, the Tower of Hanoi problem's principles are applied to optimize resource utilization and minimize execution time.

Overall, while the Tower of Hanoi problem may appear theoretical at first glance, its underlying principles have practical applications in various fields, illustrating the significance of algorithmic problem-solving techniques in real-world scenarios.
 */


import java.util.*;

public class TOH_recursive {

    public static void main(String[] args) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " +
                    destination);
            return;
        }
        towerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " +
                destination);
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
}
