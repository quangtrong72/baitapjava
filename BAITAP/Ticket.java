package BAITAP;

class TicketCounter {
    private int ticketsAvailable = 10; // Giả sử có 10 vé

    // Phương thức bán vé (đồng bộ hóa để tránh xung đột)
    public synchronized boolean sellTicket(String agencyName) {
        if (ticketsAvailable > 0) {
            System.out.println(agencyName + " bán vé số: " + ticketsAvailable);
            ticketsAvailable--;
            return true;
        } else {
            System.out.println(agencyName + " không thể bán, đã hết vé!");
            return false;
        }
    }
}

class TicketAgency extends Thread {
    private TicketCounter counter;
    private String agencyName;

    public TicketAgency(TicketCounter counter, String agencyName) {
        this.counter = counter;
        this.agencyName = agencyName;
    }

    public void run() {
        while (true) {
            boolean success = counter.sellTicket(agencyName);
            if (!success) {
                break; 
            }
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class Ticket {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(); 

       
        TicketAgency agency1 = new TicketAgency(counter, "Đại lý 1");
        TicketAgency agency2 = new TicketAgency(counter, "Đại lý 2");
        TicketAgency agency3 = new TicketAgency(counter, "Đại lý 3");

  
        agency1.start();
        agency2.start();
        agency3.start();
    }
}
