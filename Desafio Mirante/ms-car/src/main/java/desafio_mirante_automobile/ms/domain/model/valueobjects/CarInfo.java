package desafio_mirante_automobile.ms.domain.model.valueobjects;

public class CarInfo {

  private String carname;
  private String brand;
  private String model;
  private String caryear;
  private String color;
  private String price;
  private String cardescription;

  public CarInfo(String carname, String brand, String model, String caryear, String color, String price, String cardescription) {
    this.carname = carname;
    this.brand = brand;
    this.model = model;
    this.caryear = caryear;
    this.color = color;
    this.price = price;
    this.cardescription = cardescription;
  }

  public String getName() {
    return carname;
  }

  public void setName(String name) {
    this.carname = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return caryear;
  }

  public void setYear(String year) {
    this.caryear = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDescription() {
    return cardescription;
  }

  public void setDescription(String description) {
    this.cardescription = description;
  }

}
