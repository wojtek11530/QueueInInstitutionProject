package pl.wojtek11530.Model;

import pl.wojtek11530.Exceptions.EmptyQueueException;
import pl.wojtek11530.Structures.MyQueue;

public class Institution {

    private MyQueue<Client> queueOfClients;
    private int numberOfCounters;
    private Client[] clientAtTheCounters;


    private int numberOfAllCLients;

    private double firstClientComeProbability;
    private double secondClientComeProbability;


    public Institution(int numberOfCounters, double firstClientComeProbability, double secondClientComeProbability) {
        this.firstClientComeProbability = firstClientComeProbability;
        this.secondClientComeProbability = secondClientComeProbability;
        queueOfClients = new MyQueue<Client>();

        this.numberOfCounters = numberOfCounters;
        this.clientAtTheCounters = new Client[numberOfCounters];
    }

    public void printInstitution(){

        String[] clientNames = new String[numberOfCounters];
        int[] clientsLeftTime = new int[numberOfCounters];

        for (int i=0; i<clientAtTheCounters.length;i++){
            if (clientAtTheCounters[i]!=null){
                clientNames[i] = clientAtTheCounters[i].getName();
                clientsLeftTime[i] = clientAtTheCounters[i].getLeftTimeToEndACase();
            } else {
                clientNames[i] = "";
                clientsLeftTime[i] = 0;
            }
        }

        System.out.println("*********************************************************************\n");
        System.out.printf("%-18s |", "Counter No");
        for (int i=0; i<clientAtTheCounters.length;i++){
            System.out.printf("%-10d |", i+1);
        }
        System.out.println();
        System.out.printf("%-18s |", "Client Name");
        for (int i=0; i<clientAtTheCounters.length;i++){
            System.out.printf("%-10s |", clientNames[i]);
        }
        System.out.println();
        System.out.printf("%-18s |", "Client Left Time");
        for (int i=0; i<clientAtTheCounters.length;i++){
            System.out.printf("%-10d |", clientsLeftTime[i]);
        }
        System.out.println();
        System.out.println();
        queueOfClients.printQueue();


    }

    public void nextCycle(){
        for (int i=0; i<clientAtTheCounters.length;i++) {
            if (clientAtTheCounters[i]!=null) {
                clientAtTheCounters[i].setLeftTimeToEndACase(clientAtTheCounters[i].getLeftTimeToEndACase() - 1);
            }
        }
        for (int i=0; i<clientAtTheCounters.length;i++) {
            if (clientAtTheCounters[i]!=null) {
                if (clientAtTheCounters[i].getLeftTimeToEndACase() == 0) {
                    clientAtTheCounters[i] = null;
                }
            }
        }

        if (Math.random()<firstClientComeProbability){
            numberOfAllCLients++;
            queueOfClients.enqueue(new Client(new String("Client"+numberOfAllCLients),(int)(1+4*Math.random())));
        }

        if (Math.random()<secondClientComeProbability){
            numberOfAllCLients++;
            queueOfClients.enqueue(new Client(new String("Client"+numberOfAllCLients),(int)(1+4*Math.random())));
        }

         for (int i=0; i<clientAtTheCounters.length;i++) {
             if (clientAtTheCounters[i]==null){
                try {
                    clientAtTheCounters[i] = queueOfClients.dequeue();
                } catch (EmptyQueueException e) {
                }
            }
        }
    }



}
