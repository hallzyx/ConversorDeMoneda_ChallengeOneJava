public abstract class  temperatura {
    private double cantidad;
    private String nomina;
    private double token;

    public  temperatura(){
    }

    abstract void igualar();
    double convertir( int n){
        double rpta = 0;
        switch (n){
            case 0:
                rpta=5*token;
                break;

            case 1:
                rpta=5*token+273;
                break;

            case 2:
                rpta=9*token+32;
                break;
        }

        return rpta;
    };

    public double getCantidad() {
        return cantidad;
    }

    public String getNomina() {
        return nomina;
    }

    public double getToken() {
        return token;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setNomina(String nomina) {
        this.nomina = nomina;
    }

    public void setToken(double token) {
        this.token = token;
    }
}
