package neighbor.com.test321.CSV_Util;

import java.util.ArrayList;

/**
 * Created by user on 2016-08-25.
 */
public class ReferenceUtil {
    private static ReferenceUtil ourInstance = new ReferenceUtil();

    public static ReferenceUtil getInstance() {
        return ourInstance;
    }
    private ReferenceUtil() {
        referenceLatPosition = new ArrayList<Double>();
        referenceLngPosition = new ArrayList<Double>();
        distance = new ArrayList<Double>();
        refernceUniqueNum = new ArrayList<Integer>();
    }

    private String routeName;
    private ArrayList<Double> referenceLatPosition;
    private ArrayList<Double> referenceLngPosition;
    private ArrayList<Double> distance;
    private ArrayList<Integer> refernceUniqueNum;

    public ArrayList<Double> getDistance() {
        return distance;
    }

    public void setDistance(ArrayList<Double> distance) {
        this.distance = distance;
    }


    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        String[] buf = routeName.split("-");
        if(buf.length != 2) {
            this.routeName = routeName + "-00";
        } else this.routeName = routeName;
    }



    public ArrayList<Double> getReferenceLatPosition() {
        return referenceLatPosition;
    }

    public void setReferenceLatPosition(ArrayList<Double> referenceLatPosition) {
        this.referenceLatPosition = referenceLatPosition;
    }

    public ArrayList<Double> getReferenceLngPosition() {
        return referenceLngPosition;
    }

    public void setReferenceLngPosition(ArrayList<Double> referenceLngPosition) {
        this.referenceLngPosition = referenceLngPosition;
    }

    public ArrayList<Integer> getRefernceUniqueNum() {
        return refernceUniqueNum;
    }

    public void setRefernceUniqueNum(ArrayList<Integer> refernceUniqueNum) {
        this.refernceUniqueNum = refernceUniqueNum;
    }

    public void addReferenceLatPosition(double item) {
        referenceLatPosition.add(item);
    }
    public void addReferenceLngPosition(double item) {
        referenceLngPosition.add(item);
    }
    public void addRefernceUniqueNum(int item) {
        refernceUniqueNum.add(item);
    }
    public void addDistance(double item) {distance.add(item);}

}
