package aisco.product.ayobisa;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.donation.core.Donation;
import aisco.donation.DonationFactory;
import aisco.donation.ptransfer.DonationImpl;

import java.util.ArrayList;
import java.util.List;

public class AyoBisa {
    private static final int INDEX_HEALTH = 0;
    private static final int INDEX_EDUCATION = 1;
    private static final int INDEX_INFRASTRUCTURE = 2;

    private static FinancialReport income1;
    private static FinancialReport expense1;

    public static List<Program> addProgram() {
        System.out.println("\nPrograms:");
        List<Program> programs = new ArrayList<>();
        Program healthSupport = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", 1, "Health Support", "Providing medical assistance to underprivileged communities", "500 beneficiaries", "Health Foundation", "https://www.ayobisa.splelive.id/healthlogo");
        Program educationAid = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", 2, "Education Aid", "Scholarships for underprivileged students", "200 students", "Education Trust", "https://www.ayobisa.splelive.id/educationlogo");
        Program infrastructureDevelopment = ProgramFactory.createProgram("aisco.program.activity.ProgramImpl", 3, "Infrastructure Development", "Building clean water facilities in rural areas", "10 villages", "Infrastructure NGO", "https://www.ayobisa.splelive.id/infrastructurelogo");
        programs.add(INDEX_HEALTH, healthSupport);
        programs.add(INDEX_EDUCATION, educationAid);
        programs.add(INDEX_INFRASTRUCTURE, infrastructureDevelopment);
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        income1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "1", "01-01-2023", 1000000, "Donation from Company A", programs.get(INDEX_HEALTH), "50000"), "Transfer");
        incomes.add(income1);
        incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "2", "05-01-2023", 2000000, "Donation from Individual B", programs.get(INDEX_EDUCATION), "50000"), "Transfer"));
        incomes.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.income.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "3", "10-01-2023", 3000000, "CSR from Company C", programs.get(INDEX_INFRASTRUCTURE), "50000"), "Transfer"));
        return incomes;
    }

    public static List<FinancialReport> addExpense(List<Program> programs) {
        List<FinancialReport> expenses = new ArrayList<>();
        expense1 = FinancialReportFactory.createFinancialReport("aisco.financialreport.expense.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "10", "15-01-2023", 500000, "Medical Supplies", programs.get(INDEX_HEALTH), "60000"));
        expenses.add(expense1);
        expenses.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.expense.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "20", "20-01-2023", 1000000, "Scholarship Distribution", programs.get(INDEX_EDUCATION), "60000")));
        expenses.add(FinancialReportFactory.createFinancialReport("aisco.financialreport.expense.FinancialReportImpl", FinancialReportFactory.createFinancialReport("aisco.financialreport.core.FinancialReportImpl", "30", "25-01-2023", 1500000, "Construction Materials", programs.get(INDEX_INFRASTRUCTURE), "60000")));
        return expenses;
    }

    public static void addDonation() {
        Donation donate = DonationFactory.createDonation("aisco.donation.ptransfer.DonationImpl");
        donate.addDonation();
        donate.getDonation();
    }

    public static void main(String[] args) {
        System.out.println("Product AyoBisa - Transfer Payment");

        List<Program> programs = addProgram();
        System.out.println(programs);

        List<FinancialReport> incomes = addIncome(programs);
        income1.printHeader();
        System.out.println(incomes);
        int totalIncome = ((aisco.financialreport.income.FinancialReportImpl) income1).total(incomes);

        List<FinancialReport> expenses = addExpense(programs);
        expense1.printHeader();
        System.out.println(expenses);
        int totalExpense = ((aisco.financialreport.expense.FinancialReportImpl) expense1).total(expenses);

        addDonation();
        int balance = totalIncome - totalExpense;
        System.out.println("Balance: " + balance);
    }
}