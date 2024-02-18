import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {

    private String company, sourceAddress, destinationAddress, driver, billedBy;
    private double rate;
    private int invoiceNo;

    public Order() {
        invoiceNo = 12345678;
        company = "test";
        sourceAddress = "test";
        destinationAddress = "test";
        rate = 0.0;
        driver = "test";
        billedBy = "test";
    }

    public Order(int invoiceNo, String company, String sourceAddress, String destinationAddress, float rate,
            String driver, String billedBy) {
        this.invoiceNo = invoiceNo;
        this.company = company;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.rate = rate;
        this.driver = driver;
        this.billedBy = billedBy;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public String getCompany() {
        return company;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public double getRate() {
        return rate;
    }

    public String getDriver() {
        return driver;
    }

    public String getBilledBy() {
        return billedBy;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setCompany(String comapny) {
        this.company = comapny;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setBilledBy(String billedBy) {
        this.billedBy = billedBy;
    }

    public void addOrder(Scanner in) {
        System.out.println("Please enter the Invoice number");
        invoiceNo = in.nextInt();// make it unique

        System.out.println("Please enter the Company");
        company = in.nextLine();

        System.out.println("Please enter the Source Address");
        sourceAddress = in.nextLine();

        System.out.println("Please enter the Destination Address");
        destinationAddress = in.nextLine();

        System.out.println("Please enter the rate");
        rate = in.nextFloat();

        System.out.println("Please enter the driver");
        driver = in.nextLine();

        System.out.println("Please enter the Billed by Admin name");
        billedBy = in.nextLine();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"));
            writer.write(invoiceNo + " ." + company + " ." + sourceAddress + " ." + destinationAddress + " ." + rate
                    + " ." + driver + " ." + billedBy + " ." + "\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void allOrders() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("order.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
