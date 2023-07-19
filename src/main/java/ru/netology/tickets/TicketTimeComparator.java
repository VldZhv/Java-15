package ru.netology.tickets;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int flytime1 = t1.getTimeTo() - t1.getTimeFrom();
        int flytime2 = t2.getTimeTo() - t2.getTimeFrom();

        if (flytime1 < flytime2) {
            return -1;
        } else if (flytime1 > flytime2) {
            return 1;
        } else {
            return 0;
        }
    }
}
