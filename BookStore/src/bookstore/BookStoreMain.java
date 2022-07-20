/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jorge
 */
public class BookStoreMain {

    public static void main(String[] args) {
        /*
        READ PLEASE:
        I added a set of books already by default in order to test the program more effectively, to add them
        please introduce the password:"753".        
        */
        BufferedReader br = null;
        BookStore slave = new BookStore();        
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            
        
            System.out.println("1-Add/Remove good");
            System.out.println("2-Print books and/or magazines");
            System.out.println("3-Store Summary");
            System.out.println("4-Search for author");
            System.out.println("5-Search for magazine issue");
            System.out.println("6-Sell");
            System.out.println("7-Exit store");
            System.out.println("password-Add default goods");
        
        
        
            String s="";
            
                while((s=br.readLine())!=null){
                    if(s.equals("1")){
                        System.out.println("Do you want to 1-add or 2-remove a good?");
                            s=br.readLine();
                            if(s.equals("1")){
                                System.out.println("Do you want to add a 1-Book or 2-Magazine?");
                                    s=br.readLine();
                                    if(s.equals("1")){                            
                                        System.out.println("introduce name"); s=br.readLine(); String name=s;
                                        System.out.println("introduce price");s=br.readLine(); int price=Integer.parseInt(s);     
                                        System.out.println("introduce date");s=br.readLine(); String date=s;     
                                        System.out.println("introduce number of pages");s=br.readLine(); int nop=Integer.parseInt(s);    
                                        System.out.println("introduce author");s=br.readLine(); String author=s;                                 
                                        slave.AddBook(name, price, date, nop, author);
                                        System.out.println("Book crated succesfully :)");
                                    }
                                    else if(s.equals("2")){
                                        System.out.println("introduce name"); s=br.readLine(); String name=s;
                                        System.out.println("introduce price");s=br.readLine(); int price=Integer.parseInt(s);     
                                        System.out.println("introduce date");s=br.readLine(); String date=s;     
                                        System.out.println("introduce number of pages");s=br.readLine(); int nop=Integer.parseInt(s);    
                                        System.out.println("introduce issueNumber");s=br.readLine(); int in=Integer.parseInt(s);
                                        slave.AddMagazine(name, price, date, nop, in);
                                        System.out.println("Magazine crated succesfully :)");
                                    }
                                    else System.err.println("Number not recognized");
                            }
                            else if(s.equals("2")){
                                System.out.println("Which book or magazine do you want to delete?");
                                s=br.readLine();
                                slave.RemoveGood(s);                                
                                }
                            else System.err.println("Number not recognized");
                            }           
                    else if(s.equals("2")){                       
                        System.out.println("Do you want to print 1-All goods, 2-Only books or 3-Only magazines?");
                        s=br.readLine();
                            if(s.equals("1")){slave.PrintGoods();}
                            else if(s.equals("2")){slave.PrintBooks();}
                            else if(s.equals("3")){slave.PrintMagazines();}    
                            else System.err.println("Number not recognized");
                    }
                    else if(s.equals("3")){
                        System.out.println("Here is our store summary:");
                        slave.StoreSummary();
                    }
                    else if(s.equals("4")){
                        System.out.println("Introduce the author:");
                        System.out.println("");
                        s=br.readLine();
                        slave.AuthorSearch(s);
                    }
                    else if(s.equals("5")){
                        System.out.println("Introduce the issue number:");
                        System.out.println("");
                        s=br.readLine();
                        slave.IssueNumberSearch(Integer.parseInt(s));
                    }
                    else if(s.equals("6")){
                     System.out.println("Which good would you like to sell?");
                     s=br.readLine();  
                     slave.Sell(s);
                     slave.RemoveGood(s);                     
                    }
                    else if(s.equals("7")){break;}
                    else if (s.equals("753")){
                        System.out.println("Default goods added to the library :)");
                        slave.AddBook("The Road", 303, "26/09/2006", 287, "Cormac McCarthy");
                        slave.AddBook("La familia de pascual duarte", 247, "12/06/1942", 287, "Cormac McCarthy");
                        slave.AddBook("Kioto", 418, "25/06/1962", 234, "Yasunari Kawabata");
                        slave.AddMagazine("Kimetsu no Yaiba", 254, "4/10/2017", 234, 8);
                        slave.AddMagazine("Konosuba", 226, "30/06/2016", 285, 8);
                        slave.AddMagazine("Dr.Stone", 169, "4/04/2019", 192, 10);
                    }
                    
                    else System.err.println("Type one of the numbers mentioned");
                    
                }
            }catch (IOException ex) {
                System.err.println("IO Error");
            }catch (NumberFormatException nfe) {
                System.err.println("Write a number");
            }/*catch (ArithmeticException ae) {
                System.err.println("We do not have enough books");
            }*/                                         
        }        
    }
    

