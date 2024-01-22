import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class JeuDeLaVie{

    private int nbLignes, nbColonnes;
    private ArrayList<Integer> cellules; // 0 = morte, 1 = vivante

    // constructeur
    public JeuDeLaVie(int nbLignes, int nbColonnes){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.cellules = new ArrayList<Integer>(nbLignes*nbColonnes);
    } // JeuDeLaVie

    public JeuDeLaVie(){
        this.nbLignes = 10;
        this.nbColonnes = 10;
        this.cellules = new ArrayList<Integer>(nbLignes*nbColonnes);
    }

    // getters

    public int getNbLignes(){
        return nbLignes;
    }

    public int getNbColonnes(){
        return nbColonnes;
    }

    // setter
    public void setCel(int x, int y, int val){
        cellules.set(x*nbColonnes+y, val);
    }

    public void setNbLignes(int nbLignes){
        this.nbLignes = nbLignes;
    }

    public void setNbColonnes(int nbColonnes){
        this.nbColonnes = nbColonnes;
    }

    // initialise la grille avec des cellules mortes
    public void initialisation(){
        for(int i=0;i<nbLignes*nbColonnes;i++){
            cellules.add(0);
        }
    } // initialisation

    // initialise aléatoirement la grille
    public void initialisationAleatoire(int nbCellulesVivantes){
        for(int i=0; i<nbLignes*nbColonnes; i++){
            cellules.add(0);
        }
        for(int i=0; i<nbCellulesVivantes; i++){
            int x = (int)(Math.random()*nbLignes);
            int y = (int)(Math.random()*nbColonnes);
            cellules.set(x*nbColonnes+y, 1);
        }
    } // initialisationAleatoire

    // renvoie le nombre de voisins de la cellule (x,y)
    private int nbVoisins(int x, int y){
        int nbVoisins = 0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(i==0 && j==0)continue;
                if(x+i<0 || x+i>=nbLignes || y+j<0 || y+j>=nbColonnes)continue;
                if(cellules.get((x+i)*nbColonnes+y+j) == 1)nbVoisins++;
            }
        }
        return nbVoisins;
    } // nbVoisins

    // calcule la génération suivante
    public void suivant(){
        ArrayList<Integer> nouvelleCellules = new ArrayList<>(cellules.size());
        for(int i=0;i<nbLignes;i++){
            for(int j=0;j<nbColonnes;j++){
                int nbVoisins = nbVoisins(i,j);
                int indice=i*nbColonnes+j;
                if(nbVoisins<2)nouvelleCellules.add(0);
                else if(nbVoisins == 2)nouvelleCellules.add(cellules.get(indice));
                else if(nbVoisins == 3)nouvelleCellules.add(1);
                else nouvelleCellules.add(0);
            }
        }
        cellules = nouvelleCellules;
    } // suivant
    
    // renvoie une chaîne de caractères représentant la grille
    public String toString(){
        String s = "";
        for(int i=0; i<nbLignes; i++){
            for(int j=0; j<nbColonnes; j++){
                if(cellules.get(i*nbColonnes+j) == 0)s+=".";
                else s+="*";
            }
            s += "\n";
        }
        return s;
    } // toString

}

