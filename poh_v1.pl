# 商品総数とキャンペーン日数の取得
use strict;
use warnings;

my $inStr = <STDIN>;
my @arrStr = split(/ /, $inStr);
my $num_goods    = int($arrStr[0]);
my $day_campaign = int($arrStr[1]);

# 商品金額の取得
my @price;
for(my  $i=0; $i < $num_goods; $i++ ) {
    $price[$i] = int(<STDIN>);
}
@price = sort @price;

# キャンペーン設定金額の取得
for(my  $i=0; $i < $day_campaign; $i++ ) {
    my $set_price = int(<STDIN>);
    # 最大複合価格のクリア
    my $max_combi = 0;
    # 商品の数-1だけ繰り返す
    for(my  $j=0; $j < $num_goods-1; $j++ ) {
        # 商品金額が設定金額を越えていたら次へ
        if ( $price[$j] >= $set_price) { next; }
        # 自分以降の商品の数だけ繰り返す
        for(my  $k=$j+1; $k < $num_goods; $k++ ) {
            my $combi = $price[$j] + $price[$k];
            # 複合金額が設定金額以上なら次の日へ
            if( $combi > $set_price ) { next; }
            # 複合金額が最大金額以下なら最大金額に代入
            if( $combi > $max_combi) { $max_combi = $combi; }
            # 最大金額が設定金額と同じなら次の日へ
            if( $max_combi == $set_price ) { last; }
        }
        # 最大金額が設定価格と同じなら次の日へ
        if( $max_combi == $set_price ) { last; }
    }
    print "$max_combi\n";
}
