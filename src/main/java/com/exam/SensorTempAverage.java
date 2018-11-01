package com.exam;

import java.util.*;
import java.util.Map.Entry;

public class SensorTempAverage {

    private long duration;


    public  TreeMap<Integer,Double> storeTimeTemp(String data,TreeMap<Integer,Double>timeTempMap){
        String[] dataArray=data.split(",");
        int time=Integer.parseInt(dataArray[1]);
        double temp=Double.parseDouble(dataArray[2]);
        timeTempMap.put(time,temp);

        return timeTempMap;
    }
    public List<String> calculateAverage(TreeMap<Integer,Double>timeTempMap){
        List<String> finalOutput=new ArrayList<String>();
        int firstUpperLimit=timeTempMap.firstKey();
        int lastLimit=timeTempMap.lastKey();
        int countElement=0;
        double sum=0;
        long checkPoint=firstUpperLimit+(getDuration()-1);
        for (Entry<Integer,Double> entry : timeTempMap.entrySet()) {
            Integer key = entry.getKey();
            if(key<=checkPoint){
                sum=sum+entry.getValue();
                ++countElement;

            }else{
                    String element = (checkPoint - getDuration() + 1) + "-" + checkPoint;
                    Double elementValue = sum / countElement;
                    finalOutput.add(element+":"+elementValue);
                    sum = entry.getValue();
                    countElement = 1;
                    checkPoint = checkPoint + getDuration();
                if(entry.getKey()==lastLimit){
                    element = (checkPoint - getDuration() + 1) + "-" + checkPoint;
                    elementValue = sum / countElement;
                    finalOutput.add(element+":"+elementValue);
                }

            }

        }
        return finalOutput;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * Execution
     * @param data
     */

    /*
    public static void main(String[] data){
        SensorTempAverage sensorTempAverage=new SensorTempAverage();
        sensorTempAverage.setDuration(1000);
        TreeMap<Integer,Double>timeTempMap=new TreeMap<Integer, Double>();

        String[] s1={"1,10000,40 ","1,10002,45 ","1,11015,50 ","2,10005,42 ","2,11051,45 ","2,12064,42 ","2,13161,42"};
        for (String s:s1){

            sensorTempAverage.storeTimeTemp(s,timeTempMap);
        }
        System.out.println(sensorTempAverage.calculateAverage(timeTempMap));

    }
    */

}
