package com.twh5257_jdm5908_bw.ist402.fibonacciflower;

public class Flower {

    public final double GOLDEN_RATIO = .618033989, GROW_WIDTH = .03 * GOLDEN_RATIO, GROW_HEIGHT = .03 * GOLDEN_RATIO;

    private double angle;
    private int rotate, xCenter, yCenter;
    private float scaleX, scaleY, degenerate;

    public Flower() {
        rotate = 0;
        scaleX = (float) .3;
        scaleY = (float) .3;
        degenerate = (float) 1.00;
        angle = 360 * GOLDEN_RATIO;
    }

    public void initialize() {
        rotate = 0;
        scaleX = (float) .3;
        scaleY = (float) .3;
        degenerate = (float) 1.00;
        angle = 360 * GOLDEN_RATIO;

    }

    public float getScaleX(){
        return scaleX;
    }
    public void setScaleX(float scaleX){
        this.scaleX = scaleX;
    }
    public float getScaleY(){
        return scaleY;
    }
    public void setScaleY(float scaleY){
        this.scaleY = scaleY;
    }
    public void setRotate(int rotate) {
        this.rotate = rotate;
    }
    public int getRotate() {
        return rotate;
    }
    public void set_xCenter(int xCenter){
        this.xCenter = xCenter;
    }
    public int get_xCenter(){
        return xCenter;
    }

    public void set_yCenter(int yCenter){
        this.yCenter = yCenter;
    }
    public int get_yCenter(){
        return yCenter;
    }

    public void setDegenerate(float degenerate){
        this.degenerate = degenerate;
    }
    public void initializeAngle (){
        angle = 360 * GOLDEN_RATIO;
    }

    public void updatePetalValues() {
        rotate += angle;
        scaleX += scaleX * GROW_WIDTH;
        scaleY += scaleY * GROW_HEIGHT;
        angle *= degenerate;
    }
}
