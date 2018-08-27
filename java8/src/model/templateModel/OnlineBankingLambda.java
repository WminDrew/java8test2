package model.templateModel;

import java.util.function.Consumer;

public class OnlineBankingLambda {
    public void processCustomer(String id, Consumer<Customer> makeCustomerHappy){
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }
}
