import java.io.BufferedReader;
import java.io.FileReader;

public class Motif {

    public void bloc(JeuDeLaVie jeu, int x, int y){
        if(x > 0 && x < jeu.getNbLignes() && y>0 && y<jeu.getNbColonnes()){
            jeu.setCel(x, y, 1);
            jeu.setCel(x+1, y, 1);
            jeu.setCel(x, y+1, 1);
            jeu.setCel(x+1, y+1, 1);
        }
    } // bloc

    public void grenouille(JeuDeLaVie jeu, int x, int y){
        if(x > 0 && x < jeu.getNbLignes() && y>0 && y<jeu.getNbColonnes()){
            jeu.setCel(x, y, 1);
            jeu.setCel(x,y+1,1);
            jeu.setCel(x,y+2,1);
            jeu.setCel(x+1, y-1, 1);
            jeu.setCel(x+1, y, 1);
            jeu.setCel(x+1, y+1, 1);

        }
    } // grenouille

    public void planeur(JeuDeLaVie jeu, int x,int y){
        if(x>0 && x<jeu.getNbLignes() && y>0 && y<jeu.getNbColonnes()){
            jeu.setCel(x, y, 1);
            jeu.setCel(x+1, y, 1);
            jeu.setCel(x+2, y, 1);
            jeu.setCel(x, y+1, 1);
            jeu.setCel(x+1, y+2, 1);
        }
    } // planeur

    public JeuDeLaVie createFromFile(String nom){
        JeuDeLaVie jeu = new JeuDeLaVie(20,40);
        jeu.initialisation();
        int i, nbColonnes;
        try{
            BufferedReader br = new BufferedReader(new FileReader(nom));
            String line;
            i=0;
            while((line = br.readLine()) != null){
                for(int j=0; j<line.length(); j++){
                    if(line.charAt(j) == '*'){
                        jeu.setCel(i, j, 1);
                    }
                }
                i++;
            }
            jeu.setNbLignes(i+10);
        }catch(Exception e){
            System.out.println(e);
        }
        return jeu;
    }
}
