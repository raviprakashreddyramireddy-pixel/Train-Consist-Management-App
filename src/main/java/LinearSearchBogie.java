public class LinearSearchBogie {
    public boolean searchBogie(String[] bogieIds, String targetId) {
        if (bogieIds == null || targetId == null) {
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
