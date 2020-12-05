import java.util.Random;
//Tomes,Christopher
//12/2/2020
//This program will generate 3 trees. one primary trees and 2 potential subtrees. The program will check A to see if it contains B and C.
public class checkIfSubTree {

	public static void main(String[] args) {

		boolean bInA;
		boolean cInA;
	    //generate tree
		/*
		 * 	    10
		 *    78   3
		 *  1   3 3  4
		 * 
		 * 
		 * 
		 */
		
	 	tree A = new tree();    
	    A.root				 = new node(10);
	 	A.root.right		 = new node(3);
	 	A.root.left  		 = new node(78);
	 	A.root.right.right   = new node(4);
	 	A.root.right.left    = new node(3);
	 	A.root.left.right    = new node(3);
	 	A.root.left.left     = new node(1);
	 	
	 	//generate tree that IS a subtree of A.
	 	/*
	 	 *    3
	 	 *   3 4
	 	 */
	 	
	 	tree B = new tree(); 
	 	B.root = new node(3); 
	    B.root.right = new node(4); 
	    B.root.left = new node(3); 
	    //generate tree that ISNT a subtree of A.
	    /*
	     *   16
	     * 3    4
	     *
	     */
	 	tree C = new tree(); 
	 	C.root = new node(16); 
	    C.root.right = new node(4); 
	    C.root.left = new node(3); 
	    
	    //find out if B and C is in A
	 	bInA = A.traverseAnode(A.root, B.root);
	 	cInA = A.traverseAnode(A.root, C.root);
	    
	 	
	 	//print results. 
	 	if(bInA) 
	 	{
	 		System.out.println("B is a subtree of A");
	 	}else {
	 		System.out.println("B is NOT a subtree of A");
	 	}
	 	if(cInA) 
	 	{
	 		System.out.println("C is a subtree of A");
	 	}else {
	 		System.out.println("C is NOT a subtree of A");
	 	}
		   
		
	}
	
}

