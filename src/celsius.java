public class celsius extends temperatura {

    public celsius() {
       setNomina("C");
    }

    @Override
    void igualar() {
        setToken(getCantidad()/5);
    }


}
