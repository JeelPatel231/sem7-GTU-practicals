#!/usr/bin/gprolog --consult-file

male(jeel).
male(jfather).
male(jgfather).
male(pjgfather).

female(zeel).
female(jmother).
female(jgmother).
female(pjgmother).

parent(jeel, jfather).
parent(jeel, jmother).
parent(zeel, jfather).
parent(zeel, jmother).
parent(jfather, jgfather).
parent(jfather, jgmother).
parent(jmother, pjgfather).
parent(jmother, pjgmother).


father(CHILD,PARENT) :-
  parent(CHILD,PARENT),male(PARENT).

mother(CHILD,PARENT) :- 
  parent(CHILD,PARENT),female(PARENT).

grandfather(CHILD, GFATHER) :- 
  father(CHILD,FATHER),
  father(FATHER,GFATHER),
  male(GFATHER),!.

grandmother(CHILD, GMOTHER) :-
  father(CHILD,FATHER),
  mother(FATHER,GMOTHER),
  female(GMOTHER),!.

pgrandfather(CHILD, GFATHER) :- 
  mother(CHILD,MOTHER),
  father(MOTHER,GFATHER),
  male(GFATHER),!.

pgrandmother(CHILD, GMOTHER) :- 
  mother(CHILD,MOTHER),
  mother(MOTHER,GMOTHER),
  female(GMOTHER),!.

sibling(CHILD1,CHILD2) :- 
  father(CHILD1,FATHER),
  father(CHILD2,FATHER),
  mother(CHILD1,MOTHER),
  mother(CHILD2,MOTHER),
  different(CHILD2,CHILD1).
