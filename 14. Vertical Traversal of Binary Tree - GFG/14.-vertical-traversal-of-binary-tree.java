// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
     ArrayList <Integer> verticalOrder(Node root)
   {
       Map<Node,Integer> map=new LinkedHashMap<>();
       ArrayList<Integer> result=new ArrayList<>();
       Map<Integer,LinkedList<Integer>> tmap=new TreeMap<>();
       LinkedList<Node> queue=new LinkedList<>();
       queue.add(root);
       map.put(root,0);
       while(!queue.isEmpty()){
           Node temp=queue.removeFirst();
           if(temp.left!=null){
               queue.add(temp.left);
               map.put(temp.left,map.get(temp)-1);
           }
           if(temp.right!=null){ 
               queue.add(temp.right);
               map.put(temp.right,map.get(temp)+1);
           }
       }
       LinkedList<Integer> ll=new LinkedList<>();
       for(Node x:map.keySet()){
           if(!tmap.containsKey(map.get(x))){
               ll=new LinkedList<Integer>();
               ll.add(x.data);
               tmap.put(map.get(x),ll);
           }
           else{
               ll=tmap.get(map.get(x));
               ll.add(x.data);
               tmap.put(map.get(x),ll);
           }
       }
       for(Integer x:tmap.keySet()){
           LinkedList<Integer> temp=tmap.get(x);
           int size=temp.size();
           for(int i=0;i<size;i++){
               result.add(temp.get(i));
           }
       }
       return result;
        // add your code here
    }
}