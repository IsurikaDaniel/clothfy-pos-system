package clothify.bo.custom.impl;

import clothify.bo.custom.CustomerBO;
import clothify.dao.DaoFactory;
import clothify.dao.custom.CustomerDao;
import clothify.dao.util.DaoType;
import clothify.dto.CustomerDto;
import clothify.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBO {

    private CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getContact(),
                dto.getAddress(),
                dto.getDescription()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String email) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CustomerDto> allCustomer() throws SQLException, ClassNotFoundException {
        List<Customer> entityList = customerDao.getAll();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer:entityList) {
            list.add(new CustomerDto(
                    customer.getName(),
                    customer.getEmail(),
                    customer.getContact(),
                    customer.getAddress(),
                    customer.getDescription()
            ));
        }
        return list;
    }
}
