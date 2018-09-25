package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleShip {
    /*
    S = "1A 2A,12A 12A"
    T = "2B 2D 3D 4D 4A"
     */

    public static void main(String[] args) {
        System.out.println(solution(1, "1A 1A", ""));
    }

    public static String solution(int N, String S, String T) {
        if (S.trim().length() == 0 || T.trim().length() == 0) {
            return "0,0";
        }
        List<Ship> ships = parseShip(S);
        List<Point> hits = parseHit(T);

        int hit = 0;
        int sunk = 0;
        Iterator<Ship> shipIt = ships.iterator();
        while (shipIt.hasNext()) {
            Ship current = shipIt.next();
            int touching = current.getHits(hits);
            if (touching > 0) {
                if (touching == current.getSize()) {
                    sunk++;
                } else {
                    hit++;
                }
            }
        }
        return Integer.toString(sunk) + ',' + Integer.toString(hit);
    }

    public static List<Point> parseHit(String hits) {
        List<Point> hitsList = new ArrayList<>();
        String[] coords = hits.split(" ");
        for (String coord : coords) {
            hitsList.add(new Point(coord));
        }
        return hitsList;
    }

    public static List<Ship> parseShip(String ships) {
        List<Ship> shipsList = new ArrayList<>();
        String[] shipsCoords = ships.split(",");
        for (String shipCoord : shipsCoords) {
            shipCoord = shipCoord.trim();
            if (shipCoord.length() > 0) {
                String[] coords = shipCoord.split(" ");
                shipsList.add(new Ship(new Point(coords[0]), new Point(coords[1])));
            }
        }
        return shipsList;
    }

    static public class Ship {
        private Point topLeft;
        private Point bottomRight;

        public Ship(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public Point getTopLeft() {
            return topLeft;
        }

        public Point getBottomRight() {
            return bottomRight;
        }

        public int getSize() {
            return (Math.abs(topLeft.getX() - bottomRight.getX()) + 1)
                    * (Math.abs(topLeft.getY() - bottomRight.getY()) + 1);
        }

        public int getHits(List<Point> hits) {
            int touching = 0;
            for (Point hit : hits) {
                if (hit.downRight(topLeft) && hit.upLeft(bottomRight)) {
                    touching++;
                }
            }
            return touching;
        }

        @Override
        public String toString() {
            return "(" + topLeft + ", " + bottomRight + ")";
        }
    }

    static public class Point {
        int x;
        int y;

        public Point(String coord) {
            int alpha_idx = 0;
            for (int i = 0; i < coord.length(); i++) {
                if (coord.charAt(i) >= 'A') {
                    alpha_idx = i;
                    break;
                }
            }
            x = Integer.valueOf(coord.substring(0, alpha_idx));
            y = coord.charAt(alpha_idx) - 'A' + 1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean downRight(Point topLeft) {
            if (x >= topLeft.getX() && y >= topLeft.getY()) {
                return true;
            }
            return false;
        }

        public boolean upLeft(Point bottomRight) {
            if (x <= bottomRight.getX() && y <= bottomRight.getY()) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

    }
}
