package pl.wojtek11530;

import pl.wojtek11530.Model.Institution;

public class Main {

    public static void main(String[] args) {
        Institution institution = new Institution(3, 0.9, 0.5);
        for (int i = 0;i<10;i++){
            institution.nextCycle();
            institution.printInstitution();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
