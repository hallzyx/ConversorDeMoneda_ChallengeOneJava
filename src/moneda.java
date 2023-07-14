  class moneda {

    private String nomina;
    private double valor;
    private double tasa;

      public moneda(){

      }

      public moneda(double valor, String nomina) {
        this.valor = valor;
        this.nomina= nomina;
    }




    public double exchange(){
        return (tasa*valor);
    }
    public void setNomina(String nomina) {
          this.nomina = nomina;
      }
    public String getNomina() {
        return nomina;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getTasa() {
        return tasa;
    }
    public void setTasa(double tasa) {
          this.tasa = tasa;
      }
  }
