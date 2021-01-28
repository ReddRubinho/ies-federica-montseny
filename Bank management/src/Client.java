import java.util.Arrays;
import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private String NIF;
    private BankAccount[] Accounts;

    /*-----------------------------Constructors--------------------------------*/
    public Client(String name, String surname, String NIF, BankAccount[] accounts) {
        this.name = name;
        this.surname = surname;
        this.NIF = NIF;
        Accounts = accounts;
    }

    public Client(){

    }

    public Client(Client customer) {
    }

    /*----------------------------Getters & Setters-------------------------------------*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public BankAccount[] getAccounts() {
        return Accounts;
    }

    public void setAccounts(BankAccount[] accounts) {
        Accounts = accounts;
    }

    /*-------------------------------Other Methods-----------------------------------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return name.equals(client.name) && surname.equals(client.surname) && NIF.equals(client.NIF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, NIF);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", NIF='" + NIF + '\'' +
                ", Accounts=" + Arrays.toString(Accounts) +
                '}';
    }
}
