import java.util.Scanner;

public class Distributeur implements Boisson {

    private double somme;

    public Distributeur(){
        this.somme = SOMME_INITIAL;
    }

    @Override
    public int checkPayement(Breuvage boisson) {
        double cost = 0;
        System.out.println("Ma boisson " + boisson);
        if(boisson != Breuvage.CAFE && boisson != Breuvage.THE) return -1;
        System.out.println("Prix = " + cost);
        if(boisson == Breuvage.THE)
            cost = the;
        System.out.println("Prix = " + cost);
        if(boisson == Breuvage.CAFE)
            cost = cafe;
        System.out.println("Prix = " + cost);
        if(somme - cost < 0)return -1;
        somme -= cost;
        return 0;
    }

    @Override
    public int choisirAction() {
        System.out.println("Solde actuel: " + somme);
        System.out.println("Choisissez une action:");
        System.out.println("\t1) Ajouter une pièce");
        System.out.println("\t2) Choisir une boisson");
        Scanner sc = new Scanner(System.in);
        String choix = sc.next();
        switch (choix) {
            case "1":
                introductionPiece();
                break;
            case "2":
            	Breuvage b = choisirBoisson();
                if(b == Breuvage.ERROR)break;
                if(checkPayement(b) == -1)break;
                // Dire quelle boisson
                if(b==Breuvage.CAFE)System.out.println("Vous avez choisi un café");
                if(b==Breuvage.THE)System.out.println("Vous avez choisi un thé");
                double m = rendreMonnaie();
                System.out.println(m + "€ a été rendu");
                break;
            // Cas pour mettre la machine en mode maintenance
            case "99":
                return -1;
            default:
                System.out.println("Mauvaise entrée");
                break;
        }
        return 0;
    }

    @Override
    public Breuvage choisirBoisson() {
        clearScreen();
        System.out.println("Choisissez une boisson:");
        System.out.println("\t1) Prendre du café (1.50€)");
        System.out.println("\t2) Prendre un thé (1.00€)");
        System.out.println("\tx) Retour");
        Scanner sc = new Scanner(System.in);
        String choix = sc.next();
        switch (choix) {
            case "2":
                return Breuvage.THE;
            case "1":
                return Breuvage.CAFE;
            default:
                return Breuvage.ERROR;
        }
    }

    @Override
    public void introductionPiece() {
        System.out.println("\t1) Ajouter 50cts");
        System.out.println("\t2) Ajouter 1€");
        System.out.println("\tx) Retour");
        Scanner sc = new Scanner(System.in);
        String choix = sc.next();
        switch (choix) {
            case "1":
                ajouterPiece(0.5);
                break;
            case "2":
            	ajouterPiece(1.0);
                break;
            default:
                break;
        }
        clearScreen();
    }

   public void ajouterPiece(double p) {
	   somme += p;
   }
   
    @Override
    public double rendreMonnaie() {
        double rendre = somme;
        somme = 0.0;
        return rendre;
    }

    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
}
