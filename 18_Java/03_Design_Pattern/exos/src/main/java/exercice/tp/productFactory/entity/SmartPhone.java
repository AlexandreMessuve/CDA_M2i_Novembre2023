package exercice.tp.entity;

public class SmartPhone  extends Product{
    private String color;
    private String model;
    private double inch;
    private String os;

    private SmartPhone(SmartPhoneBuilder builder){
        color = builder.color;
        model = builder.model;
        inch = builder.inch;
        os = builder.os;
    }

    public static class SmartPhoneBuilder extends AbstractProductBuilder{
        private String color;
        private String model;
        private double inch;
        private String os;

        public SmartPhoneBuilder color (String color){
            this.color = color;
            return this;
        }
        public SmartPhoneBuilder model (String model){
            this.model = model;
            return this;
        }
        public SmartPhoneBuilder inch (double inch){
            this.inch = inch;
            return this;
        }
        public SmartPhoneBuilder os(String os){
            this.os = os;
            return this;
        }
        public SmartPhone build(){
            return new SmartPhone(this);
        }
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", inch=" + inch +
                ", os='" + os + '\'' +
                "} \n";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getInch() {
        return inch;
    }

    public void setInch(double inch) {
        this.inch = inch;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
