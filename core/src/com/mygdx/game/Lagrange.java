package com.mygdx.game;

import java.util.ArrayList;

//http://www.inf.u-szeged.hu/~kgelle/sites/default/files/upload/08_polinomok_interpolacio.pdf
public class Lagrange {

    public class Point{

        float x = 0;
        float y = 0;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    ArrayList<Point> points = new ArrayList<Point>();

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addpoint(float x, float y){
        points.add(new Point(x, y));
    }

    public float getY(float x){
        int count = points.size();
        float sum = 0;
        for (int i = 0; i < count; i++){
            float mul = 1;
            for(int j = 0; j<count; j++){
                if (i!=j){
                    mul*=(x-points.get(j).x)/(points.get(i).x - points.get(j).x);
                }
            }
            sum += points.get(i).y*mul;
        }
        return sum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lagrange l = new Lagrange();
        l.addpoint(-1, 2);
        l.addpoint(0, 0);
        l.addpoint(1, 4);
        l.addpoint(4, 0);

        System.out.println(" X = " + -1 + " Y = " + l.getY(-1));
        System.out.println(" X = " + 0 + " Y = " + l.getY(0));
        System.out.println(" X = " + 1 + " Y = " + l.getY(1));
        System.out.println(" X = " + 4 + " Y = " + l.getY(4));

        System.out.println("------------");
        for(float x = -10; x<10; x+=0.1f){
            System.out.println(" X = " + x + " Y = " + l.getY(x));
        }
        // TODO code application logic here
    }
}
