public class DamagedEquipment {
    private int EquipmentID;
    private String DamageDescription;
    private String ReportedDate;

    // Constructor
    public DamagedEquipment(int equipmentID, String damageDescription, String reportedDate) {
        this.EquipmentID = equipmentID;
        this.DamageDescription = damageDescription;
        this.ReportedDate = reportedDate;
    }

    // Getters and Setters
    public int getEquipmentID() {
        return EquipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        EquipmentID = equipmentID;
    }

    public String getDamageDescription() {
        return DamageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        DamageDescription = damageDescription;
    }

    public String getReportedDate() {
        return ReportedDate;
    }

    public void setReportedDate(String reportedDate) {
        ReportedDate = reportedDate;
    }
}
