player1 = input("What is Player 1's name? ")
player2 = input("What is Player 2's name? ")

player1_answer = input(player1 + ", do you want to choose rock, paper or scissors? ").lower()
player2_answer = input(player2 + ", do you want to choose rock, paper or scissors? ").lower()

if player1_answer == player2_answer:
    print("It's a tie!")
elif player1_answer == 'rock':
    if player2_answer == 'scissors':
        print("Rock wins!")
    else:
        print("Paper wins!")
elif player1_answer == 'scissors':
    if player2_answer == 'paper':
        print("Scissors win!")
    else:
        print("Rock wins!")
elif player1_answer == 'paper':
    if player2_answer == 'rock':
        print("Paper wins!")
    else:
        print("Scissors win!")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")