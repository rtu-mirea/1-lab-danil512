package com.company;
import java.util.ArrayList;

public class Map {
    protected class Edge{
        private String[] points = new String[2];
        private int backup;
        private  Edge(String place1,String place2, int backup) {
            this.backup = backup;
            points[0] = place1;
            points[1] = place2;
        }
        private String[] getPoints(){
            return points;
        }
        private int getBackup() {
         return backup;
        }
        private void setBackup(int backup) {//Странная функция
                    this.backup = backup;
        }
        }
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    public  void addEdge(String place1,String place2, int backup) {
        Edge per = new Edge(place1,place2,backup);
        edges.add(per);
    }
    public  void addBackypInfo(String place1,String place2, int backup) {
        String[] place = new String[2];
        place[0]= place1;
        place[1]= place2;
        for (int i = 0; i< edges.size(); i++){
            if (edges.get(i).getPoints()[0].equals(place1)&&edges.get(i).getPoints()[1].equals(place2))

                edges.get(i).setBackup(backup);
        }
    }
    public  int getAvaragebackup() {
        int Sum = 0;
        for (int i = 0; i< edges.size(); i++){
            Sum+= edges.get(i).getBackup();
        }
        return Sum/edges.size();
    }

    public  String generatepath(String place1,String place2) {
        String path = place1 +" ->";
        int minim  = 11;
        String[] points = new String[2];
        String per = place1;
        String lastper = "";

        int j = 0;
        while  (!per.equals(place2)){
            for (int i = 0; i < edges.size(); i++) {
                if ((edges.get(i).getPoints()[0].equals(per) || edges.get(i).getPoints()[1].equals(per))&&!edges.get(i).getPoints()[1].equals(lastper)&&!edges.get(i).getPoints()[0].equals(lastper)) {
                    if (minim > edges.get(i).getBackup()) {
                        minim = edges.get(i).getBackup();
                        points = edges.get(i).getPoints();
                        j = i;

                    }

                }

            }
            if (edges.get(j).getPoints()[0].equals(per)) {
                lastper = per;
                per = edges.get(j).getPoints()[1];

            } else {
                lastper = per;
                per = edges.get(j).getPoints()[0];
            }
            minim = 11;

            path += per + " ->";

        }

        return path;
    }

    }

