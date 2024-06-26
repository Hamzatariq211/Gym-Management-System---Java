import java.util.Date;

public class SinglePayment {
    private int paymentID;
    private int userID;
    private double amount;
    private Date paymentDate;
    private String paymonth;
    private String description;

    public SinglePayment(int paymentID, int userID, double amount, Date paymentDate, String paymonth, String description) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymonth = paymonth;
        this.description = description;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymonth() {
        return paymonth;
    }

    public void setPaymonth(String paymonth) {
        this.paymonth = paymonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
