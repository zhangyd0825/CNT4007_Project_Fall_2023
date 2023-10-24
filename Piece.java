package CNT4007_Project_Fall_2023;

public class Piece extends Message
{

    public Piece(Typ type, String msg)
    {
        super(type, msg.getBytes());
    }
}
