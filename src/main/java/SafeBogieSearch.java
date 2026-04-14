public class SafeBogieSearch {
    public boolean searchBogie(String[] bogieIds, String targetId) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot search: Bogie collection is empty.");
        }
        if (targetId == null) {
            return false;
        }

        for (int i = 0; i < bogieIds.length; i++) {
            if (targetId.equals(bogieIds[i])) {
                return true;
            }
        }
        return false;
    }
}
