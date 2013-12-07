import java.io.*;
class  poh_v1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 商品総数とキャンペーン日数の取得
        String[] sa = br.readLine().split(" ");
        int num_goods    = Integer.parseInt(sa[0]); // 商品総数
        int day_campaign = Integer.parseInt(sa[1]); // キャンペーン日数

        // 商品金額の取得
        int[] price = new int[num_goods];
        for (int i=0; i<num_goods; i++) {
            String[] s = br.readLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
        }

        // キャンペーン設定金額の取得
        int[] set_price = new int[day_campaign];
        for (int i=0; i<day_campaign; i++) {
            String[] s = br.readLine().split(" ");
            set_price[i] = Integer.parseInt(s[0]);
        }

        // キャンペーン設定金額に最も近い複合金額の算出と表示
        for (int i=0; i<day_campaign; i++) { // キャンペーンの日数分繰り返す
            int max_combi=0;
            for (int j=0; j<num_goods-1; j++) { // 商品の数-1だけ繰り返す
                for (int k=j+1; k<num_goods; k++) { // 自分以降の商品の数だけ繰り返す
                    int combi = price[j] + price[k];
                    if (combi == set_price[i]) { // 複合金額が設定金額と同じなら次へ
                        max_combi = combi;
                        break;
                    } else if (combi <= set_price[i] && combi > max_combi) {
                        max_combi = combi;
                    }
                }
                if (max_combi == set_price[i]) break; // 複合金額が設定金額なら次へ
            }
            System.out.println(max_combi); // 設定金額に最も近い複合金額を表示
        }
    }
}
