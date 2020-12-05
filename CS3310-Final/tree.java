class tree  
		{ //tree class
		    node root;
		   //this will traverse through tree B checking values against A.
		    boolean traverseBnode(node A, node B)  
		    { 

		    	
		        if (A == null && B == null)
		        {//roots terminate the same time
		        	return true;
		        }
		        else if (A == null) 
		        {//Main tree terminated first so B cant be in A 
		        	return false;
		        }
		        else if(A.val == B.val) 
		        {//vals are the same so check children nodes
		        	if(traverseBnode(A.left,B.left))//check left
		        	{
		        		return (traverseBnode(A.right,B.right));//left is valid so check right
		        	}
		        	else 
		        	{
		        		return false; //left was invalid so move on.
		        	}
		        }
		        else 
		        {
		        	return false;//vals are not the same so return false.
		        }
		        
		    } 
		   
		    //this will traverse A until it finds B tree. else returns false.
		    boolean traverseAnode(node A, node B)  
		    { 
		        if (B == null)
		        {
		        	return true;//empty tree is a subset of any tree
		        }
		        else if(A == null) 
		        {
		        	return false;//A is exhausted so return false. 
		        }
		        else if(traverseBnode(A, B))
		        {
		        	return true;//B is in A return true.
		        }
		        else 
		        {
		        	if(traverseAnode(A.left, B))//explore left of A for B
		        	{
		        		return true;
		        	}
		        	else 
		        	{
		        		return traverseAnode(A.right, B);//explore A right for B.
		        	}
		        }
		               
		    } 
		   
		  
		} 