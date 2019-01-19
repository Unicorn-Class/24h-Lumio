package fr.unicorn.lumiobase;

public class Animation {


    public static void colorWipe(Color rvb, int delay){
        for(int line = 0 ; line<Util.NB_LINE ; line++){
            for(int column = 0 ; column<Util.NB_COLUMN ; column++){
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //ColorPixel.SendColorPixel(rvb, Util.getIdPixel(line, column));
            }
        }
    }

    public static void verticalWipe(Color rvb, int delay){
        for(int line=0 ; line < Util.NB_LINE ; line++){
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TODO uncomment this
            //ColorLine.SendColorLine(rvb, Util.getIdLine(line));
        }
    }

    public static void rainbow(Color rvb, int delay){

    }

}
