Small project of simulation of an queue in an institution
==============

Description
-------------
The queue in the institution is implemented by `MyQueue` class which utilizes linked list. The institution has a given number of counters where clients are served. When there is no free counter new upcoming client has to stay in the queue.

Clients are coming randomly. By each turn a first client is coming with some probability, and an another one with other probability. Every client has his/her own left time needed to be served, by each turn it is decremented and when it is zero the client goes away and free the counter.
