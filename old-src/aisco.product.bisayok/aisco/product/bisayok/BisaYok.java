package aisco.product.bisayok;

import aisco.program.core.Program;
import aisco.program.ProgramFactory;
import aisco.financialreport.core.FinancialReport;
import aisco.financialreport.FinancialReportFactory;
import aisco.donation.core.Donation;
import aisco.donation.DonationFactory;
import aisco.donation.pewallet.DonationImpl;

import java.util.ArrayList;
import java.util.List;

public class BisaYok {
    private static final int INDEX_ENVIRONMENT = 0;
    private static final int INDEX_TECHNOLOGY = 1;

    private static FinancialReport income1;
    private static FinancialReport expense1;

    public static List<Program> addProgram() {
        System.out.println("\nPrograms:");
        List<Program> programs = new ArrayList<>();
        Program environmentCare = ProgramFactory.createProgram(
            "aisco.program.activity.ProgramImpl", 
            1, 
            "Environment Care", 
            "Planting trees and cleaning rivers", 
            "1000 trees", 
            "Green Earth Foundation", 
            "https://www.bisayok.splelive.id/environmentlogo"
        );
        Program techEducation = ProgramFactory.createProgram(
            "aisco.program.activity.ProgramImpl", 
            2, 
            "Tech Education", 
            "Providing free coding classes for students", 
            "500 students", 
            "Tech for Future", 
            "https://www.bisayok.splelive.id/techlogo"
        );
        programs.add(INDEX_ENVIRONMENT, environmentCare);
        programs.add(INDEX_TECHNOLOGY, techEducation);
        return programs;
    }

    public static List<FinancialReport> addIncome(List<Program> programs) {
        List<FinancialReport> incomes = new ArrayList<>();
        income1 = FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.income.FinancialReportImpl", 
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl", 
                "101", 
                "01-02-2023", 
                1500000, 
                "Donation from Green Company", 
                programs.get(INDEX_ENVIRONMENT), 
                "100000"
            ), 
            "EWallet"
        );
        incomes.add(income1);
        incomes.add(FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.income.FinancialReportImpl", 
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl", 
                "102", 
                "05-02-2023", 
                2500000, 
                "Donation from Tech Enthusiast", 
                programs.get(INDEX_TECHNOLOGY), 
                "100000"
            ), 
            "EWallet"
        ));
        return incomes;
    }

    public static List<FinancialReport> addExpense(List<Program> programs) {
        List<FinancialReport> expenses = new ArrayList<>();
        expense1 = FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.expense.FinancialReportImpl", 
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl", 
                "201", 
                "10-02-2023", 
                800000, 
                "Tree Planting Supplies", 
                programs.get(INDEX_ENVIRONMENT), 
                "120000"
            )
        );
        expenses.add(expense1);
        expenses.add(FinancialReportFactory.createFinancialReport(
            "aisco.financialreport.expense.FinancialReportImpl", 
            FinancialReportFactory.createFinancialReport(
                "aisco.financialreport.core.FinancialReportImpl", 
                "202", 
                "15-02-2023", 
                1200000, 
                "Coding Class Equipment", 
                programs.get(INDEX_TECHNOLOGY), 
                "120000"
            )
        ));
        return expenses;
    }

    public static void addDonation() {
        Donation donation = DonationFactory.createDonation("aisco.donation.pewallet.DonationImpl");
        donation.addDonation();
        donation.getDonation();
    }

    public static void main(String[] args) {
        System.out.println("Product BisaYok");

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