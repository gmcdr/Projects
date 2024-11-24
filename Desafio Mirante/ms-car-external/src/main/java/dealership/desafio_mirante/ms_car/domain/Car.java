package dealership.desafio_mirante.ms_car.domain;

public class Car {

    public Car() {
    
    }

    private Long id;
    private String carName;
    private String brand;
    private String model;
    private String carYear;
    private String color;
    private String price;
    private String carDescription;

    private Car(Builder builder) {
        this.id = builder.id;
        this.carName = builder.carName;
        this.brand = builder.brand;
        this.model = builder.model;
        this.carYear = builder.carYear;
        this.color = builder.color;
        this.price = builder.price;
        this.carDescription = builder.carDescription;
    }

    public static class Builder {
        private Long id;
        private String carName;
        private String brand;
        private String model;
        private String carYear;
        private String color;
        private String price;
        private String carDescription;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder carName(String carName) {
            this.carName = carName;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder carYear(String carYear) {
            this.carYear = carYear;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder carDescription(String carDescription) {
            this.carDescription = carDescription;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcarName() {
        return carName;
    }

    public void setcarName(String carName) {
        this.carName = carName;
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

    public String getcarYear() {
        return carYear;
    }

    public void setcarYear(String carYear) {
        this.carYear = carYear;
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

    public void updatePrice(String newPrice) {
        this.price = newPrice;
    }

    public String getcarDescription() {
        return carDescription;
    }

    public void setcarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public void validate() {
        if (this.carName == null || this.carName.isEmpty()) {
            throw new IllegalArgumentException("carName is required");
        }
        if (this.brand == null || this.brand.isEmpty()) {
            throw new IllegalArgumentException("Brand is required");
        }
        if (this.model == null || this.model.isEmpty()) {
            throw new IllegalArgumentException("Model is required");
        }
        if (this.carYear == null || this.carYear.isEmpty()) {
            throw new IllegalArgumentException("carYear is required");
        }
        if (this.color == null || this.color.isEmpty()) {
            throw new IllegalArgumentException("Color is required");
        }
        if (this.price == null || this.price.isEmpty()) {
            throw new IllegalArgumentException("Price is required");
        }
        if (this.carDescription == null || this.carDescription.isEmpty()) {
            throw new IllegalArgumentException("carDescription is required");
        }
    }

    public void validatecarYear() throws IllegalArgumentException {
        int currentcarYear = java.time.Year.now().getValue();
        try {
            int carcarYear = Integer.parseInt(this.carYear);
            if (carcarYear > currentcarYear) {
                throw new IllegalArgumentException("O ano do carro não pode ser maior que o ano atual.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ano inválido. O campo 'carYear' deve ser numérico.");
        }
    } 

    public void validatePrice() throws IllegalArgumentException {
        try {
            double carPrice = Double.parseDouble(this.price);
            if (carPrice <= 0) {
                throw new IllegalArgumentException("O preço do carro deve ser maior que zero.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Preço inválido. O campo 'price' deve ser numérico.");
        }
    }    

}
