public class WorkoutPlanFactory {
    public WorkoutPlan createWorkoutPlan(String[] selectedWorkouts) {
        return new WorkoutPlan(selectedWorkouts);
    }
}
