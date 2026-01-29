package com.example.tp2graphique.Models;

public class Pays
{
    private String nomPays;
    private int nbHabitants;
    private String nomCapitale;

    public Pays(String nomPays, int nbHabitants, String nomCapitale)
    {
        this.nomPays = nomPays;
        this.nbHabitants = nbHabitants;
        this.nomCapitale = nomCapitale;
    }

    public String getNomPays()
    {
        return nomPays;
    }

    public void setNomPays(String nomPays)
    {
        this.nomPays = nomPays;
    }

    public int getNbHabitants()
    {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants)
    {
        this.nbHabitants = nbHabitants;
    }

    public String getNomCapitale()
    {
        return nomCapitale;
    }

    public void setNomCapitale(String nomCapitale)
    {
        this.nomCapitale = nomCapitale;
    }
}
