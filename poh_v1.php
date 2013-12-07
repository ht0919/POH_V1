<?php
// 商品総数とキャンペーン日数の取得
fscanf(STDIN,"%d %d", $num_goods, $day_campaign);

// 商品金額の取得
for ( $i=0; $i < $num_goods; $i++ ) {
    fscanf(STDIN, "%d", $price[$i]);
}
sort($price); // 商品金額を並べ替えておく（高速化のため）

// キャンペーン設定金額の取得
for ( $i=0; $i < $day_campaign; $i++ ) {
    fscanf(STDIN, "%d", $set_price[$i]);
    $max_combi = 0;
    for ( $j=0; $j < $num_goods-1; $j++ ) { // 商品の数-1だけ繰り返す
        for ( $k=$j+1; $k < $num_goods; $k++ ) { // 自分以降の商品の数だけ繰り返す
            $combi = $price[$j] + $price[$k];
            if ($combi == $set_price[$i]) { // 複合金額が設定金額なら次へ
                $max_combi = $combi;
                break;
            } else if ($combi < $set_price[$i] && $combi > $max_combi) {
                $max_combi = $combi;
            }
        }
        if ($max_combi == $set_price[$i]) break; // 腹腔金額が設定金額なら次へ
    }
    echo $max_combi."\n"; // 設定金額に最も近い複合金額を表示
}
?>
