nums = list(input("Enter a sequence of comma separated values: ").split(", "))
sum = 0

for num in nums:
  sum += int(num)

print(sum)