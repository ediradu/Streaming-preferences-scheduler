public class ComandaAscultaStreamUser extends ComandaUser {
    @Override
    public void executa(User user) {
        user.ascultaStream();
    }
}
