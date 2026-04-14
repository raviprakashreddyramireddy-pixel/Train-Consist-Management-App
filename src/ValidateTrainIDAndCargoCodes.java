import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateTrainIDAndCargoCodes {

    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";
    
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile(CARGO_CODE_REGEX);

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("\n--- Regex Validation Behavior ---");
        
        System.out.println("\n1. testRegex_ValidTrainID:");
        validateTrainID("TRN-1234");
        
        System.out.println("\n2. testRegex_InvalidTrainIDFormat:");
        validateTrainID("TRAIN12");
        validateTrainID("TRN12A");
        validateTrainID("1234-TRN");
        
        System.out.println("\n3. testRegex_ValidCargoCode:");
        validateCargoCode("PET-AB");
        
        System.out.println("\n4. testRegex_InvalidCargoCodeFormat:");
        validateCargoCode("PET-ab");
        validateCargoCode("PET123");
        validateCargoCode("AB-PET");
        
        System.out.println("\n5. testRegex_TrainIDDigitLengthValidation:");
        validateTrainID("TRN-123");
        validateTrainID("TRN-12345");
        
        System.out.println("\n6. testRegex_CargoCodeUppercaseValidation:");
        validateCargoCode("PET-Ab");
        validateCargoCode("PET-aB");
        
        System.out.println("\n7. testRegex_EmptyInputHandling:");
        validateTrainID("");
        validateCargoCode("");
        
        System.out.println("\n8. testRegex_ExactPatternMatch:");
        validateTrainID("TRN-1234X");
        validateCargoCode("PET-ABC");
        validateTrainID("XTRN-1234");
        validateCargoCode("XPET-AB");
    }

    private static void validateTrainID(String trainId) {
        if (trainId == null || trainId.isEmpty()) {
            System.out.println("Train ID: [] - Invalid format.");
            return;
        }
        Matcher matcher = TRAIN_ID_PATTERN.matcher(trainId);
        if (matcher.matches()) {
            System.out.println("Train ID: [" + trainId + "] - Valid format.");
        } else {
            System.out.println("Train ID: [" + trainId + "] - Invalid format.");
        }
    }

    private static void validateCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) {
            System.out.println("Cargo Code: [] - Invalid format.");
            return;
        }
        Matcher matcher = CARGO_CODE_PATTERN.matcher(cargoCode);
        if (matcher.matches()) {
            System.out.println("Cargo Code: [" + cargoCode + "] - Valid format.");
        } else {
            System.out.println("Cargo Code: [" + cargoCode + "] - Invalid format.");
        }
    }
}
