package aisco.donation.pcreditcard;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import aisco.donation.core.*;
import aisco.donation.core.DonationComponent;

public class DonationImpl extends DonationComponent {
    private List<Object> donationList;
    private String CVC;
    private String cardNumber;
    private Date expiryDate;
    private String paymentStatus; // Status pembayaran (e.g., "Pending", "Completed")

    public DonationImpl() {
        super();
        this.donationList = new ArrayList<>();
        this.paymentStatus = "Pending"; // Default status
        System.out.println("\nDonation via Payment Credit Card");
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String CVC, String cardNumber, Date expiryDate, String paymentStatus) {
        super(name, email, phone, amount, paymentMethod);
        this.donationList = new ArrayList<>();
        this.CVC = CVC;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.paymentStatus = paymentStatus != null ? paymentStatus : "Pending"; // Default ke "Pending" jika null
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String CVC, String cardNumber, Date expiryDate) {
        this(name, email, phone, amount, paymentMethod, CVC, cardNumber, expiryDate, "Pending");
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void addDonation() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2029, Calendar.MARCH, 15);
        Date expiryDate1 = calendar.getTime();
    
        calendar.set(2026, Calendar.JUNE, 30);
        Date expiryDate2 = calendar.getTime();
    
        calendar.set(2027, Calendar.DECEMBER, 31);
        Date expiryDate3 = calendar.getTime();

        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Credit Card", "123", "4111111111111111", expiryDate1, "Completed"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Credit Card", "456", "4222222222222222", expiryDate2, "Pending"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Credit Card", "789", "4333333333333333", expiryDate3, "Completed"));
    }

    public void getDonation() {
        System.out.println(Arrays.asList(donationList));
    }

    
    @Override
    public String toString() {
        String maskedCardNumber = "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        return "- Donasi " + name + ":\n" +
            "  Amount: " + amount + "\n" +
            "  Payment Method: " + paymentMethod + "\n" +
            "  Card Number: " + maskedCardNumber + "\n" +
            "  Expiry Date: " + expiryDate + "\n" +
            "  Status: " + paymentStatus + "\n";
    }

}
