import math

def add(a, b):
	return a+b

def mul(a,b):
	return a*b

def mod(a, b):
	"""
	>>> mod(10, 2)
	0

	>>> mod(3, 5)
	3

	>>> mod(5, 4)
	1

	>>> mod(29, 13)
	3
	
	"""
	return a % b

#given two sides of a right triangle,
#this function returns the hypotenuse length
def hypotenuse(a,b):
	"""
	>>> hypotenuse(3, 4)
	5.0

	>>> hypotenuse(6, 8)
	10.0

	"""
	return math.sqrt( a**2 + b**2 )

