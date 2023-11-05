public class ComandaListeazaUser extends ComandaUser {
    @Override
    public void executa(User user) {
        user.listeazaUser();
    }
}
