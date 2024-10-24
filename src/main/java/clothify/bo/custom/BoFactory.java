package clothify.bo.custom;

import clothify.bo.SuperBo;
import clothify.bo.custom.impl.AccountBoImpl;
import clothify.bo.custom.impl.CustomerBoImpl;
import clothify.bo.custom.impl.EmployeeBoImpl;
import clothify.dao.util.BoType;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case ACCOUNT: return (T) new AccountBoImpl();
            case EMPLOYEE: return (T) new EmployeeBoImpl();
            case CUSTOMER: return (T) new CustomerBoImpl();

        }
        return null;
    }
}
