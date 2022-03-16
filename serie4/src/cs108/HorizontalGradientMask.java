package cs108;

public final class HorizontalGradientMask implements Image<Double> {


    @Override
    public Double apply(double x, double y) {

        if(x < -1){
            return 0.0;
        } if(x>1){
            return 1.0;
        }
        return (x+1) / 2;

    }
}

