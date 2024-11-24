package dealership.desafio_mirante.ms_car.domain;

public class Car {

    private Long id;
    private String name;
    private String brand;
    private String model;
    private String year;
    private String color;
    private String price;
    private String description;

    private Car(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
        this.color = builder.color;
        this.price = builder.price;
        this.description = builder.description;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String brand;
        private String model;
        private String year;
        private String color;
        private String price;
        private String description;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
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

        public Builder year(String year) {
            this.year = year;
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

        public Builder description(String description) {
            this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void validate() {
        if (this.name == null || this.name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (this.brand == null || this.brand.isEmpty()) {
            throw new IllegalArgumentException("Brand is required");
        }
        if (this.model == null || this.model.isEmpty()) {
            throw new IllegalArgumentException("Model is required");
        }
        if (this.year == null || this.year.isEmpty()) {
            throw new IllegalArgumentException("Year is required");
        }
        if (this.color == null || this.color.isEmpty()) {
            throw new IllegalArgumentException("Color is required");
        }
        if (this.price == null || this.price.isEmpty()) {
            throw new IllegalArgumentException("Price is required");
        }
        if (this.description == null || this.description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }
    }

    public void validateYear() throws IllegalArgumentException {
        int currentYear = java.time.Year.now().getValue();
        try {
            int carYear = Integer.parseInt(this.year);
            if (carYear > currentYear) {
                throw new IllegalArgumentException("O ano do carro não pode ser maior que o ano atual.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ano inválido. O campo 'year' deve ser numérico.");
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
