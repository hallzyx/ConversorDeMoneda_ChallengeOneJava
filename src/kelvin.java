public class kelvin extends temperatura {
    public kelvin() {
        setNomina("K");

    }

    @Override
    void igualar() {
        setToken((getCantidad() - 273) / 5);
    }
}

