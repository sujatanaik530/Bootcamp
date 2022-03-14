package CarsCSV;

public class Cars {
    private String cName;
    private double cMPG;
    private byte cCylinders;
    private double cDisplacement;
    private double cHorsepower;
    private double cWeight;
    private double cAcceleration;
    private byte cModel;
    private String cOrigin;

    public Cars() {
    }

    public Cars(String cName, double cMPG, byte cCylinders, double cDisplacement, double cHorsepower, double cWeight, double cAcceleration, byte cModel, String cOrigin) {
        this.cName = cName;
        this.cMPG = cMPG;
        this.cCylinders = cCylinders;
        this.cDisplacement = cDisplacement;
        this.cHorsepower = cHorsepower;
        this.cWeight = cWeight;
        this.cAcceleration = cAcceleration;
        this.cModel = cModel;
        this.cOrigin = cOrigin;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public double getcMPG() {
        return cMPG;
    }

    public void setcMPG(double cMPG) {
        this.cMPG = cMPG;
    }

    public byte getcCylinders() {
        return cCylinders;
    }

    public void setcCylinders(byte cCylinders) {
        this.cCylinders = cCylinders;
    }

    public double getcDisplacement() {
        return cDisplacement;
    }

    public void setcDisplacement(double cDisplacement) {
        this.cDisplacement = cDisplacement;
    }

    public double getcHorsepower() {
        return cHorsepower;
    }

    public void setcHorsepower(double cHorsepower) {
        this.cHorsepower = cHorsepower;
    }

    public double getcWeight() {
        return cWeight;
    }

    public void setcWeight(double cWeight) {
        this.cWeight = cWeight;
    }

    public double getcAcceleration() {
        return cAcceleration;
    }

    public void setcAcceleration(double cAcceleration) {
        this.cAcceleration = cAcceleration;
    }

    public byte getcModel() {
        return cModel;
    }

    public void setcModel(byte cModel) {
        this.cModel = cModel;
    }

    public String getcOrigin() {
        return cOrigin;
    }

    public void setcOrigin(String cOrigin) {
        this.cOrigin = cOrigin;
    }
}
