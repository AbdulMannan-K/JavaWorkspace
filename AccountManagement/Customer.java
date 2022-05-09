public class Customer {
    private String name;
    private String adress;
    private String phone;
    private boolean saving;
    private boolean checking;
    CheckingAccount checkingAccount;
    SavingAccount savingAccount;



    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public void setSaving(boolean saving) {
        this.saving = saving;
    }

    public boolean isChecking() {
        return checking;
    }

    public boolean isSaving() {
        return saving;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(int location, int accountType,short pin) {
        switch (accountType){
            case 1 ->{
                savingAccount = new SavingAccount(pin);
                savingAccount.setAccountNumber(location,accountType);
            }
            case 2 -> {
                checkingAccount = new CheckingAccount(pin);
                checkingAccount.setAccountNumber(location,accountType);
            }
        }
    }

    public void setAccountNumber( int type , short pin1 , short pin2) {
        switch (type){
            case 1 -> savingAccount = new SavingAccount(pin1);
            case 2 -> checkingAccount = new CheckingAccount(pin2);
            case 3 -> {
                savingAccount = new SavingAccount(pin1);
                checkingAccount = new CheckingAccount(pin2);
            }
        }
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    Customer(String name , String adress , String phone){
        setAdress(adress);
        setName(name);
        setPhone(phone);
        setChecking(false);
        setSaving(false);
    }

}
