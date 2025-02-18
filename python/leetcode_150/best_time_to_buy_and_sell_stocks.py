def max_profit(prices):
    min_p = float('inf')
    max_p = 0

    for price in prices:
        if price < min_p:
            min_p = price
        
        profit = price - min_p

        if profit > max_p: 
            max_p =  profit
    
    return max_p

            
print(max_profit([7,3,6,1,1,9]))

