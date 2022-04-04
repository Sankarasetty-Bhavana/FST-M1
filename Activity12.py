def calSum(num):
  if num:
    return num + calSum(num-1)
  else:
    return 0
res = calSum(10)

print(res)