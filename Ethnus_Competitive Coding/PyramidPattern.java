// input:-
// n=5

// output:-
//     1
//    232
//   34523
//  4567234
// 567892345

// Pyramid Pattern

import java.util.*;
class PyramidPattern{
	public static void main(String[] args) {
        int n = 5;

        for(int row=0;row<n;row++){
            for(int col=0;col<n-row-1;col++){
                System.out.print(" ");
            }
            //System.out.println();
            
            // for(int col=0;col<2*row+1;col++){
            //     System.out.print(2*row+1);
            // }
            
            for(int col=0;col<row+1;col++){
                
                System.out.print(row+col+1);
            }
            
            for(int col=0;col<row;col++){

                System.out.print(col+2);
            }
            
            System.out.println();
        }
        


	}
}