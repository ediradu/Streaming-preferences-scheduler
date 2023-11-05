public class ComandaFactory {
    public IComanda creazaComanda(Integer id, String comanda) {
        switch (comanda) {
            case "LIST": {
                if (Singleton.Instanta().streamerHashMap.containsKey(id)) {
                    return new ComandaListeazaStreamer();
                } else if (Singleton.Instanta().userHashMap.containsKey(id)) {
                    return new ComandaListeazaUser();
                }
                break;
            }
            case "ADD": {
                return new ComandaAdaugaStream();
            }
            case "DELETE": {
                return new ComandaStergeStream();
            }
            case "LISTEN": {
                return new ComandaAscultaStreamUser();
            }
            case "RECOMMEND": {
                return new ComandaRecomandaPreferinteUser();
            }
            case "SURPRISE": {
                return new ComandaRecomandaSurprizaUser();
            }
            default: {
                return null;
            }
        }
        return null;
    }
}
