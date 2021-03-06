import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class  poh_v1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 商品総数とキャンペーン日数の取得
        String[] sa = br.readLine().split(" ");
        int num_goods    = Integer.parseInt(sa[0]); // 商品総数
        int day_campaign = Integer.parseInt(sa[1]); // キャンペーン日数

        // 商品金額の取得
        int[] price = new int[num_goods];
        for (int i=0; i < num_goods; i++) {
            String[] s = br.readLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
        }
        // 商品金額の並べ替え
        Arrays.sort(price);

        // キャンペーン設定金額の取得
        for (int i=0; i < day_campaign; i++) {
            String s = br.readLine();
            int set_price = Integer.parseInt(s);
            // 最大複合価格のクリア
            int max_combi=0;
            // 商品の数-1だけ繰り返す
            for (int j=0; j < num_goods-1; j++) {
                // 商品金額が設定金額以上なら次の商品へ
                if (price[j] >= set_price) continue;
                // 自分以降の商品の数だけ繰り返す
                for (int k=j+1; k < num_goods; k++) {
                    int combi = price[j] + price[k];
                    // 複合金額が設定金額より大きいなら次の商品へ
                    if (combi > set_price) continue;
                    // 複合金額が最大金額より大きいなら最大金額に代入
                    if (combi > max_combi) max_combi = combi;
                    // 最大金額が設定金額と同じなら次の日へ
                    if (max_combi == set_price) break;
                }
                // 最大金額が設定金額と同じなら次の日へ
                if (max_combi == set_price) break;
            }
            System.out.println(max_combi);
        }
    }
}
