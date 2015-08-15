def disemvoweler(phrase):
	consonants = ''
	vowels = ''
	vowel = 'aeiou'

	for letter in phrase:
		if letter in vowel:
			vowels += letter
		elif letter in ' ,./?!@#$%^&*()_-+=":;[]{}1234567890':
			pass
		else:
			consonants += letter

	return consonants, vowels

if __name__ == '__main__':
	phrase = input()

	cons, vows = disemvoweler(phrase)

	print(cons)
	print(vows)
