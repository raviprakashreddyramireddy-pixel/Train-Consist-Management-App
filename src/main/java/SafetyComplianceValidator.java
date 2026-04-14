import java.util.List;

public class SafetyComplianceValidator {

    public boolean validateTrainSafety(List<GoodsBogie> bogies) {
        if (bogies == null || bogies.isEmpty()) {
            return true;
        }
        return bogies.stream()
                .allMatch(bogie -> !bogie.getType().equals("Cylindrical") || bogie.getCargo().equals("Petroleum"));
    }
}
