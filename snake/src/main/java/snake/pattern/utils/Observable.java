package snake.pattern.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable 
{
    /**
     * Ajouter un Observateur
     * @param observateur
     */
    public abstract void enregistrerObservateur(Observateur observateur);

    /**
     * Supprimer un observateur
     * @param observateur
     */
    public abstract void supprimerObservateur(Observateur observateur);

    /**
     *Notifier tous les Observateur d'un changement
     */
    public abstract void notifierObservateurs();

    protected List<Observateur> views;

    protected Observable()
    {
        views = new ArrayList<>();
    }
}
