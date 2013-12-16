import java.io.*;
class  poh_v1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ¤•i‘”‚ÆƒLƒƒƒ“ƒy[ƒ““ú”‚Ìæ“¾
        String[] sa = br.readLine().split(" ");
        int num_goods    = Integer.parseInt(sa[0]); // ¤•i‘”
        int day_campaign = Integer.parseInt(sa[1]); // ƒLƒƒƒ“ƒy[ƒ““ú”

        // ¤•i‹àŠz‚Ìæ“¾
        int[] price = new int[num_goods];
        for (int i=0; i < num_goods; i++) {
            String[] s = br.readLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
        }

        // ƒLƒƒƒ“ƒy[ƒ“İ’è‹àŠz‚Ìæ“¾
        for (int i=0; i < day_campaign; i++) {
            String s = br.readLine();
            int set_price = Integer.parseInt(s);
            // Å‘å•¡‡‰¿Ši‚ÌƒNƒŠƒA
            int max_combi=0;
            // ¤•i‚Ì”-1‚¾‚¯ŒJ‚è•Ô‚·
            for (int j=0; j < num_goods-1; j++) {
                // ¤•i‹àŠz‚ªİ’è‹àŠzˆÈã‚È‚çŸ‚Ö
                if (price[j] >= set_price) continue;
                // ©•ªˆÈ~‚Ì¤•i‚Ì”‚¾‚¯ŒJ‚è•Ô‚·
                for (int k=j+1; k < num_goods; k++) {
                    int combi = price[j] + price[k];
                    // •¡‡‹àŠz‚ªİ’è‹àŠzˆÈã‚È‚ç‚Æ“¯‚¶‚È‚çŸ‚Ì“ú‚Ö
                    if (combi > set_price) continue;
                    // •¡‡‹àŠz‚ªÅ‘å‹àŠzˆÈ‰º‚È‚çÅ‘å‹àŠz‚É‘ã“ü
                    if (combi > max_combi) max_combi = combi;
                    // Å‘å‹àŠz‚ªİ’è‹àŠz‚Æ“¯‚¶‚È‚çŸ‚Ì“ú‚Ö
                    if (max_combi == set_price) break;
                }
                // Å‘å‹àŠz‚ªİ’è‹àŠz‚Æ“¯‚¶‚È‚çŸ‚Ì“ú‚Ö
                if (max_combi == set_price) break;
            }
            System.out.println(max_combi);
        }
    }
}
