public class App {
    public static void main(String[] args) throws Exception {
        Distributeur d1 = new Distributeur();
        while(d1.choisirAction() != -1){
            // En fonctionnement
        }
        System.out.println("Arret du distributeur...");
    }
}
