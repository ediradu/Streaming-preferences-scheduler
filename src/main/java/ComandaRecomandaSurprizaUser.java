public class ComandaRecomandaSurprizaUser extends ComandaUser {
    @Override
    public void executa(User user) {
        user.recomandaSurpriza();
    }
}
