
import controller.loging.impl.ConsoleLogger;
import controller.loging.impl.LoggedComplexCalculator;
import model.ComplexCalc;
import view.View;


public class Main {
    public static void main(String[] args) {
        View view = new View(new LoggedComplexCalculator(new ComplexCalc(), new ConsoleLogger()));
        view.run();
    }
}