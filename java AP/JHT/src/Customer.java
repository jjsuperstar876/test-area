import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Customer {

    private int custID = generateRandomID();;
    private String company;
    private String contactPerson;
    private String address1;
    private String address2;
    private String postOffice;
    private String parish;
    private String telephone;
    private String email;
    private String status;
    private String balance;

    public Customer() {
        custID = 1234567;
        company = "test";
        contactPerson = "test";
        address1 = "test";
        address2 = "test";
        postOffice = "test";
        parish = "test";
        telephone = "test";
        email = "test";
        status = "test";
        balance = "test";
    }

    public Customer(int custID, String company, String contactPerson, String address1, String address2,
            String postOffice, String parish, String telephone, String email, String status, String balance) {
        super();
        this.custID = custID;
        this.company = company;
        this.contactPerson = contactPerson;
        this.address1 = address1;
        this.address2 = address2;
        this.postOffice = postOffice;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.balance = balance;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    private static int generateRandomID() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    public void custFile(Scanner in) {
        // randomly generate ID Number
        System.out.println("ID Generated: "/* + custID */);
        custID = in.nextInt();// make unique

        System.out.println("Please enter the Company");
        company = in.nextLine();

        System.out.println("Please enter Contact Person");
        contactPerson = in.nextLine();

        System.out.println("Please enter Address Line 1");
        address1 = in.nextLine();

        System.out.println("Please enter Address Line 2");
        address2 = in.nextLine();

        System.out.println("Please enter Post Office");
        postOffice = in.nextLine();

        System.out.println("Please enter Telephone");
        telephone = in.nextLine();

        System.out.println("Please enter Email");
        email = in.nextLine();

        System.out.println("Please enter Status");
        status = in.nextLine();

        System.out.println("Please enter Balance");
        balance = in.nextLine();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("customer.txt"));
            System.out.println("Customer's info:  ");
            writer.write(custID + " ." + company + " ." + contactPerson + " ." + address1 + " ." + address2 + " ."
                    + postOffice + " " +
                    parish + " ." + telephone + " ." + email + " ." + status + " ." + balance);

            writer.close();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }

    /*
     * Customer ID, Company, Contact Person, Address 1, Address 2, Post
     * Office, Parish, Telephone, Email, Status (active or inactive) –
     * customers with an outstanding balance over 30 days have their
     * account flagged inactive.
     */

}