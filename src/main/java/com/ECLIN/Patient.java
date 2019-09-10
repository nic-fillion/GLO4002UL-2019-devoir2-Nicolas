package com.ECLIN;

public class Client {
    
    String clientName;
    int clientGravity;
    VisibleSymptom clientVisibleSymptom;
    
    public Client(String name, int gravity, VisibleSymptom visibleSymptom) {
        this.clientName = name;
        this.clientGravity = gravity;
        this.clientVisibleSymptom = visibleSymptom;
    }
}
