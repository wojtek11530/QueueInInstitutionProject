package pl.wojtek11530.Model;

public class Client {

    private String name;
    private int leftTimeToEndACase;

    public Client(String name, int leftTimeToEndACase) {
        this.name = name;
        this.leftTimeToEndACase = leftTimeToEndACase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeftTimeToEndACase() {
        return leftTimeToEndACase;
    }

    public void setLeftTimeToEndACase(int leftTimeToEndACase) {
        this.leftTimeToEndACase = leftTimeToEndACase;
    }

    @Override
    public String toString() {
        return
                 name + ", leftTimeToEndACase=" + leftTimeToEndACase ;
    }
}
