package entity;

import java.util.Arrays;

public class DriverManagement {
    private Driver driver;
    private DriverManagementDetail[] driverManagementDetails;

    public DriverManagement(Driver driver, DriverManagementDetail[] driverManagementDetails) {
        this.driver = driver;
        this.driverManagementDetails = driverManagementDetails;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public DriverManagementDetail[] getDriverManagementDetails() {
        return driverManagementDetails;
    }

    public void setDriverManagementDetails(DriverManagementDetail[] driverManagementDetails) {
        this.driverManagementDetails = driverManagementDetails;
    }

    @Override
    public String toString() {
        return "DriverManagement{" +
                "driver=" + driver +
                ", driverManagementDetails=" + Arrays.toString(driverManagementDetails) +
                '}';
    }
}
