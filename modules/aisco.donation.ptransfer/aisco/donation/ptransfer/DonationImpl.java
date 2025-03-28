package aisco.donation.ptransfer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aisco.donation.core.*;
import aisco.donation.core.DonationComponent;

public class DonationImpl extends DonationComponent {
    private List<Object> donationList;
    private String bankName;
    private String accountNumber;
    private String paymentStatus;  // Status pembayaran (e.g., "Pending", "Completed")

    public DonationImpl() {
        super();
        this.donationList = new ArrayList<>();
        this.paymentStatus = "Pending"; // Default status
        System.out.println("\nDonation via Payment Transfer");
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String bankName, String accountNumber, String paymentStatus) {
        super(name, email, phone, amount, paymentMethod);
        this.donationList = new ArrayList<>();
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.paymentStatus = paymentStatus != null ? paymentStatus : "Pending"; // Default ke "Pending" jika null
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String bankName, String accountNumber) {
        this(name, email, phone, amount, paymentMethod, bankName, accountNumber, "Pending");
    }

    @Override
    public void addDonation() {
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Transfer", "Bank BCA", "1234567890", "Completed"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Transfer", "Bank Mandiri", "0987654321", "Pending"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Transfer", "Bank BRI", "1122334455", "Completed"));
        donationList.add(new DonationImpl("Budi", "budi@jmail.com", "+62828 2345 3091", 900000, "Transfer", "Bank BNI", "6677889900", "Pending"));
    }
    
    public void getDonation() {
    	System.out.println(Arrays.asList(donationList));
    }

    @Override
    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + " Bank: " + bankName + " Account: " + accountNumber + " Status: " + paymentStatus + "\n";
    }
}