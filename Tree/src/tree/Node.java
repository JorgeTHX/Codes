/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author jorge
 */
public class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
    
    public String toString(){
        String left="null";
        String right="null";
        if(this.left!=null) left=""+this.left.value;
        if(this.right!=null) right=""+this.right.value;
        return "Value: "+this.value+" Left: "+left+" Right: "+right+"\n";
    }
}
