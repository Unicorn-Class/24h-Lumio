package fr.unicorn.lumiobase.sensors;

import fr.unicorn.lumiobase.Led;

import java.util.ArrayList;

public class PushButton {
    private int num;
    private Led led;

    //private ArrayList<PushButton> ;
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean verif(){
        boolean t=false;
        if(this.num==led.getNum()){
            t=true;
        }
        return t;
    }
}
