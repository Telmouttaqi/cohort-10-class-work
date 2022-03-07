public class Balloon {
    private String color;
    private double psi;

    public Balloon(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getPsi() {
        this.psi = this.psi + Math.random() * 5.0;
        return psi;
    }

    public void inflate(){
        return;
    }

    public boolean isExploded(){
        //if the psi field is greater than 16.0, returns true.

        if (psi > 16.0){


            return true;
        }
        else return false;
    }
}
