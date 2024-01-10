package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.CustomerBO;
import lk.ijse.DAO.custom.CustomerDAO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOimpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.CUSTOMER);
    public boolean save(CustomerDto customer) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getContact(),customer.getNIC()));
    }
    @Override
    public CustomerDto searchAll(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.searchAll(id);
    }
    @Override
    /*public boolean update(CustomerDto customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new CustomerDto(customer.getName(),customer.getAddress(),customer.getContact(),customer.getNIC(),customer.getId()));
    }*/
    public boolean update(CustomerDto customer) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customer);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }
    @Override
    public List<CustomerDto> getAll() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }
}
