#include <iostream>
int main(void) {

    int num_goods;      // 商品総数
    int day_campaign;   // キャンペーン日数
    int *price;         // 商品金額
    int set_price;      // キャンペーン設定金額
    int combi;          // 複合金額
    int max_combi;      // 最大複合金額

    // 商品総数とキャンペーン日数の取得
    std::cin >> num_goods >> day_campaign;

    // 商品金額の取得
    price = new int[num_goods];
    for( int i=0; i < num_goods; i++) {
        std::cin >> price[i];
    }
 
    // キャンペーン設定金額に最も複合金額の算出と表示
    for( int i=0; i < day_campaign; i++) {
        std::cin >> set_price; // キャンペーン設定金額の取得
        max_combi = 0;
        for( int j=0; j < num_goods-1; j++) { // 商品の数-1だけ繰り返す
          for( int k=j+1; k < num_goods; k++) { // 自分以降の商品の数だけ繰り返す
              combi = price[j] + price[k];
              // 複合金額が設定金額を超えていたら次の商品へ
              if (combi > set_price) continue;
              // 複合金額が最大金額を超えていたら代入 
              if (combi > max_combi) max_combi = combi;
              // 複合価格が設定金額と同じなら次の設定金額へ
              if (combi == set_price) break;
          }
          if (max_combi == set_price) break; // 複合価格が設定金額と同じなら次の設定金額へ
        }
        std::cout << max_combi << std::endl; // 設定金額に最も近い複合金額を表示
    }
    delete[] price;
    return 0;
}
