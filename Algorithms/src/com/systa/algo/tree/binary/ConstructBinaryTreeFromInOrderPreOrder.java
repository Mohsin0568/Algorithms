package com.systa.algo.tree.binary;

public class ConstructBinaryTreeFromInOrderPreOrder {
	
	Node root; 
	static int preIndex = 0;
	
	public static void main(String args[]){ 
		ConstructBinaryTreeFromInOrderPreOrder tree = new ConstructBinaryTreeFromInOrderPreOrder(); 
        int in[] = new int[] { 2, 8, 6, 9, 5, 1, 7, 3 }; 
        int pre[] = new int[] { 5, 6, 8, 2, 9, 7, 1, 3 }; 
        int len = in.length; 
        Node root = tree.buildTree(in, pre, 0, len - 1); 
  
        // building the tree by printing inorder traversal 
        System.out.println("Inorder traversal of constructed tree is : "); 
        tree.printInorder(root); 
    }
	   
	void printInorder(Node node){ 
		if (node == null) 
			return; 
  
        /* first recur on left child */
        printInorder(node.getLeftChild()); 
  
        /* then print the data of node */
        System.out.print(node.getValue() + " "); 
  
        /* now recur on right child */
        printInorder(node.getRightChild()); 
	} 
	
	Node buildTree(int in[], int pre[], int inStrt, int inEnd){ 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.getValue()); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.setLeftChild(buildTree(in, pre, inStrt, inIndex - 1)); 
        tNode.setRightChild(buildTree(in, pre, inIndex + 1, inEnd)); 
  
        return tNode; 
    }
	
	int search(int arr[], int strt, int end, int value){ 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    }

}
