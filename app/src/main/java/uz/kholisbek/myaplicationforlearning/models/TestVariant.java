package uz.kholisbek.myaplicationforlearning.models;

public class TestVariant {
    private String question;
    private String variantA;
    private String variantB;
    private String variantC;
    private String variantD;
    private String answer;

    public TestVariant(String question, String variantA, String variantB, String variantC, String variantD, String answer) {
        this.question = question;
        this.variantA = variantA;
        this.variantB = variantB;
        this.variantC = variantC;
        this.variantD = variantD;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getVariantA() {
        return variantA;
    }

    public String getVariantB() {
        return variantB;
    }

    public String getVariantC() {
        return variantC;
    }

    public String getVariantD() {
        return variantD;
    }

    public String getAnswer() {
        return answer;
    }
}
