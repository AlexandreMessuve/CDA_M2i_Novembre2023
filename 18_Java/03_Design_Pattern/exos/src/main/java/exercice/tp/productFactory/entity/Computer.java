package exercice.tp.entity;

public class Computer extends Product{
    private String processor;
    private int memoryRam;
    private String graphicCard;



    private Computer(ComputerBuilder builder) {
        processor = builder.processor;
        memoryRam = builder.memoryRam;
        graphicCard = builder.graphicCard;
    }


    public static class ComputerBuilder extends AbstractProductBuilder{
        private String processor;
        private int memoryRam;
        private String graphicCard;

        public ComputerBuilder processor(String processor) {
            this.processor = processor;
            return this;
        }
        public ComputerBuilder memoryRam(int memoryRam) {
            this.memoryRam = memoryRam;
            return this;
        }
        public ComputerBuilder graphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memoryRam='" + memoryRam + '\'' +
                ", graphicCard='" + graphicCard + '\'' +
                "} \n";
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(int memoryRam) {
        this.memoryRam = memoryRam;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }
}
