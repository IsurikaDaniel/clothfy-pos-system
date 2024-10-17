package clothify.dao.custom.impl;

import clothify.dao.custom.AccountDao;
import clothify.dao.util.HibernateUtil;
import clothify.entity.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public boolean save(Account entity) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Account entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Account> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
