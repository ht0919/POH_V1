using System;
class poh_v1 {
    public static void Main(String[] args) {
        // 商品総数とキャンペーン日数の取得
        String[] str = System.Console.ReadLine().Trim().Split(' ');
        int num_goods    = Int32.Parse(str[0]);
        int day_campaign = Int32.Parse(str[1]);
        // 商品金額の取得
        int[] price = new int[num_goods];
        for (int i=0; i < num_goods; i++) {
            price[i] = Int32.Parse(System.Console.ReadLine().Trim());
        }
        Array.Sort(price);
        // キャンペーン設定金額の取得
        int[] set_price = new int[day_campaign];
        for (int i=0; i < day_campaign; i++) {
            set_price[i] = Int32.Parse(System.Console.ReadLine().Trim());
        }
        // キャンペーンの日数分繰り返す
        for (int i=0; i < day_campaign; i++) {
            int max_combi = 0;
            // 商品の数-1だけ繰り返す
            for(int j=0; j < num_goods-1; j++) {
            // 自分以降の商品の数だけ繰り返す
                for(int k=j+1; k < num_goods; k++) {
                    int combi = price[j] + price[k];
                    // 複合金額が設定金額を超えていたら次の商品へ
                    if (combi > set_price[i]) continue;
                    // 複合金額が最大金額を超えていたら代入 
                    if (combi > max_combi) max_combi = combi;
                    // 複合価格が設定金額と同じなら次の設定金額へ
                    if (combi == set_price[i]) break;
                }
                // 複合価格が設定金額と同じなら次の設定金額へ
                if (max_combi == set_price[i]) break;
            }
            // キャンペーン設定金額に最も複合金額の算出と表示
            System.Console.WriteLine("{0}", max_combi);
        }
    }
}
