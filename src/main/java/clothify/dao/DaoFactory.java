package clothify.dao;

import clothify.dao.custom.impl.AccountDaoImpl;
import clothify.dao.custom.impl.EmployeeDaoImpl;
import clothify.dao.util.DaoType;

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
        }
        return null;
    }
}
