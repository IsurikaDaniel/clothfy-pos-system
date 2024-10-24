package clothify.bo.custom;


import clothify.bo.SuperBo;
import clothify.dto.CustomerDto;
import clothify.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBo {

    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<CustomerDto> allCustomer() throws SQLException, ClassNotFoundException;

    Customer findCustomerById(String searchId);
}
