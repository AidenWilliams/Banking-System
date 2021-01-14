package Users;

import Accounts.Account;
import Accounts.Transaction;
import Workflow.Job;
import Workflow.Limits;
import Workflow.Instruction;
import Workflow.BankSystem;
import java.util.ArrayList;

public class RetailCustomer extends Customer{
    public RetailCustomer(String id, String name, String surname, ArrayList<String> addresses, String DOB, String email,
                   String phoneNumber) {
        super(id, name, surname, addresses, DOB, email, phoneNumber);
    }

    @Override
    String viewBalance() {
        StringBuilder output = new StringBuilder();
        for(Account account: accounts){
            output.append("Account Number\n");
            output.append(account.getNumber()).append("\n");
            output.append("Available Balance\n");
            output.append(account.getAvailableBalance()).append("\n");
            output.append("Balance On Hold\n");
            output.append(account.getBalanceOnHold()).append("\n");
            return output.toString();
        }
        return "";
    }

    @Override
    String viewBalance(String accountNumber) {
        StringBuilder output = new StringBuilder();
        for(Account account: accounts){
            if(account.getNumber().equals(accountNumber)){
                output.append("Available Balance\n");
                output.append(account.getAvailableBalance()).append("\n");
                output.append("Balance On Hold\n");
                output.append(account.getBalanceOnHold()).append("\n");
                return output.toString();
            }
        }
        return "";
    }

    @Override
    String viewTransactions() {
        StringBuilder output = new StringBuilder();
        for(Account account: accounts){
            output.append("Account Number\n");
            output.append("Detail\tFrom\tTo\tAmount\n");
            for(Transaction transaction: account.getTransactions()){
                output.append(transaction.getDetail()).append("\t");
                output.append(transaction.getFrom()).append("\t");
                output.append(transaction.getTo()).append("\t");
                output.append(transaction.getAmount()).append("\n");
            }
        }
        return output.toString();
    }

    @Override
    String viewTransactions(String accountNumber) {
        StringBuilder output = new StringBuilder();
        for(Account account: accounts){
            if(account.getNumber().equals(accountNumber)) {
                output.append("Detail\tFrom\tTo\tAmount\n");
                for (Transaction transaction : account.getTransactions()) {
                    output.append(transaction.getDetail()).append("\t");
                    output.append(transaction.getFrom()).append("\t");
                    output.append(transaction.getTo()).append("\t");
                    output.append(transaction.getAmount()).append("\n");
                }
                return output.toString();
            }
        }
        return "";
    }

    @Override
    void addInstruction(String detail) {
        BankSystem.instructions.add(new Instruction(detail, this));
    }

    @Override
    void removeInstruction(int id) {
        BankSystem.instructions.remove(id);
    }

    @Override
    String viewInstruction(Instruction instruction) {
        StringBuilder output = new StringBuilder();
        output.append(instruction.getDetail()).append("\t");
        output.append(instruction.getStatus()).append("\t");
        output.append(instruction.getAssignee());
        return output.toString();
    }

    @Override
    String viewInstructions() {
        StringBuilder output = new StringBuilder();
        int counter = 0;
        for(Instruction instruction: BankSystem.instructions){
            output.append("Instruction List\n");
            output.append("ID\tDetail\tStatus\tAssigned\n");
            output.append(counter++).append("\t").append(viewInstruction(instruction)).append("\n");
        }
        return output.toString();
    }

    @Override
    public void requestTransferToAccount(String detail, String accountFrom, String accountTo, double amount) {
        Account from = getAccount(accountFrom);
        if(from == null) return; //bad

        from.setAvailableBalance(from.getAvailableBalance() - amount);
        from.setBalanceOnHold(from.getBalanceOnHold() + amount);

        ArrayList<Object> jobDetails = new ArrayList<>();
        jobDetails.add(this);
        jobDetails.add(detail);
        jobDetails.add(accountFrom);
        jobDetails.add(accountTo);
        jobDetails.add(amount);
        if(amount <= Limits.MAX_EASY_TRANSFER){
            Account f = BankSystem.getAccount(accountFrom);
            Account t = BankSystem.getAccount(accountFrom);

            f.setBalanceOnHold(f.getBalanceOnHold() - amount);
            t.setAvailableBalance(t.getAvailableBalance() + amount);
            f.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));
            t.addTransaction(new Transaction(detail, accountFrom, accountTo, amount));

            BankSystem.AmendAccount(accountFrom, f);
            BankSystem.AmendAccount(accountTo, t);
        }else{
            BankSystem.jobs.add(new Job(jobDetails, "Transfer"));
        }
    }
}