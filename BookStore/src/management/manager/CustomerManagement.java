package management.manager;

import ioFile.CustomerIOFile;
import model.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private List<Customer> customerList = null;
    private CustomerIOFile customerIOFile = new CustomerIOFile();

    public CustomerManagement() {
        try {
            this.customerList = customerIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Customer customer) {
        try {
            this.customerList.add(customer);
            this.customerIOFile.writerFile(customerList);
            System.out.println("Thêm Thành Công !!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(String id, Customer customer) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.customerList.set(index, customer);
                this.customerIOFile.writerFile(customerList);
                System.out.println("Sửa Thành Công !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Không Có Id Muốn Sửa !!!");
        }
    }

    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.customerList.remove(index);
                this.customerIOFile.writerFile(customerList);
                System.out.println("Xóa Thành Công !!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Không Có Id Muốn Xóa !!!");
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (id.equals(this.customerList.get(i).getCustomerId())) {
                return i;
            }
        }
        return -1;
    }

    public List<Customer> getAll() {
        try {
            return this.customerIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(customer);
            }
        }
        return list;
    }
}
