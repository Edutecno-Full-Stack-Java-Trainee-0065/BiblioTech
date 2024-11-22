package algoritmos;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        AlertaStock.verificarStockCritico(data.getLibros(), 1L);
        AlertaStock.calcularPrestamosPeriodo(data.getPrestamos(), 1L, 11, 2023);
    }
}