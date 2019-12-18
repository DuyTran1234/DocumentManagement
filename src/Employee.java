public class Employee extends Person {
    private String employeeID;
    private String position;
    private int workFlow;

    String getEmployeeID() {
        return employeeID;
    }

    String getPosition() {
        return position;
    }

    int getWorkFlow() {
        return workFlow;
    }

    void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    void setPosition(String position) {
        this.position = position;
    }

    void setWorkFlow(int workFlow) {
        this.workFlow = workFlow;
    }
}
