public class ComandaRecomandaPreferinteUser extends ComandaUser{
    @Override
    public void executa(User user) {
        user.recomandaPreferinte();
    }
}
