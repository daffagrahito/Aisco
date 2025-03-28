package aisco.donation.pewallet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import aisco.donation.core.*;
import aisco.donation.core.DonationComponent;
import payment.page.core.PaymentPage;
import payment.page.PaymentPageFactory;

public class DonationImpl extends DonationComponent {
    private List<Object> donationList;
    private String eWalletName;
    private String QRCode;
    private String paymentStatus; // Status pembayaran (e.g., "Pending", "Completed")
    PaymentPage payment;

    public DonationImpl() {
        super();
        this.donationList = new ArrayList<>();
        this.paymentStatus = "Pending"; // Default status
        this.payment = PaymentPageFactory.createPaymentPage("EWallet");
        System.out.println("\nDonation via Payment E-Wallet");
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String eWalletName, String QRCode, String paymentStatus) {
        super(name, email, phone, amount, paymentMethod);
        this.donationList = new ArrayList<>();
        this.eWalletName = eWalletName;
        this.QRCode = QRCode;
        this.paymentStatus = paymentStatus != null ? paymentStatus : "Pending";
        this.payment = PaymentPageFactory.createPaymentPage(paymentMethod);
    }

    public DonationImpl(String name, String email, String phone, int amount, String paymentMethod, String eWalletName, String QRCode) {
        this(name, email, phone, amount, paymentMethod, eWalletName, QRCode, "Pending");
    }

    @Override
    public void addDonation() {
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "EWallet", "OVO", "QR12345", "Completed"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "EWallet", "GoPay", "QR67890", "Pending"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "EWallet", "DANA", "QR11223", "Completed"));
    }
    
    @Override
    public void getDonations() {
    	System.out.println(Arrays.asList(donationList));
    }

    @Override
    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + " EWallet: " + eWalletName + " QRCode: " + QRCode + " Status: " + paymentStatus + "\n";
    }
}