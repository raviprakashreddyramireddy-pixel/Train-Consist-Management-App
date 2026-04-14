public class CargoAssigner {
    private boolean finallyExecuted;

    public boolean getFinallyExecuted() {
        return finallyExecuted;
    }

    public boolean assignCargo(GoodsBogie bogie, String cargo) {
        finallyExecuted = false;
        boolean assigned = false;
        try {
            if ("Rectangular".equals(bogie.getType()) && "Petroleum".equals(cargo)) {
                throw new CargoSafetyException("Unsafe cargo assignment: Petroleum in Rectangular bogie.");
            }
            assigned = true;
        } catch (CargoSafetyException e) {
            assigned = false;
        } finally {
            finallyExecuted = true;
        }
        return assigned;
    }
}
