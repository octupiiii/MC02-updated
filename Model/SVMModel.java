package Model;

public class SVMModel extends Model {
        SpecialVendingMachine svmMachine;
        private boolean specialvendingMachineCreated = false;

        public SVMModel(SpecialVendingMachine svmMachine) {
            super(null);
            this.svmMachine = new SpecialVendingMachine();
        }

        public void setVMStatus(boolean VMStatus) {
            this.specialvendingMachineCreated = VMStatus;
        }
    
        public boolean getVMStatus() {
            return specialvendingMachineCreated;
        }

        public boolean getSVMStatus() {
            return true;
        }

        @Override
        public VendingMachine getVendingMachine() {
            return this.svmMachine;
        }


}
