package snake.pattern.utils;

public interface Observable 
{
    /**
     * Ajouter un Observateur
     * @param observateur
     */
    public void enregistrerObservateur(Observateur observateur);

    /**
     * Supprimer un observateur
     * @param observateur
     */
    public void supprimerObservateur(Observateur observateur);

    /**
     *Notifier tous les Observateur d'un changement
     */
    public void notifierObservateurs();
}
