public class Piece extends Message
{

    public Piece(Typ type, String msg)
    {
        super(type, msg.getBytes());
    }
}
