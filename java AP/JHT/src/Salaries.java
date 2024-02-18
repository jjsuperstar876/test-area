
//import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Salaries {
    private int payId, sDay, sMonth, sYear, eDay, eMonth, eYear;
    private double salary;
    private String preparedBy;

    public Salaries() {
        payId = 1234567;
        sDay = 1;
        sMonth = 1;
        sYear = 2020;
        eDay = 31;
        eMonth = 12;
        eYear = 2021;
        salary = 5000;
        preparedBy = "John Brown";
    }

    public Salaries(int payId, int sDay, int sMonth, int sYear, int eDay, int eMonth, int eYear, float salary,
            String preparedBy) {
        super();
        this.payId = payId;
        this.sDay = sDay;
        this.sMonth = sMonth;
        this.sYear = sYear;
        this.eDay = eDay;
        this.eMonth = eMonth;
        this.eYear = eYear;
        this.salary = salary;
        this.preparedBy = preparedBy;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public int getsDay() {
        return sDay;
    }

    public void setsDay(int sDay) {
        this.sDay = sDay;
    }

    public int getsMonth() {
        return sMonth;
    }

    public void setsMonth(int sMonth) {
        this.sMonth = sMonth;
    }

    public int getsYear() {
        return sYear;
    }

    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    public int geteDay() {
        return eDay;
    }

    public void seteDay(int eDay) {
        this.eDay = eDay;
    }

    public int geteMonth() {
        return eMonth;
    }

    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    public int geteYear() {
        return eYear;
    }

    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public void salary(Scanner in) {
        String username, fname = "", lname = "";
        System.out.println("Please enter the Staff username");// Remember to go and make it unique
        username = in.nextLine();

        try {
            BufferedReader readerS = new BufferedReader(new FileReader("staff.txt"));
            String lineS;
            BufferedReader readerO = new BufferedReader(new FileReader("order.txt"));
            String lineO = "";
            while ((lineS = readerS.readLine()) != null) {
                String[] partS = lineS.split(" .");
                String user = partS[0];

                if (user.equals(username)) {
                    String position = partS[10];
                    if (position.equals("driver")) {
                        String[] partO = lineO.split(" .");
                        String rate = partO[4];
                        salary = Double.parseDouble(rate) * .3 + salary;
                    } else {
                        salary = 1000;// add more info later
                        break;
                    }

                }
                fname.equals(partS[2]);
                lname.equals(partS[3]);

            }

            System.out.println(fname + " " + lname + " " + "has a salary of " + salary);

            readerS.close();
            readerO.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
