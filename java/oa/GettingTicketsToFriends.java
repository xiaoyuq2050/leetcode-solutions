package oa;

import java.util.*;

public class GettingTicketsToFriends {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);

        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        List<Event> events = new ArrayList<>();
        while (numberOfEvents > 0) {
            String eventLine = scan.nextLine();
            // TODO: you will need to parse and store the events
            int x_space_idx = eventLine.indexOf(' ');
            int id = Integer.parseInt(eventLine.substring(0, x_space_idx));
            int y_space_idx = eventLine.indexOf(' ', x_space_idx + 1);
            int x = Integer.parseInt(eventLine.substring(x_space_idx + 1, y_space_idx));
            int y;
            int cur_idx = eventLine.indexOf(' ', y_space_idx + 1);
            if (cur_idx == -1) {
                continue;
            } else {
                y = Integer.parseInt(eventLine.substring(y_space_idx + 1, cur_idx));
            }
            while (cur_idx != -1) {
                int next_idx = eventLine.indexOf(' ', cur_idx + 1);
                if (next_idx == -1) {
                    events.add(new Event(id, x, y, Integer.parseInt(eventLine.substring(cur_idx + 1))));
                } else {
                    events.add(new Event(id, x, y, Integer.parseInt(eventLine.substring(cur_idx + 1, next_idx))));
                }
                cur_idx = next_idx;
            }
            numberOfEvents--;
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        while (numberOfBuyers > 0) {
            String buyerLine = scan.nextLine();
            // TODO: you will need to parse and store the buyers
            int x_space_idx = buyerLine.indexOf(' ');
            int x = Integer.parseInt(buyerLine.substring(0, x_space_idx));
            int y = Integer.parseInt(buyerLine.substring(x_space_idx + 1));
            for (Event e: events) {
                e.setDistance(x, y);
            }
            Collections.sort(events);
            if (events.size() > 0) {
                System.out.println(events.get(0).id + ' ' + events.get(0).price);
                events.remove(0);
            } else {
                System.out.println("-1 0");
            }
            numberOfBuyers--;
        }

        // The solution to the first sample above would be to output the following to console:
        // (Obviously, your solution will need to figure out the output and not just hard code it)
        System.out.println("2 50");
    }

    public static class Event implements Comparable<Event>{
        int id;
        int x;
        int y;
        int price;
        int distance;

        Event(int id, int x, int y, int price) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.price = price;
        }

        public void setDistance(int x, int y) {
            this.distance = calculateManhattanDistance(this.x, this.y, x, y);
        }

        public int compareTo(Event e1) {
            if (this.distance < e1.distance) {
                return -1;
            } else if (this.distance > e1.distance) {
                return 1;
            } else {
                if (this.price < e1.price) {
                    return -1;
                } else if (this.price > e1.price) {
                    return 1;
                } else {
                    if (this.id < e1.id) {
                        return -1;
                    } else if (this.id > e1.id) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }



    // The following method get the manhatten distance betwen two points (x1,y1) and (x2,y2)
    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
