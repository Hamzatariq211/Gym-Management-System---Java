public class WorkoutPlan {
    private String[] selectedWorkouts;

    public WorkoutPlan(String[] selectedWorkouts) {
        this.selectedWorkouts = selectedWorkouts;
    }

    // Getter methods for selected workouts
    public String getMonday() {
        return selectedWorkouts[0];
    }

    public String getTuesday() {
        return selectedWorkouts[1];
    }

    public String getWednesday() {
        return selectedWorkouts[2];
    }

    public String getThursday() {
        return selectedWorkouts[3];
    }

    public String getFriday() {
        return selectedWorkouts[4];
    }

    public String getSaturday() {
        return selectedWorkouts[5];
    }

    public String getSunday() {
        return selectedWorkouts[6];
    }
}
