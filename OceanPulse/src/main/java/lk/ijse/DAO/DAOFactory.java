package lk.ijse.DAO;

import lk.ijse.DAO.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return daoFactory == null? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        BOAT,DRIVER,INSTRUCTOR,EMPLOYEE,CUSTOMER,ITEM,SHEDULE,RESERVATION,ORDERS
    }
    public static SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case BOAT:
                return new BoatDAOimpl();
            case DRIVER:
                return new DriverDAOimpl();
            case EMPLOYEE:
                return new EmployeeDAOimpl();
            case INSTRUCTOR:
                return new InstructorDAOimpl();
            case ITEM:
                return new ItemMngDAOimpl();
            case CUSTOMER:
                return new CustomerDAOimpl();
            case SHEDULE:
                return new SheduleDAOimpl();
            case RESERVATION:
                return new ReservationDAOimpl();
            case ORDERS:
                return new OrderDAOimpl();
            default:
                return null;
        }
    }
}
