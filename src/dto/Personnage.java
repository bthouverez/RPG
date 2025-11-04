package dto;

import java.util.Random;

public abstract class Personnage {
    public static int CPT = 0;
    protected int id;
    protected String nom;
    protected int pointsDeVie;
    protected int pointsDeVieMax;
    protected int forceFrappe;
    protected Arme arme;

    public Personnage() {
        CPT++;
        this.id = CPT;
        this.nom = "dto.Personnage";
        this.pointsDeVie = 100;
        this.pointsDeVieMax = 100;
        this.forceFrappe = 10;
        this.arme = null;
    }

    public Personnage(String nom, int pointsDeVie, int force) {
        CPT++;
        this.id = CPT;
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.pointsDeVieMax = pointsDeVie;
        this.forceFrappe = force;
        this.arme = null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getForceFrappe() {
        return forceFrappe;
    }

    public Arme getArme() {
        return arme;
    }

    public int getPointsDeVieMax() {
        return pointsDeVieMax;
    }
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public void setForceFrappe(int ff) {
        this.forceFrappe = ff;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setPointsDeVieMax(int pointsDeVieMax) {
        this.pointsDeVieMax = pointsDeVieMax;
    }

    public void attaquer(Personnage adversaire) {
        Random rnd = new Random();

        // Chance de rater
        if(rnd.nextInt(100) <= 1) {
            System.out.println(this.nom + " a raté son attaque contre " + adversaire.getNom() + " !");
            return;
        }

        int forceFrappeBase = 0;
        if(this.arme != null) {
            forceFrappeBase = this.forceFrappe + this.arme.getDegats();
        } else {
            forceFrappeBase = this.forceFrappe;
        }

        int degats = 0;
        if(rnd.nextInt(100) < 3) { // Chance de critique
            System.out.println(this.nom + " attaque critique " + adversaire.getNom() + " avec une force de " + 2*forceFrappeBase);
            degats = 2*forceFrappeBase;
        } else {
            System.out.println(this.nom + " attaque " + adversaire.getNom() + " avec une force de " + forceFrappeBase);
            degats = forceFrappeBase;
        }


        adversaire.recevoirCoups(degats);


        if(adversaire.getPointsDeVie() < 0) {
            adversaire.setPointsDeVie(0);
            System.out.println(adversaire.getNom() + " est mort !");
        }

    }

    public void recevoirCoups(int degats) {
        // parcourir le tableau des pieces d'armure
        //  calculer l'arùure totale
        // vérifier si les dégats - armure > 0
        // mettre à jour les pdv
        this.pointsDeVie -= degats;
        if(this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
            System.out.println(this.nom + " est mort !");
        }
    }



    public abstract String getType();

    @Override
    public String toString() {
        String s = "Un dto.Personnage nommé " + this.nom + " a "
                + this.pointsDeVie + " points de vie et une force de frappe de " + this.forceFrappe;
        if(this.arme != null) {
            s += " et une arme: " + this.arme;
        } else {
            s += " et pas d'arme";
        }
        return s;
    }

}
