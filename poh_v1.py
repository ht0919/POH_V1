# coding: UTF-8
if __name__ == "__main__":
    # 商品総数とキャンペーン日数の取得
    num_goods, day_campaign = map(int, raw_input().split())
    # 商品金額の取得
    price = []
    for i in xrange(num_goods):
        price.append(input())
    price.sort()
    # キャンペーンの日数分繰り返す
    for i in xrange(day_campaign):
        # キャンペーン設定金額の取得
        set_price = input()
        # 最大複合価格のクリア
        max_combi = 0
        # 商品の数-1だけ繰り返す
        for j in xrange(num_goods-1):
            # 商品金額が設定金額を越えていたら次へ
            if price[j] >= set_price:
                continue
            # 自分以降の商品の数だけ繰り返す
            for k in xrange(j+1,num_goods):
                combi = price[j] + price[k];
                # 複合金額が設定金額以上なら次の日へ
                if combi > set_price:
                    continue
                # 複合金額が最大金額以下なら最大金額に代入
                if combi > max_combi:
                    max_combi = combi
                # 最大金額が設定金額と同じなら次の日へ
                if max_combi == set_price:
                    break
            # 最大金額が設定金額と同じなら次の日へ
            if max_combi == set_price:
                break
        print max_combi
