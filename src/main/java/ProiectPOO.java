public class ProiectPOO {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Nothing to read here");
        } else {
            CitesteFisier citesteFisier = new CitesteFisier(args);
            CitesteFisierDecorator citesteFisierDecorator = new CitesteFisierDecorator(citesteFisier);
            citesteFisierDecorator.parcurge();
        }
    }
}
