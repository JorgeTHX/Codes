/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author jorge
 */
public class Book extends Good{
    private String author;
    
    
    public Book(String n, int p, String d, int pc, String a) {
        super(n, p, d, pc);
        this.author=a;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String toString(){
        return this.name;
    }
    
}
