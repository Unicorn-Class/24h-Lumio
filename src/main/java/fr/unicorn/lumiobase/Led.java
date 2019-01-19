package fr.unicorn.lumiobase;

public class Led {
    private boolean state;
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Led(int num, boolean state){
        this.state=state;
        this.num=num;
    }
    private int num;

    public boolean changeState(){
        return !(this.state);
    }
}
