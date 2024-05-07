package exercice.tp.productFactory.entity;

public class Bicycle extends Product{
    private String color;
    private String tyreType;

    private Bicycle(BicycleBuilder builder) {
        color = builder.color;
        tyreType = builder.tyreType;
    }
    public static class BicycleBuilder extends AbstractProductBuilder{
        private String color;
        private String tyreType;

        public BicycleBuilder color(String color){
            this.color = color;
            return this;
        }
        public BicycleBuilder tyreType(String tyreType){
            this.tyreType = tyreType;
            return this;
        }
        public Bicycle build(){
            return new Bicycle(this);
        }
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "color='" + color + '\'' +
                ", tyreType='" + tyreType + '\'' +
                "} \n";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTyreType() {
        return tyreType;
    }

    public void setTyreType(String tyreType) {
        this.tyreType = tyreType;
    }
}
