public interface IBank {
    void showCustomersInfo();

    void showAccountsInfo(String newNIF);

    void showAccountInfo(String newNIF);

    Client checkNIF(String checkedNIF);

    int chooseAccount(BankAccount[] chosenAccounts);

    void addMoney (String operacion);
}
