# 商品総数とキャンペーン日数の取得
inputStr = gets.chomp.split(" ")
num_goods    = inputStr[0].to_i
day_campaign = inputStr[1].to_i

# 商品金額の取得
price = []
num_goods.times do
  price.push(gets.to_i)
end

# キャンペーン設定金額に最も近い複合金額の算出と表示
day_campaign.times do |i|
  set_price = gets.chomp.to_i
  max_combi = 0
  num_goods.times do |j|
    num_goods.times do |k|
      combi = price[j] + price[k]
      if combi > set_price
        next
      end
      if combi <= set_price and max_combi <= combi and j != k
        max_combi = combi
      end
      if max_combi == set_price
        break
      end
    end
    if max_combi == set_price
        break
    end
  end
  print max_combi, "\n"
end
