package Sem6;

public class laptop {
    String brand;
    String model;
    String colour;
    String RAM;
    String SSDCapacity;
    String processorFamily;
    String screenDiagonal;

    public laptop(String brand, String model, String colour, String RAM, String SSDCapacity, String processorFamily, String screenDiagonal) {
        this.brand = brand.toUpperCase();
        this.model = model.toUpperCase();
        this.colour = colour.toUpperCase();
        this.RAM = RAM.toUpperCase();
        this.SSDCapacity = SSDCapacity.toUpperCase();
        this.processorFamily = processorFamily.toUpperCase();
        this.screenDiagonal = screenDiagonal.toUpperCase();
    }

    public String getBrand() {
        return brand;
    }

    public String getColour() {
        return colour;
    }

    public String getRAM() {
        return RAM;
    }

    public String getSSDCapacity() {
        return SSDCapacity;
    }

    public String getProcessorFamily() {
        return processorFamily;
    }

    public String getScreenDiagonal() {
        return screenDiagonal;
    }

    public void Info() {
        System.out.println(String.format("Производитель: %s\nМодель: %s\nЦвет: %s\nОперативная память(ГБ): %s\nОбъем SSD(ГБ): %s\nСемейство процессоров: %s\nДиагональ экрана(дюйм): %s\n",
                this.brand, this.model, this.colour, this.RAM, this.SSDCapacity, this.processorFamily, this.screenDiagonal));
    }

    public String toString() {
        return (String.format("Производитель: %s\nМодель: %s\nЦвет: %s\nОперативная память(ГБ): %s\nОбъем SSD(ГБ): %s\nСемейство процессоров: %s\nДиагональ экрана(дюйм): %s\n",
                this.brand, this.model, this.colour, this.RAM, this.SSDCapacity, this.processorFamily, this.screenDiagonal));
    }

}