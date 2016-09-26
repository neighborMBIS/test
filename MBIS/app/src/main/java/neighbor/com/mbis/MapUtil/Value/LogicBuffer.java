package neighbor.com.mbis.MapUtil.Value;

import java.util.ArrayList;

/**
 * Created by user on 2016-09-08.
 */
public class LogicBuffer {

    private static LogicBuffer ourInstance = null;

    public static LogicBuffer getInstance() {
        if(ourInstance == null) {
            ourInstance = new LogicBuffer();
            return ourInstance;
        } else {
            return ourInstance;
        }
    }

    //계산용 버퍼
    private int arriveTimeBuf, startTimeBuf, stationArriveNumBuf, stationStartNumBuf;

    public static int jumpBuf[] = new int[]{-2, -1, 0};
    public static int startBuf[] = new int[]{-10, -10, -10};
    public static double locationXBuf=0, locationYBuf=0;
    public static int countBy_30sec = 30;
    ArrayList<String> stationListBuf = new ArrayList<String>();


    public int getArriveTimeBuf() {
        return arriveTimeBuf;
    }

    public void setArriveTimeBuf(int arriveTimeBuf) {
        this.arriveTimeBuf = arriveTimeBuf;
    }

    public int getStartTimeBuf() {
        return startTimeBuf;
    }

    public void setStartTimeBuf(int startTimeBuf) {
        this.startTimeBuf = startTimeBuf;
    }

    public int getStationArriveNumBuf() {
        return stationArriveNumBuf;
    }

    public void setStationArriveNumBuf(int stationArriveNumBuf) {
        this.stationArriveNumBuf = stationArriveNumBuf;
    }

    public int getStationStartNumBuf() {
        return stationStartNumBuf;
    }

    public void setStationStartNumBuf(int stationStartNumBuf) {
        this.stationStartNumBuf = stationStartNumBuf;
    }

    public ArrayList<String> getStationListBuf() {
        return stationListBuf;
    }

    public void setStationListBuf(ArrayList<String> stationListBuf) {
        this.stationListBuf = stationListBuf;
    }
}
