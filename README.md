# pancake-sort
A sorting method that's somehow worse than bubblesort.

"Pancake sort” is a comparison method that’s kind of like a selection sort modification. It's more complicated than writing merge sort, and yet is worse than bubble sort which tells you everything you need to know about it really. How pancake sort works is that in an ArrayList of comparable values like integers first it finds a maximum value in the current unsorted portion. It then flips the whole list from the maximum value’s position to the end of the list, flipping it backwards, like so:
	[6, 4, 9, 2, 3, 5, 1] -> max value is 9 so it’s flipped to the end -> [6, 4, 1, 5, 3, 2, 9]
Now that the ‘9’ in this list is sorted, it is flipped to the start of the list again, like so:
[6, 4, 1, 5, 3, 2, 9] -> flipped so 9 is in the front -> [<mark> 9 </mark>, 2, 3, 5, 1, 4, 6]
Now the 9 (highlighted) is sorted and this process is repeated with the new unsorted portion, until the whole list is sorted. The next few steps would look like this
	[<mark> 9 </mark> , 2, 3, 5, 1, 4, 6] -> [<mark> 9 , 6 </mark>, 4, 1, 5, 3, 2] -> [9, 6, 4, 1, 2, 3, 5] -> [<mark> 9, 6, 5 </mark>, 3, 2, 1, 4]...etc.
Writing the code for this sort was much harder than understanding how it worked, because I figured that out early. What I struggle with most in writing it’s code was probably the flip() method and an else condition for an if-else statement in the condition that the maximum value was already at the end. If the max was already at the end, it would not need to be flipped to the end, and so it required only one flip. I fixed my code my printing out the arrayList after each running of the for-loop to see what was happening and to fix the code accordingly, which surprisingly worked pretty well, and in total the code took me an hour and twenty minutes to write. The benchmark tests I used to test my code out were a totally random order list, a reverse, max unsorted list, an almost sorted list, and a list in which the maximum value was at the start. Some sources that helped me understand how pancake sort worked were this really cool and helpful visual representation on youtube (https://www.youtube.com/watch?time_continue=1&v=kk-_DDgoXfk) and a wikipedia article on it that described the basics.
When I tested out pancake sort for its efficiency based on number of steps, I learned that it’s not efficient at all, as it was considerably worse than bubble sort. In this chart, the x-axis is the number of integers I tested each sorting method with, and pancake sort even gets worse as the number of integers it’s sorting increases.

![pancakesortefficiency](https://user-images.githubusercontent.com/56317794/72671378-1715c300-39fe-11ea-8f7d-64dffbbfc4df.png)

| # of Integers | BubbleSort | SelectionSort | InsertionSort | BubbleSort |
| --- | --- | --- | --- | --- |
| 100 | 53584 | 24484 | 2267 | 114012 |
| 200 | 215700 | 91892 | 5707 | 450684 |
| 400 | 871786 | 352372 | 12097 | 1779952 |
| 800 | 3508596 | 1353716 | 23402 | 7078137 |

I also tested out how much time it took to run in terms of milliseconds and for 500 integers, with a max possible value of 500, it was taking an average of 30 ms, which was also slower than the other sorts, but I guess this makes sense since there’s three methods (pancakeSort itself, flip, and findMax).

