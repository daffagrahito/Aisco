package aisco.donation.pewallet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aisco.donation.core.*;
import aisco.donation.core.DonationComponent;

public class DonationImpl extends DonationComponent {
    private List<Object> donationList;
    private String eWalletName;
    private String qrCode;
    private String paymentStatus; // Status pembayaran (e.g., "Pending", "Completed")

    public DonationImpl() {
        super();
        this.donationList = new ArrayList<>();
        this.paymentStatus = "Pending"; // Default status
        System.out.println("\nDonation via Payment E-Wallet");
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String eWalletName, String qrCode, String paymentStatus) {
        super(name, email, phone, amount, paymentMethod);
        this.donationList = new ArrayList<>();
        this.eWalletName = eWalletName;
        this.qrCode = qrCode;
        this.paymentStatus = paymentStatus != null ? paymentStatus : "Pending";
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String eWalletName, String qrCode) {
        this(name, email, phone, amount, paymentMethod, eWalletName, qrCode, "Pending");
    }

    @Override
    public void addDonation() {
        donationList.add(new DonationImpl(
            "Anisa", 
            "anisa@jmail.com", 
            "+62878 6654 3321", 
            2500000, 
            "EWallet", 
            "OVO", 
            "00020101021126580014ID.CO.BANKOVO0115123456789012345293000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", 
            "Completed"
        ));
        donationList.add(new DonationImpl(
            "Dave", 
            "dave@jmail.com", 
            "+62828 2345 3091", 
            500000, 
            "EWallet", 
            "GoPay", 
            "00020101021126580014ID.CO.BANKGOPAY011567890123456789029300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", 
            "Pending"
        ));
        donationList.add(new DonationImpl(
            "Edo", 
            "edo@jmail.com", 
            "+62828 2345 3091", 
            300000, 
            "EWallet", 
            "DANA", 
            "00020101021126580014ID.CO.BANKDANA0115112233445566778892930000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", 
            "Completed"
        ));
    }
    
    public void getDonation() {
    	System.out.println(Arrays.asList(donationList));
    }

    @Override
    public String toString() {
        return "- Donasi " + name + ":\n" +
            "  Amount: " + amount + "\n" +
            "  Payment Method: " + paymentMethod + "\n" +
            "  EWallet: " + eWalletName + "\n" +
            "  QRCode: " + qrCode + "\n" +
            "  Status: " + paymentStatus + "\n";
    }
}