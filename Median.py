# Henrique Teske Barbieri
# HackerRank - Search - Median
# add (a x) or remove (r x) some number from the list. For each add or remove operation,
# output the median of numbers in the list
# The median of M numbers is defined as the middle number after sorting them in order
# if M is odd or the average number of the middle 2 numbers (again after sorting) 
# if M is even

# Approach: Brute. Reads the line, removes or inserts value (rearrange in this case)
# if there is an odd number of items, gets the middle one, else the average


#!/bin/python
import bisect

N = int(raw_input())

vals = []
for i in range(0, N):

	tmp = raw_input()
    # reads if it is add (a) or remove (r) and the number
	a, b = [xx for xx in tmp.split(' ')]
        rem = 0
        if a == 'r':
            # try to remove item
            try:
                vals.remove(int(b))
            except ValueError:
                rem = 1
                pass
            
        else:
            # sorts the list
            bisect.insort(vals, int(b))
            
            
        comp = len(vals)
        if comp == 0 or rem == 1:
            print 'Wrong!'
        else:
            if comp%2==0:
                tmp = (vals[(comp/2)-1]+vals[comp/2])/float(2)
                if tmp%1==0:
                    print int(tmp)
                else:
                    print tmp
            else:
                print vals[comp/2]
