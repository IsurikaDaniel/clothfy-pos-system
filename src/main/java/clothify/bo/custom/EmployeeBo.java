package clothify.bo.custom;

import clothify.bo.SuperBo;
import clothify.dto.EmployeeDto;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeBo extends SuperBo {
    boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
    List<EmployeeDto> allEmployee() throws SQLException, ClassNotFoundException;
}
