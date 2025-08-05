// Java code to implement the approach

import java.lang.*;
import java.util.*;

class Test {

  // Function to count the minimum
  // number of splits
  public static int minimumSplits(int arr[], int n) {
    int totalSplits = 0;

    // Get the value at the last index
    int prevVal = arr[n - 1];

    for (int idx = n - 2; idx >= 0; idx--) {
      totalSplits += (arr[idx] - 1) / prevVal;
      int numGroups = ((arr[idx] - 1) / prevVal + 1);
      prevVal = arr[idx] / numGroups;
    }

    return totalSplits;
  }

  // Driver code
  public static void main(String[] args) {
    int arr[] = { 5, 6, 5, 7, 9 };
    int N = arr.length;

    int minSplit = minimumSplits(arr, N);
    System.out.print(minSplit);
  }
}







int, long, 
10^18 BigInteger

float, double, 

char 

String

boolean



Java __> their threading concurrency robust application_driven  
C++ __> Low level , memory mgt, fast, 

for(int i = 0 ; i< n; i++){

}

while(N >0){
  // CODE
}

do{

}while(n>0)

switch(ch){
  case 1:
    //code
    break;

  case 2:
    //code
    

  case 3:
    //code
    

    default:
      break;


}

// What is fall-through ??

// OOPS -- Encapsulation  ,  Abstraction  , Inheritance  , Polymorphism

Abstraction 

public int add(int a , int b){
  return a + b;
}

add(4,5); // return 9



Encapsulation -- Access modifiers -- public , private, protected 
public int add(int a , int b){
  return a + b;
}

add(4,5); // return 9



[ //module 

class A{
  private int add(int a , int b){
  return a + b;
}

public display(){
  print(add(6,4));
}
}


class B{
  public int add(int a , int b){
  return a + b;
}

public display(){
  print(add(6,4));
}
}


]

// className objectname  = new ClassName();
B ob1 = new B();

ob1.display();

// Polymorphism

Compile Time  __> Number of Parameters /// Types of Parameters /// Return type  -Method overloading

public int Ojas(int a, int b){
  return a+b;
}

public double Ojas(double a, int b){
  return a+b;
}

public float Ojas(double a, int b) throws Error{
  return (float)a+b;
}

1,3 // frontend aapka 1st nimber decimal hona chahiye

public int Ojas(int a, int b, int c){
  return a+b+c;
}


// Runtime polymorphism --- Overriding

class A{
  public void display(){
    // ojas
  }

  public void display2(){
    // ojas2
  }
}

class B{
  @Override
  public void display(){
    // negi
  }
}

B ob1 = new A();
ob1.display2(); --> negi






interface A{

  public int add(int a, int b){}; --> abstract functions // virtual functions
  public int subtract(int a, int b){};

}



interface --> class --> objects

if else

try {
 // code 
}
catch(Error){
  throw ArraysOutOfBound;
  throws

} finally {

}

Mathematical error, ArraysOutOfBound error


// COLLECTIONS

1. ArrayList  
2. LinkedList
3. HashSet
4. HashMap
5. Stack
6. Queue
7. PriorityQueue
8. TreeSet
9. TreeMap


Syntax : C<datatype> name = new C<>(); Integer, Float, Double, Character, String, Boolean
ArrayList<Integer> al = new ArrayList<>();
List<Integer> al = new ArrayList<>();
LinkedList<Integer> ll = new LinkedList<>();
Stack<Integer> stack = new Stack<>();
Queue<Integer> queue = new LinkedList<>();
DeQueue<Integer> dequeue = new DeQueue<>();
PriorityQueue<Integer> pq = new PriorityQueue<>();
HashSet<String> hashSet = new HashSet<>(); 
HashMap<Integer, Integer> hashMap = new HashMap<>(); // key , value

al.add(8);

stack.push(8)
int a = stack.pop()
int b = stack.top();

addFirst(4);
addLast(6);
deleteFirst();
deleteLast();

5,6,7,8,9,10

al.set(idx, value) // 3, 18 __> TLE 









