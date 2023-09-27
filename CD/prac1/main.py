from dataclasses import dataclass
from typing import Dict, List
"""Program for validating string ending with bb"""

@dataclass
class Automata:
    dfa: List[Dict[str, int]]
    accepting : List[int]
    intitial: int

    def validate(self, string):
        current_state = self.intitial 
        for char in string:
            current_state = self.dfa[current_state][char]
        return current_state in self.accepting



DFA_ending_bb = Automata(
    dfa = [
        { 'a' : 0, 'b' : 1},
        { 'a' : 1, 'b' : 2},
        { 'a' : 0, 'b' : 2},
    ],
    accepting = [2],
    intitial = 0
)

result = DFA_ending_bb.validate(input())
print(result)
