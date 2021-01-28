import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    private static BankAccount accountFill() {
        BankAccount account = new BankAccount();
        System.out.println("Introduce el numero de cuenta");
        account.setAccountNumber(scan.nextLine());

        System.out.println("Cual es el balance de la cuenta?");
        account.setBalance(scan.nextLine());

        return account;
    }

    private static BankAccount[] accountsDataFill( Client customer) {
        System.out.println("Cuantas cuentas tiene "+ customer.getName() +"?");
        BankAccount[] accounts = new BankAccount[scan.nextInt()];
        scan.nextLine();

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountFill();
        }
        return accounts;
    }

    private static Client dataFill() {
        Client newCustomer = new Client();

        System.out.println("Cual es su nombre?");
        newCustomer.setName(scan.nextLine());

        System.out.println("Y sus apellidos?");
        newCustomer.setSurname(scan.nextLine());

        System.out.println("Ahora toca decir el NIF:");
        newCustomer.setNIF(scan.nextLine());

        newCustomer.setAccounts(accountsDataFill(newCustomer));

        return newCustomer;


    }

    private static Client[] customersFill(int arrayLength) {
        Client[] customers = new Client[arrayLength];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = dataFill();
        }
        return customers;
    }

    private static Bank dataFill(Bank newBank) {

        System.out.println("Cual será el nombre del banco?");
        newBank.setName(scan.nextLine());

        System.out.println("Cuantos clientes forman parte del banco?");
        int arrayLength = scan.nextInt();
        scan.nextLine();

        System.out.println("Introduce los datos de cada cliente por favor");
        newBank.setCustomers(customersFill(arrayLength));

        return newBank;
    }

    private static void menu(){
        System.out.println("Menu. Selecciona una de las opciones numericas:");
        System.out.println("1.- ");
    }

    public static void main(String[] args) {
        Bank banco = new Bank();
        dataFill(banco);
        System.out.println(banco.getName());

    }
}
