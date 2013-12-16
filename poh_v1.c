#include <stdio.h>
int main(void) {

    int num_goods;      // 商品総数
    int day_campaign;   // キャンペーン日数
    int price[500000];  // 商品金額
    int set_price;      // キャンペーン設定金額
    int combi;          // 複合金額
    int max_combi;      // 最大複合金額
    int i, j, k;        // ループ用カウンタ変数

    // 商品総数とキャンペーン日数の取得
    scanf("%d %d", &num_goods, &day_campaign);

    // 商品金額の取得
    for( i=0; i < num_goods; i++) {
        scanf("%d", &price[i]);
    }
 
    // キャンペーン設定金額の取得
    for( i=0; i < day_campaign; i++) {
        scanf("%d", &set_price);
        // 最大複合金額のクリア
        max_combi = 0;
        // 商品の数-1だけ繰り返す
        for( j=0; j < num_goods-1; j++) {
            // 商品金額が設定金額以上なら次の商品へ
            if (price[j] >= set_price) continue;
            // 自分以降の商品の数だけ繰り返す
            for( k=j+1; k < num_goods; k++) {
                combi = price[j] + price[k];
                // 複合金額が設定金額以上なら次の商品へ
                if (combi > set_price) continue;
                // 複合金額が最大金額以上なら最大金額に代入 
                if (combi > max_combi) max_combi = combi;
                // 最大金額が設定金額と同じなら次の日へ
                if (max_combi == set_price) break;
            }
            // 最大金額が設定金額と同じなら次の日へ
            if (max_combi == set_price) break;
        }
        printf("%d\n", max_combi);
    }
    return 0;
}
