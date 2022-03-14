package GenericsDemo;

public class G_DataTypesClass<DataType> {
    private DataType varName;

    public G_DataTypesClass() {

    }
    public G_DataTypesClass(DataType v) {
        this.varName = v;
    }
    public void setVarName(DataType v) {
        this.varName = v;
    }
    public DataType getVarName() {
        return this.varName;
    }
}
