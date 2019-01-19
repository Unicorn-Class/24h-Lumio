package fr.unicorn.lumiobase.sensors;

public class Led {
    private boolean state;
    private int num;

    public Led(int num, boolean state){
        this.state=state;
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean changeState(){
        return !(this.state);
    }
}
