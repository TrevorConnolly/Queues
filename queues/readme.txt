Programming Assignment 2: Deques and Randomized Queues


/* *****************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 **************************************************************************** */
To inmplement the randomized queue, I used an array because it calls for
constant amortized time that resized each time the number of items in the array
either reached the length or reached 1/4 of the length. I used an instance
variable to track the number of items actaully in the
array (non null items). I used StdRandom to shuffle the array in the iterator.
I used a double linked list for deque that tracked the node before and after
each node that way I could implement removeLast in an easy way. Using linked
lists made most sense to me for Deque since I didn't have to randomize anything
and simply had to remove and add nodes.

/* *****************************************************************************
 *  How much memory (in bytes) do your data types use to store n items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 **************************************************************************** */

Randomized Queue:   ~  _32n_  bytes (when array is 1/4 full because when array is
full it takes 8n memory and 8n * 4 = 32n)

Deque:              ~  _40n_  bytes (16 byte overhead per node + 8 bytes
to node item + 8 bytes to reference next + 8 bytes to reference before = 40n)
+




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */
