import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank implements IBank {
    private String name;
    private Client[] customers;

    static Scanner scan = new Scanner(System.in);

    /*-----------------------------Constructors--------------------------------*/
    public Bank(String name, Client[] customers) {
        this.name = name;
        this.customers = customers;
    }

    public Bank() {

    }

    /*------------------------------------Methods implemented from IBank---------------------------------*/
    @Override
    public void showCustomersInfo() {
        for (Client customer : customers) {
            System.out.println(customer.getName() + customer.getSurname() + ", NIF: " + customer.getNIF());
        }
    }

    @Override
    public int chooseAccount(BankAccount[] chosenAccounts) {
        System.out.println("Elige una cuenta.");
        int order = 1;
        for (BankAccount account : chosenAccounts) {
            System.out.println("Cuenta " + order + ": " + account.getAccountNumber());
            order++;
        }
        order = scan.nextInt();
        return order;
    }

    @Override
    public void showAccountInfo(String newNIF) {
        Client chosen = new Client(checkNIF(newNIF));
        if (chosen.getNIF().equals(null)) {
            System.err.println("No existe el cliente");
        } else {
            BankAccount[] chosenAccounts = new BankAccount[chosen.getAccounts().length];
            chosenAccounts = chosen.getAccounts();
            int orden = chooseAccount(chosenAccounts);
            System.out.println("La cuenta " + chosenAccounts[orden].getAccountNumber() + "tiene un saldo de " + chosenAccounts[orden].getBalance());
        }
    }

    @Override
    public void showAccountsInfo(String newNIF) {
        Client chosen = new Client(checkNIF(newNIF));
        if (chosen.getNIF().equals(null)) {
            System.err.println("El cliente no existe");
        } else {
            BankAccount[] chosenAccounts = new BankAccount[chosen.getAccounts().length];
            chosenAccounts = chosen.getAccounts();
            for (BankAccount account : chosenAccounts) {
                System.out.println("La cuenta cuyo numero es: " + account.getAccountNumber() + " tiene un saldo de " + account.getBalance());
            }
        }
    }

    @Override
    public Client checkNIF(String checkedNIF) {
        Client chosen = new Client();
        for (Client customer : customers) {
            if (customer.getNIF().equals(checkedNIF)) {
                chosen = customer;
            }
        }
        return chosen;
    }

    @Override
    public void addMoney(String operacion) {
        System.out.println("Introduce el NIF del cliente");
        String NIF = scan.nextLine();
        Client customer = checkNIF(NIF);
        showAccountsInfo(customer.getNIF());
        int accountOrderNum = chooseAccount(customer.getAccounts());
        BankAccount[] customerAccounts = customer.getAccounts();
        System.out.println("Introduce la cantidad con la que se operará");
        int toOperateBalance = scan.nextInt();
        double finalBalance;
        switch (operacion){
            case "ingresar":
                finalBalance = Double.parseDouble(customerAccounts[accountOrderNum].getBalance()) + toOperateBalance;
                customerAccounts[accountOrderNum].setBalance(String.valueOf(finalBalance));
                break;
            case "sacar":
                finalBalance = Double.parseDouble(customerAccounts[accountOrderNum].getBalance()) - toOperateBalance;
                customerAccounts[accountOrderNum].setBalance(String.valueOf(finalBalance));
                break;
        }


    }

    /*----------------------------Getters & Setters-------------------------------------*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client[] getCustomers() {
        return customers;
    }

    public void setCustomers(Client[] customers) {
        this.customers = customers;
    }

    /*-------------------------------Other Methods-----------------------------------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return name.equals(bank.name) && Arrays.equals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(customers);
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", clients=" + Arrays.toString(customers) +
                '}';
    }
}
