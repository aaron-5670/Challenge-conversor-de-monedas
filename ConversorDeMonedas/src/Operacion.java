public class Operacion {
    private Double moneda;
    private Double divisa;
    public Double oper(){
        return this.moneda*this.divisa;
    }

    public Double getMoneda() {
        return this.moneda;
    }

    public void setMoneda(Double moneda) {
        this.moneda = moneda;
    }


    public void setDivisa(Double divisa) {
        this.divisa = divisa;
    }

}

