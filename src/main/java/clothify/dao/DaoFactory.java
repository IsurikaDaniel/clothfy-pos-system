package clothify.dao;

import clothify.dao.custom.impl.AccountDaoImpl;
import clothify.dao.custom.impl.CustomerDaoImpl;
import clothify.dao.custom.impl.EmployeeDaoImpl;
import clothify.dao.util.DaoType;

import static clothify.dao.util.BoType.CUSTOMER;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){

    }
    public static DaoFactory getInstance(){
        return daoFactory!=null? daoFactory:(daoFactory=new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case ACCOUNT: return(T) new AccountDaoImpl();
            case EMPLOYEE: return (T) new EmployeeDaoImpl();
            case CUSTOMER: return (T) new CustomerDaoImpl();
        }
        return null;
    }
}
