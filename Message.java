import java.util.Base64;

public class Message
{
    private int messageSize; //4 byte
    private byte type;
    private byte[] messageBody;

    protected enum Typ
    {
        Choke, Unchoke, Interested, NotInterested, Have, Bitfield, Request, Piece
    }

    public Message(Typ type, byte[]msg)
    {
        switch(type)
        {
            case Choke:
                this.type = 0;
                break;
            case Unchoke:
                this.type = 1;
                break;
            case Interested:
                this.type = 2;
                break;
            case NotInterested:
                this.type = 3;
                break;
            case Have:
                this.type = 4;
                break;
            case Bitfield:
                this.type = 5;
                break;
            case Request:
                this.type = 6;
                break;
            case Piece:
                this.type = 7;
                break;
            default:
                this.type = 0;
                break;
        }
        if(msg == null)
        {
            this.messageSize = 1;
        }
        else
        {
            this.messageSize = 1 + msg.length;
        }
        this.messageBody = msg;
    }

    public int getType()
    {
        return this.type;
    }
    public int getSize()
    {
        return messageSize;
    }
    public String getMessage()
    {
        String toReturn = Base64.getEncoder().encodeToString(messageBody);
        return toReturn;
    }
    public void setMessageBody(byte[] input)
    {
        if(type == 4 || type == 5 || type == 6 || type == 7)
        {
            this.messageBody = input;
            this.messageSize = input.length;
        }
        else
        {

        }
    }
    public void displayType()
    {
        System.out.println(type + "\n");
    }
    public void displayMessageSize()
    {
        System.out.println(messageSize + "\n");
    }
    public void displayMessageBody()
    {
        System.out.println(messageBody + "\n");
    }


}
