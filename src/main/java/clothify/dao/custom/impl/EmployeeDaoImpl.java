package clothify.dao.custom.impl;

import clothify.dao.custom.EmployeeDao;
import clothify.dao.util.HibernateUtil;
import clothify.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(Employee entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Employee entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Employee employee = session.find(Employee.class, entity.getId());
        employee.setName(entity.getName());
        employee.setContact(Integer.parseInt(String.valueOf(entity.getContact())));
        employee.setEmail(entity.getEmail());
        employee.setAddress(entity.getAddress());
        employee.setCompany(entity.getCompany());
        session.save(employee);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Employee.class,value));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Employee> getAll() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Employee");
        List<Employee> list = query.list();
        session.close();
        return list;
    }
}
