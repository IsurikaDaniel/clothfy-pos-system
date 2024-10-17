package clothify.bo.custom;

import clothify.bo.SuperBo;
import clothify.dto.AccountDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountBO extends SuperBo {
    boolean saveAccount(AccountDto dto) throws SQLException, ClassNotFoundException;
    boolean updateAccount(AccountDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteAccount(String email) throws SQLException, ClassNotFoundException;
    List<AccountDto> allAccount() throws SQLException, ClassNotFoundException;

}
