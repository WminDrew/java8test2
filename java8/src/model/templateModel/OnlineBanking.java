package model.templateModel;

abstract class OnlineBanking {
    public void processCustomer(String id){
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    abstract void makeCustomerHappy(Customer customer);
}
