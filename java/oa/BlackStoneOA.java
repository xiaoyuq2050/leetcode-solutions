package oa;

import java.io.IOException;

import java.util.*;

public class BlackStoneOA {
    public static void main(String[] args) throws IOException {
        String line = "Vodafone,STOCK,10,50,0|Google,STOCK,15,50,0|Microsoft,BOND,15,100,0.05:Vodafone,STOCK,15,50,0|Google,STOCK,10,50,0|Microsoft,BOND,15,100,0.05";
        int port_idx = line.indexOf(':');
        String port = line.substring(0, port_idx);
        String ben = line.substring(port_idx + 1);
        Map<String, String> port_map = getMap(port);
        Map<String, String> ben_map = getMap(ben);
        Map<String, float[]> port_m = betterMap(port_map);
        Map<String, float[]> ben_m = betterMap(ben_map);
        float total_port = 0;
        float total_ben = 0;
        for (Map.Entry<String, float[]> e: port_m.entrySet()) {
            total_port += e.getValue()[2];
        }
        for (Map.Entry<String, float[]> e: ben_m.entrySet()) {
            total_ben += e.getValue()[2];
        }
        Map<String, Float> change = new HashMap<>();
        for (Map.Entry<String, float[]> e: port_m.entrySet()) {
            float per_port = e.getValue()[2] / total_port;
            float per_ben;
            if (ben_m.get(e.getKey()) == null) {
                per_ben = 0;
            } else {
                per_ben = ben_m.get(e.getKey())[2] / total_ben;
            }
            change.put(e.getKey(), per_port - per_ben);
        }
        // add when only in benchmark
        for (Map.Entry<String, Float> e: change.entrySet()) {
            if (e.getValue() != 0) {
                int bs_share = Math.round(e.getValue() * total_port / port_m.get(e.getKey())[1]);
                if (bs_share > 0) {
                    System.out.println("SELL," + e.getKey() + ',' + Math.abs(bs_share));
                }
                if (bs_share < 0) {
                    System.out.println("BUY," + e.getKey() + ',' + Math.abs(bs_share));
                }
            }
        }
    }

    public static Map<String, String> getMap(String port) {
        Map<String, String> port_map = new HashMap<>();
        int idx = 0;
        int next_idx;
        while (idx != -1 && idx < port.length()) {
            next_idx = port.indexOf('|', idx + 1);
            if (next_idx == -1) {
                String stock = port.substring(idx);
                String stockname = stock.substring(0, stock.indexOf(','));
                String stockattr = stock.substring(stock.indexOf(',') + 1);
                port_map.put(stockname, stockattr);
                break;
            }
            String stock = port.substring(idx, next_idx);
            int name = stock.indexOf(',');
            String stockname = stock.substring(0, name);
            String stockattr = stock.substring(name + 1);
            port_map.put(stockname, stockattr);
            idx = next_idx + 1;
        }
        return port_map;
    }

    public static Map<String, float[]> betterMap(Map<String, String> ori) {
        Map<String, float[]> res = new HashMap<>();
        for (Map.Entry<String, String> entry: ori.entrySet()) {
            int share_int = entry.getValue().indexOf(',');
            int price_int = entry.getValue().indexOf(',', share_int + 1);
            int inter_int = entry.getValue().indexOf(',', price_int + 1);
            String type = entry.getValue().substring(0, share_int);
            int share = Integer.valueOf(entry.getValue().substring(share_int + 1, price_int));
            float price = Integer.valueOf(entry.getValue().substring(price_int + 1, inter_int));
            float interest = Float.valueOf(entry.getValue().substring(inter_int + 1));
            if (interest != 0 && type.equals("BOND")) {
                price = (float)((price + interest) * 0.01);
            }
            float[] info = new float[]{share, price, share * price};
            res.put(entry.getKey(), info);
        }
        return res;
    }
}
