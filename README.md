# Benchmarks for some basic array utilities.
This is just me to playing around with JMH benchmarks for a few functions
I wrote to insert / replace / remove values from byte arrays!

This is just something I've done to fulfill my own curiosity about performance 
of copying arrays. It seems to me that the fastest way to achieve an insertion 
or removal of some bytes is to create a new array and use System#array copy. 

Is this faster than just concatinating arrays as some people on stackoverflow
suggest? Let's see! :)

What I will be providing is:
1. Instructions
2. Results from my machine.

### Instructions
When there is something you can run these will be added :P

### Results
When I have done some comparisons these will be included.
