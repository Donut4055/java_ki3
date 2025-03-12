package bt6;

public class MoveablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MoveablePoint() {
        super();
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ") with speed (" + xSpeed + ", " + ySpeed + ")";
    }
}
