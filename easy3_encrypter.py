#Encrypts text when given a number a to use as a key to shift
def encrypt(a):

	#keeps key within alphabet
	#print(a%26)
	key = (a % 26)

	message = input("Write your message here:\n")
	output = ""

	for x in message:
		#does not change spaces
		#newx initialized as space so that spaces still printed
		newx = ' '
		if not x == ' ':

			#checks
			#print(ord(x))
			#print( (ord(x) + key) % 26 )


			#changes letter to lower case
			x = x.lower()

			#the coded number of the letter
			# a is 97, z is 122
			coded = ord(x) + key

			#chr creates character out of number based on ordinal value
			#if value is within range, return regular chr() fn
			if(coded < 123 and coded > 96):
				newx = chr(coded)

			#if outside of range, mod 97 skips all nonletters from 0-96
			#then, mod 26 of that gives a number between 0-26
			#add that number to 97 and you get the letter wanted.
			#IT WORKS!
			else:
				newx = chr( 97 + (  ( (coded % 97) % 26 )  ) )

		output += newx
	return output

#higher order function that creates encrypt functions
#instead of user entering message in function, 
#message is passed in as parameter in message
def makeEncrypter(a):
	def encrypt(message):
		key = (a % 26)
		output = ""
		
		for x in message:
			newx = ' '
			if not x == ' ':

				x = x.lower()
				coded = ord(x) + key

				if(coded < 123 and coded > 96):
					newx = chr(coded)

				else:
					newx = chr( 97 + (  ( (coded % 97) % 26 )  ) )

			output += newx
		return output

	return encrypt