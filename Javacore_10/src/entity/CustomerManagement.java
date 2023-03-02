package entity;

import java.util.Arrays;

public class CustomerManagement {
    private Customer customer;
    private CustomerManagementDetail[] customerManagementDetails;
    private int totalService;

    public CustomerManagement(Customer customer, CustomerManagementDetail[] customerManagementDetails) {
        this.customer = customer;
        this.customerManagementDetails = customerManagementDetails;
        int tempTotal = 0;
        for (int i = 0; i < customerManagementDetails.length; i++) {
            tempTotal += customerManagementDetails[i].getQuantity();
        }
        this.totalService = tempTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerManagementDetail[] getCustomerManagementDetails() {
        return customerManagementDetails;
    }

    public void setCustomerManagementDetails(CustomerManagementDetail[] customerManagementDetails) {
        this.customerManagementDetails = customerManagementDetails;
    }

    public int getTotalService() {
        return totalService;
    }

    public void setTotalService(int totalService) {
        this.totalService = totalService;
    }

    @Override
    public String toString() {
        return "CustomerManagement{" +
                "customer=" + customer +
                ", customerManagementDetails=" + Arrays.toString(customerManagementDetails) +
                '}';
    }
}
