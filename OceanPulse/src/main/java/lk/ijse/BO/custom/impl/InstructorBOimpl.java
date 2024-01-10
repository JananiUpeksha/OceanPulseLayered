package lk.ijse.BO.custom.impl;

import lk.ijse.BO.custom.InstructorBO;
import lk.ijse.DAO.DAOFactory;
import lk.ijse.DAO.custom.InstructorDAO;
import lk.ijse.dto.InsructorDto;

import java.sql.SQLException;
import java.util.List;

public class InstructorBOimpl implements InstructorBO {
    InstructorDAO instructorDAO = (InstructorDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.INSTRUCTOR);
    @Override
    public boolean save(InsructorDto insructor) throws SQLException, ClassNotFoundException {
        return instructorDAO.save(new InsructorDto(insructor.getId(),insructor.getName(),insructor.getAddress(),insructor.getContact(),insructor.getQualification()));
    }
    @Override
    public boolean update(InsructorDto insructor) throws SQLException, ClassNotFoundException {
        return instructorDAO.save(new InsructorDto(insructor.getName(),insructor.getContact(),insructor.getAddress(),insructor.getQualification(),insructor.getId()));
    }
    @Override
    public  InsructorDto searchAll(String id) throws SQLException, ClassNotFoundException {
        return instructorDAO.searchAll(id);
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return instructorDAO.delete(id);
    }
    @Override
    public List<InsructorDto> getAll() throws SQLException, ClassNotFoundException {
        return instructorDAO.getAll();
    }
}
