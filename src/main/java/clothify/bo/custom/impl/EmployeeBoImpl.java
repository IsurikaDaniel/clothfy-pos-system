package clothify.bo.custom.impl;

import clothify.bo.custom.EmployeeBo;
import clothify.dao.DaoFactory;
import clothify.dao.custom.EmployeeDao;
import clothify.dao.util.DaoType;
import clothify.dto.EmployeeDto;
import clothify.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {

    private EmployeeDao employeeDao = DaoFactory.getInstance().getDao(DaoType.EMPLOYEE);


    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.save(new Employee(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getCompany()
        ));
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(new Employee(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getCompany()
        ));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }

    @Override
    public List<EmployeeDto> allEmployee() throws SQLException, ClassNotFoundException {
        List<Employee> entityList = employeeDao.getAll();
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee employees:entityList) {
            list.add(new EmployeeDto(
                    employees.getId(),
                    employees.getName(),
                    employees.getContact(),
                    employees.getEmail(),
                    employees.getAddress(),
                    employees.getCompany()
            ));
        }
        return list;
    }
}
