public class PiesaMuzicala extends Stream {
    private TipPiesaMuzicala tipPiesaMuzicala;
    public PiesaMuzicala(Integer id, Integer streamGenre, Long nooflistenings, Integer streamerId, Long length, Long dateAdded, String name) {
        super(id, nooflistenings, streamerId, length, dateAdded, name);
        parseazaStreamGenre(streamGenre);
    }
    @Override
    public void parseazaStreamGenre(Integer streamGenre) {
        if (streamGenre.equals(TipPiesaMuzicala.Pop.ordinal() + 1))
            this.tipPiesaMuzicala = TipPiesaMuzicala.Pop;
        else if (streamGenre.equals(TipPiesaMuzicala.Latin.ordinal() + 1))
            this.tipPiesaMuzicala = TipPiesaMuzicala.Latin;
        else if (streamGenre.equals(TipPiesaMuzicala.House.ordinal() + 1))
            this.tipPiesaMuzicala = TipPiesaMuzicala.House;
        else if (streamGenre.equals(TipPiesaMuzicala.Dance.ordinal() + 1))
            this.tipPiesaMuzicala = TipPiesaMuzicala.Dance;
        else if (streamGenre.equals(TipPiesaMuzicala.Trap.ordinal() + 1))
            this.tipPiesaMuzicala = TipPiesaMuzicala.Trap;
    }
    public TipPiesaMuzicala getTipPiesaMuzicala() {
        return tipPiesaMuzicala;
    }
}
