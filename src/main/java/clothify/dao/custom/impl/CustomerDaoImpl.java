package clothify.dao.custom.impl;

import clothify.dao.custom.CustomerDao;
import clothify.dao.util.HibernateUtil;
import clothify.entity.Customer;
import clothify.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Customer customer = session.find(Customer.class, entity.getId());
        customer.setName(entity.getName());
        customer.setContact(entity.getContact());
        customer.setEmail(entity.getEmail());
        customer.setAddress(entity.getAddress());
        customer.setDescription(entity.getDescription());
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Find the customer by ID
            Customer customer = session.find(Customer.class, value);

            if (customer != null) {
                // If the customer is found, delete it
                session.delete(customer);
                transaction.commit();
                return true;
            } else {
                // Customer not found, handle the situation accordingly
                System.out.println("Customer with ID " + value + " does not exist.");
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback transaction in case of failure
            }
            throw e;  // Rethrow the exception
        } finally {
            session.close();  // Ensure the session is closed
        }
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Customer");
        List<Customer> list = query.list();
        session.close();
        return list;
    }

    public Customer findCustomerById(String id) {
        // Open a Hibernate session
        Session session = HibernateUtil.getSession();

        // Start a transaction (optional for read-only operations, but good practice)
        Transaction transaction = session.beginTransaction();

        // Use session.get() to find the entity by its primary key (ID)
        Customer customer = session.get(Customer.class, id);

        // Commit the transaction (not always needed for read operations)
        transaction.commit();

        // Close the session
        session.close();

        // Return the found customer (can be null if not found)
        return customer;
    }

}
