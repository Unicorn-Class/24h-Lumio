package fr.unicorn.lumiobase.sensors;

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

    public PushButton(int i) {
        num = i;
    }

    public boolean verif(){
        boolean t=false;
        if(this.num==led.getNum()){
            t=true;
        }
        return t;
    }
}
