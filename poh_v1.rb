# 商品総数とキャンペーン日数の取得
inputStr = gets.chomp.split(" ")
num_goods    = inputStr[0].to_i
day_campaign = inputStr[1].to_i

# 商品金額の取得
price = []
num_goods.times do
  price.push(gets.to_i)
end
# 商品金額の並べ替え
price.sort!

# キャンペーン設定金額の取得
day_campaign.times do |i|
  set_price = gets.chomp.to_i
  # 最大複合金額のクリア
  max_combi = 0
  # 商品の数-1だけ繰り返す
  from = 0
  to   = num_goods - 2
  for j in from..to
    # 商品金額が設定金額以上なら次へ
    if price[j] >= set_price then next end
    # 自分以降の商品の数だけ繰り返す
    from = j + 1
    to   = num_goods - 1
    for k in from..to do
      combi = price[j] + price[k]
      # 複合金額が設定金額より大きいなら次の金額へ
      if combi > set_price then next end
      # 複合金額が最大金額より大きいなら最大金額に代入
      if combi > max_combi then max_combi = combi end
      # 最大金額が設定金額と同じなら次の日へ
      if max_combi == set_price then break end
    end
    # 最大金額が設定金額と同じなら次の日へ
    if max_combi == set_price then break end
  end
  print max_combi, "\n"
end
