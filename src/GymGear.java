import java.math.BigDecimal;
import java.sql.Timestamp;

public class GymGear {
    private int gearId;
    private String gearName;
    private String gearType;
    private BigDecimal price;
    private int quantity;
    private String supplier;
    private Timestamp purchaseDate;

    public GymGear() {
        // Default constructor
    }

    public GymGear(int gearId, String gearName, String gearType, BigDecimal price,
                   int quantity, String supplier, Timestamp purchaseDate) {
        this.gearId = gearId;
        this.gearName = gearName;
        this.gearType = gearType;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.purchaseDate = purchaseDate;
    }

    public int getGearId() {
        return gearId;
    }

    public void setGearId(int gearId) {
        this.gearId = gearId;
    }

    public String getGearName() {
        return gearName;
    }

    public void setGearName(String gearName) {
        this.gearName = gearName;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
