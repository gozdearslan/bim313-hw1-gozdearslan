package edu.bim313;

import java.util.List;

import static edu.bim313.TurkishNetwork.cities;
import static edu.bim313.TurkishNetwork.distance;


public class Triangle {
    int a, b, c;

    public Triangle(List<Integer> list) {
        if(list.size()!=3){
            throw new IllegalArgumentException("A traingle must edges");
        }

        a= list.get(0);
        b= list.get(1);
        c= list.get(2);
    }

    @Override
    public String toString() {


        return  cities[a]+ " " +cities[b]+" "+cities[c];
    }

    public boolean checkInEquality() {

        return distance[b][a] + distance[b][c] >= distance[a][c];
    }
}
