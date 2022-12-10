package by.it.boycova.jd01_09;


 class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value=value;
    }

    public double getValue() {
        return value;
    }
    public Scalar(String stringValue) {

        this.value=Double.parseDouble(stringValue);
    }

    public Scalar(Scalar var1) {
        this.value=var1.value;
    }

    @Override
    public Var add(Var otherVar) {
        if(otherVar instanceof Scalar second){
            double summa=this.value+second.value;
            return new Scalar(summa);
        }else {
            return otherVar.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar second){
            double residual=this.value-second.value;
            return new Scalar(residual);
        }
        else {
            Scalar minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar second){
            double product=this.value*second.value;
            return new Scalar(product);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar second){
            if(second.value==0){
                return super.div(other);
            }else{
                double quotient=this.value/second.value;
                return new Scalar(quotient);
            }

        }else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}

