package lk.ijse.BO;

public class BOFactory {
    public static BOFactory boFactory;
    public BOFactory(){}
    public static BOFactory getBoFactory(){
        return boFactory == null? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
        BOAT,DRIVER,INSTRUCTOR,EMPLOYEE,CUSTOMER,ITEM, SCHEDULE,RESERVATION,ORDERS,ORDER_DETAILS
    }
    public static SuperBO getBO (BOTypes boTypes){
        switch (boTypes){
            case BOAT:
                return new BoatBOimpl();
            case DRIVER:
                return new DriverBOimpl();
            case INSTRUCTOR:
                return new InstructorBOimpl();
            case EMPLOYEE:
                return new EmployeeBOimpl();
            case CUSTOMER:
                return new CustomerBOimpl();
            case ITEM:
                return new ItemBOimpl();
            case SCHEDULE:
                return new sheduleBOimpl();
            case RESERVATION:
                return new ReservationBOimpl();
            case ORDERS:
                return new OrderBOimpl();
            default:
                return null;
        }
    }
}
