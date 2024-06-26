public class Equipment {
    private String EquipmentName;
    private String Category;
    private String Manufacturer;
    private int Quantity;
    private double Price;
    private String PurchaseDate;
    private String Description;

    public Equipment(String equipmentName, String category, String manufacturer, int quantity, double price, String PurchaseDate, String description) {
        this.EquipmentName = equipmentName;
        this.Category = category;
        this.Manufacturer = manufacturer;
        this.Quantity = quantity;
        this.Price = price;
        this.PurchaseDate=PurchaseDate;
        this.Description = description;
    }





    public String getEquipmentName() {
        return EquipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        EquipmentName = equipmentName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }
    
    
    @Override
    public String toString() {
        return 
                "Name: " + EquipmentName + "\n" +
                "Category: " + Category + "\n" +
                "Manufacturer: " + Manufacturer + "\n" +
                "Quantity: " + Quantity + "\n" +
                "Price: " + Price + "\n" +
                "Description: " + Description;
    }
}
