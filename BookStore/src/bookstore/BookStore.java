/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public class BookStore {    
    ArrayList<Good> goods=new ArrayList<>();        
    ArrayList<Book> books=new ArrayList<>();
    ArrayList<Magazine> magazines=new ArrayList<>();
    
    //Book b1=new Book("The Road", 303, "26/09/2006", 287, "Cormac McCarthy");
    //Book b2=new Book("La familia de pascual duarte", 247, "12/06/1942", 287, "Cormac McCarthy");
    //Book b3=new Book("Kioto", 418, "25/06/1962", 234, "Yasunari Kawabata");
    //Magazine m1=new Magazine("Kimetsu no Yaiba", 254, "4/10/2017", 234, 8);
    //Magazine m2=new Magazine("Konosuba", 226, "30/06/2016", 285, 8);
    //Magazine m3=new Magazine("Dr.Stone", 169, "4/04/2019", 192, 10);
    
    int valance=0;
    
    public void AddBook(String n, int p, String d, int pg, String a){            
        goods.add(new Book(n,p,d,pg,a));
        books.add(new Book(n,p,d,pg,a));
    }
    public void AddMagazine(String n, int p, String d, int pg, int i){
        goods.add(new Magazine(n,p,d,pg,i));
        magazines.add(new Magazine(n,p,d,pg,i));
    }
    public void RemoveGood(String n){
        String nameSearch=n;
        int cs=0;
        for (int i=0; i<goods.size();i++){
            if(nameSearch.equals(goods.get(i).name)){
                goods.remove(i);
                cs++;
            }            
        }
        if (cs==0){System.err.println("Good not found");}
        for (int i=0; i<books.size();i++){
            if(nameSearch.equals(books.get(i).name)){
                books.remove(i);
                System.out.println("Book removed succesfully :)");
            }
        }
        for (int i=0; i<magazines.size();i++){
            if(nameSearch.equals(magazines.get(i).name)){
                magazines.remove(i);
                System.out.println("Magazine removed succesfully :)");
            }
        }
    }
    
    public void PrintGoods(){
        System.out.println(goods);
    }
    public void PrintBooks(){
        System.out.println(books);
    }
    public void PrintMagazines(){
        System.out.println(magazines);
    }
    
    public void StoreSummary(){
        System.out.println("We have "+goods.size()+" goods available");
        System.out.println("We have "+books.size()+" books available");
        System.out.println("We have "+magazines.size()+" magazines available");
        int tm=0;
        int ap=0;
        if(goods.size()==0){System.out.println("We do not have any prices yet");}
        else{ 
            for (int i=0; i<goods.size(); i++){tm=tm+goods.get(i).price;}            
                ap=tm/goods.size();
                System.out.println("Our average price is "+ap+" cz");
        }
        int tp=0;
        for (int i=0; i<goods.size(); i++){tp=tp+goods.get(i).pageCount;}
        System.out.println("Our total amount of pages is: "+tp);
        System.out.println("Our current valance is: "+valance);
        
    }
    
    public void AuthorSearch(String a){
        System.out.println("");
        String authorSearch=a;
        int cs=0;
        for (int i=0; i<books.size();i++){            
            if(authorSearch.equals(books.get(i).getAuthor())){
                System.out.println(books.get(i).name);               
                cs++;
            }
        }
        if(cs==0){
            System.out.println("This author doesn't have any book here :(");
        }
    }
            
    public void IssueNumberSearch(int in){
        System.out.println("");
        int issueNumberSearch=in;
        int cs=0;
        for (int i=0; i<magazines.size();i++){            
            if(issueNumberSearch==magazines.get(i).getIssueNumber()){
                System.out.println(magazines.get(i).name);               
                cs++;
            }
        }
        if(cs==0){
            System.out.println("There is no magazine with this issue number :(");
        }
    }
    
    public void Sell(String n){
        String nameSearch=n;
        int cs=0;
        for (int i=0; i<goods.size();i++){
            if(nameSearch.equals(goods.get(i).name)){
                valance=valance+goods.get(i).price;
                System.out.println("Good succesfully sold :)");
                cs++;
            }
        }
        System.out.println("Our current valance is: "+valance);        
    }
    
}
    