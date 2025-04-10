public class Main {
    public static void main(String[] args) {
        // Test d'intervalles fermés
        IntervFerme ferme1 = new IntervFerme(1, 5);
        IntervFerme ferme2 = new IntervFerme(3, 7);
        
        System.out.println("Intervalles fermés :");
        System.out.println("ferme1 = " + ferme1);
        System.out.println("ferme2 = " + ferme2);
        System.out.println("Intersection : " + ferme1.intersection(ferme2));
        System.out.println("Union : " + ferme1.union(ferme2));
        
        // Test d'intervalles ouverts
        IntervOuvert ouvert1 = new IntervOuvert(1, 5);
        IntervOuvert ouvert2 = new IntervOuvert(3, 7);
        
        System.out.println("\nIntervalles ouverts :");
        System.out.println("ouvert1 = " + ouvert1);
        System.out.println("ouvert2 = " + ouvert2);
        System.out.println("Intersection : " + ouvert1.intersection(ouvert2));
        System.out.println("Union : " + ouvert1.union(ouvert2));
        
        // Test d'appartenance
        System.out.println("\nTest d'appartenance :");
        System.out.println("2 appartient à ferme1 : " + ferme1.appartient(2));
        System.out.println("6 appartient à ferme1 : " + ferme1.appartient(6));
        System.out.println("2 appartient à ouvert1 : " + ouvert1.appartient(2));
        System.out.println("1 appartient à ouvert1 : " + ouvert1.appartient(1));
    }
} 