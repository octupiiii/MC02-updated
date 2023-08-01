package Model;

public class Model {

    private boolean vendingMachineCreated = false;

    public Model() {
    }

    public void setVMStatus(boolean VMStatus) {
        this.vendingMachineCreated = VMStatus;
    }

    public boolean getVMStatus() {
        return vendingMachineCreated;
    }

}
