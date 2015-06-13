def info():

	""" A function that asks for a user's name, age, and reddit username,
	which it then prints back out to the user. Exciting!

	"""
	name = input("What's your name? ")

	#initialized to -1 to be able to pass the while statement for 1st run.
	age = -1

	#used to show warning on invalid age inputs
	notFirst = False

	#re-does age input if age is valid
	while int(age) < 0 or int(age) > 90000000:

		#prints warning if age is not valid after first try
		if notFirst == True:
			print("That is not a valid age. Please try again.\n")

		#actual age input here
		age = input("What's your age? ")
		#marks as not first time. If invalid age, then prints warning.
		#If valid age, nothing happens cuz while loop
		notFirst = True
	
	username = input("What's your reddit username? ")

	print("Your name is", name, ", you are", age, 
		"years old, and your username is", username, ".\n")