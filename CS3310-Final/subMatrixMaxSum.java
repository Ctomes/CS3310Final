//Tomes, Christopher
//12/04/1993
//Q4 this program will take a matrix of size NxN and process the data and find the submatrix with the largest sum. In cases
//where the largest sum is a single value the matrix will print a single element n the double array.

public class subMatrixMaxSum {

	public static void main(String[] args) {

		//our matrix to search.
		 int matrix[][] = new int[][]{ 
			 {-100, 2, -1, -4, -20, 21 },
             {-1, 2, -1, -4, -20, 21 },
             {-1, 12, 26, -4, -20, -92},
             {6, 2, -1, -40, 25, 21 },
             {-1, 99, -1, -4, -20, 21 },
             {10, 2, -1, -4, -20, 21 }};
             
             System.out.println("Matrix to be searched:");//print out matrix
             for(int j = 0;j<matrix[0].length;j++) 
             {
	        	 for(int i = 0;i<matrix.length;i++) 
	        	 {
	        		System.out.print("["+matrix[j][i]+"]"); 
	        	 }
	        	 System.out.println();
	         }

            
             findSumMax(matrix, 6);//find max sum and submatrix in Matrix passing the size of NxN matrix and the matrix itself.
		}


	 private static  void findSumMax(int[][] matrix, int sizeOfMatrix)
	 {
	     
	     
	     int tempMatrix[][] = new int[sizeOfMatrix+1][sizeOfMatrix];

	     for (int i = 0; i < sizeOfMatrix; i++) 
	     {
	         for (int j = 0; j < sizeOfMatrix; j++) 
	         {
	             tempMatrix[i + 1][j] = tempMatrix[i][j]+matrix[i][j];//generate a duplicate array that is larger to accommodate sums.
	         }
	     }
	     
	     int largestNum          = Integer.MIN_VALUE; //start at neg infinity for special cases.
	     int maximumSumSoFar     = 0;//store for maximum sum.
	     
	     //values we save for indexes of subarray with maximum sum. 
	     int finalStartRow       = 0;
	     int finalEndRow         = 0;
	     int finalStartColumn    = 0;
	     int finalEndColumn      = 0;
	     
	    for (int startRow = 0;startRow < sizeOfMatrix; startRow++) 
	     {//loop through rows
	         for (int currentRow = startRow; currentRow < sizeOfMatrix; currentRow++) 
	         {//probe foward
	             int runningSum = 0;
	             int startColumn = 0;
	             
	             for (int currentColumn = 0; currentColumn < sizeOfMatrix; currentColumn++) 
	             {//loop through column
	            	 if(largestNum < matrix[currentRow][currentColumn]) 
	            	 {//keep track of largest number in matrix for special case.
	            		 largestNum = matrix[currentRow][currentColumn];
	            	 }
	            	 
	                 runningSum = runningSum + tempMatrix[currentRow + 1][currentColumn] - tempMatrix[startRow][currentColumn];
	                 
	                 if (runningSum < 0) 
	                 {//resulting sum ended up being negative so reset.
	                     runningSum = 0;
	                     startColumn = currentColumn + 1;
	                 }
	                 else if (maximumSumSoFar < runningSum) 
	                 {// if the sum is larger save and update values.
	                     maximumSumSoFar = runningSum;
	                     finalStartRow = startRow;
	                     finalEndRow = currentRow;
	                     finalStartColumn = startColumn;
	                     finalEndColumn = currentColumn;
	                 }
	             }
	         }
	     }
	     
	     // Printing final values
	     if(maximumSumSoFar ==0) 
	     {
	    	 System.out.print("The maximum sum is " + largestNum); //if the largest sum is a single digit print out the largestnumber
	     }else 
	     {
	    	 System.out.println("\nThe maximum sum is " + maximumSumSoFar);

	         for(int j = finalStartRow;j<=finalEndRow;j++) 
	         {
	        	 for(int i = finalStartColumn;i<=finalEndColumn;i++) 
	        	 {
	        		System.out.print("["+matrix[j][i]+"]"); 
	        	 }
	        	 System.out.println();
	         }
	     }
	         
	    
	 }

}