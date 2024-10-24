package clothify.dao.custom;

import clothify.dao.CrudDao;
import clothify.entity.Customer;

public interface CustomerDao extends CrudDao<Customer> {

    Customer findCustomerById(String id);
}
