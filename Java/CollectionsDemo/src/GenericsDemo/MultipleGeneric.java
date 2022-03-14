package GenericsDemo;

// DType1 and DType1 are just names.
public class MultipleGeneric <DType1, DType2>{
    private DType1 v1;
    private DType2 v2;

    public MultipleGeneric(DType1 v1, DType2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public MultipleGeneric() {
    }

    public DType1 getV1() {
        return v1;
    }

    public void setV1(DType1 v1) {
        this.v1 = v1;
    }

    public DType2 getV2() {
        return v2;
    }

    public void setV2(DType2 v2) {
        this.v2 = v2;
    }

    public void printBoth() {
        System.out.println(this.v1);
        System.out.println(this.v2);
    }
}
