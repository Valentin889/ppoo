package cs108;

public record Complex(double x, double y) {

    public double module(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public Complex add(Complex that){
        return new Complex(x+that.x , y + that.y);
    }

    public Complex squared(){
        double nx = Math.pow(x,2) - Math.pow(y,2);
        double ny = 2*x*y;
        return new Complex(nx,ny);
    }
}
