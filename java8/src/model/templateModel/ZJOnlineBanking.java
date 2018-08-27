package model.templateModel;

public class ZJOnlineBanking extends OnlineBanking {
    @Override
    void makeCustomerHappy(Customer customer) {
        System.out.println("Hello "+customer.getName());
    }
}
