public class Trainer {
    private int trainerId;
    private String username;
    private String password;
    private String name;
    private String specialization;
    private String experience;

    // Constructor
    public Trainer(int trainerId, String username, String password, String name, String specialization, String experience) {
        this.trainerId = trainerId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    // Getters and Setters for trainerId
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    // Getters and Setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters and Setters for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and Setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for specialization
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Getters and Setters for experience
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
