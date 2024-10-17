package clothify.bo.custom.impl;

import clothify.bo.custom.AccountBO;
import clothify.dao.DaoFactory;
import clothify.dao.custom.AccountDao;
import clothify.dao.util.DaoType;
import clothify.dto.AccountDto;
import clothify.entity.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountBoImpl implements AccountBO {

    private AccountDao accountDao = DaoFactory.getInstance().getDao(DaoType.ACCOUNT);
    @Override
    public boolean saveAccount(AccountDto dto) throws SQLException, ClassNotFoundException {
        return accountDao.save(new Account(
                dto.getEmail(),
                dto.getPassword(),
                dto.getJobRole()
        ));
    }

    @Override
    public boolean updateAccount(AccountDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteAccount(String email) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<AccountDto> allAccount() throws SQLException, ClassNotFoundException {
        List<Account> entityList = accountDao.getAll();
        List<AccountDto> list = new ArrayList<>();
        for (Account accounts:entityList) {
            list.add(new AccountDto(
                    accounts.getEmail(),
                    accounts.getPassword(),
                    accounts.getJobRole()
            ));
        }
        return list;
    }
}
