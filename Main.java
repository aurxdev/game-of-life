public class Main {

    public static void main(String[] args) {
        Motif motif=new Motif(); 
        // on créer le jeu à partir du fichier canon.txt
        JeuDeLaVie jeu = motif.createFromFile("canon.txt");

        // ajoute un bloc à la position (15,1)
        motif.bloc(jeu, 15,1);
        // ajoute une grenouille à la position (6,6)
        // motif.grenouille(jeu, 6, 6);
        // ajoute un planeur à la position (4,8)
        // motif.planeur(jeu,4, 8);

        int gen=0;
        while(true){
            System.out.println("Generation: "+gen);
            System.out.println(jeu.toString());
            jeu.suivant();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            gen++;
            System.out.println("\033[H\033[2J");
        }
    }
}
