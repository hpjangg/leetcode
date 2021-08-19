package line.pretest.singleton;

public class TicketMaker {
    private int ticket = 0;
    public int getNextTicketNumber() {
        return ticket++;
    }

    private TicketMaker() {}

    private volatile static TicketMaker ticketMaker;

    public static TicketMaker getInstance() {
        if (ticketMaker == null) {
            synchronized (TicketMaker.class) {
                if (ticketMaker == null) {
                    ticketMaker = new TicketMaker();
                }
            }
        }
        return ticketMaker;
    }

}
