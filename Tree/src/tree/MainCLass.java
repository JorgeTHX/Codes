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
public class MainCLass {
    public static void main(String[] args) {
        System.out.println("TREE APP");
        long startTime;
        long elapsedTime;
        
        int size = 100000;
        int searches = 100000;
        
        Tree t= new Tree();
        int[] arr = new int [size];
        
        /*t.insertNodeRecursiveCheck(50);
        t.insertNodeRecursiveCheck(70);
        t.insertNodeRecursiveCheck(80);
        t.insertNodeRecursiveCheck(75);
        t.insertNodeRecursiveCheck(6);
        t.insertNodeRecursiveCheck(20);
        t.insertNodeRecursiveCheck(4);
        t.insertNodeRecursiveCheck(5);*/
        
       
        
        /*for (int i=0; i<size; i++){
            t.insertNodeRecursiveCheck((int)(Math.random()*size));               
            }*/
        
        for (int i=0; i<size; i++){
            arr[i]=((int)(Math.random()*size));                
            }
        
        /*for (int i=0; i<size; i++){
            System.out.println(arr[i]);
        }*/
         //t.printTree();
         
        
        
        

        startTime = System.nanoTime();
        for (int i=0; i<size; i++){
                t.insertNodeRecursiveCheck((int)(Math.random()*size));               
        }
        System.out.println("Tree created");
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = "+elapsedTime/1000000+" ms");
        
        System.out.println("");
        
        startTime = System.nanoTime();
        for(int i=0; i<searches; i++){
            t.findNode((int)(Math.random()*size));
        }
        System.out.println("Nodes found");
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = "+elapsedTime/1000000+" ms");
        
        System.out.println("");
        
        startTime = System.nanoTime();
        for (int i=0; i<size; i++){
            arr[i]=((int)(Math.random()*size));                
        }
        System.out.println("Array created");
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = "+elapsedTime/1000000+" ms");
        
        System.out.println("");
        
        startTime = System.nanoTime();
        for(int e=0; e<searches; e++){
            int num= (int)(Math.random()*size);
            for(int i=0; i<size; i++){
                if(arr[i]==num){
                    //System.out.println("value "+num+" found");
                    break;
                }
                else if (i==size-1) break; //System.out.println("value "+num+" not found");
            }
        }
        System.out.println("Array values found");
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time = "+elapsedTime/1000000+" ms");
    }    
}

