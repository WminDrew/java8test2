package model.templateModel;

public class Customer {
    private String id;
    private String account;
    private String name;

    public Customer(String id, String account, String name) {
        this.id = id;
        this.account = account;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
