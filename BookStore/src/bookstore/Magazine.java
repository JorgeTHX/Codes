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
public class Magazine extends Good{    
    private int issueNumber;
    
    public Magazine(String n, int p, String d, int pc, int in) {
        super(n, p, d, pc);
        this.issueNumber=in;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    public String toString(){
        return this.name;
    }
    
}
