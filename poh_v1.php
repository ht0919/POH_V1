<?php
// 商品総数とキャンペーン日数の取得
fscanf(STDIN,"%d %d", $num_goods, $day_campaign);

// 商品金額の取得
for ( $i=0; $i < $num_goods; $i++ ) {
    fscanf(STDIN, "%d", $price[$i]);
}
// 商品金額の並べ替え
sort($price);

// キャンペーン設定金額の取得
for ( $i=0; $i < $day_campaign; $i++ ) {
    fscanf(STDIN, "%d", $set_price);
    // 最大金額のクリア
    $max_combi = 0;
    // 商品の数-1だけ繰り返す
    for ( $j=0; $j < $num_goods-1; $j++ ) {
        // 商品金額が設定金額以上なら次の商品へ
        if ($price[$j] >= $set_price) continue;
        // 自分以降の商品の数だけ繰り返す
        for ( $k=$j+1; $k < $num_goods; $k++ ) {
            $combi = $price[$j] + $price[$k];
            // 複合金額が設定金額より大きいなら次の商品へ
            if ($combi > $set_price) continue;
            // 複合金額が最大金額より大きいなら最大金額に代入
            if ($combi > $max_combi) $max_combi = $combi;
            //最大金額が設定金額と同じなら次の日へ
            if ($max_combi == $set_price) break;
        }
        //最大金額が設定金額と同じなら次の日へ
        if ($max_combi == $set_price) break;
    }
    echo $max_combi."\n";
}
?>
