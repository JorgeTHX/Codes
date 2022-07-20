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
public class Tree {
    Node root;
    
    public Tree(){
        this.root=null;
    }
    public Tree(int n){
        this.root=new Node(n);
    }
    /*public void printTree(){
        System.out.println(this.root);
        Node temp=this.root;
        while(true){
            if(temp.left!=null){
                System.out.println(temp.left);
                temp=temp.left;
            }else if(temp.left==null) break;
        while(true){
            if(temp.right!=null){
                System.out.println(temp.right);
                temp=temp.right;
            }else if(temp.right==null) break;    
            
        }
    }*/
    
     public void printTree(){
        if(root==null) 
            System.out.println("Tree is empty");
        else printTree(this.root);
    }
     
    public void printTree(Node temp){
        System.out.print(temp);
        if(temp.left!=null) 
            printTree(temp.left);
        if(temp.right!=null) 
            printTree(temp.right);
    }
    
    
    public void insertNodeNormal(int n){
        Node newNode=new Node(n);
        if(this.root==null){            
            this.root=newNode;
            return;
        }
        Node temp=this.root;
        while(true){
            if(n==temp.value) return;
            if(n<temp.value){
                if(temp.left==null){
                    temp.left=newNode;
                    return;
                }else temp=temp.left;
            }
            if(n>temp.value){
                if(temp.right==null){
                    temp.right=newNode;
                    return;
                }else temp=temp.right;
            }
        }
    }   
    public void insertNodeRecursiveCheck(int n){
        if(this.root==null){            
            this.root=new Node(n);
            return;
        }else insertNodeRecursive(this.root, n);
    }
    
    //recursive version
    public void insertNodeRecursive(Node temp, int n){
        if(n==temp.value) return;
        if(n<temp.value){
            if(temp.left==null){
                temp.left=new Node(n);
                return;
            }else insertNodeRecursive(temp.left, n);
        }
        if(n>temp.value){
            if(temp.right==null){
                temp.right=new Node(n);
                return;
            }else insertNodeRecursive(temp.right, n);
        }
    }
    
    public Node findNode(int n){        
        Node fn=this.root;
        while(true){
            if (n==fn.value){
                //System.out.println("Node "+fn.value+" found");
                return fn;
            }
            else if(n>fn.value && fn.right!=null){
                fn=fn.right;
            }
            else if(n<fn.value && fn.left!=null){
                fn=fn.left;
            }
            else{
                //System.out.println("The Node "+n+" is not in the tree");
                return null;
            }
        }
    }
    public void deleteNode(int n){
        Node temp=this.root;
        if(findNode(n)==null) System.out.println("The node is not here");
        if(findNode(n)!=null){
            while(true){
                if (temp.right!=null && n==temp.right.value){ 
                    if(temp.right.left!=null && temp.right.right!=null){
                        System.out.println("unable to delete"); break;
                    }
                    else if(temp.right.right!=null){
                        temp.right=temp.right.right; break;
                    }
                    else if(temp.right.left!=null){
                        temp.right=temp.right.left; break;
                    }
                    else{
                        temp.right=null; break;
                    }
                }else if (temp.left!=null && n==temp.left.value ){
                    if(temp.left.left!=null && temp.left.right!=null){
                        System.out.println("unable to delete"); break;
                    }
                    else if(temp.left.left!=null){
                        temp.left=temp.left.left; break;
                    }
                    else if(temp.left.right!=null){
                        temp.left=temp.left.right; break;
                    }
                    else{
                        temp.left=null; break;
                    }
                }
                else if(n>temp.value && temp.right!=null){
                    temp=temp.right;
                }
                else if(n<temp.value && temp.left!=null){
                    temp=temp.left;
                }
            }
        }        
    }
}
