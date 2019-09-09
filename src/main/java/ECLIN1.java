public class ECLIN1 {

    public static void main(String[] args) {
        TriageType doctorTriageType = TriageType.FIFO;
        TriageType radiologyTriageType = TriageType.FIFO;
        System.out.println("Hello World!");
    }

    public enum TriageType {
        FIFO
    }

    public enum VisibleSymptom {
        COLD,
        FLU,
        EBOLA,
        BROKEN_BONE,
        CHEST_PAIN,
        MIGRAINE,
        SPRAIN
    }

}
