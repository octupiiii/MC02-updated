package Model;

public class Model {
    VendingMachine vmMachine;

    private boolean vendingMachineCreated = false;

    public Model(VendingMachine vmMachine) {
        this.vmMachine = new VendingMachine();
    }

    public void setVMStatus(boolean VMStatus) {
        this.vendingMachineCreated = VMStatus;
    }

    public boolean getVMStatus() {
        return vendingMachineCreated;
    }

    public VendingMachine getVendingMachine() {
        return this.vmMachine;
    }




}
