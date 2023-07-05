package model;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String customerId, String name, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Id Khách Hàng: " + this.getCustomerId() + "\n" +
                "Tên Khách Hàng: " + this.getName() + "\n" +
                "Số Điện Thoại: " + this.getPhone() + "\n" +
                "Địa Chỉ: " + this.getAddress();
    }
}
