import java.util.Random;
//Tomes,Christopher
//12/2/2020
//this is the solution to number 2 on final.
//Program generates an array of size 10 then fills it with random values. 
//after which it will call continuousSumFind to find max sum and the correlated subArray.
public class ContinuousSum {

	public static void main(String[] args) 
	{
		
		//Generate an array of random values between -100 - 100
		Random rand = new Random();
		int [] arr = new int[10];
		for(int i = 0;i< arr.length;i++) {arr[i] = rand.nextInt(200)-100;}
        
		continuousSumFind(arr);
        
	}
	
    static void continuousSumFind(int arr[]) 
    { 
    	//Print out the input array.
    	System.out.print("Input: ");
        for(int i = 0;i < arr.length; i++) {
        	if(i != arr.length-1) {
        		System.out.print(""+arr[i]+",");
        	}else {
        		System.out.print(""+arr[i]);
        	}
        }
        System.out.println("");
        
        
        int largestSum = Integer.MIN_VALUE; //neg infinity initally and records out largestSum.
        int testSum = 0; //walks forward to determine if will produce new largersum.
        int trueFront=0; //front of sub array
        int front = 0;	//tests to see if new sub array we are looking at is valid.
        int back = 0; // end of sub array.
        
        //single loop over array 
        for (int i = 0; i < arr.length; i++) 
        { 
        	//if testSum resets we need a new front index.
        	if(testSum == 0){
        		front=i;	
        	}
        	//begin adding vals to testsum.
            testSum += arr[i];
            
            //if this generates a larger val, proceed to save val, begin/end of sub array.
            if (largestSum < testSum)
            {
                largestSum = testSum; 
            	back=i;
            	trueFront=front;
            }
            //reset testsum if the array fails to generate a valid new max sum.
            if (testSum < 0) 
            {
            	testSum = 0; 
            } 
        }
        //print subArray.
        System.out.print("Output: " + largestSum + " which is sequence: [");
        for(int i = trueFront;i <= back; i++) {
        	if(i != back) {
        		System.out.print(""+arr[i]+",");
        	}else {
        		System.out.print(""+arr[i]);
        	}
  
        	}
        System.out.print("]");
        }
        
        
    } 


	


