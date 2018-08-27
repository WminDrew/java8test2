package model.templateModel;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Database {
    public static List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public static Customer getCustomerWithId(String id){
        List<Customer> list = customerList.stream().filter(c -> c.getId().equals(id)).collect(toList());
        return list.get(0);
    }
}
