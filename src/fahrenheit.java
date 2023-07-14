public class fahrenheit extends temperatura {

    public fahrenheit() {
        setNomina("F");

    }

    @Override
    void igualar() {
        setToken((getCantidad() - 32) / 9);
    }
}

