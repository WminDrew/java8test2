package model.templateModel;

import java.util.Arrays;
import java.util.List;

import static model.templateModel.Database.customerList;

public class Test {
    public static void main(String[] args) {
        Customer c1 = new Customer("1","1","1");
        Customer c2 = new Customer("2","2","2");
        Customer c3 = new Customer("3","3","3");
        Customer c4 = new Customer("4","4","4");
        Customer c5 = new Customer("5","5","5");
        List<Customer> customerList = Arrays.asList(c1,c2,c3,c4,c5);
        Database d = new Database();
        d.setCustomerList(customerList);
        ZJOnlineBanking zj = new ZJOnlineBanking();
        zj.processCustomer("1");

        //使用Lambda不用继承抽象类OnlineBanking类，也可以实现不同的fangshi
        new OnlineBankingLambda().processCustomer("3",c -> System.out.println("Hello "+c.getName()));
        new OnlineBankingLambda().processCustomer("4",c -> System.out.println("Hello "+ c.getName()));
    }
}
