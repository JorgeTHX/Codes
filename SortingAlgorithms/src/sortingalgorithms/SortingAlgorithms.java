
package sortingalgorithms;


import java.util.Arrays;


public class SortingAlgorithms {


    public static void main(String[] args) { 
        
        
        //int[]test=randomArray(1000000,0,1000000);    //Generates random array: length, minimum, maximum 
        //int[]test=reverseArray(100000);             //Generates reverse array: length
        int[]test=nearlySortedArray(1000000,1500,0,100);  //Generates nearly sorted array: length, numbers passed until randomness occurs, minimum, maximum                
        
        System.out.println(Arrays.toString(test)); //Prints original array
        
        final long START = System.nanoTime();      //Starts counter
        
        //System.out.println(Arrays.toString(bubbleSort(test))); //Bubble sort run and print
        
        //quickSort(test, 0, test.length-1);          //Quick sort run
        //System.out.println(Arrays.toString(test));  //Quick sort print
        
        //mergeSort(test);                            //Merge sort run
        //System.out.println(Arrays.toString(test));  //Merge sort print
        
        //radixSort(test, test.length);               //Radix sort run
        //System.out.println(Arrays.toString(test));  //Radix sort print
        
        final long END = System.nanoTime();           //Ends counter
        System.out.println("Time taken : " + ((END - START) / 1e+9) + " seconds");  //Prints counter

    }
    
    static void swap(int[] arr, int i, int j) //Function to swap two elements (ownwork)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
            
    public static int[] bubbleSort(int[] arr){  //bubble sort array code  (ownwork)
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                }
        return arr;
    }                                               
    
    private static void quickSort(int arr[], int begin, int end) { //Quick sort recursive code: https://www.baeldung.com/java-quicksort 
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);            
            
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    
    private static int partition(int arr[], int begin, int end) { //Partition needed for quicksort
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;           
                swap(arr,i,j);
            }
        }
            swap(arr,i+1,end);
            return i+1;
    }    
    
    private static void mergeSort(int arr[]){ //Merge sort recursive code: https://www.youtube.com/watch?v=bOk35XmHPKs 
        int length=arr.length;
        
        if(length<2){
           return;
        }
        
        int midIndex=length/2;
        int leftHalf[]=new int[midIndex];
        int rightHalf[]=new int[length-midIndex]; //not using midIndex variable because might cause error with odd amount of numbers
        
        for(int i=0;i<midIndex;i++){
            leftHalf[i]=arr[i];
        }       
        for(int i=midIndex;i<length;i++){
            rightHalf[i-midIndex]=arr[i];
        }
        
        mergeSort(leftHalf);
        mergeSort(rightHalf);   
        
        merge(arr, leftHalf, rightHalf);
    }
    
    private static void merge(int arr[], int leftHalf[], int rightHalf[]){
       int leftSize=leftHalf.length;
       int rightSize=rightHalf.length;
       
       int i=0, j=0, k=0;
       
       while(i<leftSize && j<rightSize){
           if(leftHalf[i] <= rightHalf[j]){
              arr[k] = leftHalf[i];
              i++;
           }
           else{
              arr[k]=rightHalf[j];
              j++;
           }
        k++;
       }
       
       while (i<leftSize){
           arr[k]=leftHalf[i];
           i++;
           k++;               
       }
       while (j<rightSize){
           arr[k]=rightHalf[j];
           j++;
           k++;               
       }
    }
    
    static int getMax(int arr[], int n){ //Utility function to get maximum value in an array (for Radix sort)
        int mx=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>mx){
                mx=arr[i];
            }
        }
        return mx;
    }
    
    static void countSort(int arr[], int n, int exp){ //Countsort used by Radixsort
        int output[]=new int [n];
        int i;
        int count[]=new int[10];
        Arrays.fill(count, 0);
        
        //Store count of occurrences in count[]
        for(i=0;i<n;i++){    
            count[(arr[i]/exp)%10]++;
        }
        
        //Count[i] contains actual positions of digits in output[]
        for (i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        
        //Build output array
        for(i=n-1;i>=0;i--){
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        //Copy output array to arr[]
        for (i=0;i<n;i++){
            arr[i]=output[i];
        }        
    }
    
    static void radixSort(int arr[], int n){// Radix sort code calling previous codes:https://www.geeksforgeeks.org/radix-sort/
        int m=getMax(arr,n);
        
        for (int exp=1;m/exp>0;exp*=10){
            countSort(arr, n, exp);
        }
    }
    
    
    
                              
    public static int[] randomArray(int length, int min, int max){ //Code generating random array (ownwork)
        int[] ranArr= new int[length];
        int randomNum;
        for(int i=0;i<length;i++){
           randomNum = (int)Math.floor(Math.random()*(max-min+1)+min);
           ranArr[i]=randomNum;
        } 
      return ranArr;
    }
    
    public static int[] reverseArray(int length){ //Code generating reverse array (ownwork)
        int[] revArr= new int[length];
        int reverseNum;
        for(int i=0;i<length;i++){
           reverseNum = length-i;
           revArr[i]=reverseNum;
        } 
      return revArr;
    }
    
    public static int[] nearlySortedArray(int length, int numRan, int min, int max){
        int[] nearArr=new int[length];
        int ranCount=0;
        int num;
        for(int i=0;i<length;i++){            
            num=i;
            if(ranCount==numRan){
                num=(int)Math.floor(Math.random()*(max-min+1)+min);
                ranCount=0;
            }
            nearArr[i]=num;
            ranCount++;
        }
      return nearArr;
    }
}
